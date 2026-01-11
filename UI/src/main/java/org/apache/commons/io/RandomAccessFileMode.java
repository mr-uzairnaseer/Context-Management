package org.apache.commons.io;

import java.io.File;
import java.io.RandomAccessFile;

/* loaded from: classes6.dex */
public enum RandomAccessFileMode {
    READ_ONLY("r"),
    READ_WRITE("rw"),
    READ_WRITE_SYNC_ALL("rws"),
    READ_WRITE_SYNC_CONTENT("rwd");

    private final String mode;

    RandomAccessFileMode(String str) {
        this.mode = str;
    }

    public RandomAccessFile c(File file) {
        return new RandomAccessFile(file, this.mode);
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.mode;
    }
}
