package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Looper;

/* loaded from: classes4.dex */
public final class zzad {
    public zzad(Context context) {
    }

    public static boolean a() {
        return Looper.myLooper() == Looper.getMainLooper();
    }
}
