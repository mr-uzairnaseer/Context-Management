package com.airbnb.lottie.utils;

/* loaded from: classes4.dex */
public class GammaEvaluator {
    public static float a(float f3) {
        return f3 <= 0.04045f ? f3 / 12.92f : (float) Math.pow((f3 + 0.055f) / 1.055f, 2.4000000953674316d);
    }

    public static float b(float f3) {
        return f3 <= 0.0031308f ? f3 * 12.92f : (float) ((Math.pow(f3, 0.4166666567325592d) * 1.0549999475479126d) - 0.054999999701976776d);
    }

    public static int c(float f3, int i3, int i4) {
        if (i3 == i4 || f3 <= 0.0f) {
            return i3;
        }
        if (f3 >= 1.0f) {
            return i4;
        }
        float f4 = ((i3 >> 24) & 255) / 255.0f;
        float fA = a(((i3 >> 16) & 255) / 255.0f);
        float fA2 = a(((i3 >> 8) & 255) / 255.0f);
        float fA3 = a((i3 & 255) / 255.0f);
        float fA4 = a(((i4 >> 16) & 255) / 255.0f);
        float f5 = f4 + (((((i4 >> 24) & 255) / 255.0f) - f4) * f3);
        float fA5 = fA2 + ((a(((i4 >> 8) & 255) / 255.0f) - fA2) * f3);
        float fA6 = fA3 + (f3 * (a((i4 & 255) / 255.0f) - fA3));
        return (Math.round(b(fA + ((fA4 - fA) * f3)) * 255.0f) << 16) | (Math.round(f5 * 255.0f) << 24) | (Math.round(b(fA5) * 255.0f) << 8) | Math.round(b(fA6) * 255.0f);
    }
}
