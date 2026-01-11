package com.google.firebase.crashlytics.internal;

import android.util.Log;

/* loaded from: classes.dex */
public class Logger {
    public static final String TAG = "FirebaseCrashlytics";

    /* renamed from: c, reason: collision with root package name */
    public static final Logger f72113c = new Logger(TAG);

    /* renamed from: a, reason: collision with root package name */
    public final String f72114a;

    /* renamed from: b, reason: collision with root package name */
    public int f72115b = 4;

    public Logger(String str) {
        this.f72114a = str;
    }

    public static Logger f() {
        return f72113c;
    }

    public final boolean a(int i3) {
        return this.f72115b <= i3 || Log.isLoggable(this.f72114a, i3);
    }

    public void b(String str) {
        c(str, null);
    }

    public void c(String str, Throwable th) {
        if (a(3)) {
            Log.d(this.f72114a, str, th);
        }
    }

    public void d(String str) {
        e(str, null);
    }

    public void e(String str, Throwable th) {
        if (a(6)) {
            Log.e(this.f72114a, str, th);
        }
    }

    public void g(String str) {
        h(str, null);
    }

    public void h(String str, Throwable th) {
        if (a(4)) {
            Log.i(this.f72114a, str, th);
        }
    }

    public void i(String str) {
        j(str, null);
    }

    public void j(String str, Throwable th) {
        if (a(2)) {
            Log.v(this.f72114a, str, th);
        }
    }

    public void k(String str) {
        l(str, null);
    }

    public void l(String str, Throwable th) {
        if (a(5)) {
            Log.w(this.f72114a, str, th);
        }
    }
}
