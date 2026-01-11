package org.apache.commons.lang3.function;

import java.lang.Throwable;

@FunctionalInterface
/* loaded from: classes7.dex */
public interface FailableIntConsumer<E extends Throwable> {
    public static final FailableIntConsumer NOP = new FailableIntConsumer() { // from class: org.apache.commons.lang3.function.n
    };
}
