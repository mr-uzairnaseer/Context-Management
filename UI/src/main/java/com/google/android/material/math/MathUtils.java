package com.google.android.material.math;

/* loaded from: classes4.dex */
public final class MathUtils {
    public static final float DEFAULT_EPSILON = 1.0E-4f;

    private MathUtils() {
    }

    public static float a(float f3, float f4, float f5, float f6) {
        return (float) Math.hypot(f5 - f3, f6 - f4);
    }

    public static float b(float f3, float f4, float f5, float f6, float f7, float f8) {
        return e(a(f3, f4, f5, f6), a(f3, f4, f7, f6), a(f3, f4, f7, f8), a(f3, f4, f5, f8));
    }

    public static boolean c(float f3, float f4, float f5) {
        return f3 + f5 >= f4;
    }

    public static float d(float f3, float f4, float f5) {
        return ((1.0f - f5) * f3) + (f5 * f4);
    }

    public static float e(float f3, float f4, float f5, float f6) {
        return (f3 <= f4 || f3 <= f5 || f3 <= f6) ? (f4 <= f5 || f4 <= f6) ? f5 > f6 ? f5 : f6 : f4 : f3;
    }
}
