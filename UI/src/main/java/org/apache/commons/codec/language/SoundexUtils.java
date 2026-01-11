package org.apache.commons.codec.language;

import java.util.Locale;

/* loaded from: classes4.dex */
final class SoundexUtils {
    public static String a(String str) {
        if (b(str)) {
            return str;
        }
        int length = str.length();
        char[] cArr = new char[length];
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            if (Character.isLetter(str.charAt(i4))) {
                cArr[i3] = str.charAt(i4);
                i3++;
            }
        }
        return i3 == length ? str.toUpperCase(Locale.ENGLISH) : new String(cArr, 0, i3).toUpperCase(Locale.ENGLISH);
    }

    public static boolean b(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }
}
