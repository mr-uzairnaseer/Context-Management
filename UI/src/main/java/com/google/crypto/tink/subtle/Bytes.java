package com.google.crypto.tink.subtle;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.util.Arrays;

/* loaded from: classes5.dex */
public final class Bytes {
    private Bytes() {
    }

    public static byte[] a(byte[]... bArr) throws GeneralSecurityException {
        int length = 0;
        for (byte[] bArr2 : bArr) {
            if (length > Integer.MAX_VALUE - bArr2.length) {
                throw new GeneralSecurityException("exceeded size limit");
            }
            length += bArr2.length;
        }
        byte[] bArr3 = new byte[length];
        int length2 = 0;
        for (byte[] bArr4 : bArr) {
            System.arraycopy(bArr4, 0, bArr3, length2, bArr4.length);
            length2 += bArr4.length;
        }
        return bArr3;
    }

    public static final boolean b(byte[] bArr, byte[] bArr2) {
        return MessageDigest.isEqual(bArr, bArr2);
    }

    public static final void c(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, int i3) {
        if (i3 < 0 || byteBuffer2.remaining() < i3 || byteBuffer3.remaining() < i3 || byteBuffer.remaining() < i3) {
            throw new IllegalArgumentException("That combination of buffers, offsets and length to xor result in out-of-bond accesses.");
        }
        for (int i4 = 0; i4 < i3; i4++) {
            byteBuffer.put((byte) (byteBuffer2.get() ^ byteBuffer3.get()));
        }
    }

    public static final byte[] d(byte[] bArr, int i3, byte[] bArr2, int i4, int i5) {
        if (i5 < 0 || bArr.length - i5 < i3 || bArr2.length - i5 < i4) {
            throw new IllegalArgumentException("That combination of buffers, offsets and length to xor result in out-of-bond accesses.");
        }
        byte[] bArr3 = new byte[i5];
        for (int i6 = 0; i6 < i5; i6++) {
            bArr3[i6] = (byte) (bArr[i6 + i3] ^ bArr2[i6 + i4]);
        }
        return bArr3;
    }

    public static final byte[] e(byte[] bArr, byte[] bArr2) {
        if (bArr.length == bArr2.length) {
            return d(bArr, 0, bArr2, 0, bArr.length);
        }
        throw new IllegalArgumentException("The lengths of x and y should match.");
    }

    public static final byte[] f(byte[] bArr, byte[] bArr2) {
        if (bArr.length < bArr2.length) {
            throw new IllegalArgumentException("xorEnd requires a.length >= b.length");
        }
        int length = bArr.length - bArr2.length;
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
        for (int i3 = 0; i3 < bArr2.length; i3++) {
            int i4 = length + i3;
            bArrCopyOf[i4] = (byte) (bArrCopyOf[i4] ^ bArr2[i3]);
        }
        return bArrCopyOf;
    }
}
