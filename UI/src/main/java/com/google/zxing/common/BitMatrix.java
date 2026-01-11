package com.google.zxing.common;

import com.squareup.kotlinpoet.FileSpecKt;
import java.util.Arrays;

/* loaded from: classes5.dex */
public final class BitMatrix implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    public final int f75091a;

    /* renamed from: b, reason: collision with root package name */
    public final int f75092b;

    /* renamed from: c, reason: collision with root package name */
    public final int f75093c;

    /* renamed from: d, reason: collision with root package name */
    public final int[] f75094d;

    public BitMatrix(int i3) {
        this(i3, i3);
    }

    public final String a(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder(this.f75092b * (this.f75091a + 1));
        for (int i3 = 0; i3 < this.f75092b; i3++) {
            for (int i4 = 0; i4 < this.f75091a; i4++) {
                sb.append(d(i4, i3) ? str : str2);
            }
            sb.append(str3);
        }
        return sb.toString();
    }

    public void b() {
        int length = this.f75094d.length;
        for (int i3 = 0; i3 < length; i3++) {
            this.f75094d[i3] = 0;
        }
    }

    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public BitMatrix clone() {
        return new BitMatrix(this.f75091a, this.f75092b, this.f75093c, (int[]) this.f75094d.clone());
    }

    public boolean d(int i3, int i4) {
        return ((this.f75094d[(i4 * this.f75093c) + (i3 / 32)] >>> (i3 & 31)) & 1) != 0;
    }

    public int e() {
        return this.f75092b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof BitMatrix)) {
            return false;
        }
        BitMatrix bitMatrix = (BitMatrix) obj;
        return this.f75091a == bitMatrix.f75091a && this.f75092b == bitMatrix.f75092b && this.f75093c == bitMatrix.f75093c && Arrays.equals(this.f75094d, bitMatrix.f75094d);
    }

    public int f() {
        return this.f75091a;
    }

    public void h(int i3, int i4) {
        int i5 = (i4 * this.f75093c) + (i3 / 32);
        int[] iArr = this.f75094d;
        iArr[i5] = (1 << (i3 & 31)) | iArr[i5];
    }

    public int hashCode() {
        int i3 = this.f75091a;
        return (((((((i3 * 31) + i3) * 31) + this.f75092b) * 31) + this.f75093c) * 31) + Arrays.hashCode(this.f75094d);
    }

    public void j(int i3, int i4, int i5, int i6) {
        if (i4 < 0 || i3 < 0) {
            throw new IllegalArgumentException("Left and top must be nonnegative");
        }
        if (i6 <= 0 || i5 <= 0) {
            throw new IllegalArgumentException("Height and width must be at least 1");
        }
        int i7 = i5 + i3;
        int i8 = i6 + i4;
        if (i8 > this.f75092b || i7 > this.f75091a) {
            throw new IllegalArgumentException("The region must fit inside the matrix");
        }
        while (i4 < i8) {
            int i9 = this.f75093c * i4;
            for (int i10 = i3; i10 < i7; i10++) {
                int[] iArr = this.f75094d;
                int i11 = (i10 / 32) + i9;
                iArr[i11] = iArr[i11] | (1 << (i10 & 31));
            }
            i4++;
        }
    }

    public String k(String str, String str2) {
        return a(str, str2, org.apache.commons.lang3.StringUtils.LF);
    }

    public String toString() {
        return k("X ", FileSpecKt.DEFAULT_INDENT);
    }

    public BitMatrix(int i3, int i4) {
        if (i3 <= 0 || i4 <= 0) {
            throw new IllegalArgumentException("Both dimensions must be greater than 0");
        }
        this.f75091a = i3;
        this.f75092b = i4;
        int i5 = (i3 + 31) / 32;
        this.f75093c = i5;
        this.f75094d = new int[i5 * i4];
    }

    public BitMatrix(int i3, int i4, int i5, int[] iArr) {
        this.f75091a = i3;
        this.f75092b = i4;
        this.f75093c = i5;
        this.f75094d = iArr;
    }
}
