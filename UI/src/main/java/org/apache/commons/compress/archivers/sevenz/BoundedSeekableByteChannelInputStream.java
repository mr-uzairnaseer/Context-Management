package org.apache.commons.compress.archivers.sevenz;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;

/* loaded from: classes5.dex */
final class BoundedSeekableByteChannelInputStream extends InputStream {

    /* renamed from: a, reason: collision with root package name */
    public final ByteBuffer f160057a;

    /* renamed from: b, reason: collision with root package name */
    public final SeekableByteChannel f160058b;

    /* renamed from: c, reason: collision with root package name */
    public long f160059c;

    public BoundedSeekableByteChannelInputStream(SeekableByteChannel seekableByteChannel, long j3) {
        this.f160058b = seekableByteChannel;
        this.f160059c = j3;
        this.f160057a = ByteBuffer.allocate((j3 >= PlaybackStateCompat.ACTION_PLAY_FROM_URI || j3 <= 0) ? 8192 : (int) j3);
    }

    public final int a(int i3) throws IOException {
        this.f160057a.rewind().limit(i3);
        int i4 = this.f160058b.read(this.f160057a);
        this.f160057a.flip();
        return i4;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        long j3 = this.f160059c;
        if (j3 <= 0) {
            return -1;
        }
        this.f160059c = j3 - 1;
        int iA = a(1);
        return iA < 0 ? iA : this.f160057a.get() & 255;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i3, int i4) throws IOException {
        ByteBuffer byteBufferAllocate;
        int iA;
        if (i4 == 0) {
            return 0;
        }
        long j3 = this.f160059c;
        if (j3 <= 0) {
            return -1;
        }
        if (i4 > j3) {
            i4 = (int) j3;
        }
        if (i4 <= this.f160057a.capacity()) {
            byteBufferAllocate = this.f160057a;
            iA = a(i4);
        } else {
            byteBufferAllocate = ByteBuffer.allocate(i4);
            iA = this.f160058b.read(byteBufferAllocate);
            byteBufferAllocate.flip();
        }
        if (iA >= 0) {
            byteBufferAllocate.get(bArr, i3, iA);
            this.f160059c -= iA;
        }
        return iA;
    }
}
