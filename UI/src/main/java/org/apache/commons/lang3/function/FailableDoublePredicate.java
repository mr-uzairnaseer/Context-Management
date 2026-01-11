package org.apache.commons.lang3.function;

import java.lang.Throwable;

@FunctionalInterface
/* loaded from: classes7.dex */
public interface FailableDoublePredicate<E extends Throwable> {
    public static final FailableDoublePredicate FALSE = new FailableDoublePredicate() { // from class: org.apache.commons.lang3.function.i
    };
    public static final FailableDoublePredicate TRUE = new FailableDoublePredicate() { // from class: org.apache.commons.lang3.function.i
    };
}
