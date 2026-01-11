package org.apache.commons.compress.compressors;

import java.io.FilterOutputStream;
import java.io.OutputStream;

/* loaded from: classes5.dex */
public abstract class CompressorOutputStream<T extends OutputStream> extends FilterOutputStream {
    public CompressorOutputStream() {
        super(null);
    }

    public CompressorOutputStream(OutputStream outputStream) {
        super(outputStream);
    }
}
