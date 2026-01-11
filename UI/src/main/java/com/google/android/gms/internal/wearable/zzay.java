package com.google.android.gms.internal.wearable;

import java.util.Collections;
import java.util.List;

/* loaded from: classes4.dex */
public final class zzay {
    public static /* bridge */ /* synthetic */ int a(long[] jArr, long j3, int i3, int i4) {
        while (i3 < i4) {
            if (jArr[i3] == j3) {
                return i3;
            }
            i3++;
        }
        return -1;
    }

    public static List b(long... jArr) {
        int length = jArr.length;
        return length == 0 ? Collections.EMPTY_LIST : new zzax(jArr, 0, length);
    }
}
