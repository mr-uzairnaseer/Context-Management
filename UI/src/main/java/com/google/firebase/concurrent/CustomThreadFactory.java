package com.google.firebase.concurrent;

import android.os.Process;
import android.os.StrictMode;
import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes.dex */
class CustomThreadFactory implements ThreadFactory {

    /* renamed from: e, reason: collision with root package name */
    public static final ThreadFactory f72006e = Executors.defaultThreadFactory();

    /* renamed from: a, reason: collision with root package name */
    public final AtomicLong f72007a = new AtomicLong();

    /* renamed from: b, reason: collision with root package name */
    public final String f72008b;

    /* renamed from: c, reason: collision with root package name */
    public final int f72009c;

    /* renamed from: d, reason: collision with root package name */
    public final StrictMode.ThreadPolicy f72010d;

    public CustomThreadFactory(String str, int i3, StrictMode.ThreadPolicy threadPolicy) {
        this.f72008b = str;
        this.f72009c = i3;
        this.f72010d = threadPolicy;
    }

    public static /* synthetic */ void a(CustomThreadFactory customThreadFactory, Runnable runnable) throws SecurityException, IllegalArgumentException {
        Process.setThreadPriority(customThreadFactory.f72009c);
        StrictMode.ThreadPolicy threadPolicy = customThreadFactory.f72010d;
        if (threadPolicy != null) {
            StrictMode.setThreadPolicy(threadPolicy);
        }
        runnable.run();
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(final Runnable runnable) {
        Thread threadNewThread = f72006e.newThread(new Runnable() { // from class: com.google.firebase.concurrent.a
            @Override // java.lang.Runnable
            public final void run() throws SecurityException, IllegalArgumentException {
                CustomThreadFactory.a(this.f72038a, runnable);
            }
        });
        threadNewThread.setName(String.format(Locale.ROOT, "%s Thread #%d", this.f72008b, Long.valueOf(this.f72007a.getAndIncrement())));
        return threadNewThread;
    }
}
