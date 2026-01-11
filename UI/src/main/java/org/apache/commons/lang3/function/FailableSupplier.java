package org.apache.commons.lang3.function;

import java.lang.Throwable;

@FunctionalInterface
/* loaded from: classes7.dex */
public interface FailableSupplier<T, E extends Throwable> {
    public static final FailableSupplier NUL = new FailableSupplier() { // from class: org.apache.commons.lang3.function.d0
        @Override // org.apache.commons.lang3.function.FailableSupplier
        public final Object get() {
            return FailableSupplier.a();
        }
    };

    static /* synthetic */ Object a() {
        return null;
    }

    static FailableSupplier b() {
        return NUL;
    }

    Object get();
}
