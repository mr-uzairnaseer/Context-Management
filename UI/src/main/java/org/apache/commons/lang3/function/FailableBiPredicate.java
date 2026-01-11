package org.apache.commons.lang3.function;

import java.lang.Throwable;

@FunctionalInterface
/* loaded from: classes7.dex */
public interface FailableBiPredicate<T, U, E extends Throwable> {
    public static final FailableBiPredicate FALSE = new FailableBiPredicate() { // from class: org.apache.commons.lang3.function.e
    };
    public static final FailableBiPredicate TRUE = new FailableBiPredicate() { // from class: org.apache.commons.lang3.function.e
    };
}
