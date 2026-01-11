package org.maplibre.android.utils;

/* loaded from: classes9.dex */
public class Compare {
    public static int a(int i3, int i4) {
        if (i3 < i4) {
            return -1;
        }
        return i3 == i4 ? 0 : 1;
    }

    public static int b(boolean z2, boolean z3) {
        if (z2 == z3) {
            return 0;
        }
        return z2 ? 1 : -1;
    }
}
