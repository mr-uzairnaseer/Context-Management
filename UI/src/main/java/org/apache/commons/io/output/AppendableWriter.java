package org.apache.commons.io.output;

import java.io.IOException;
import java.io.Writer;
import java.lang.Appendable;
import java.util.Objects;

/* loaded from: classes6.dex */
public class AppendableWriter<T extends Appendable> extends Writer {

    /* renamed from: a, reason: collision with root package name */
    public final Appendable f161819a;

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i3, int i4) throws IOException {
        Objects.requireNonNull(cArr, "Character array is missing");
        if (i4 >= 0 && i3 + i4 <= cArr.length) {
            for (int i5 = 0; i5 < i4; i5++) {
                this.f161819a.append(cArr[i3 + i5]);
            }
            return;
        }
        throw new IndexOutOfBoundsException("Array Size=" + cArr.length + ", offset=" + i3 + ", length=" + i4);
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(char c3) throws IOException {
        this.f161819a.append(c3);
        return this;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(CharSequence charSequence) throws IOException {
        this.f161819a.append(charSequence);
        return this;
    }

    @Override // java.io.Writer
    public void write(int i3) throws IOException {
        this.f161819a.append((char) i3);
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(CharSequence charSequence, int i3, int i4) throws IOException {
        this.f161819a.append(charSequence, i3, i4);
        return this;
    }

    @Override // java.io.Writer
    public void write(String str, int i3, int i4) throws IOException {
        Objects.requireNonNull(str, "String is missing");
        this.f161819a.append(str, i3, i4 + i3);
    }
}
