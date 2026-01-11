package com.google.firebase.perf.logging;

import android.util.Log;

/* loaded from: classes.dex */
class LogWrapper {

    /* renamed from: a, reason: collision with root package name */
    public static LogWrapper f73427a;

    private LogWrapper() {
    }

    public static synchronized LogWrapper c() {
        try {
            if (f73427a == null) {
                f73427a = new LogWrapper();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f73427a;
    }

    public void a(String str) {
        Log.d("FirebasePerformance", str);
    }

    public void b(String str) {
        Log.e("FirebasePerformance", str);
    }

    public void d(String str) {
        Log.i("FirebasePerformance", str);
    }

    public void e(String str) {
        Log.w("FirebasePerformance", str);
    }
}
