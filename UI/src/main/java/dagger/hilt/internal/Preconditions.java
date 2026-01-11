package dagger.hilt.internal;

/* loaded from: classes.dex */
public final class Preconditions {
    private Preconditions() {
    }

    public static void a(boolean z2, String str, Object... objArr) {
        if (!z2) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    public static Object b(Object obj) {
        obj.getClass();
        return obj;
    }

    public static Object c(Object obj, String str) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(str);
    }

    public static void d(boolean z2, String str, Object... objArr) {
        if (!z2) {
            throw new IllegalStateException(String.format(str, objArr));
        }
    }
}
