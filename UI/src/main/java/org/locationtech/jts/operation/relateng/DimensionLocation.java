package org.locationtech.jts.operation.relateng;

/* loaded from: classes7.dex */
class DimensionLocation {
    public static final int AREA_BOUNDARY = 121;
    public static final int AREA_INTERIOR = 120;
    public static final int EXTERIOR = 2;
    public static final int LINE_BOUNDARY = 111;
    public static final int LINE_INTERIOR = 110;
    public static final int POINT_INTERIOR = 103;

    public static int a(int i3) {
        if (i3 == 103 || i3 == 110) {
            return 0;
        }
        if (i3 == 111) {
            return 1;
        }
        if (i3 != 120) {
            return i3 != 121 ? 2 : 1;
        }
        return 0;
    }

    public static int b(int i3) {
        if (i3 != 0) {
            return i3 != 1 ? 2 : 121;
        }
        return 120;
    }

    public static int c(int i3) {
        if (i3 != 0) {
            return i3 != 1 ? 2 : 111;
        }
        return 110;
    }

    public static int d(int i3) {
        return i3 != 0 ? 2 : 103;
    }
}
