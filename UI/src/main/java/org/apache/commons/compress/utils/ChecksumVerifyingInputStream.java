package org.apache.commons.compress.utils;

import java.io.IOException;
import java.util.zip.CheckedInputStream;

@Deprecated
/* loaded from: classes5.dex */
public class ChecksumVerifyingInputStream extends CheckedInputStream {

    /* renamed from: a, reason: collision with root package name */
    public long f161306a;

    /* renamed from: b, reason: collision with root package name */
    public final long f161307b;

    public final void a() throws IOException {
        if (this.f161306a <= 0 && this.f161307b != getChecksum().getValue()) {
            throw new IOException("Checksum verification failed");
        }
    }

    @Override // java.util.zip.CheckedInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        if (this.f161306a <= 0) {
            return -1;
        }
        int i3 = super.read();
        if (i3 >= 0) {
            this.f161306a--;
        }
        a();
        return i3;
    }

    @Override // java.util.zip.CheckedInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i3, int i4) throws IOException {
        if (i4 == 0) {
            return 0;
        }
        int i5 = super.read(bArr, i3, i4);
        if (i5 >= 0) {
            this.f161306a -= i5;
        }
        a();
        return i5;
    }
}
