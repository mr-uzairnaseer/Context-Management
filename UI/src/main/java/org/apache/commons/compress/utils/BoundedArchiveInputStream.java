package org.apache.commons.compress.utils;

import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes5.dex */
public abstract class BoundedArchiveInputStream extends InputStream {

    /* renamed from: a, reason: collision with root package name */
    public final long f161300a;

    /* renamed from: b, reason: collision with root package name */
    public ByteBuffer f161301b;

    /* renamed from: c, reason: collision with root package name */
    public long f161302c;

    public abstract int a(long j3, ByteBuffer byteBuffer);

    @Override // java.io.InputStream
    public synchronized int read() {
        try {
            if (this.f161302c >= this.f161300a) {
                return -1;
            }
            ByteBuffer byteBuffer = this.f161301b;
            if (byteBuffer == null) {
                this.f161301b = ByteBuffer.allocate(1);
            } else {
                byteBuffer.rewind();
            }
            if (a(this.f161302c, this.f161301b) < 1) {
                return -1;
            }
            this.f161302c++;
            return this.f161301b.get() & 255;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // java.io.InputStream
    public synchronized int read(byte[] bArr, int i3, int i4) {
        long j3 = this.f161302c;
        long j4 = this.f161300a;
        if (j3 >= j4) {
            return -1;
        }
        long jMin = Math.min(i4, j4 - j3);
        if (jMin <= 0) {
            return 0;
        }
        if (i3 >= 0 && i3 <= bArr.length && jMin <= bArr.length - i3) {
            int iA = a(this.f161302c, ByteBuffer.wrap(bArr, i3, (int) jMin));
            if (iA > 0) {
                this.f161302c += iA;
            }
            return iA;
        }
        throw new IndexOutOfBoundsException("offset or len are out of bounds");
    }
}
