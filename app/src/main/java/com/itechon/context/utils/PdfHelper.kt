package com.itechon.context.utils

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.pdf.PdfDocument
import androidx.core.content.FileProvider
import com.itechon.context.data.model.ContextEntity
import com.itechon.context.data.model.ItemEntity
import com.itechon.context.data.model.ItemType
import java.io.File
import java.io.FileOutputStream
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

object PdfHelper {

    fun generateContextReport(context: Context, contextEntity: ContextEntity, items: List<ItemEntity>): File? {
        val pdfDocument = PdfDocument()
        val pageInfo = PdfDocument.PageInfo.Builder(595, 842, 1).create() // A4 size
        val page = pdfDocument.startPage(pageInfo)
        val canvas = page.canvas
        val paint = Paint()

        var yPosition = 50f
        
        // Title
        paint.textSize = 24f
        paint.color = Color.BLACK
        paint.isFakeBoldText = true
        canvas.drawText("Context Report: ${contextEntity.title}", 30f, yPosition, paint)
        yPosition += 40f

        // Metadata
        paint.textSize = 14f
        paint.isFakeBoldText = false
        paint.color = Color.DKGRAY
        val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault())
        val dateStr = try { dateFormat.format(Date(contextEntity.createdAt.toEpochMilliseconds())) } catch (e: Exception) { "Unknown Date" }
        canvas.drawText("Generated on: ${dateFormat.format(Date())}", 30f, yPosition, paint)
        yPosition += 20f
        canvas.drawText("Context Created: $dateStr", 30f, yPosition, paint)
        yPosition += 40f

        // Separator
        paint.color = Color.LTGRAY
        paint.strokeWidth = 2f
        canvas.drawLine(30f, yPosition, 565f, yPosition, paint)
        yPosition += 30f

        // Items
        paint.color = Color.BLACK
        paint.textSize = 16f
        
        items.forEach { item ->
            // Check page bounds (simple check, not handling multi-page perfectly for MVP)
            if (yPosition > 800f) {
                // In a real app we would finishPage and startPage. 
                // For MVP we just stop or could implement multi-page logic.
                // Stopping drawing to avoid crash/mess.
                return@forEach
            }

            val itemDate = try { dateFormat.format(Date(item.timestamp.toEpochMilliseconds())) } catch (e: Exception) { "" }
            
            paint.isFakeBoldText = true
            canvas.drawText("${item.type} - $itemDate", 30f, yPosition, paint)
            yPosition += 20f
            
            paint.isFakeBoldText = false
            val content = item.content ?: (if(item.type == ItemType.AUDIO) "Audio recording" else "No content")
            
            // Text wrapping (very usage)
            val maxCharsPerLine = 60
            val chunks = content.chunked(maxCharsPerLine)
            chunks.forEach { line ->
                 canvas.drawText(line, 30f, yPosition, paint)
                 yPosition += 20f
            }
            
            yPosition += 20f // Spacing between items
        }

        pdfDocument.finishPage(page)

        // Save
        val file = File(context.cacheDir, "report_${contextEntity.id}.pdf")
        try {
            pdfDocument.writeTo(FileOutputStream(file))
            pdfDocument.close()
            return file
        } catch (e: Exception) {
            e.printStackTrace()
            pdfDocument.close()
            return null
        }
    }
}
