package com.google.zxing;

/* loaded from: classes5.dex */
public abstract class ReaderException extends Exception {

    /* renamed from: a, reason: collision with root package name */
    public static final boolean f74960a;

    /* renamed from: b, reason: collision with root package name */
    public static final StackTraceElement[] f74961b;

    static {
        f74960a = System.getProperty("surefire.test.class.path") != null;
        f74961b = new StackTraceElement[0];
    }

    @Override // java.lang.Throwable
    public final synchronized Throwable fillInStackTrace() {
        return null;
    }
}
