package org.apache.commons.compress.utils;

import java.io.FilterOutputStream;
import java.io.IOException;

@Deprecated
/* loaded from: classes5.dex */
public class CountingOutputStream extends FilterOutputStream {

    /* renamed from: a, reason: collision with root package name */
    public long f161309a;

    public void a(long j3) {
        if (j3 != -1) {
            this.f161309a += j3;
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i3, int i4) throws IOException {
        ((FilterOutputStream) this).out.write(bArr, i3, i4);
        a(i4);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i3) throws IOException {
        ((FilterOutputStream) this).out.write(i3);
        a(1L);
    }
}
