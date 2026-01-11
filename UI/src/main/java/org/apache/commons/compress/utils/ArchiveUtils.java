package org.apache.commons.compress.utils;

import java.lang.Character;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/* loaded from: classes5.dex */
public class ArchiveUtils {
    private ArchiveUtils() {
    }

    public static boolean a(byte[] bArr, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            if (bArr[i4] != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean b(byte[] bArr, int i3, int i4, byte[] bArr2, int i5, int i6, boolean z2) {
        int iMin = Math.min(i4, i6);
        for (int i7 = 0; i7 < iMin; i7++) {
            if (bArr[i3 + i7] != bArr2[i5 + i7]) {
                return false;
            }
        }
        if (i4 == i6) {
            return true;
        }
        if (!z2) {
            return false;
        }
        if (i4 > i6) {
            while (i6 < i4) {
                if (bArr[i3 + i6] != 0) {
                    return false;
                }
                i6++;
            }
        } else {
            while (i4 < i6) {
                if (bArr2[i5 + i4] != 0) {
                    return false;
                }
                i4++;
            }
        }
        return true;
    }

    public static boolean c(String str, byte[] bArr, int i3, int i4) {
        byte[] bytes = str.getBytes(StandardCharsets.US_ASCII);
        return b(bytes, 0, bytes.length, bArr, i3, i4, false);
    }

    public static String d(String str) {
        Character.UnicodeBlock unicodeBlockOf;
        char[] charArray = str.toCharArray();
        char[] cArrCopyOf = charArray.length <= 255 ? charArray : Arrays.copyOf(charArray, 255);
        if (charArray.length > 255) {
            Arrays.fill(cArrCopyOf, 252, 255, '.');
        }
        StringBuilder sb = new StringBuilder();
        for (char c3 : cArrCopyOf) {
            if (Character.isISOControl(c3) || (unicodeBlockOf = Character.UnicodeBlock.of(c3)) == null || unicodeBlockOf == Character.UnicodeBlock.SPECIALS) {
                sb.append('?');
            } else {
                sb.append(c3);
            }
        }
        return sb.toString();
    }

    public static byte[] e(String str) {
        return str.getBytes(StandardCharsets.US_ASCII);
    }

    public static String f(byte[] bArr) {
        return new String(bArr, StandardCharsets.US_ASCII);
    }

    public static String g(byte[] bArr, int i3, int i4) {
        return new String(bArr, i3, i4, StandardCharsets.US_ASCII);
    }
}
