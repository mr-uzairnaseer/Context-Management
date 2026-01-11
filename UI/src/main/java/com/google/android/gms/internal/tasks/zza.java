package com.google.android.gms.internal.tasks;

import android.os.Handler;
import android.os.Looper;

/* loaded from: classes.dex */
public final class zza extends Handler {

    /* renamed from: a, reason: collision with root package name */
    public final Looper f62830a;

    public zza() {
        this.f62830a = Looper.getMainLooper();
    }

    public zza(Looper looper) {
        super(looper);
        this.f62830a = Looper.getMainLooper();
    }
}
