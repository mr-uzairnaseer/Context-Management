package org.apache.commons.io.input;

import java.io.IOException;
import java.io.Reader;

/* loaded from: classes6.dex */
public class BoundedReader extends Reader {

    /* renamed from: a, reason: collision with root package name */
    public final Reader f161548a;

    /* renamed from: b, reason: collision with root package name */
    public int f161549b;

    /* renamed from: c, reason: collision with root package name */
    public int f161550c;

    /* renamed from: d, reason: collision with root package name */
    public int f161551d;

    /* renamed from: e, reason: collision with root package name */
    public final int f161552e;

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f161548a.close();
    }

    @Override // java.io.Reader
    public void mark(int i3) throws IOException {
        int i4 = this.f161549b;
        this.f161551d = i3 - i4;
        this.f161550c = i4;
        this.f161548a.mark(i3);
    }

    @Override // java.io.Reader
    public int read() {
        int i3 = this.f161549b;
        if (i3 >= this.f161552e) {
            return -1;
        }
        int i4 = this.f161550c;
        if (i4 >= 0 && i3 - i4 >= this.f161551d) {
            return -1;
        }
        this.f161549b = i3 + 1;
        return this.f161548a.read();
    }

    @Override // java.io.Reader
    public void reset() throws IOException {
        this.f161549b = this.f161550c;
        this.f161548a.reset();
    }

    @Override // java.io.Reader
    public int read(char[] cArr, int i3, int i4) {
        for (int i5 = 0; i5 < i4; i5++) {
            int i6 = read();
            if (i6 == -1) {
                if (i5 == 0) {
                    return -1;
                }
                return i5;
            }
            cArr[i3 + i5] = (char) i6;
        }
        return i4;
    }
}
