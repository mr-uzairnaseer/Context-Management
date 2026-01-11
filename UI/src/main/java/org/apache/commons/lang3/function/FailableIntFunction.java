package org.apache.commons.lang3.function;

import java.lang.Throwable;

@FunctionalInterface
/* loaded from: classes7.dex */
public interface FailableIntFunction<R, E extends Throwable> {
    public static final FailableIntFunction NOP = new FailableIntFunction() { // from class: org.apache.commons.lang3.function.o
    };
}
