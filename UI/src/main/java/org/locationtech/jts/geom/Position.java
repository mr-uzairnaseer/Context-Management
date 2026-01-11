package org.locationtech.jts.geom;

/* loaded from: classes5.dex */
public class Position {
    public static final int LEFT = 1;
    public static final int ON = 0;
    public static final int RIGHT = 2;

    public static final int a(int i3) {
        if (i3 == 1) {
            return 2;
        }
        if (i3 == 2) {
            return 1;
        }
        return i3;
    }
}
