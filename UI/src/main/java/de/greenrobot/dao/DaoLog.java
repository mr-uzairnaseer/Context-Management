package de.greenrobot.dao;

import android.util.Log;

/* loaded from: classes5.dex */
public class DaoLog {
    public static final int ASSERT = 7;
    public static final int DEBUG = 3;
    public static final int ERROR = 6;
    public static final int INFO = 4;
    public static final int VERBOSE = 2;
    public static final int WARN = 5;

    public static int a(String str) {
        return Log.d("greenDAO", str);
    }

    public static int b(String str, Throwable th) {
        return Log.e("greenDAO", str, th);
    }

    public static int c(String str) {
        return Log.i("greenDAO", str);
    }

    public static int d(String str, Throwable th) {
        return Log.i("greenDAO", str, th);
    }

    public static int e(String str) {
        return Log.w("greenDAO", str);
    }

    public static int f(String str, Throwable th) {
        return Log.w("greenDAO", str, th);
    }
}
