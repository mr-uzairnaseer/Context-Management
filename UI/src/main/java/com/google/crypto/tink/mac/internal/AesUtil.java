package com.google.crypto.tink.mac.internal;

import java.util.Arrays;

/* loaded from: classes5.dex */
public final class AesUtil {
    public static final int BLOCK_SIZE = 16;

    private AesUtil() {
    }

    public static byte[] a(byte[] bArr) {
        if (bArr.length >= 16) {
            throw new IllegalArgumentException("x must be smaller than a block.");
        }
        byte[] bArrCopyOf = Arrays.copyOf(bArr, 16);
        bArrCopyOf[bArr.length] = -128;
        return bArrCopyOf;
    }

    public static byte[] b(byte[] bArr) {
        if (bArr.length != 16) {
            throw new IllegalArgumentException("value must be a block.");
        }
        byte[] bArr2 = new byte[16];
        for (int i3 = 0; i3 < 16; i3++) {
            byte b3 = (byte) ((bArr[i3] << 1) & 254);
            bArr2[i3] = b3;
            if (i3 < 15) {
                bArr2[i3] = (byte) (((byte) ((bArr[i3 + 1] >> 7) & 1)) | b3);
            }
        }
        bArr2[15] = (byte) (((byte) ((bArr[0] >> 7) & 135)) ^ bArr2[15]);
        return bArr2;
    }
}
