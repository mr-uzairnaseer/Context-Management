package com.google.zxing;

import com.google.openlocationcode.OpenLocationCode;

/* loaded from: classes5.dex */
public abstract class LuminanceSource {

    /* renamed from: a, reason: collision with root package name */
    public final int f74946a;

    /* renamed from: b, reason: collision with root package name */
    public final int f74947b;

    public final int a() {
        return this.f74947b;
    }

    public abstract byte[] b();

    public abstract byte[] c(int i3, byte[] bArr);

    public final int d() {
        return this.f74946a;
    }

    public final String toString() {
        int i3 = this.f74946a;
        byte[] bArrC = new byte[i3];
        StringBuilder sb = new StringBuilder(this.f74947b * (i3 + 1));
        for (int i4 = 0; i4 < this.f74947b; i4++) {
            bArrC = c(i4, bArrC);
            for (int i5 = 0; i5 < this.f74946a; i5++) {
                int i6 = bArrC[i5] & 255;
                sb.append(i6 < 64 ? '#' : i6 < 128 ? OpenLocationCode.SEPARATOR : i6 < 192 ? '.' : ' ');
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}
