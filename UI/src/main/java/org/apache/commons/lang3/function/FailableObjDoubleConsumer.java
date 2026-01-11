package org.apache.commons.lang3.function;

import java.lang.Throwable;

@FunctionalInterface
/* loaded from: classes7.dex */
public interface FailableObjDoubleConsumer<T, E extends Throwable> {
    public static final FailableObjDoubleConsumer NOP = new FailableObjDoubleConsumer() { // from class: org.apache.commons.lang3.function.z
    };
}
