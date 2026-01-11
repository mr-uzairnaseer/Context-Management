package org.apache.commons.codec.digest;

/* loaded from: classes4.dex */
public final class MurmurHash3 {
    public static final int DEFAULT_SEED = 104729;

    @Deprecated
    public static final long NULL_HASHCODE = 2862933555777941757L;

    @Deprecated
    public static class IncrementalHash32 extends IncrementalHash32x86 {
    }

    public static class IncrementalHash32x86 {

        /* renamed from: a, reason: collision with root package name */
        public final byte[] f159692a = new byte[3];
    }

    private MurmurHash3() {
    }
}
