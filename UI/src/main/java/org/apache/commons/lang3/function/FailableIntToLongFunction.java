package org.apache.commons.lang3.function;

import java.lang.Throwable;

@FunctionalInterface
/* loaded from: classes7.dex */
public interface FailableIntToLongFunction<E extends Throwable> {
    public static final FailableIntToLongFunction NOP = new FailableIntToLongFunction() { // from class: org.apache.commons.lang3.function.r
    };
}
