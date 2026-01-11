package org.apache.commons.lang3.function;

import java.lang.Throwable;

@FunctionalInterface
/* loaded from: classes7.dex */
public interface FailableToIntBiFunction<T, U, E extends Throwable> {
    public static final FailableToIntBiFunction NOP = new FailableToIntBiFunction() { // from class: org.apache.commons.lang3.function.g0
    };
}
