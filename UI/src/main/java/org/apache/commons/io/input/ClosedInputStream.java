package org.apache.commons.io.input;

import java.io.InputStream;

/* loaded from: classes6.dex */
public class ClosedInputStream extends InputStream {

    @Deprecated
    public static final ClosedInputStream CLOSED_INPUT_STREAM;
    public static final ClosedInputStream INSTANCE;

    static {
        ClosedInputStream closedInputStream = new ClosedInputStream();
        INSTANCE = closedInputStream;
        CLOSED_INPUT_STREAM = closedInputStream;
    }

    @Override // java.io.InputStream
    public int read() {
        return -1;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i3, int i4) {
        return -1;
    }
}
