package org.apache.commons.io.output;

import java.io.OutputStream;

/* loaded from: classes6.dex */
public class NullOutputStream extends OutputStream {
    public static final NullOutputStream INSTANCE;

    @Deprecated
    public static final NullOutputStream NULL_OUTPUT_STREAM;

    static {
        NullOutputStream nullOutputStream = new NullOutputStream();
        INSTANCE = nullOutputStream;
        NULL_OUTPUT_STREAM = nullOutputStream;
    }

    @Deprecated
    public NullOutputStream() {
    }

    @Override // java.io.OutputStream
    public void write(int i3) {
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) {
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i3, int i4) {
    }
}
