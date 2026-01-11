package com.google.openlocationcode;

import java.util.Objects;

/* loaded from: classes5.dex */
public final class OpenLocationCode {
    public static final String CODE_ALPHABET = "23456789CFGHJMPQRVWX";
    public static final int CODE_PRECISION_NORMAL = 10;
    public static final int MAX_DIGIT_COUNT = 15;
    public static final char PADDING_CHARACTER = '0';
    public static final char SEPARATOR = '+';

    /* renamed from: b, reason: collision with root package name */
    public static final int f74443b = 20;

    /* renamed from: c, reason: collision with root package name */
    public static final long f74444c = (20 * 25000000) * 20;

    /* renamed from: d, reason: collision with root package name */
    public static final long f74445d = (20 * 8192000) * 20;

    /* renamed from: a, reason: collision with root package name */
    public final String f74446a;

    public static class CodeArea {

        /* renamed from: a, reason: collision with root package name */
        public final double f74447a;

        /* renamed from: b, reason: collision with root package name */
        public final double f74448b;

        /* renamed from: c, reason: collision with root package name */
        public final double f74449c;

        /* renamed from: d, reason: collision with root package name */
        public final double f74450d;

        /* renamed from: e, reason: collision with root package name */
        public final int f74451e;

        public CodeArea(double d3, double d4, double d5, double d6, int i3) {
            this.f74447a = d3;
            this.f74448b = d4;
            this.f74449c = d5;
            this.f74450d = d6;
            this.f74451e = i3;
        }

        public double a() {
            return (this.f74447a + this.f74449c) / 2.0d;
        }

        public double b() {
            return (this.f74448b + this.f74450d) / 2.0d;
        }
    }

    public OpenLocationCode(String str) {
        if (f(str.toUpperCase())) {
            this.f74446a = str.toUpperCase();
            return;
        }
        throw new IllegalArgumentException("The provided code '" + str + "' is not a valid Open Location Code.");
    }

    public static CodeArea b(String str) {
        return new OpenLocationCode(str).a();
    }

    public static boolean e(String str) {
        try {
            return new OpenLocationCode(str).d();
        } catch (IllegalArgumentException unused) {
            return false;
        }
    }

    public static boolean f(String str) {
        String upperCase;
        int iIndexOf;
        if (str == null || str.length() < 2 || (iIndexOf = (upperCase = str.toUpperCase()).indexOf(43)) == -1 || iIndexOf != upperCase.lastIndexOf(43) || iIndexOf % 2 != 0 || iIndexOf > 8) {
            return false;
        }
        if (iIndexOf == 8 && (CODE_ALPHABET.indexOf(upperCase.charAt(0)) > 8 || CODE_ALPHABET.indexOf(upperCase.charAt(1)) > 17)) {
            return false;
        }
        boolean z2 = false;
        for (int i3 = 0; i3 < iIndexOf; i3++) {
            if (CODE_ALPHABET.indexOf(upperCase.charAt(i3)) == -1 && upperCase.charAt(i3) != '0') {
                return false;
            }
            if (z2) {
                if (upperCase.charAt(i3) != '0') {
                    return false;
                }
            } else if (upperCase.charAt(i3) != '0') {
                continue;
            } else {
                if (iIndexOf < 8) {
                    return false;
                }
                if (i3 != 2 && i3 != 4 && i3 != 6) {
                    return false;
                }
                z2 = true;
            }
        }
        int i4 = iIndexOf + 1;
        if (upperCase.length() > i4) {
            if (z2 || upperCase.length() == iIndexOf + 2) {
                return false;
            }
            while (i4 < upperCase.length()) {
                if (CODE_ALPHABET.indexOf(upperCase.charAt(i4)) == -1) {
                    return false;
                }
                i4++;
            }
        }
        return true;
    }

    public CodeArea a() {
        int i3;
        if (!e(this.f74446a)) {
            throw new IllegalStateException("Method decode() could only be called on valid full codes, code was " + this.f74446a + ".");
        }
        String strReplace = this.f74446a.replace(String.valueOf(SEPARATOR), "").replace(String.valueOf('0'), "");
        long j3 = f74444c;
        long j4 = f74445d;
        long jIndexOf = -2250000000L;
        long jIndexOf2 = -1474560000;
        int i4 = 0;
        while (true) {
            if (i4 >= Math.min(strReplace.length(), 10)) {
                break;
            }
            int i5 = f74443b;
            j3 /= i5;
            j4 /= i5;
            jIndexOf += CODE_ALPHABET.indexOf(strReplace.charAt(i4)) * j3;
            jIndexOf2 += CODE_ALPHABET.indexOf(strReplace.charAt(i4 + 1)) * j4;
            i4 += 2;
        }
        for (i3 = 10; i3 < Math.min(strReplace.length(), 15); i3++) {
            j3 /= 5;
            j4 /= 4;
            int iIndexOf = CODE_ALPHABET.indexOf(strReplace.charAt(i3));
            jIndexOf += (iIndexOf / 4) * j3;
            jIndexOf2 += (iIndexOf % 4) * j4;
        }
        return new CodeArea(jIndexOf / 2.5E7d, jIndexOf2 / 8192000.0d, (jIndexOf + j3) / 2.5E7d, (jIndexOf2 + j4) / 8192000.0d, Math.min(strReplace.length(), 15));
    }

    public String c() {
        return this.f74446a;
    }

    public boolean d() {
        return this.f74446a.indexOf(43) == 8;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || OpenLocationCode.class != obj.getClass()) {
            return false;
        }
        return Objects.equals(this.f74446a, ((OpenLocationCode) obj).f74446a);
    }

    public int hashCode() {
        String str = this.f74446a;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return c();
    }
}
