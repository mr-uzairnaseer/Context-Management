package androidx.content.preferences.protobuf;

/* loaded from: classes.dex */
final class Android {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f34893a;

    /* renamed from: b, reason: collision with root package name */
    public static final Class f34894b = a("libcore.io.Memory");

    /* renamed from: c, reason: collision with root package name */
    public static final boolean f34895c;

    static {
        f34895c = (f34893a || a("org.robolectric.Robolectric") == null) ? false : true;
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
        return f34894b;
    }

    public static boolean c() {
        if (f34893a) {
            return true;
        }
        return (f34894b == null || f34895c) ? false : true;
    }
}
