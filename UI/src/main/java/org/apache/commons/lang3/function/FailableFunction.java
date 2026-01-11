package org.apache.commons.lang3.function;

import java.lang.Throwable;

@FunctionalInterface
/* loaded from: classes7.dex */
public interface FailableFunction<T, R, E extends Throwable> {
    public static final FailableFunction NOP = new FailableFunction() { // from class: org.apache.commons.lang3.function.m
    };
}
