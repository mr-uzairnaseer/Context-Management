package com.google.android.gms.internal.wearable;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* loaded from: classes4.dex */
public class zzt extends Handler {
    public zzt(Looper looper) {
        super(looper);
        Looper.getMainLooper();
    }

    public void a(Message message) {
        super.dispatchMessage(message);
    }

    @Override // android.os.Handler
    public final void dispatchMessage(Message message) {
        a(message);
    }
}
