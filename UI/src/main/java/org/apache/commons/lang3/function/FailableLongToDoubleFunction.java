package org.apache.commons.lang3.function;

import java.lang.Throwable;

@FunctionalInterface
/* loaded from: classes7.dex */
public interface FailableLongToDoubleFunction<E extends Throwable> {
    public static final FailableLongToDoubleFunction NOP = new FailableLongToDoubleFunction() { // from class: org.apache.commons.lang3.function.w
    };
}
