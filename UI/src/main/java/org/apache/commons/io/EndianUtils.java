package org.apache.commons.io;

import androidx.media3.muxer.MuxerUtil;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes6.dex */
public class EndianUtils {
    @Deprecated
    public EndianUtils() {
    }

    public static int a(InputStream inputStream) throws IOException {
        int i3 = inputStream.read();
        if (-1 != i3) {
            return i3;
        }
        throw new EOFException("Unexpected EOF reached");
    }

    public static double b(InputStream inputStream) {
        return Double.longBitsToDouble(f(inputStream));
    }

    public static float c(InputStream inputStream) {
        return Float.intBitsToFloat(d(inputStream));
    }

    public static int d(InputStream inputStream) throws IOException {
        return (a(inputStream) & 255) + ((a(inputStream) & 255) << 8) + ((a(inputStream) & 255) << 16) + ((a(inputStream) & 255) << 24);
    }

    public static int e(byte[] bArr, int i3) {
        j(bArr, i3, 4);
        return (bArr[i3] & 255) + ((bArr[i3 + 1] & 255) << 8) + ((bArr[i3 + 2] & 255) << 16) + ((bArr[i3 + 3] & 255) << 24);
    }

    public static long f(InputStream inputStream) {
        byte[] bArr = new byte[8];
        for (int i3 = 0; i3 < 8; i3++) {
            bArr[i3] = (byte) a(inputStream);
        }
        return g(bArr, 0);
    }

    public static long g(byte[] bArr, int i3) {
        j(bArr, i3, 8);
        return (e(bArr, i3 + 4) << 32) + (e(bArr, i3) & MuxerUtil.UNSIGNED_INT_MAX_VALUE);
    }

    public static short h(InputStream inputStream) {
        return (short) ((a(inputStream) & 255) + ((a(inputStream) & 255) << 8));
    }

    public static int i(InputStream inputStream) throws IOException {
        return (a(inputStream) & 255) + ((a(inputStream) & 255) << 8);
    }

    public static void j(byte[] bArr, int i3, int i4) {
        int i5 = i3 + i4;
        if (bArr.length >= i5) {
            return;
        }
        throw new IllegalArgumentException("Data only has " + bArr.length + "bytes, needed " + i5 + "bytes.");
    }
}
