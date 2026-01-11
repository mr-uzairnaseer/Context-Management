package io.jenetics.jpx;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Objects;

/* loaded from: classes8.dex */
final class NonCloseableOutputStream extends OutputStream {

    /* renamed from: a, reason: collision with root package name */
    public final OutputStream f151000a;

    public NonCloseableOutputStream(OutputStream outputStream) {
        Objects.requireNonNull(outputStream);
        this.f151000a = outputStream;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        this.f151000a.flush();
    }

    @Override // java.io.OutputStream
    public void write(int i3) throws IOException {
        this.f151000a.write(i3);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        this.f151000a.write(bArr);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i3, int i4) throws IOException {
        this.f151000a.write(bArr, i3, i4);
    }
}
