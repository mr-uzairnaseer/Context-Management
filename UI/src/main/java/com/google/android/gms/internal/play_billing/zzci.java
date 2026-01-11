package com.google.android.gms.internal.play_billing;

/* loaded from: classes4.dex */
public class zzci {
    public static int a(int i3, int i4) {
        if (i4 < 0) {
            throw new IllegalArgumentException("cannot store more than MAX_VALUE elements");
        }
        if (i4 <= i3) {
            return i3;
        }
        int i5 = i3 + (i3 >> 1) + 1;
        if (i5 < i4) {
            int iHighestOneBit = Integer.highestOneBit(i4 - 1);
            i5 = iHighestOneBit + iHighestOneBit;
        }
        if (i5 < 0) {
            return Integer.MAX_VALUE;
        }
        return i5;
    }
}
