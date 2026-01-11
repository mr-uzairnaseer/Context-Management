package org.apache.commons.lang3.function;

import java.lang.Throwable;
import java.util.Objects;
import java.util.function.Function;

@FunctionalInterface
/* loaded from: classes7.dex */
public interface FailableConsumer<T, E extends Throwable> {
    public static final FailableConsumer NOP;

    static {
        final Function functionIdentity = Function.identity();
        Objects.requireNonNull(functionIdentity);
        NOP = new FailableConsumer() { // from class: org.apache.commons.lang3.function.f
            @Override // org.apache.commons.lang3.function.FailableConsumer
            public final void accept(Object obj) {
                functionIdentity.apply(obj);
            }
        };
    }

    static FailableConsumer a() {
        return NOP;
    }

    void accept(Object obj);
}
