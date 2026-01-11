package com.airbnb.lottie.utils;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes4.dex */
public class LottieThreadFactory implements ThreadFactory {

    /* renamed from: d, reason: collision with root package name */
    public static final AtomicInteger f51330d = new AtomicInteger(1);

    /* renamed from: a, reason: collision with root package name */
    public final ThreadGroup f51331a;

    /* renamed from: b, reason: collision with root package name */
    public final AtomicInteger f51332b = new AtomicInteger(1);

    /* renamed from: c, reason: collision with root package name */
    public final String f51333c;

    public LottieThreadFactory() {
        SecurityManager securityManager = System.getSecurityManager();
        this.f51331a = securityManager == null ? Thread.currentThread().getThreadGroup() : securityManager.getThreadGroup();
        this.f51333c = "lottie-" + f51330d.getAndIncrement() + "-thread-";
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(this.f51331a, runnable, this.f51333c + this.f51332b.getAndIncrement(), 0L);
        thread.setDaemon(false);
        thread.setPriority(10);
        return thread;
    }
}
