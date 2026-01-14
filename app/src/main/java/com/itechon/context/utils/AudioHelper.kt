package com.itechon.context.utils

import android.content.Context
import android.media.MediaPlayer
import android.media.MediaRecorder
import android.net.Uri
import java.io.File
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class AudioHelper(private val context: Context) {
    private var mediaRecorder: MediaRecorder? = null
    private var mediaPlayer: MediaPlayer? = null
    private var progressJob: kotlinx.coroutines.Job? = null
    private val scope = kotlinx.coroutines.CoroutineScope(kotlinx.coroutines.Dispatchers.Main)

    private val _currentPlayingUri = kotlinx.coroutines.flow.MutableStateFlow<String?>(null)
    val currentPlayingUri = _currentPlayingUri.asStateFlow()

    private val _isPlaying = kotlinx.coroutines.flow.MutableStateFlow(false)
    val isPlaying = _isPlaying.asStateFlow()

    private val _progress = kotlinx.coroutines.flow.MutableStateFlow(0f)
    val progress = _progress.asStateFlow()

    fun startRecording(): File? {
        val file = File(context.cacheDir, "recording_${System.currentTimeMillis()}.m4a")
        mediaRecorder = MediaRecorder().apply {
            setAudioSource(MediaRecorder.AudioSource.MIC)
            setOutputFormat(MediaRecorder.OutputFormat.MPEG_4)
            setAudioEncoder(MediaRecorder.AudioEncoder.AAC)
            setOutputFile(file.absolutePath)
            prepare()
            start()
        }
        return file
    }

    fun stopRecording() {
        try {
            mediaRecorder?.stop()
        } catch (e: Exception) {
            // fast stop or not started
        }
        mediaRecorder?.release()
        mediaRecorder = null
    }

    fun playAudio(uri: Uri) {
        if (_currentPlayingUri.value == uri.toString() && _isPlaying.value) {
            pausePlayback()
            return
        }

        stopPlayback()
        _currentPlayingUri.value = uri.toString()
        _isPlaying.value = true

        mediaPlayer = MediaPlayer().apply {
            setDataSource(context, uri)
            prepare()
            start()
            setOnCompletionListener {
                stopPlayback()
            }
        }
        startProgressTracker()
    }

    fun pausePlayback() {
        mediaPlayer?.pause()
        _isPlaying.value = false
        progressJob?.cancel()
    }

    fun resumePlayback() {
        mediaPlayer?.start()
        _isPlaying.value = true
        startProgressTracker()
    }

    fun stopPlayback() {
        progressJob?.cancel()
        mediaPlayer?.apply {
            if (isPlaying) stop()
            release()
        }
        mediaPlayer = null
        _isPlaying.value = false
        _currentPlayingUri.value = null
        _progress.value = 0f
    }

    private fun startProgressTracker() {
        progressJob?.cancel()
        progressJob = scope.launch {
            while (isActive && mediaPlayer != null && mediaPlayer!!.isPlaying) {
                val current = mediaPlayer!!.currentPosition
                val total = mediaPlayer!!.duration
                if (total > 0) {
                    _progress.value = current.toFloat() / total.toFloat()
                }
                delay(100)
            }
        }
    }
}
