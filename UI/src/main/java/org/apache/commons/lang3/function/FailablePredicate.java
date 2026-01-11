package org.apache.commons.lang3.function;

import java.lang.Throwable;

@FunctionalInterface
/* loaded from: classes7.dex */
public interface FailablePredicate<T, E extends Throwable> {
    public static final FailablePredicate FALSE = new FailablePredicate() { // from class: org.apache.commons.lang3.function.c0
    };
    public static final FailablePredicate TRUE = new FailablePredicate() { // from class: org.apache.commons.lang3.function.c0
    };
}
