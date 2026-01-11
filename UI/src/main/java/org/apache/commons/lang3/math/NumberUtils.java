package org.apache.commons.lang3.math;

import androidx.collection.SieveCacheKt;

/* loaded from: classes7.dex */
public class NumberUtils {
    public static final Long LONG_ZERO = 0L;
    public static final Long LONG_ONE = 1L;
    public static final Long LONG_MINUS_ONE = -1L;
    public static final Integer INTEGER_ZERO = 0;
    public static final Integer INTEGER_ONE = 1;
    public static final Integer INTEGER_TWO = 2;
    public static final Integer INTEGER_MINUS_ONE = -1;
    public static final Short SHORT_ZERO = 0;
    public static final Short SHORT_ONE = 1;
    public static final Short SHORT_MINUS_ONE = -1;
    public static final Byte BYTE_ZERO = (byte) 0;
    public static final Byte BYTE_ONE = (byte) 1;
    public static final Byte BYTE_MINUS_ONE = (byte) -1;
    public static final Double DOUBLE_ZERO = Double.valueOf(0.0d);
    public static final Double DOUBLE_ONE = Double.valueOf(1.0d);
    public static final Double DOUBLE_MINUS_ONE = Double.valueOf(-1.0d);
    public static final Float FLOAT_ZERO = Float.valueOf(0.0f);
    public static final Float FLOAT_ONE = Float.valueOf(1.0f);
    public static final Float FLOAT_MINUS_ONE = Float.valueOf(-1.0f);
    public static final Long LONG_INT_MAX_VALUE = Long.valueOf(SieveCacheKt.NodeLinkMask);
    public static final Long LONG_INT_MIN_VALUE = Long.valueOf(SieveCacheKt.NodeMetaAndPreviousMask);

    @Deprecated
    public NumberUtils() {
    }

    public static int a(byte b3, byte b4) {
        return b3 - b4;
    }

    public static int b(int i3, int i4) {
        if (i3 == i4) {
            return 0;
        }
        return i3 < i4 ? -1 : 1;
    }

    public static int c(long j3, long j4) {
        if (j3 == j4) {
            return 0;
        }
        return j3 < j4 ? -1 : 1;
    }

    public static int d(short s2, short s3) {
        if (s2 == s3) {
            return 0;
        }
        return s2 < s3 ? -1 : 1;
    }

    public static float e(String str, float f3) {
        if (str == null) {
            return f3;
        }
        try {
            return Float.parseFloat(str);
        } catch (NumberFormatException unused) {
            return f3;
        }
    }
}
