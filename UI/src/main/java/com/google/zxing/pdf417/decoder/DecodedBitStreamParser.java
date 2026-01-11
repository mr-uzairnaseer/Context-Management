package com.google.zxing.pdf417.decoder;

import java.math.BigInteger;

/* loaded from: classes5.dex */
final class DecodedBitStreamParser {

    /* renamed from: a, reason: collision with root package name */
    public static final char[] f75277a = ";<>@[\\]_`~!\r\t,:\n-.$/\"|*()?{}'".toCharArray();

    /* renamed from: b, reason: collision with root package name */
    public static final char[] f75278b = "0123456789&\r\t,:#-.$/+%*=^".toCharArray();

    /* renamed from: c, reason: collision with root package name */
    public static final BigInteger[] f75279c;

    /* renamed from: com.google.zxing.pdf417.decoder.DecodedBitStreamParser$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f75280a;

        static {
            int[] iArr = new int[Mode.values().length];
            f75280a = iArr;
            try {
                iArr[Mode.ALPHA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f75280a[Mode.LOWER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f75280a[Mode.MIXED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f75280a[Mode.PUNCT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f75280a[Mode.ALPHA_SHIFT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f75280a[Mode.PUNCT_SHIFT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public enum Mode {
        ALPHA,
        LOWER,
        MIXED,
        PUNCT,
        ALPHA_SHIFT,
        PUNCT_SHIFT
    }

    static {
        BigInteger[] bigIntegerArr = new BigInteger[16];
        f75279c = bigIntegerArr;
        bigIntegerArr[0] = BigInteger.ONE;
        BigInteger bigIntegerValueOf = BigInteger.valueOf(900L);
        bigIntegerArr[1] = bigIntegerValueOf;
        int i3 = 2;
        while (true) {
            BigInteger[] bigIntegerArr2 = f75279c;
            if (i3 >= bigIntegerArr2.length) {
                return;
            }
            bigIntegerArr2[i3] = bigIntegerArr2[i3 - 1].multiply(bigIntegerValueOf);
            i3++;
        }
    }

    private DecodedBitStreamParser() {
    }
}
