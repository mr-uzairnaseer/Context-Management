package com.google.firebase.messaging;

import androidx.collection.SieveCacheKt;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/* loaded from: classes5.dex */
final class ByteStreams {
    private ByteStreams() {
    }

    public static byte[] a(Queue queue, int i3) {
        if (queue.isEmpty()) {
            return new byte[0];
        }
        byte[] bArr = (byte[]) queue.remove();
        if (bArr.length == i3) {
            return bArr;
        }
        int length = i3 - bArr.length;
        byte[] bArrCopyOf = Arrays.copyOf(bArr, i3);
        while (length > 0) {
            byte[] bArr2 = (byte[]) queue.remove();
            int iMin = Math.min(length, bArr2.length);
            System.arraycopy(bArr2, 0, bArrCopyOf, i3 - length, iMin);
            length -= iMin;
        }
        return bArrCopyOf;
    }

    public static InputStream b(InputStream inputStream, long j3) {
        return new LimitedInputStream(inputStream, j3);
    }

    public static int c(long j3) {
        if (j3 > SieveCacheKt.NodeLinkMask) {
            return Integer.MAX_VALUE;
        }
        if (j3 < SieveCacheKt.NodeMetaAndPreviousMask) {
            return Integer.MIN_VALUE;
        }
        return (int) j3;
    }

    public static byte[] d(InputStream inputStream) {
        return e(inputStream, new ArrayDeque(20), 0);
    }

    public static byte[] e(InputStream inputStream, Queue queue, int i3) throws IOException {
        int iMin = Math.min(8192, Math.max(128, Integer.highestOneBit(i3) * 2));
        while (i3 < 2147483639) {
            int iMin2 = Math.min(iMin, 2147483639 - i3);
            byte[] bArr = new byte[iMin2];
            queue.add(bArr);
            int i4 = 0;
            while (i4 < iMin2) {
                int i5 = inputStream.read(bArr, i4, iMin2 - i4);
                if (i5 == -1) {
                    return a(queue, i3);
                }
                i4 += i5;
                i3 += i5;
            }
            iMin = c(iMin * (iMin < 4096 ? 4 : 2));
        }
        if (inputStream.read() == -1) {
            return a(queue, 2147483639);
        }
        throw new OutOfMemoryError("input is too large to fit in a byte array");
    }

    public static final class LimitedInputStream extends FilterInputStream {

        /* renamed from: a, reason: collision with root package name */
        public long f73113a;

        /* renamed from: b, reason: collision with root package name */
        public long f73114b;

        public LimitedInputStream(InputStream inputStream, long j3) {
            super(inputStream);
            this.f73114b = -1L;
            this.f73113a = j3;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int available() {
            return (int) Math.min(((FilterInputStream) this).in.available(), this.f73113a);
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public synchronized void mark(int i3) {
            ((FilterInputStream) this).in.mark(i3);
            this.f73114b = this.f73113a;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() throws IOException {
            if (this.f73113a == 0) {
                return -1;
            }
            int i3 = ((FilterInputStream) this).in.read();
            if (i3 != -1) {
                this.f73113a--;
            }
            return i3;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public synchronized void reset() {
            if (!((FilterInputStream) this).in.markSupported()) {
                throw new IOException("Mark not supported");
            }
            if (this.f73114b == -1) {
                throw new IOException("Mark not set");
            }
            ((FilterInputStream) this).in.reset();
            this.f73113a = this.f73114b;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public long skip(long j3) throws IOException {
            long jSkip = ((FilterInputStream) this).in.skip(Math.min(j3, this.f73113a));
            this.f73113a -= jSkip;
            return jSkip;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i3, int i4) throws IOException {
            long j3 = this.f73113a;
            if (j3 == 0) {
                return -1;
            }
            int i5 = ((FilterInputStream) this).in.read(bArr, i3, (int) Math.min(i4, j3));
            if (i5 != -1) {
                this.f73113a -= i5;
            }
            return i5;
        }
    }
}
