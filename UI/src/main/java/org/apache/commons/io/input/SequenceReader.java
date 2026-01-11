package org.apache.commons.io.input;

import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.Objects;

/* loaded from: classes6.dex */
public class SequenceReader extends Reader {

    /* renamed from: a, reason: collision with root package name */
    public Reader f161658a;

    /* renamed from: b, reason: collision with root package name */
    public final Iterator f161659b;

    public final Reader a() throws IOException {
        Reader reader = this.f161658a;
        if (reader != null) {
            reader.close();
        }
        if (this.f161659b.hasNext()) {
            this.f161658a = (Reader) this.f161659b.next();
        } else {
            this.f161658a = null;
        }
        return this.f161658a;
    }

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        while (a() != null) {
        }
    }

    @Override // java.io.Reader
    public int read() throws IOException {
        int i3 = -1;
        while (true) {
            Reader reader = this.f161658a;
            if (reader == null) {
                return i3;
            }
            i3 = reader.read();
            if (i3 != -1) {
                return i3;
            }
            a();
        }
    }

    @Override // java.io.Reader
    public int read(char[] cArr, int i3, int i4) throws IOException {
        Objects.requireNonNull(cArr, "cbuf");
        if (i4 < 0 || i3 < 0 || i3 + i4 > cArr.length) {
            throw new IndexOutOfBoundsException("Array Size=" + cArr.length + ", offset=" + i3 + ", length=" + i4);
        }
        int i5 = 0;
        while (true) {
            Reader reader = this.f161658a;
            if (reader == null) {
                break;
            }
            int i6 = reader.read(cArr, i3, i4);
            if (i6 == -1) {
                a();
            } else {
                i5 += i6;
                i3 += i6;
                i4 -= i6;
                if (i4 <= 0) {
                    break;
                }
            }
        }
        if (i5 > 0) {
            return i5;
        }
        return -1;
    }
}
