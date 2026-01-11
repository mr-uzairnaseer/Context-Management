package com.google.zxing.pdf417.encoder;

/* loaded from: classes5.dex */
final class BarcodeRow {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f75303a;

    /* renamed from: b, reason: collision with root package name */
    public int f75304b = 0;

    public BarcodeRow(int i3) {
        this.f75303a = new byte[i3];
    }

    public void a(boolean z2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            int i5 = this.f75304b;
            this.f75304b = i5 + 1;
            c(i5, z2);
        }
    }

    public byte[] b(int i3) {
        int length = this.f75303a.length * i3;
        byte[] bArr = new byte[length];
        for (int i4 = 0; i4 < length; i4++) {
            bArr[i4] = this.f75303a[i4 / i3];
        }
        return bArr;
    }

    public final void c(int i3, boolean z2) {
        this.f75303a[i3] = z2 ? (byte) 1 : (byte) 0;
    }
}
