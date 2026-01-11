package com.google.android.gms.internal.measurement;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

/* loaded from: classes.dex */
public final class zzcy {
    public static final int zza;

    static {
        zza = Build.VERSION.SDK_INT >= 31 ? 33554432 : 0;
    }

    public static PendingIntent a(Context context, int i3, Intent intent, int i4) {
        return PendingIntent.getBroadcast(context, 0, intent, i4);
    }
}
