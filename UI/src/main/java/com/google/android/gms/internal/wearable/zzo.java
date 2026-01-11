package com.google.android.gms.internal.wearable;

import android.os.Build;

/* loaded from: classes4.dex */
public final class zzo {
    public static final int zza;

    static {
        zza = Build.VERSION.SDK_INT >= 31 ? 33554432 : 0;
    }
}
