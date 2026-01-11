package com.squareup.picasso;

/* loaded from: classes5.dex */
public enum MemoryPolicy {
    NO_CACHE(1),
    NO_STORE(2);

    final int index;

    MemoryPolicy(int i3) {
        this.index = i3;
    }

    public static boolean a(int i3) {
        return (i3 & NO_CACHE.index) == 0;
    }

    public static boolean c(int i3) {
        return (i3 & NO_STORE.index) == 0;
    }
}
