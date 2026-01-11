package org.apache.commons.lang3.function;

import java.lang.Throwable;

@FunctionalInterface
/* loaded from: classes7.dex */
public interface FailableToLongBiFunction<T, U, E extends Throwable> {
    public static final FailableToLongBiFunction NOP = new FailableToLongBiFunction() { // from class: org.apache.commons.lang3.function.i0
    };
}
