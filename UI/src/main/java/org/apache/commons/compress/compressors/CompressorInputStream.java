package org.apache.commons.compress.compressors;

import java.io.InputStream;

/* loaded from: classes5.dex */
public abstract class CompressorInputStream extends InputStream {

    /* renamed from: a, reason: collision with root package name */
    public long f160523a;

    public void a(int i3) {
        c(i3);
    }

    public void c(long j3) {
        if (j3 != -1) {
            this.f160523a += j3;
        }
    }

    public long d() {
        return this.f160523a;
    }

    public void e(long j3) {
        this.f160523a -= j3;
    }
}
