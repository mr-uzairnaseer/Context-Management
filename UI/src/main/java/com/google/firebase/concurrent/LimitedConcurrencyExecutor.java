package com.google.firebase.concurrent;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;

/* loaded from: classes5.dex */
class LimitedConcurrencyExecutor implements Executor {

    /* renamed from: a, reason: collision with root package name */
    public final Executor f72019a;

    /* renamed from: b, reason: collision with root package name */
    public final Semaphore f72020b;

    /* renamed from: c, reason: collision with root package name */
    public final LinkedBlockingQueue f72021c;

    public static /* synthetic */ void a(LimitedConcurrencyExecutor limitedConcurrencyExecutor, Runnable runnable) {
        limitedConcurrencyExecutor.getClass();
        try {
            runnable.run();
        } finally {
            limitedConcurrencyExecutor.f72020b.release();
            limitedConcurrencyExecutor.c();
        }
    }

    public final Runnable b(final Runnable runnable) {
        return new Runnable() { // from class: com.google.firebase.concurrent.v
            @Override // java.lang.Runnable
            public final void run() {
                LimitedConcurrencyExecutor.a(this.f72078a, runnable);
            }
        };
    }

    public final void c() {
        while (this.f72020b.tryAcquire()) {
            Runnable runnable = (Runnable) this.f72021c.poll();
            if (runnable == null) {
                this.f72020b.release();
                return;
            }
            this.f72019a.execute(b(runnable));
        }
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.f72021c.offer(runnable);
        c();
    }
}
