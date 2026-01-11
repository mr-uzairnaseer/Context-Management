package org.apache.commons.compress.archivers.tar;

import java.io.InputStream;

/* loaded from: classes5.dex */
final class TarArchiveSparseZeroInputStream extends InputStream {
    @Override // java.io.InputStream
    public int read() {
        return 0;
    }

    @Override // java.io.InputStream
    public long skip(long j3) {
        return j3;
    }
}
