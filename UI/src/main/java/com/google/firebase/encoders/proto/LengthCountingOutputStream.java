package com.google.firebase.encoders.proto;

import java.io.OutputStream;

/* loaded from: classes5.dex */
final class LengthCountingOutputStream extends OutputStream {

    /* renamed from: a, reason: collision with root package name */
    public long f72962a = 0;

    public long a() {
        return this.f72962a;
    }

    @Override // java.io.OutputStream
    public void write(int i3) {
        this.f72962a++;
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) {
        this.f72962a += bArr.length;
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i3, int i4) {
        int i5;
        if (i3 >= 0 && i3 <= bArr.length && i4 >= 0 && (i5 = i3 + i4) <= bArr.length && i5 >= 0) {
            this.f72962a += i4;
            return;
        }
        throw new IndexOutOfBoundsException();
    }
}
