package org.json;

import java.io.IOException;
import java.io.Writer;

/* loaded from: classes8.dex */
public class StringBuilderWriter extends Writer {
    private final StringBuilder builder;

    public StringBuilderWriter() {
        StringBuilder sb = new StringBuilder();
        this.builder = sb;
        ((Writer) this).lock = sb;
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
    }

    public String toString() {
        return this.builder.toString();
    }

    @Override // java.io.Writer
    public void write(int i3) {
        this.builder.append((char) i3);
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i3, int i4) {
        int i5;
        if (i3 < 0 || i3 > cArr.length || i4 < 0 || (i5 = i3 + i4) > cArr.length || i5 < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (i4 == 0) {
            return;
        }
        this.builder.append(cArr, i3, i4);
    }

    public StringBuilderWriter(int i3) {
        StringBuilder sb = new StringBuilder(i3);
        this.builder = sb;
        ((Writer) this).lock = sb;
    }

    @Override // java.io.Writer
    public void write(String str) {
        this.builder.append(str);
    }

    @Override // java.io.Writer
    public void write(String str, int i3, int i4) {
        this.builder.append((CharSequence) str, i3, i4 + i3);
    }

    @Override // java.io.Writer, java.lang.Appendable
    public StringBuilderWriter append(CharSequence charSequence) {
        write(String.valueOf(charSequence));
        return this;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public StringBuilderWriter append(CharSequence charSequence, int i3, int i4) {
        if (charSequence == null) {
            charSequence = "null";
        }
        return append(charSequence.subSequence(i3, i4));
    }

    @Override // java.io.Writer, java.lang.Appendable
    public StringBuilderWriter append(char c3) {
        write(c3);
        return this;
    }
}
