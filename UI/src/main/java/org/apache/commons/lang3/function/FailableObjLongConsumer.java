package org.apache.commons.lang3.function;

import java.lang.Throwable;

@FunctionalInterface
/* loaded from: classes7.dex */
public interface FailableObjLongConsumer<T, E extends Throwable> {
    public static final FailableObjLongConsumer NOP = new FailableObjLongConsumer() { // from class: org.apache.commons.lang3.function.b0
    };
}
