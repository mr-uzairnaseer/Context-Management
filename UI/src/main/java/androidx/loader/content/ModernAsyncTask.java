package androidx.loader.content;

import android.os.Binder;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.util.Log;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
abstract class ModernAsyncTask<Result> {

    /* renamed from: e, reason: collision with root package name */
    public static Handler f36728e;

    /* renamed from: b, reason: collision with root package name */
    public volatile Status f36730b = Status.PENDING;

    /* renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f36731c = new AtomicBoolean();

    /* renamed from: d, reason: collision with root package name */
    public final AtomicBoolean f36732d = new AtomicBoolean();

    /* renamed from: a, reason: collision with root package name */
    public final FutureTask f36729a = new FutureTask<Result>(new Callable<Result>() { // from class: androidx.loader.content.ModernAsyncTask.1
        @Override // java.util.concurrent.Callable
        public Object call() {
            ModernAsyncTask.this.f36732d.set(true);
            Object objB = null;
            try {
                Process.setThreadPriority(10);
                objB = ModernAsyncTask.this.b();
                Binder.flushPendingCommands();
                return objB;
            } finally {
            }
        }
    }) { // from class: androidx.loader.content.ModernAsyncTask.2
        @Override // java.util.concurrent.FutureTask
        public void done() {
            try {
                ModernAsyncTask.this.j(get());
            } catch (InterruptedException e3) {
                Log.w("AsyncTask", e3);
            } catch (CancellationException unused) {
                ModernAsyncTask.this.j(null);
            } catch (ExecutionException e4) {
                throw new RuntimeException("An error occurred while executing doInBackground()", e4.getCause());
            } catch (Throwable th) {
                throw new RuntimeException("An error occurred while executing doInBackground()", th);
            }
        }
    };

    /* renamed from: androidx.loader.content.ModernAsyncTask$4, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass4 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f36737a;

        static {
            int[] iArr = new int[Status.values().length];
            f36737a = iArr;
            try {
                iArr[Status.RUNNING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f36737a[Status.FINISHED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public enum Status {
        PENDING,
        RUNNING,
        FINISHED
    }

    public static Handler e() {
        Handler handler;
        synchronized (ModernAsyncTask.class) {
            try {
                if (f36728e == null) {
                    f36728e = new Handler(Looper.getMainLooper());
                }
                handler = f36728e;
            } catch (Throwable th) {
                throw th;
            }
        }
        return handler;
    }

    public final boolean a(boolean z2) {
        this.f36731c.set(true);
        return this.f36729a.cancel(z2);
    }

    public abstract Object b();

    public final void c(Executor executor) {
        if (this.f36730b == Status.PENDING) {
            this.f36730b = Status.RUNNING;
            executor.execute(this.f36729a);
            return;
        }
        int i3 = AnonymousClass4.f36737a[this.f36730b.ordinal()];
        if (i3 == 1) {
            throw new IllegalStateException("Cannot execute task: the task is already running.");
        }
        if (i3 == 2) {
            throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
        }
        throw new IllegalStateException("We should never reach this state");
    }

    public void d(Object obj) {
        if (f()) {
            g(obj);
        } else {
            h(obj);
        }
        this.f36730b = Status.FINISHED;
    }

    public final boolean f() {
        return this.f36731c.get();
    }

    public void g(Object obj) {
    }

    public void h(Object obj) {
    }

    public void i(final Object obj) {
        e().post(new Runnable() { // from class: androidx.loader.content.ModernAsyncTask.3
            @Override // java.lang.Runnable
            public void run() {
                ModernAsyncTask.this.d(obj);
            }
        });
    }

    public void j(Object obj) {
        if (this.f36732d.get()) {
            return;
        }
        i(obj);
    }
}
