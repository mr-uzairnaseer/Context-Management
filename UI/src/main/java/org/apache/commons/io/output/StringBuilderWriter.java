package org.apache.commons.io.output;

import java.io.Serializable;
import java.io.Writer;

/* loaded from: classes6.dex */
public class StringBuilderWriter extends Writer implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final StringBuilder f161846a = new StringBuilder();

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
    }

    public String toString() {
        return this.f161846a.toString();
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i3, int i4) {
        if (cArr != null) {
            this.f161846a.append(cArr, i3, i4);
        }
    }

    @Override // java.io.Writer
    public void write(String str) {
        if (str != null) {
            this.f161846a.append(str);
        }
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(char c3) {
        this.f161846a.append(c3);
        return this;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(CharSequence charSequence) {
        this.f161846a.append(charSequence);
        return this;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(CharSequence charSequence, int i3, int i4) {
        this.f161846a.append(charSequence, i3, i4);
        return this;
    }
}
