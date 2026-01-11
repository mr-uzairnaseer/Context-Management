package com.google.android.gms.common.util.concurrent;

import android.os.Process;

/* loaded from: classes.dex */
final class zza implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final Runnable f60764a;

    public zza(Runnable runnable, int i3) {
        this.f60764a = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() throws SecurityException, IllegalArgumentException {
        Process.setThreadPriority(0);
        this.f60764a.run();
    }
}
