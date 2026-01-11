package com.google.android.gms.common;

/* loaded from: classes4.dex */
final class zzx {
    public static int a(int i3) {
        int[] iArr = {1, 2, 3, 4, 5, 6};
        for (int i4 = 0; i4 < 6; i4++) {
            int i5 = iArr[i4];
            int i6 = i5 - 1;
            if (i5 == 0) {
                throw null;
            }
            if (i6 == i3) {
                return i5;
            }
        }
        return 1;
    }
}
