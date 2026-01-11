package retrofit2;

import java.lang.invoke.MethodHandles;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/* loaded from: classes9.dex */
final class DefaultMethodSupport {

    /* renamed from: a, reason: collision with root package name */
    public static Constructor f165861a;

    private DefaultMethodSupport() {
    }

    public static Object a(Method method, Class cls, Object obj, Object[] objArr) throws NoSuchMethodException, SecurityException {
        Constructor declaredConstructor = f165861a;
        if (declaredConstructor == null) {
            declaredConstructor = MethodHandles.Lookup.class.getDeclaredConstructor(Class.class, Integer.TYPE);
            declaredConstructor.setAccessible(true);
            f165861a = declaredConstructor;
        }
        return ((MethodHandles.Lookup) declaredConstructor.newInstance(cls, -1)).unreflectSpecial(method, cls).bindTo(obj).invokeWithArguments(objArr);
    }
}
