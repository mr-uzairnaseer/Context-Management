package org.apache.commons.compress.utils;

/* loaded from: classes5.dex */
public class ExactMath {
    private ExactMath() {
    }

    public static int a(int i3, long j3) {
        try {
            return Math.addExact(i3, Math.toIntExact(j3));
        } catch (ArithmeticException e3) {
            throw new IllegalArgumentException("Argument too large or result overflows", e3);
        }
    }
}
