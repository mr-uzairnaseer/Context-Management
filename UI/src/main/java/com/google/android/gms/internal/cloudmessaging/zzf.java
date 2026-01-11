package com.google.android.gms.internal.cloudmessaging;

import android.os.Handler;
import android.os.Looper;

/* loaded from: classes.dex */
public class zzf extends Handler {

    /* renamed from: a, reason: collision with root package name */
    public final Looper f61453a;

    public zzf() {
        this.f61453a = Looper.getMainLooper();
    }

    public zzf(Looper looper) {
        super(looper);
        this.f61453a = Looper.getMainLooper();
    }

    public zzf(Looper looper, Handler.Callback callback) {
        super(looper, callback);
        this.f61453a = Looper.getMainLooper();
    }
}
