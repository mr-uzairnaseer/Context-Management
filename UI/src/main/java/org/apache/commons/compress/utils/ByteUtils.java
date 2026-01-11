package org.apache.commons.compress.utils;

import java.io.DataInput;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes5.dex */
public final class ByteUtils {
    public static final byte[] EMPTY_BYTE_ARRAY = new byte[0];

    public interface ByteConsumer {
        void accept(int i3);
    }

    public interface ByteSupplier {
        int a();
    }

    @Deprecated
    public static class InputStreamByteSupplier implements ByteSupplier {

        /* renamed from: a, reason: collision with root package name */
        public final InputStream f161304a;

        @Override // org.apache.commons.compress.utils.ByteUtils.ByteSupplier
        public int a() {
            return this.f161304a.read();
        }
    }

    public static class OutputStreamByteConsumer implements ByteConsumer {

        /* renamed from: a, reason: collision with root package name */
        public final OutputStream f161305a;

        public OutputStreamByteConsumer(OutputStream outputStream) {
            this.f161305a = outputStream;
        }

        @Override // org.apache.commons.compress.utils.ByteUtils.ByteConsumer
        public void accept(int i3) throws IOException {
            this.f161305a.write(i3);
        }
    }

    private ByteUtils() {
    }

    public static void a(int i3) {
        if (i3 > 8) {
            throw new IllegalArgumentException("Can't read more than eight bytes into a long value");
        }
    }

    public static long b(DataInput dataInput, int i3) {
        a(i3);
        long unsignedByte = 0;
        for (int i4 = 0; i4 < i3; i4++) {
            unsignedByte |= dataInput.readUnsignedByte() << (i4 * 8);
        }
        return unsignedByte;
    }

    public static long c(ByteSupplier byteSupplier, int i3) throws IOException {
        a(i3);
        long j3 = 0;
        for (int i4 = 0; i4 < i3; i4++) {
            long jA = byteSupplier.a();
            if (jA == -1) {
                throw new IOException("Premature end of data");
            }
            j3 |= jA << (i4 * 8);
        }
        return j3;
    }

    public static long d(byte[] bArr) {
        return e(bArr, 0, bArr.length);
    }

    public static long e(byte[] bArr, int i3, int i4) {
        a(i4);
        long j3 = 0;
        for (int i5 = 0; i5 < i4; i5++) {
            j3 |= (bArr[i3 + i5] & 255) << (i5 * 8);
        }
        return j3;
    }

    public static void f(OutputStream outputStream, long j3, int i3) throws IOException {
        for (int i4 = 0; i4 < i3; i4++) {
            outputStream.write((int) (255 & j3));
            j3 >>= 8;
        }
    }

    public static void g(ByteConsumer byteConsumer, long j3, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            byteConsumer.accept((int) (255 & j3));
            j3 >>= 8;
        }
    }

    public static void h(byte[] bArr, long j3, int i3, int i4) {
        for (int i5 = 0; i5 < i4; i5++) {
            bArr[i3 + i5] = (byte) (255 & j3);
            j3 >>= 8;
        }
    }
}
