package org.apache.commons.io.input;

import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Proxy;

/* loaded from: classes6.dex */
public class ClassLoaderObjectInputStream extends ObjectInputStream {

    /* renamed from: a, reason: collision with root package name */
    public final ClassLoader f161582a;

    @Override // java.io.ObjectInputStream
    public Class resolveClass(ObjectStreamClass objectStreamClass) {
        try {
            return Class.forName(objectStreamClass.getName(), false, this.f161582a);
        } catch (ClassNotFoundException unused) {
            return super.resolveClass(objectStreamClass);
        }
    }

    @Override // java.io.ObjectInputStream
    public Class resolveProxyClass(String[] strArr) {
        Class[] clsArr = new Class[strArr.length];
        for (int i3 = 0; i3 < strArr.length; i3++) {
            clsArr[i3] = Class.forName(strArr[i3], false, this.f161582a);
        }
        try {
            return Proxy.getProxyClass(this.f161582a, clsArr);
        } catch (IllegalArgumentException unused) {
            return super.resolveProxyClass(strArr);
        }
    }
}
