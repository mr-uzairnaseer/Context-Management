package org.apache.commons.compress.archivers.zip;

import java.io.Serializable;
import java.math.BigInteger;

/* loaded from: classes5.dex */
public final class ZipEightByteInteger implements Serializable {
    public static final ZipEightByteInteger ZERO = new ZipEightByteInteger(0);

    /* renamed from: a, reason: collision with root package name */
    public final BigInteger f160459a;

    public ZipEightByteInteger(BigInteger bigInteger) {
        this.f160459a = bigInteger;
    }

    public static byte[] b(long j3) {
        return c(BigInteger.valueOf(j3));
    }

    public static byte[] c(BigInteger bigInteger) {
        long jLongValue = bigInteger.longValue();
        byte[] bArr = {(byte) (255 & jLongValue), (byte) ((65280 & jLongValue) >> 8), (byte) ((16711680 & jLongValue) >> 16), (byte) ((4278190080L & jLongValue) >> 24), (byte) ((1095216660480L & jLongValue) >> 32), (byte) ((280375465082880L & jLongValue) >> 40), (byte) ((71776119061217280L & jLongValue) >> 48), (byte) ((jLongValue & 9151314442816847872L) >> 56)};
        if (bigInteger.testBit(63)) {
            bArr[7] = (byte) (bArr[7] | (-128));
        }
        return bArr;
    }

    public static long e(byte[] bArr) {
        return f(bArr, 0);
    }

    public static long f(byte[] bArr, int i3) {
        return i(bArr, i3).longValue();
    }

    public static BigInteger h(byte[] bArr) {
        return i(bArr, 0);
    }

    public static BigInteger i(byte[] bArr, int i3) {
        int i4 = i3 + 7;
        BigInteger bigIntegerValueOf = BigInteger.valueOf(((bArr[i4] << 56) & 9151314442816847872L) + ((bArr[i3 + 6] << 48) & 71776119061217280L) + ((bArr[i3 + 5] << 40) & 280375465082880L) + ((bArr[i3 + 4] << 32) & 1095216660480L) + ((bArr[i3 + 3] << 24) & 4278190080L) + ((bArr[i3 + 2] << 16) & 16711680) + ((bArr[i3 + 1] << 8) & 65280) + (bArr[i3] & 255));
        return (bArr[i4] & (-128)) == -128 ? bigIntegerValueOf.setBit(63) : bigIntegerValueOf;
    }

    public byte[] a() {
        return c(this.f160459a);
    }

    public long d() {
        return this.f160459a.longValue();
    }

    public boolean equals(Object obj) {
        if (obj instanceof ZipEightByteInteger) {
            return this.f160459a.equals(((ZipEightByteInteger) obj).g());
        }
        return false;
    }

    public BigInteger g() {
        return this.f160459a;
    }

    public int hashCode() {
        return this.f160459a.hashCode();
    }

    public String toString() {
        return "ZipEightByteInteger value: " + this.f160459a;
    }

    public ZipEightByteInteger(byte[] bArr, int i3) {
        this.f160459a = i(bArr, i3);
    }

    public ZipEightByteInteger(long j3) {
        this(BigInteger.valueOf(j3));
    }
}
