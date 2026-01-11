package org.apache.commons.compress.utils;

import java.io.FilterInputStream;
import java.io.IOException;

@Deprecated
/* loaded from: classes5.dex */
public class CountingInputStream extends FilterInputStream {

    /* renamed from: a, reason: collision with root package name */
    public long f161308a;

    public final void a(long j3) {
        if (j3 != -1) {
            this.f161308a += j3;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int i3 = ((FilterInputStream) this).in.read();
        if (i3 >= 0) {
            a(1L);
        }
        return i3;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i3, int i4) throws IOException {
        if (i4 == 0) {
            return 0;
        }
        int i5 = ((FilterInputStream) this).in.read(bArr, i3, i4);
        if (i5 >= 0) {
            a(i5);
        }
        return i5;
    }
}
