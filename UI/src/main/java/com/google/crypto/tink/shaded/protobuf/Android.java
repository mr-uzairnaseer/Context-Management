package com.google.crypto.tink.shaded.protobuf;

/* loaded from: classes5.dex */
final class Android {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f71034a;

    /* renamed from: b, reason: collision with root package name */
    public static final Class f71035b = a("libcore.io.Memory");

    /* renamed from: c, reason: collision with root package name */
    public static final boolean f71036c;

    static {
        f71036c = (f71034a || a("org.robolectric.Robolectric") == null) ? false : true;
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
        return f71035b;
    }

    public static boolean c() {
        if (f71034a) {
            return true;
        }
        return (f71035b == null || f71036c) ? false : true;
    }
}
