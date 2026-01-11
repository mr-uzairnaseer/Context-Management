package com.google.android.gms.measurement.internal;

import org.locationtech.jts.geom.Dimension;

/* loaded from: classes.dex */
enum zzao {
    UNSET('0'),
    REMOTE_DEFAULT(Dimension.SYM_L),
    REMOTE_DELEGATION(Dimension.SYM_A),
    MANIFEST('3'),
    INITIALIZATION('4'),
    API('5'),
    CHILD_ACCOUNT('6'),
    TCF('7'),
    REMOTE_ENFORCED_DEFAULT('8'),
    FAILSAFE('9');

    private final char zzl;

    zzao(char c3) {
        this.zzl = c3;
    }

    public static zzao c(char c3) {
        for (zzao zzaoVar : values()) {
            if (zzaoVar.zzl == c3) {
                return zzaoVar;
            }
        }
        return UNSET;
    }
}
