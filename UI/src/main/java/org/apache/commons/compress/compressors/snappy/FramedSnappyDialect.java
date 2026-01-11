package org.apache.commons.compress.compressors.snappy;

/* loaded from: classes5.dex */
public enum FramedSnappyDialect {
    STANDARD(true, true),
    IWORK_ARCHIVE(false, false);

    private final boolean checksumWithCompressedChunks;
    private final boolean streamIdentifier;

    FramedSnappyDialect(boolean z2, boolean z3) {
        this.streamIdentifier = z2;
        this.checksumWithCompressedChunks = z3;
    }

    public boolean c() {
        return this.checksumWithCompressedChunks;
    }
}
