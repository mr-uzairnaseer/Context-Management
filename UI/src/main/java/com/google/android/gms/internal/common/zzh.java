package com.google.android.gms.internal.common;

import android.os.Handler;
import android.os.Looper;

/* loaded from: classes4.dex */
public class zzh extends Handler {

    /* renamed from: a, reason: collision with root package name */
    public final Looper f61473a;

    public zzh() {
        this.f61473a = Looper.getMainLooper();
    }

    public zzh(Looper looper) {
        super(looper);
        this.f61473a = Looper.getMainLooper();
    }

    public zzh(Looper looper, Handler.Callback callback) {
        super(looper, callback);
        this.f61473a = Looper.getMainLooper();
    }
}
