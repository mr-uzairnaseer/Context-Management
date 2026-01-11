package com.squareup.picasso;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes5.dex */
final class MarkableInputStream extends InputStream {

    /* renamed from: a, reason: collision with root package name */
    public final InputStream f75732a;

    /* renamed from: b, reason: collision with root package name */
    public long f75733b;

    /* renamed from: c, reason: collision with root package name */
    public long f75734c;

    /* renamed from: d, reason: collision with root package name */
    public long f75735d;

    /* renamed from: e, reason: collision with root package name */
    public long f75736e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f75737f;

    /* renamed from: g, reason: collision with root package name */
    public int f75738g;

    public MarkableInputStream(InputStream inputStream) {
        this(inputStream, 4096);
    }

    public void a(boolean z2) {
        this.f75737f = z2;
    }

    @Override // java.io.InputStream
    public int available() {
        return this.f75732a.available();
    }

    public void c(long j3) throws IOException {
        if (this.f75733b > this.f75735d || j3 < this.f75734c) {
            throw new IOException("Cannot reset");
        }
        this.f75732a.reset();
        f(this.f75734c, j3);
        this.f75733b = j3;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f75732a.close();
    }

    public long d(int i3) throws IOException {
        long j3 = this.f75733b + i3;
        if (this.f75735d < j3) {
            e(j3);
        }
        return this.f75733b;
    }

    public final void e(long j3) throws IOException {
        try {
            long j4 = this.f75734c;
            long j5 = this.f75733b;
            if (j4 >= j5 || j5 > this.f75735d) {
                this.f75734c = j5;
                this.f75732a.mark((int) (j3 - j5));
            } else {
                this.f75732a.reset();
                this.f75732a.mark((int) (j3 - this.f75734c));
                f(this.f75734c, this.f75733b);
            }
            this.f75735d = j3;
        } catch (IOException e3) {
            throw new IllegalStateException("Unable to mark: " + e3);
        }
    }

    public final void f(long j3, long j4) throws IOException {
        while (j3 < j4) {
            long jSkip = this.f75732a.skip(j4 - j3);
            if (jSkip == 0) {
                if (read() == -1) {
                    return;
                } else {
                    jSkip = 1;
                }
            }
            j3 += jSkip;
        }
    }

    @Override // java.io.InputStream
    public void mark(int i3) {
        this.f75736e = d(i3);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.f75732a.markSupported();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (!this.f75737f) {
            long j3 = this.f75733b + 1;
            long j4 = this.f75735d;
            if (j3 > j4) {
                e(j4 + this.f75738g);
            }
        }
        int i3 = this.f75732a.read();
        if (i3 != -1) {
            this.f75733b++;
        }
        return i3;
    }

    @Override // java.io.InputStream
    public void reset() throws IOException {
        c(this.f75736e);
    }

    @Override // java.io.InputStream
    public long skip(long j3) throws IOException {
        if (!this.f75737f) {
            long j4 = this.f75733b;
            if (j4 + j3 > this.f75735d) {
                e(j4 + j3 + this.f75738g);
            }
        }
        long jSkip = this.f75732a.skip(j3);
        this.f75733b += jSkip;
        return jSkip;
    }

    public MarkableInputStream(InputStream inputStream, int i3) {
        this(inputStream, i3, 1024);
    }

    public MarkableInputStream(InputStream inputStream, int i3, int i4) {
        this.f75736e = -1L;
        this.f75737f = true;
        this.f75738g = -1;
        this.f75732a = inputStream.markSupported() ? inputStream : new BufferedInputStream(inputStream, i3);
        this.f75738g = i4;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        if (!this.f75737f) {
            long j3 = this.f75733b;
            if (bArr.length + j3 > this.f75735d) {
                e(j3 + bArr.length + this.f75738g);
            }
        }
        int i3 = this.f75732a.read(bArr);
        if (i3 != -1) {
            this.f75733b += i3;
        }
        return i3;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i3, int i4) throws IOException {
        if (!this.f75737f) {
            long j3 = this.f75733b;
            long j4 = i4;
            if (j3 + j4 > this.f75735d) {
                e(j3 + j4 + this.f75738g);
            }
        }
        int i5 = this.f75732a.read(bArr, i3, i4);
        if (i5 != -1) {
            this.f75733b += i5;
        }
        return i5;
    }
}
