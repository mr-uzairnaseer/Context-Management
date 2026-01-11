package org.locationtech.jts.index.quadtree;

import com.squareup.kotlinpoet.FileSpecKt;

/* loaded from: classes6.dex */
public class DoubleBits {
    public static final int EXPONENT_BIAS = 1023;

    /* renamed from: a, reason: collision with root package name */
    public double f163547a;

    /* renamed from: b, reason: collision with root package name */
    public long f163548b;

    public DoubleBits(double d3) {
        this.f163547a = d3;
        this.f163548b = Double.doubleToLongBits(d3);
    }

    public static int b(double d3) {
        return new DoubleBits(d3).c();
    }

    public static double d(int i3) {
        if (i3 > 1023 || i3 < -1022) {
            throw new IllegalArgumentException("Exponent out of bounds");
        }
        return Double.longBitsToDouble((i3 + 1023) << 52);
    }

    public int a() {
        return ((int) (this.f163548b >> 52)) & 2047;
    }

    public int c() {
        return a() - 1023;
    }

    public String toString() {
        String strSubstring = ("0000000000000000000000000000000000000000000000000000000000000000" + Long.toBinaryString(this.f163548b)).substring(r0.length() - 64);
        return strSubstring.substring(0, 1) + FileSpecKt.DEFAULT_INDENT + strSubstring.substring(1, 12) + "(" + c() + ") " + strSubstring.substring(12) + " [ " + this.f163547a + " ]";
    }
}
