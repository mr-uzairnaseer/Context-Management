package org.apache.commons.compress.utils;

import java.io.FilterOutputStream;
import java.io.OutputStream;

/* loaded from: classes5.dex */
public class FlushShieldFilterOutputStream extends FilterOutputStream {
    public FlushShieldFilterOutputStream(OutputStream outputStream) {
        super(outputStream);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
    public void flush() {
    }
}
