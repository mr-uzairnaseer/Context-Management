package com.google.crypto.tink.subtle;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;

/* loaded from: classes5.dex */
public final class RewindableReadableByteChannel implements ReadableByteChannel {

    /* renamed from: a, reason: collision with root package name */
    public final ReadableByteChannel f71695a;

    /* renamed from: b, reason: collision with root package name */
    public ByteBuffer f71696b = null;

    /* renamed from: c, reason: collision with root package name */
    public boolean f71697c = true;

    /* renamed from: d, reason: collision with root package name */
    public boolean f71698d = false;

    public RewindableReadableByteChannel(ReadableByteChannel readableByteChannel) {
        this.f71695a = readableByteChannel;
    }

    public synchronized void a() {
        this.f71697c = false;
    }

    public synchronized void c() {
        if (!this.f71697c) {
            throw new IOException("Cannot rewind anymore.");
        }
        ByteBuffer byteBuffer = this.f71696b;
        if (byteBuffer != null) {
            byteBuffer.position(0);
        }
    }

    @Override // java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        this.f71697c = false;
        this.f71698d = true;
        this.f71695a.close();
    }

    public final synchronized void d(int i3) {
        try {
            if (this.f71696b.capacity() < i3) {
                int iPosition = this.f71696b.position();
                ByteBuffer byteBufferAllocate = ByteBuffer.allocate(Math.max(this.f71696b.capacity() * 2, i3));
                this.f71696b.rewind();
                byteBufferAllocate.put(this.f71696b);
                byteBufferAllocate.position(iPosition);
                this.f71696b = byteBufferAllocate;
            }
            this.f71696b.limit(i3);
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // java.nio.channels.Channel
    public synchronized boolean isOpen() {
        return this.f71695a.isOpen();
    }

    @Override // java.nio.channels.ReadableByteChannel
    public synchronized int read(ByteBuffer byteBuffer) {
        if (this.f71698d) {
            return this.f71695a.read(byteBuffer);
        }
        int iRemaining = byteBuffer.remaining();
        if (iRemaining == 0) {
            return 0;
        }
        ByteBuffer byteBuffer2 = this.f71696b;
        if (byteBuffer2 == null) {
            if (!this.f71697c) {
                this.f71698d = true;
                return this.f71695a.read(byteBuffer);
            }
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(iRemaining);
            this.f71696b = byteBufferAllocate;
            int i3 = this.f71695a.read(byteBufferAllocate);
            this.f71696b.flip();
            if (i3 > 0) {
                byteBuffer.put(this.f71696b);
            }
            return i3;
        }
        if (byteBuffer2.remaining() >= iRemaining) {
            int iLimit = this.f71696b.limit();
            ByteBuffer byteBuffer3 = this.f71696b;
            byteBuffer3.limit(byteBuffer3.position() + iRemaining);
            byteBuffer.put(this.f71696b);
            this.f71696b.limit(iLimit);
            if (!this.f71697c && !this.f71696b.hasRemaining()) {
                this.f71696b = null;
                this.f71698d = true;
            }
            return iRemaining;
        }
        int iRemaining2 = this.f71696b.remaining();
        int iPosition = this.f71696b.position();
        int iLimit2 = this.f71696b.limit();
        d((iRemaining - iRemaining2) + iLimit2);
        this.f71696b.position(iLimit2);
        int i4 = this.f71695a.read(this.f71696b);
        this.f71696b.flip();
        this.f71696b.position(iPosition);
        byteBuffer.put(this.f71696b);
        if (iRemaining2 == 0 && i4 < 0) {
            return -1;
        }
        int iPosition2 = this.f71696b.position() - iPosition;
        if (!this.f71697c && !this.f71696b.hasRemaining()) {
            this.f71696b = null;
            this.f71698d = true;
        }
        return iPosition2;
    }
}
