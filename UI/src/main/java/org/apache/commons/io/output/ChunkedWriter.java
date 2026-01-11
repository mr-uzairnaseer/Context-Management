package org.apache.commons.io.output;

import java.io.FilterWriter;
import java.io.IOException;

/* loaded from: classes6.dex */
public class ChunkedWriter extends FilterWriter {

    /* renamed from: a, reason: collision with root package name */
    public final int f161823a;

    @Override // java.io.FilterWriter, java.io.Writer
    public void write(char[] cArr, int i3, int i4) throws IOException {
        while (i4 > 0) {
            int iMin = Math.min(i4, this.f161823a);
            ((FilterWriter) this).out.write(cArr, i3, iMin);
            i4 -= iMin;
            i3 += iMin;
        }
    }
}
