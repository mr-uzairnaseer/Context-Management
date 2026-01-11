package org.apache.commons.lang3.function;

import java.lang.Throwable;

@FunctionalInterface
/* loaded from: classes7.dex */
public interface FailableLongConsumer<E extends Throwable> {
    public static final FailableLongConsumer NOP = new FailableLongConsumer() { // from class: org.apache.commons.lang3.function.t
    };
}
