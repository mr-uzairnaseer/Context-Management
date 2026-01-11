package org.apache.commons.io.input;

import java.io.InputStream;

/* loaded from: classes6.dex */
public class CircularInputStream extends InputStream {

    /* renamed from: a, reason: collision with root package name */
    public long f161578a;

    /* renamed from: b, reason: collision with root package name */
    public int f161579b;

    /* renamed from: c, reason: collision with root package name */
    public final byte[] f161580c;

    /* renamed from: d, reason: collision with root package name */
    public final long f161581d;

    @Override // java.io.InputStream
    public int read() {
        long j3 = this.f161581d;
        if (j3 >= 0) {
            long j4 = this.f161578a;
            if (j4 == j3) {
                return -1;
            }
            this.f161578a = j4 + 1;
        }
        int i3 = this.f161579b + 1;
        byte[] bArr = this.f161580c;
        int length = i3 % bArr.length;
        this.f161579b = length;
        return bArr[length] & 255;
    }
}
