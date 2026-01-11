package org.apache.commons.compress.archivers.zip;

/* loaded from: classes5.dex */
final class CircularBuffer {

    /* renamed from: a, reason: collision with root package name */
    public final int f160241a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f160242b;

    /* renamed from: c, reason: collision with root package name */
    public int f160243c;

    /* renamed from: d, reason: collision with root package name */
    public int f160244d;

    public CircularBuffer(int i3) {
        this.f160241a = i3;
        this.f160242b = new byte[i3];
    }

    public boolean a() {
        return this.f160243c != this.f160244d;
    }

    public void b(int i3, int i4) {
        int i5 = this.f160244d - i3;
        int i6 = i4 + i5;
        while (i5 < i6) {
            byte[] bArr = this.f160242b;
            int i7 = this.f160244d;
            int i8 = this.f160241a;
            bArr[i7] = bArr[(i5 + i8) % i8];
            this.f160244d = (i7 + 1) % i8;
            i5++;
        }
    }

    public int c() {
        if (!a()) {
            return -1;
        }
        byte[] bArr = this.f160242b;
        int i3 = this.f160243c;
        byte b3 = bArr[i3];
        this.f160243c = (i3 + 1) % this.f160241a;
        return b3 & 255;
    }

    public void d(int i3) {
        byte[] bArr = this.f160242b;
        int i4 = this.f160244d;
        bArr[i4] = (byte) i3;
        this.f160244d = (i4 + 1) % this.f160241a;
    }
}
