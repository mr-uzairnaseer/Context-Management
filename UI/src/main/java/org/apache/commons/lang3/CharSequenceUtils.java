package org.apache.commons.lang3;

/* loaded from: classes7.dex */
public class CharSequenceUtils {
    @Deprecated
    public CharSequenceUtils() {
    }

    public static int a(CharSequence charSequence, CharSequence charSequence2, int i3) {
        return charSequence instanceof String ? ((String) charSequence).indexOf(charSequence2.toString(), i3) : charSequence instanceof StringBuilder ? ((StringBuilder) charSequence).indexOf(charSequence2.toString(), i3) : charSequence instanceof StringBuffer ? ((StringBuffer) charSequence).indexOf(charSequence2.toString(), i3) : charSequence.toString().indexOf(charSequence2.toString(), i3);
    }

    public static boolean b(CharSequence charSequence, boolean z2, int i3, CharSequence charSequence2, int i4, int i5) {
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            return ((String) charSequence).regionMatches(z2, i3, (String) charSequence2, i4, i5);
        }
        int length = charSequence.length() - i3;
        int length2 = charSequence2.length() - i4;
        if (i3 < 0 || i4 < 0 || i5 < 0 || length < i5 || length2 < i5) {
            return false;
        }
        while (true) {
            int i6 = i5 - 1;
            if (i5 <= 0) {
                return true;
            }
            int i7 = i3 + 1;
            char cCharAt = charSequence.charAt(i3);
            int i8 = i4 + 1;
            char cCharAt2 = charSequence2.charAt(i4);
            if (cCharAt != cCharAt2) {
                if (!z2) {
                    return false;
                }
                char upperCase = Character.toUpperCase(cCharAt);
                char upperCase2 = Character.toUpperCase(cCharAt2);
                if (upperCase != upperCase2 && Character.toLowerCase(upperCase) != Character.toLowerCase(upperCase2)) {
                    return false;
                }
            }
            i3 = i7;
            i5 = i6;
            i4 = i8;
        }
    }
}
