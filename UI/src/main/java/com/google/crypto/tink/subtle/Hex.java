package com.google.crypto.tink.subtle;

/* loaded from: classes5.dex */
public final class Hex {
    private Hex() {
    }

    public static byte[] a(String str) {
        if (str.length() % 2 != 0) {
            throw new IllegalArgumentException("Expected a string of even length");
        }
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i3 = 0; i3 < length; i3++) {
            int i4 = i3 * 2;
            int iDigit = Character.digit(str.charAt(i4), 16);
            int iDigit2 = Character.digit(str.charAt(i4 + 1), 16);
            if (iDigit == -1 || iDigit2 == -1) {
                throw new IllegalArgumentException("input is not hexadecimal");
            }
            bArr[i3] = (byte) ((iDigit * 16) + iDigit2);
        }
        return bArr;
    }

    public static String b(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b3 : bArr) {
            int i3 = b3 & 255;
            sb.append("0123456789abcdef".charAt(i3 / 16));
            sb.append("0123456789abcdef".charAt(i3 % 16));
        }
        return sb.toString();
    }
}
