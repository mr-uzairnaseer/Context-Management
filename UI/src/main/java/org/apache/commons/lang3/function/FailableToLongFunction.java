package org.apache.commons.lang3.function;

import java.lang.Throwable;

@FunctionalInterface
/* loaded from: classes7.dex */
public interface FailableToLongFunction<T, E extends Throwable> {
    public static final FailableToLongFunction NOP = new FailableToLongFunction() { // from class: org.apache.commons.lang3.function.j0
    };
}
