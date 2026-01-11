package org.locationtech.jts.io;

import java.util.EnumSet;

/* loaded from: classes6.dex */
public enum Ordinate {
    X,
    Y,
    Z,
    M;

    private static final EnumSet<Ordinate> XY;
    private static final EnumSet<Ordinate> XYM;
    private static final EnumSet<Ordinate> XYZ;
    private static final EnumSet<Ordinate> XYZM;

    static {
        Ordinate ordinate = X;
        Ordinate ordinate2 = Y;
        Ordinate ordinate3 = Z;
        Ordinate ordinate4 = M;
        XY = EnumSet.of(ordinate, ordinate2);
        XYZ = EnumSet.of(ordinate, ordinate2, ordinate3);
        XYM = EnumSet.of(ordinate, ordinate2, ordinate4);
        XYZM = EnumSet.of(ordinate, ordinate2, ordinate3, ordinate4);
    }
}
