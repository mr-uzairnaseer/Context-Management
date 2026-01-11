package org.apache.commons.lang3.function;

import java.lang.Throwable;

@FunctionalInterface
/* loaded from: classes7.dex */
public interface FailableToDoubleBiFunction<T, U, E extends Throwable> {
    public static final FailableToDoubleBiFunction NOP = new FailableToDoubleBiFunction() { // from class: org.apache.commons.lang3.function.e0
    };
}
