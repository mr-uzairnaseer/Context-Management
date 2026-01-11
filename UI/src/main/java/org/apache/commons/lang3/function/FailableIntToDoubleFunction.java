package org.apache.commons.lang3.function;

import java.lang.Throwable;

@FunctionalInterface
/* loaded from: classes7.dex */
public interface FailableIntToDoubleFunction<E extends Throwable> {
    public static final FailableIntToDoubleFunction NOP = new FailableIntToDoubleFunction() { // from class: org.apache.commons.lang3.function.q
    };
}
