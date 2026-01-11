package org.locationtech.jts.geom;

/* loaded from: classes5.dex */
public class Dimension {
    public static final int A = 2;
    public static final int DONTCARE = -3;
    public static final int FALSE = -1;
    public static final int L = 1;
    public static final int P = 0;
    public static final char SYM_A = '2';
    public static final char SYM_DONTCARE = '*';
    public static final char SYM_FALSE = 'F';
    public static final char SYM_L = '1';
    public static final char SYM_P = '0';
    public static final char SYM_TRUE = 'T';
    public static final int TRUE = -2;

    public static char a(int i3) {
        if (i3 == -3) {
            return '*';
        }
        if (i3 == -2) {
            return SYM_TRUE;
        }
        if (i3 == -1) {
            return SYM_FALSE;
        }
        if (i3 == 0) {
            return '0';
        }
        if (i3 == 1) {
            return SYM_L;
        }
        if (i3 == 2) {
            return SYM_A;
        }
        throw new IllegalArgumentException("Unknown dimension value: " + i3);
    }
}
