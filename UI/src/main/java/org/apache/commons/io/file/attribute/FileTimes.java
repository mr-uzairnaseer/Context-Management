package org.apache.commons.io.file.attribute;

import androidx.collection.SieveCacheKt;
import java.nio.file.attribute.FileTime;
import java.time.Instant;
import java.util.concurrent.TimeUnit;

/* loaded from: classes6.dex */
public final class FileTimes {
    public static final FileTime EPOCH = FileTime.from(Instant.EPOCH);

    /* renamed from: a, reason: collision with root package name */
    public static final long f161419a = TimeUnit.SECONDS.toNanos(1) / 100;

    /* renamed from: b, reason: collision with root package name */
    public static final long f161420b = TimeUnit.MILLISECONDS.toNanos(1) / 100;

    private FileTimes() {
    }

    public static FileTime a(long j3) {
        return FileTime.from(j3, TimeUnit.SECONDS);
    }

    public static boolean b(long j3) {
        return SieveCacheKt.NodeMetaAndPreviousMask <= j3 && j3 <= SieveCacheKt.NodeLinkMask;
    }

    public static boolean c(FileTime fileTime) {
        return b(f(fileTime));
    }

    public static FileTime d(long j3) {
        long jAddExact = Math.addExact(j3, -116444736000000000L);
        long j4 = f161419a;
        return FileTime.from(Instant.ofEpochSecond(Math.floorDiv(jAddExact, j4), Math.floorMod(jAddExact, j4) * 100));
    }

    public static long e(FileTime fileTime) {
        return Math.subtractExact((fileTime.toInstant().getEpochSecond() * f161419a) + (r4.getNano() / 100), -116444736000000000L);
    }

    public static long f(FileTime fileTime) {
        if (fileTime != null) {
            return fileTime.to(TimeUnit.SECONDS);
        }
        return 0L;
    }
}
