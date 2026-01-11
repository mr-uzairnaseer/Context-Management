package com.google.firebase.perf.util;

import org.apache.commons.io.FileUtils;

/* loaded from: classes5.dex */
public enum StorageUnit {
    TERABYTES(FileUtils.ONE_TB) { // from class: com.google.firebase.perf.util.StorageUnit.1
    },
    GIGABYTES(FileUtils.ONE_GB) { // from class: com.google.firebase.perf.util.StorageUnit.2
    },
    MEGABYTES(1048576) { // from class: com.google.firebase.perf.util.StorageUnit.3
    },
    KILOBYTES(1024) { // from class: com.google.firebase.perf.util.StorageUnit.4
    },
    BYTES(1) { // from class: com.google.firebase.perf.util.StorageUnit.5
    };

    long numBytes;

    public long c(long j3) {
        return (j3 * this.numBytes) / KILOBYTES.numBytes;
    }

    StorageUnit(long j3) {
        this.numBytes = j3;
    }
}
