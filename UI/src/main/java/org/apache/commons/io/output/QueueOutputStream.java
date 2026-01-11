package org.apache.commons.io.output;

import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: classes6.dex */
public class QueueOutputStream extends OutputStream {

    /* renamed from: a, reason: collision with root package name */
    public final BlockingQueue f161845a;

    public QueueOutputStream() {
        this(new LinkedBlockingQueue());
    }

    @Override // java.io.OutputStream
    public void write(int i3) throws InterruptedException, InterruptedIOException {
        try {
            this.f161845a.put(Integer.valueOf(i3 & 255));
        } catch (InterruptedException e3) {
            Thread.currentThread().interrupt();
            InterruptedIOException interruptedIOException = new InterruptedIOException();
            interruptedIOException.initCause(e3);
            throw interruptedIOException;
        }
    }

    public QueueOutputStream(BlockingQueue blockingQueue) {
        Objects.requireNonNull(blockingQueue, "blockingQueue");
        this.f161845a = blockingQueue;
    }
}
