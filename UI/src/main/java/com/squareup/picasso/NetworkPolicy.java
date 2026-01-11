package com.squareup.picasso;

/* loaded from: classes5.dex */
public enum NetworkPolicy {
    NO_CACHE(1),
    NO_STORE(2),
    OFFLINE(4);

    final int index;

    NetworkPolicy(int i3) {
        this.index = i3;
    }

    public static boolean a(int i3) {
        return (i3 & OFFLINE.index) != 0;
    }

    public static boolean c(int i3) {
        return (i3 & NO_CACHE.index) == 0;
    }

    public static boolean d(int i3) {
        return (i3 & NO_STORE.index) == 0;
    }
}
