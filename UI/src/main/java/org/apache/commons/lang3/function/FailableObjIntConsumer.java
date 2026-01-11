package org.apache.commons.lang3.function;

import java.lang.Throwable;

@FunctionalInterface
/* loaded from: classes7.dex */
public interface FailableObjIntConsumer<T, E extends Throwable> {
    public static final FailableObjIntConsumer NOP = new FailableObjIntConsumer() { // from class: org.apache.commons.lang3.function.a0
    };
}
