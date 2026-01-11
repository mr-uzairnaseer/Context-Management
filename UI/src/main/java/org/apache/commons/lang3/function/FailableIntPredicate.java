package org.apache.commons.lang3.function;

import java.lang.Throwable;

@FunctionalInterface
/* loaded from: classes7.dex */
public interface FailableIntPredicate<E extends Throwable> {
    public static final FailableIntPredicate FALSE = new FailableIntPredicate() { // from class: org.apache.commons.lang3.function.p
    };
    public static final FailableIntPredicate TRUE = new FailableIntPredicate() { // from class: org.apache.commons.lang3.function.p
    };
}
