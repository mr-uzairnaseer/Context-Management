package org.maplibre.android.gestures;

/* loaded from: classes8.dex */
class PermittedActionsGuard {
    public boolean a(int i3, int i4, int i5) {
        long jB = b(i4, i5);
        long j3 = i3;
        if (j3 == jB) {
            return false;
        }
        while (jB != 0) {
            if (j3 == (255 & jB)) {
                return false;
            }
            jB >>= 8;
        }
        return true;
    }

    public final long b(int i3, int i4) {
        if (i4 == 0) {
            return 0L;
        }
        if (Math.abs(i3 - i4) > 1) {
            return 255L;
        }
        if (i3 > i4) {
            return 5L;
        }
        if (i3 < i4) {
            return 255L;
        }
        return ((i3 == 1 ? 1L : 6L) << 8) + 2;
    }
}
