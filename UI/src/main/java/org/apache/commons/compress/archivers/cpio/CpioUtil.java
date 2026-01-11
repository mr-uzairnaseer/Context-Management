package org.apache.commons.compress.archivers.cpio;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/* loaded from: classes5.dex */
final class CpioUtil {

    /* renamed from: a, reason: collision with root package name */
    public static final String f159968a = StandardCharsets.US_ASCII.name();

    public static long a(byte[] bArr, boolean z2) {
        if (bArr.length % 2 != 0) {
            throw new UnsupportedOperationException();
        }
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
        if (!z2) {
            for (int i3 = 0; i3 < bArrCopyOf.length; i3 += 2) {
                byte b3 = bArrCopyOf[i3];
                int i4 = i3 + 1;
                bArrCopyOf[i3] = bArrCopyOf[i4];
                bArrCopyOf[i4] = b3;
            }
        }
        long j3 = bArrCopyOf[0] & 255;
        for (int i5 = 1; i5 < bArrCopyOf.length; i5++) {
            j3 = (j3 << 8) | (bArrCopyOf[i5] & 255);
        }
        return j3;
    }

    public static long b(long j3) {
        return j3 & 61440;
    }

    public static byte[] c(long j3, int i3, boolean z2) {
        byte[] bArr = new byte[i3];
        if (i3 % 2 != 0 || i3 < 2) {
            throw new UnsupportedOperationException();
        }
        for (int i4 = i3 - 1; i4 >= 0; i4--) {
            bArr[i4] = (byte) (255 & j3);
            j3 >>= 8;
        }
        if (!z2) {
            for (int i5 = 0; i5 < i3; i5 += 2) {
                byte b3 = bArr[i5];
                int i6 = i5 + 1;
                bArr[i5] = bArr[i6];
                bArr[i6] = b3;
            }
        }
        return bArr;
    }
}
