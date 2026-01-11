package dagger.hilt.android.internal;

import android.os.Looper;

/* loaded from: classes.dex */
public final class ThreadUtil {

    /* renamed from: a, reason: collision with root package name */
    public static Thread f76036a;

    private ThreadUtil() {
    }

    public static void a() {
        if (!b()) {
            throw new IllegalStateException("Must be called on the Main thread.");
        }
    }

    public static boolean b() {
        if (f76036a == null) {
            f76036a = Looper.getMainLooper().getThread();
        }
        return Thread.currentThread() == f76036a;
    }
}
