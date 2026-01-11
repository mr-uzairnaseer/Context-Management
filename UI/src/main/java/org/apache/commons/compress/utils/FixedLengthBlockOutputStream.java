package org.apache.commons.compress.utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.WritableByteChannel;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes5.dex */
public class FixedLengthBlockOutputStream extends OutputStream implements WritableByteChannel {

    /* renamed from: a, reason: collision with root package name */
    public final WritableByteChannel f161310a;

    /* renamed from: b, reason: collision with root package name */
    public final int f161311b;

    /* renamed from: c, reason: collision with root package name */
    public final ByteBuffer f161312c;

    /* renamed from: d, reason: collision with root package name */
    public final AtomicBoolean f161313d = new AtomicBoolean();

    public static final class BufferAtATimeOutputChannel implements WritableByteChannel {

        /* renamed from: a, reason: collision with root package name */
        public final OutputStream f161314a;

        /* renamed from: b, reason: collision with root package name */
        public final AtomicBoolean f161315b;

        @Override // java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.f161315b.compareAndSet(false, true)) {
                this.f161314a.close();
            }
        }

        @Override // java.nio.channels.Channel
        public boolean isOpen() {
            return !this.f161315b.get();
        }

        @Override // java.nio.channels.WritableByteChannel
        public int write(ByteBuffer byteBuffer) throws IOException {
            if (!isOpen()) {
                throw new ClosedChannelException();
            }
            if (!byteBuffer.hasArray()) {
                throw new IOException("Direct buffer somehow written to BufferAtATimeOutputChannel");
            }
            try {
                int iPosition = byteBuffer.position();
                int iLimit = byteBuffer.limit() - iPosition;
                this.f161314a.write(byteBuffer.array(), byteBuffer.arrayOffset() + iPosition, iLimit);
                byteBuffer.position(byteBuffer.limit());
                return iLimit;
            } catch (IOException e3) {
                try {
                    close();
                } catch (IOException unused) {
                }
                throw e3;
            }
        }

        public BufferAtATimeOutputChannel(OutputStream outputStream) {
            this.f161315b = new AtomicBoolean();
            this.f161314a = outputStream;
        }
    }

    public FixedLengthBlockOutputStream(OutputStream outputStream, int i3) {
        if (outputStream instanceof FileOutputStream) {
            this.f161310a = ((FileOutputStream) outputStream).getChannel();
            this.f161312c = ByteBuffer.allocateDirect(i3);
        } else {
            this.f161310a = new BufferAtATimeOutputChannel(outputStream);
            this.f161312c = ByteBuffer.allocate(i3);
        }
        this.f161311b = i3;
    }

    public void a() throws IOException {
        if (this.f161312c.position() != 0) {
            d();
            e();
        }
    }

    public final void c() throws IOException {
        if (this.f161312c.hasRemaining()) {
            return;
        }
        e();
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
    public void close() throws IOException {
        if (this.f161313d.compareAndSet(false, true)) {
            try {
                a();
            } finally {
                this.f161310a.close();
            }
        }
    }

    public final void d() {
        this.f161312c.order(ByteOrder.nativeOrder());
        int iRemaining = this.f161312c.remaining();
        if (iRemaining > 8) {
            int iPosition = this.f161312c.position() & 7;
            if (iPosition != 0) {
                int i3 = 8 - iPosition;
                for (int i4 = 0; i4 < i3; i4++) {
                    this.f161312c.put((byte) 0);
                }
                iRemaining -= i3;
            }
            while (iRemaining >= 8) {
                this.f161312c.putLong(0L);
                iRemaining -= 8;
            }
        }
        while (this.f161312c.hasRemaining()) {
            this.f161312c.put((byte) 0);
        }
    }

    public final void e() throws IOException {
        this.f161312c.flip();
        int iWrite = this.f161310a.write(this.f161312c);
        boolean zHasRemaining = this.f161312c.hasRemaining();
        int i3 = this.f161311b;
        if (iWrite != i3 || zHasRemaining) {
            throw new IOException(String.format("Failed to write %,d bytes atomically. Only wrote  %,d", Integer.valueOf(i3), Integer.valueOf(iWrite)));
        }
        this.f161312c.clear();
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        if (!this.f161310a.isOpen()) {
            this.f161313d.set(true);
        }
        return !this.f161313d.get();
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i3, int i4) throws IOException {
        if (!isOpen()) {
            throw new ClosedChannelException();
        }
        while (i4 > 0) {
            int iMin = Math.min(i4, this.f161312c.remaining());
            this.f161312c.put(bArr, i3, iMin);
            c();
            i4 -= iMin;
            i3 += iMin;
        }
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        int i3;
        if (isOpen()) {
            int iRemaining = byteBuffer.remaining();
            if (iRemaining < this.f161312c.remaining()) {
                this.f161312c.put(byteBuffer);
                return iRemaining;
            }
            int iLimit = byteBuffer.limit();
            if (this.f161312c.position() != 0) {
                int iRemaining2 = this.f161312c.remaining();
                byteBuffer.limit(byteBuffer.position() + iRemaining2);
                this.f161312c.put(byteBuffer);
                e();
                i3 = iRemaining - iRemaining2;
            } else {
                i3 = iRemaining;
            }
            while (i3 >= this.f161311b) {
                byteBuffer.limit(byteBuffer.position() + this.f161311b);
                this.f161310a.write(byteBuffer);
                i3 -= this.f161311b;
            }
            byteBuffer.limit(iLimit);
            this.f161312c.put(byteBuffer);
            return iRemaining;
        }
        throw new ClosedChannelException();
    }

    @Override // java.io.OutputStream
    public void write(int i3) throws IOException {
        if (isOpen()) {
            this.f161312c.put((byte) i3);
            c();
            return;
        }
        throw new ClosedChannelException();
    }
}
