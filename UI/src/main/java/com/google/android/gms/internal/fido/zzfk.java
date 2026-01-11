package com.google.android.gms.internal.fido;

/* loaded from: classes4.dex */
public final class zzfk {
    public static Object a(Object obj, String str) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(str.concat(" must not be null"));
    }

    public static String b(String str) {
        if (str.isEmpty()) {
            throw new IllegalArgumentException("identifier must not be empty");
        }
        if (!c(str.charAt(0))) {
            throw new IllegalArgumentException("identifier must start with an ASCII letter: ".concat(str));
        }
        for (int i3 = 1; i3 < str.length(); i3++) {
            char cCharAt = str.charAt(i3);
            if (!c(cCharAt) && ((cCharAt < '0' || cCharAt > '9') && cCharAt != '_')) {
                throw new IllegalArgumentException("identifier must contain only ASCII letters, digits or underscore: ".concat(str));
            }
        }
        return str;
    }

    public static boolean c(char c3) {
        if (c3 < 'a' || c3 > 'z') {
            return c3 >= 'A' && c3 <= 'Z';
        }
        return true;
    }
}
