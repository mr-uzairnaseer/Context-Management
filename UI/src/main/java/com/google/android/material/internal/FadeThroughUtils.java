package com.google.android.material.internal;

/* loaded from: classes4.dex */
final class FadeThroughUtils {
    private FadeThroughUtils() {
    }

    public static void a(float f3, float[] fArr) {
        if (f3 <= 0.5f) {
            fArr[0] = 1.0f - (f3 * 2.0f);
            fArr[1] = 0.0f;
        } else {
            fArr[0] = 0.0f;
            fArr[1] = (f3 * 2.0f) - 1.0f;
        }
    }
}
