package org.apache.commons.compress.archivers.zip;

import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes5.dex */
abstract class RandomAccessOutputStream extends OutputStream {
    public abstract void a(byte[] bArr, int i3, int i4, long j3);

    public void c(byte[] bArr, long j3) {
        a(bArr, 0, bArr.length, j3);
    }

    @Override // java.io.OutputStream
    public void write(int i3) throws IOException {
        write(new byte[]{(byte) i3});
    }
}
