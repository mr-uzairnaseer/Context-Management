package org.apache.commons.lang3.function;

import java.lang.Throwable;

@FunctionalInterface
/* loaded from: classes7.dex */
public interface FailableBiConsumer<T, U, E extends Throwable> {
    public static final FailableBiConsumer NOP = new FailableBiConsumer() { // from class: org.apache.commons.lang3.function.c
        @Override // org.apache.commons.lang3.function.FailableBiConsumer
        public final void accept(Object obj, Object obj2) {
            FailableBiConsumer.a(obj, obj2);
        }
    };

    static /* synthetic */ void a(Object obj, Object obj2) {
    }

    void accept(Object obj, Object obj2);
}
