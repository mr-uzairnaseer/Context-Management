package org.apache.commons.compress;

import java.io.IOException;

/* loaded from: classes5.dex */
public class MemoryLimitException extends IOException {

    /* renamed from: a, reason: collision with root package name */
    public final long f159852a;

    /* renamed from: b, reason: collision with root package name */
    public final int f159853b;

    public MemoryLimitException(long j3, int i3) {
        super(a(j3, i3));
        this.f159852a = j3;
        this.f159853b = i3;
    }

    public static String a(long j3, int i3) {
        return j3 + " kb of memory would be needed; limit was " + i3 + " kb. If the file is not corrupt, consider increasing the memory limit.";
    }

    public MemoryLimitException(long j3, int i3, Exception exc) {
        super(a(j3, i3), exc);
        this.f159852a = j3;
        this.f159853b = i3;
    }
}
