package org.apache.commons.io.input;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;

/* loaded from: classes6.dex */
final class ByteBufferCleaner {

    /* renamed from: a, reason: collision with root package name */
    public static final Cleaner f161557a = b();

    public interface Cleaner {
        void a(ByteBuffer byteBuffer);
    }

    public static final class Java8Cleaner implements Cleaner {

        /* renamed from: a, reason: collision with root package name */
        public final Method f161558a;

        /* renamed from: b, reason: collision with root package name */
        public final Method f161559b;

        @Override // org.apache.commons.io.input.ByteBufferCleaner.Cleaner
        public void a(ByteBuffer byteBuffer) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            Object objInvoke = this.f161558a.invoke(byteBuffer, null);
            if (objInvoke != null) {
                this.f161559b.invoke(objInvoke, null);
            }
        }

        private Java8Cleaner() throws SecurityException, ReflectiveOperationException {
            this.f161559b = Class.forName("sun.misc.Cleaner").getMethod("clean", null);
            this.f161558a = Class.forName("sun.nio.ch.DirectBuffer").getMethod("cleaner", null);
        }
    }

    public static final class Java9Cleaner implements Cleaner {

        /* renamed from: a, reason: collision with root package name */
        public final Object f161560a;

        /* renamed from: b, reason: collision with root package name */
        public final Method f161561b;

        @Override // org.apache.commons.io.input.ByteBufferCleaner.Cleaner
        public void a(ByteBuffer byteBuffer) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            this.f161561b.invoke(this.f161560a, byteBuffer);
        }

        private Java9Cleaner() throws SecurityException, ReflectiveOperationException {
            Class<?> cls = Class.forName("sun.misc.Unsafe");
            Field declaredField = cls.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            this.f161560a = declaredField.get(null);
            this.f161561b = cls.getMethod("invokeCleaner", ByteBuffer.class);
        }
    }

    public static void a(ByteBuffer byteBuffer) {
        try {
            f161557a.a(byteBuffer);
        } catch (Exception e3) {
            throw new IllegalStateException("Failed to clean direct buffer.", e3);
        }
    }

    public static Cleaner b() {
        try {
            return new Java8Cleaner();
        } catch (Exception e3) {
            try {
                return new Java9Cleaner();
            } catch (Exception unused) {
                throw new IllegalStateException("Failed to initialize a Cleaner.", e3);
            }
        }
    }

    public static boolean c() {
        return f161557a != null;
    }
}
