package org.apache.commons.io.input;

import java.io.Reader;

/* loaded from: classes6.dex */
public class ClosedReader extends Reader {

    @Deprecated
    public static final ClosedReader CLOSED_READER;
    public static final ClosedReader INSTANCE;

    static {
        ClosedReader closedReader = new ClosedReader();
        INSTANCE = closedReader;
        CLOSED_READER = closedReader;
    }

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // java.io.Reader
    public int read(char[] cArr, int i3, int i4) {
        return -1;
    }
}
