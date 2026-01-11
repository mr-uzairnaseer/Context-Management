package com.google.zxing.qrcode.encoder;

import com.squareup.kotlinpoet.FileSpecKt;
import java.lang.reflect.Array;
import java.util.Arrays;

/* loaded from: classes5.dex */
public final class ByteMatrix {

    /* renamed from: a, reason: collision with root package name */
    public final byte[][] f75349a;

    /* renamed from: b, reason: collision with root package name */
    public final int f75350b;

    /* renamed from: c, reason: collision with root package name */
    public final int f75351c;

    public ByteMatrix(int i3, int i4) {
        this.f75349a = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, i4, i3);
        this.f75350b = i3;
        this.f75351c = i4;
    }

    public void a(byte b3) {
        for (byte[] bArr : this.f75349a) {
            Arrays.fill(bArr, b3);
        }
    }

    public byte b(int i3, int i4) {
        return this.f75349a[i4][i3];
    }

    public byte[][] c() {
        return this.f75349a;
    }

    public int d() {
        return this.f75351c;
    }

    public int e() {
        return this.f75350b;
    }

    public void f(int i3, int i4, int i5) {
        this.f75349a[i4][i3] = (byte) i5;
    }

    public void g(int i3, int i4, boolean z2) {
        this.f75349a[i4][i3] = z2 ? (byte) 1 : (byte) 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder((this.f75350b * 2 * this.f75351c) + 2);
        for (int i3 = 0; i3 < this.f75351c; i3++) {
            byte[] bArr = this.f75349a[i3];
            for (int i4 = 0; i4 < this.f75350b; i4++) {
                byte b3 = bArr[i4];
                if (b3 == 0) {
                    sb.append(" 0");
                } else if (b3 != 1) {
                    sb.append(FileSpecKt.DEFAULT_INDENT);
                } else {
                    sb.append(" 1");
                }
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}
