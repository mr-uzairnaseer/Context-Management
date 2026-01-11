package org.apache.commons.lang3.function;

import java.lang.Throwable;

@FunctionalInterface
/* loaded from: classes7.dex */
public interface FailableToIntFunction<T, E extends Throwable> {
    public static final FailableToIntFunction NOP = new FailableToIntFunction() { // from class: org.apache.commons.lang3.function.h0
    };
}
