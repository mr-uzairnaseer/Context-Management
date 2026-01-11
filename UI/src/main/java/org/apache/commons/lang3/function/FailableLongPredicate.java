package org.apache.commons.lang3.function;

import java.lang.Throwable;

@FunctionalInterface
/* loaded from: classes7.dex */
public interface FailableLongPredicate<E extends Throwable> {
    public static final FailableLongPredicate FALSE = new FailableLongPredicate() { // from class: org.apache.commons.lang3.function.v
    };
    public static final FailableLongPredicate TRUE = new FailableLongPredicate() { // from class: org.apache.commons.lang3.function.v
    };
}
