package com.google.zxing.common;

import java.util.Arrays;

/* loaded from: classes5.dex */
public final class BitArray implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    public int[] f75089a;

    /* renamed from: b, reason: collision with root package name */
    public int f75090b;

    public BitArray() {
        this.f75090b = 0;
        this.f75089a = new int[1];
    }

    public static int[] k(int i3) {
        return new int[(i3 + 31) / 32];
    }

    public void a(boolean z2) {
        e(this.f75090b + 1);
        if (z2) {
            int[] iArr = this.f75089a;
            int i3 = this.f75090b;
            int i4 = i3 / 32;
            iArr[i4] = (1 << (i3 & 31)) | iArr[i4];
        }
        this.f75090b++;
    }

    public void b(BitArray bitArray) {
        int i3 = bitArray.f75090b;
        e(this.f75090b + i3);
        for (int i4 = 0; i4 < i3; i4++) {
            a(bitArray.f(i4));
        }
    }

    public void c(int i3, int i4) {
        if (i4 < 0 || i4 > 32) {
            throw new IllegalArgumentException("Num bits must be between 0 and 32");
        }
        e(this.f75090b + i4);
        while (i4 > 0) {
            boolean z2 = true;
            if (((i3 >> (i4 - 1)) & 1) != 1) {
                z2 = false;
            }
            a(z2);
            i4--;
        }
    }

    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public BitArray clone() {
        return new BitArray((int[]) this.f75089a.clone(), this.f75090b);
    }

    public final void e(int i3) {
        if (i3 > (this.f75089a.length << 5)) {
            int[] iArrK = k(i3);
            int[] iArr = this.f75089a;
            System.arraycopy(iArr, 0, iArrK, 0, iArr.length);
            this.f75089a = iArrK;
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof BitArray)) {
            return false;
        }
        BitArray bitArray = (BitArray) obj;
        return this.f75090b == bitArray.f75090b && Arrays.equals(this.f75089a, bitArray.f75089a);
    }

    public boolean f(int i3) {
        return ((1 << (i3 & 31)) & this.f75089a[i3 / 32]) != 0;
    }

    public int h() {
        return this.f75090b;
    }

    public int hashCode() {
        return (this.f75090b * 31) + Arrays.hashCode(this.f75089a);
    }

    public int j() {
        return (this.f75090b + 7) / 8;
    }

    public void l(int i3, byte[] bArr, int i4, int i5) {
        for (int i6 = 0; i6 < i5; i6++) {
            int i7 = 0;
            for (int i8 = 0; i8 < 8; i8++) {
                if (f(i3)) {
                    i7 |= 1 << (7 - i8);
                }
                i3++;
            }
            bArr[i4 + i6] = (byte) i7;
        }
    }

    public void m(BitArray bitArray) {
        if (this.f75090b != bitArray.f75090b) {
            throw new IllegalArgumentException("Sizes don't match");
        }
        int i3 = 0;
        while (true) {
            int[] iArr = this.f75089a;
            if (i3 >= iArr.length) {
                return;
            }
            iArr[i3] = iArr[i3] ^ bitArray.f75089a[i3];
            i3++;
        }
    }

    public String toString() {
        int i3 = this.f75090b;
        StringBuilder sb = new StringBuilder(i3 + (i3 / 8) + 1);
        for (int i4 = 0; i4 < this.f75090b; i4++) {
            if ((i4 & 7) == 0) {
                sb.append(' ');
            }
            sb.append(f(i4) ? 'X' : '.');
        }
        return sb.toString();
    }

    public BitArray(int[] iArr, int i3) {
        this.f75089a = iArr;
        this.f75090b = i3;
    }
}
