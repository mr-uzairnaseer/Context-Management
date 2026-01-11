package org.apache.commons.lang3.function;

import java.lang.Throwable;

@FunctionalInterface
/* loaded from: classes7.dex */
public interface FailableBiFunction<T, U, R, E extends Throwable> {
    public static final FailableBiFunction NOP = new FailableBiFunction() { // from class: org.apache.commons.lang3.function.d
    };
}
