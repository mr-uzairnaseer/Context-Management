package org.apache.commons.lang3.function;

import java.lang.Throwable;

@FunctionalInterface
/* loaded from: classes7.dex */
public interface FailableLongFunction<R, E extends Throwable> {
    public static final FailableLongFunction NOP = new FailableLongFunction() { // from class: org.apache.commons.lang3.function.u
    };
}
