package com.airbnb.lottie;

/* loaded from: classes4.dex */
public enum RenderMode {
    AUTOMATIC,
    HARDWARE,
    SOFTWARE;

    public boolean c(int i3, boolean z2, int i4) {
        int iOrdinal = ordinal();
        if (iOrdinal == 1) {
            return false;
        }
        if (iOrdinal != 2) {
            return (z2 && i3 < 28) || i4 > 4 || i3 <= 25;
        }
        return true;
    }
}
