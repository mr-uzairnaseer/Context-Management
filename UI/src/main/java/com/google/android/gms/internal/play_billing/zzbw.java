package com.google.android.gms.internal.play_billing;

/* loaded from: classes4.dex */
final class zzbw {
    public static int a(int i3, String str) {
        if (i3 >= 0) {
            return i3;
        }
        throw new IllegalArgumentException(str + " cannot be negative but was: " + i3);
    }

    public static void b(Object obj, Object obj2) {
        if (obj == null) {
            throw new NullPointerException("null key in entry: null=".concat(String.valueOf(obj2)));
        }
        if (obj2 != null) {
            return;
        }
        throw new NullPointerException("null value in entry: " + obj.toString() + "=null");
    }
}
