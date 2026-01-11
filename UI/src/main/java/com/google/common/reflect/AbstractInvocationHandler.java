package com.google.common.reflect;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/* loaded from: classes5.dex */
public abstract class AbstractInvocationHandler implements InvocationHandler {

    /* renamed from: a, reason: collision with root package name */
    public static final Object[] f70005a = new Object[0];

    public static boolean b(Object obj, Class cls) {
        if (cls.isInstance(obj)) {
            return true;
        }
        return Proxy.isProxyClass(obj.getClass()) && Arrays.equals(obj.getClass().getInterfaces(), cls.getInterfaces());
    }

    public abstract Object a(Object obj, Method method, Object[] objArr);

    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public int hashCode() {
        return super.hashCode();
    }

    @Override // java.lang.reflect.InvocationHandler
    public final Object invoke(Object obj, Method method, Object[] objArr) {
        if (objArr == null) {
            objArr = f70005a;
        }
        if (objArr.length == 0 && method.getName().equals("hashCode")) {
            return Integer.valueOf(hashCode());
        }
        if (objArr.length != 1 || !method.getName().equals("equals") || method.getParameterTypes()[0] != Object.class) {
            return (objArr.length == 0 && method.getName().equals(InAppPurchaseConstants.METHOD_TO_STRING)) ? toString() : a(obj, method, objArr);
        }
        Object obj2 = objArr[0];
        if (obj2 == null) {
            return Boolean.FALSE;
        }
        if (obj == obj2) {
            return Boolean.TRUE;
        }
        return Boolean.valueOf(b(obj2, obj.getClass()) && equals(Proxy.getInvocationHandler(obj2)));
    }

    public String toString() {
        return super.toString();
    }
}
