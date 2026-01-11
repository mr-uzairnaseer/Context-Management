package org.locationtech.jts.shape.fractal;

import okhttp3.internal.ws.WebSocketProtocol;

/* loaded from: classes7.dex */
public class HilbertCode {
    public static final int MAX_LEVEL = 16;

    public static int a(int i3, int i4, int i5) {
        int iB = b(i3);
        int i6 = 16 - iB;
        int i7 = i4 << i6;
        int i8 = i5 << i6;
        long j3 = i7 ^ i8;
        long j4 = j3 ^ WebSocketProtocol.PAYLOAD_SHORT_MAX;
        long j5 = ((i4 | i5) << i6) ^ 65535;
        long j6 = (i8 ^ 65535) & i7;
        long j7 = (j4 >> 1) | j3;
        long j8 = (j3 >> 1) ^ j3;
        long j9 = j5 >> 1;
        long j10 = j6 >> 1;
        long j11 = (j9 ^ (j4 & j10)) ^ j5;
        long j12 = j6 ^ ((j3 & j9) ^ j10);
        long j13 = j8 >> 2;
        long j14 = ((j7 >> 2) & j7) ^ (j8 & j13);
        long j15 = j7 ^ j8;
        long j16 = (j7 & j13) ^ (j8 & (j15 >> 2));
        long j17 = j11 >> 2;
        long j18 = j12 >> 2;
        long j19 = j11 ^ ((j7 & j17) ^ (j8 & j18));
        long j20 = j12 ^ ((j8 & j17) ^ (j15 & j18));
        long j21 = j16 >> 4;
        long j22 = ((j14 >> 4) & j14) ^ (j16 & j21);
        long j23 = j14 ^ j16;
        long j24 = (j14 & j21) ^ (j16 & (j23 >> 4));
        long j25 = j19 >> 4;
        long j26 = j20 >> 4;
        long j27 = j19 ^ ((j14 & j25) ^ (j16 & j26));
        long j28 = j20 ^ ((j16 & j25) ^ (j23 & j26));
        long j29 = j27 >> 8;
        long j30 = j28 >> 8;
        long j31 = j27 ^ ((j22 & j29) ^ (j24 & j30));
        long j32 = j28 ^ ((j24 & j29) ^ ((j22 ^ j24) & j30));
        long j33 = (j32 ^ (j32 >> 1)) | (WebSocketProtocol.PAYLOAD_SHORT_MAX ^ ((j31 ^ (j31 >> 1)) | j3));
        long j34 = (j3 | (j3 << 8)) & 16711935;
        long j35 = (j34 | (j34 << 4)) & 252645135;
        long j36 = (j35 | (j35 << 2)) & 858993459;
        long j37 = (j33 | (j33 << 8)) & 16711935;
        long j38 = (j37 | (j37 << 4)) & 252645135;
        long j39 = (j38 | (j38 << 2)) & 858993459;
        return (int) (((((j39 | (j39 << 1)) & 1431655765) << 1) | ((j36 | (j36 << 1)) & 1431655765)) >> (32 - (iB * 2)));
    }

    public static int b(int i3) {
        if (i3 < 1) {
            i3 = 1;
        }
        if (i3 > 16) {
            return 16;
        }
        return i3;
    }
}
