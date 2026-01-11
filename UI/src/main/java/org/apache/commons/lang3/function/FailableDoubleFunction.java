package org.apache.commons.lang3.function;

import java.lang.Throwable;

@FunctionalInterface
/* loaded from: classes7.dex */
public interface FailableDoubleFunction<R, E extends Throwable> {
    public static final FailableDoubleFunction NOP = new FailableDoubleFunction() { // from class: org.apache.commons.lang3.function.h
    };
}
