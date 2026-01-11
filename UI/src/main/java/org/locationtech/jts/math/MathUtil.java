package org.locationtech.jts.math;

/* loaded from: classes6.dex */
public class MathUtil {

    /* renamed from: a, reason: collision with root package name */
    public static final double f163660a = Math.log(10.0d);
    public static final double PHI_INV = (Math.sqrt(5.0d) - 1.0d) / 2.0d;

    public static int a(int i3, int i4, int i5) {
        return i3 < i4 ? i4 : i3 > i5 ? i5 : i3;
    }

    public static double b(double d3, double d4, double d5, double d6) {
        if (d4 > d3) {
            d3 = d4;
        }
        if (d5 <= d3) {
            d5 = d3;
        }
        return d6 > d5 ? d6 : d5;
    }

    public static double c(double d3) {
        return d(d3, PHI_INV);
    }

    public static double d(double d3, double d4) {
        double d5 = d3 + d4;
        return d5 < 1.0d ? d5 : d5 - Math.floor(d5);
    }
}
