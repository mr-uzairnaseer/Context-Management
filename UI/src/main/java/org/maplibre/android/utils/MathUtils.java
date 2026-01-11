package org.maplibre.android.utils;

/* loaded from: classes9.dex */
public class MathUtils {
    public static double a(double d3, double d4, double d5) {
        return Math.max(d4, Math.min(d5, d3));
    }

    public static float b(float f3, float f4, float f5) {
        return Math.max(f4, Math.min(f5, f3));
    }

    public static double c(double d3, double d4, double d5, double d6, double d7) {
        return (((d3 - d4) / (d5 - d4)) * (d7 - d6)) + d6;
    }
}
