package dagger.internal;

import java.util.HashSet;
import java.util.LinkedHashMap;

/* loaded from: classes5.dex */
public final class DaggerCollections {
    private DaggerCollections() {
    }

    public static int a(int i3) {
        if (i3 < 3) {
            return i3 + 1;
        }
        if (i3 < 1073741824) {
            return (int) ((i3 / 0.75f) + 1.0f);
        }
        return Integer.MAX_VALUE;
    }

    public static HashSet b(int i3) {
        return new HashSet(a(i3));
    }

    public static LinkedHashMap c(int i3) {
        return new LinkedHashMap(a(i3));
    }
}
