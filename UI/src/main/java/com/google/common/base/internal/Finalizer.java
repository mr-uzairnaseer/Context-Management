package com.google.common.base.internal;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes2.dex */
public class Finalizer implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    public static final Logger f67990d = Logger.getLogger(Finalizer.class.getName());

    /* renamed from: e, reason: collision with root package name */
    public static final Constructor f67991e;

    /* renamed from: f, reason: collision with root package name */
    public static final Field f67992f;

    /* renamed from: a, reason: collision with root package name */
    public final WeakReference f67993a;

    /* renamed from: b, reason: collision with root package name */
    public final PhantomReference f67994b;

    /* renamed from: c, reason: collision with root package name */
    public final ReferenceQueue f67995c;

    static {
        Constructor constructorC = c();
        f67991e = constructorC;
        f67992f = constructorC == null ? e() : null;
    }

    public static Constructor c() {
        try {
            return Thread.class.getConstructor(ThreadGroup.class, Runnable.class, String.class, Long.TYPE, Boolean.TYPE);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Field e() {
        try {
            Field declaredField = Thread.class.getDeclaredField("inheritableThreadLocals");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            f67990d.log(Level.INFO, "Couldn't access Thread.inheritableThreadLocals. Reference finalizer threads will inherit thread local values.");
            return null;
        }
    }

    public final boolean a(Reference reference) {
        Reference referencePoll;
        Method methodD = d();
        if (methodD == null || !b(reference, methodD)) {
            return false;
        }
        do {
            referencePoll = this.f67995c.poll();
            if (referencePoll == null) {
                return true;
            }
        } while (b(referencePoll, methodD));
        return false;
    }

    public final boolean b(Reference reference, Method method) {
        reference.clear();
        if (reference == this.f67994b) {
            return false;
        }
        try {
            method.invoke(reference, null);
            return true;
        } catch (Throwable th) {
            f67990d.log(Level.SEVERE, "Error cleaning up after reference.", th);
            return true;
        }
    }

    public final Method d() {
        Class cls = (Class) this.f67993a.get();
        if (cls == null) {
            return null;
        }
        try {
            return cls.getMethod("finalizeReferent", null);
        } catch (NoSuchMethodException e3) {
            throw new AssertionError(e3);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        while (a(this.f67995c.remove())) {
        }
    }
}
