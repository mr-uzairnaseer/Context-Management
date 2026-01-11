package com.google.android.gms.internal.base;

import android.os.Handler;
import android.os.Looper;

/* loaded from: classes.dex */
public class zau extends Handler {

    /* renamed from: a, reason: collision with root package name */
    public final Looper f61450a;

    public zau() {
        this.f61450a = Looper.getMainLooper();
    }

    public zau(Looper looper) {
        super(looper);
        this.f61450a = Looper.getMainLooper();
    }

    public zau(Looper looper, Handler.Callback callback) {
        super(looper, callback);
        this.f61450a = Looper.getMainLooper();
    }
}
