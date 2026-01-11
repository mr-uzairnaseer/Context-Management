package org.apache.commons.compress.utils;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.NonWritableChannelException;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

/* loaded from: classes5.dex */
public class MultiReadOnlySeekableByteChannel implements SeekableByteChannel {

    /* renamed from: d, reason: collision with root package name */
    public static final Path[] f161316d = new Path[0];

    /* renamed from: a, reason: collision with root package name */
    public final List f161317a;

    /* renamed from: b, reason: collision with root package name */
    public long f161318b;

    /* renamed from: c, reason: collision with root package name */
    public int f161319c;

    public MultiReadOnlySeekableByteChannel(List list) {
        Objects.requireNonNull(list, "channels");
        this.f161317a = Collections.unmodifiableList(new ArrayList(list));
    }

    public synchronized SeekableByteChannel a(long j3, long j4) {
        try {
            if (!isOpen()) {
                throw new ClosedChannelException();
            }
            for (int i3 = 0; i3 < j3; i3++) {
                j4 += ((SeekableByteChannel) this.f161317a.get(i3)).size();
            }
        } catch (Throwable th) {
            throw th;
        }
        return position(j4);
    }

    @Override // java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Iterator it = this.f161317a.iterator();
        IOException iOException = null;
        while (it.hasNext()) {
            try {
                ((SeekableByteChannel) it.next()).close();
            } catch (IOException e3) {
                if (iOException == null) {
                    iOException = e3;
                }
            }
        }
        if (iOException != null) {
            throw new IOException("failed to close wrapped channel", iOException);
        }
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return this.f161317a.stream().allMatch(new Predicate() { // from class: org.apache.commons.compress.utils.b
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return ((SeekableByteChannel) obj).isOpen();
            }
        });
    }

    @Override // java.nio.channels.SeekableByteChannel
    public long position() {
        return this.f161318b;
    }

    @Override // java.nio.channels.SeekableByteChannel, java.nio.channels.ReadableByteChannel
    public synchronized int read(ByteBuffer byteBuffer) {
        try {
            if (!isOpen()) {
                throw new ClosedChannelException();
            }
            int i3 = 0;
            if (!byteBuffer.hasRemaining()) {
                return 0;
            }
            while (byteBuffer.hasRemaining() && this.f161319c < this.f161317a.size()) {
                SeekableByteChannel seekableByteChannel = (SeekableByteChannel) this.f161317a.get(this.f161319c);
                int i4 = seekableByteChannel.read(byteBuffer);
                if (i4 == -1) {
                    this.f161319c++;
                } else {
                    if (seekableByteChannel.position() >= seekableByteChannel.size()) {
                        this.f161319c++;
                    }
                    i3 += i4;
                }
            }
            if (i3 <= 0) {
                return -1;
            }
            this.f161318b += i3;
            return i3;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // java.nio.channels.SeekableByteChannel
    public long size() throws ClosedChannelException {
        if (!isOpen()) {
            throw new ClosedChannelException();
        }
        Iterator it = this.f161317a.iterator();
        long size = 0;
        while (it.hasNext()) {
            size += ((SeekableByteChannel) it.next()).size();
        }
        return size;
    }

    @Override // java.nio.channels.SeekableByteChannel
    public SeekableByteChannel truncate(long j3) {
        throw new NonWritableChannelException();
    }

    @Override // java.nio.channels.SeekableByteChannel, java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) {
        throw new NonWritableChannelException();
    }

    @Override // java.nio.channels.SeekableByteChannel
    public synchronized SeekableByteChannel position(long j3) {
        try {
            if (j3 < 0) {
                throw new IllegalArgumentException("Negative position: " + j3);
            }
            if (!isOpen()) {
                throw new ClosedChannelException();
            }
            this.f161318b = j3;
            int i3 = 0;
            while (i3 < this.f161317a.size()) {
                SeekableByteChannel seekableByteChannel = (SeekableByteChannel) this.f161317a.get(i3);
                long size = seekableByteChannel.size();
                long j4 = -1;
                if (j3 == -1) {
                    j4 = j3;
                    j3 = 0;
                } else if (j3 <= size) {
                    this.f161319c = i3;
                } else {
                    j4 = j3 - size;
                    j3 = size;
                }
                seekableByteChannel.position(j3);
                i3++;
                j3 = j4;
            }
        } catch (Throwable th) {
            throw th;
        }
        return this;
    }
}
