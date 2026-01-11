package org.apache.commons.lang3.function;

import java.lang.Throwable;

@FunctionalInterface
/* loaded from: classes7.dex */
public interface FailableDoubleConsumer<E extends Throwable> {
    public static final FailableDoubleConsumer NOP = new FailableDoubleConsumer() { // from class: org.apache.commons.lang3.function.g
    };
}
