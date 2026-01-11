package freemarker.template.utility;

import java.io.Writer;

/* loaded from: classes8.dex */
public final class NullWriter extends Writer {
    public static final NullWriter INSTANCE = new NullWriter();

    private NullWriter() {
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
    }

    @Override // java.io.Writer
    public void write(int i3) {
    }

    @Override // java.io.Writer
    public void write(String str) {
    }

    @Override // java.io.Writer
    public void write(String str, int i3, int i4) {
    }

    @Override // java.io.Writer
    public void write(char[] cArr) {
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i3, int i4) {
    }
}
