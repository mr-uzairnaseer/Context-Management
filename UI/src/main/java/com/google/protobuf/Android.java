package com.google.protobuf;

/* loaded from: classes.dex */
final class Android {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f74460a;

    /* renamed from: b, reason: collision with root package name */
    public static final Class f74461b = a("libcore.io.Memory");

    /* renamed from: c, reason: collision with root package name */
    public static final boolean f74462c;

    static {
        f74462c = (f74460a || a("org.robolectric.Robolectric") == null) ? false : true;
    }

    private Android() {
    }

    public static Class a(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Class b() {
        return f74461b;
    }

    public static boolean c() {
        if (f74460a) {
            return true;
        }
        return (f74461b == null || f74462c) ? false : true;
    }
}
