package org.apache.commons.compress.utils;

/* loaded from: classes5.dex */
public class OsgiUtils {

    /* renamed from: a, reason: collision with root package name */
    public static final boolean f161320a;

    static {
        ClassLoader classLoader = OsgiUtils.class.getClassLoader();
        f161320a = classLoader != null && a(classLoader.getClass());
    }

    public static boolean a(Class cls) {
        while (true) {
            if (cls == null) {
                return false;
            }
            if (cls.getName().equals("org.osgi.framework.BundleReference")) {
                return true;
            }
            for (Class<?> cls2 : cls.getInterfaces()) {
                if (a(cls2)) {
                    return true;
                }
            }
            cls = cls.getSuperclass();
        }
    }

    public static boolean b() {
        return f161320a;
    }
}
