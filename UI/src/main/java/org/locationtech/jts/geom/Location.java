package org.locationtech.jts.geom;

import org.apache.commons.codec.language.Soundex;

/* loaded from: classes5.dex */
public class Location {
    public static final int BOUNDARY = 1;
    public static final int EXTERIOR = 2;
    public static final int INTERIOR = 0;
    public static final int NONE = -1;

    public static char a(int i3) {
        if (i3 == -1) {
            return Soundex.SILENT_MARKER;
        }
        if (i3 == 0) {
            return 'i';
        }
        if (i3 == 1) {
            return 'b';
        }
        if (i3 == 2) {
            return 'e';
        }
        throw new IllegalArgumentException("Unknown location value: " + i3);
    }
}
