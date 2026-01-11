package com.google.android.recaptcha.internal;

/* loaded from: classes4.dex */
final class zzlu {
    public static void zza(boolean z2, String str, long j3, long j4) {
        if (z2) {
            return;
        }
        throw new ArithmeticException("overflow: " + str + "(" + j3 + ", " + j4 + ")");
    }

    public static void zzb(boolean z2) {
        if (!z2) {
            throw new ArithmeticException("mode was UNNECESSARY, but rounding was necessary");
        }
    }
}
