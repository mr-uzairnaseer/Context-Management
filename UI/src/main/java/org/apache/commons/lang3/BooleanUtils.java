package org.apache.commons.lang3;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: classes7.dex */
public class BooleanUtils {
    public static final String FALSE = "false";
    public static final String NO = "no";
    public static final String OFF = "off";
    public static final String ON = "on";
    public static final String TRUE = "true";
    public static final String YES = "yes";

    /* renamed from: a, reason: collision with root package name */
    public static final List f161918a = Collections.unmodifiableList(Arrays.asList(Boolean.FALSE, Boolean.TRUE));

    @Deprecated
    public BooleanUtils() {
    }

    public static int a(boolean z2, boolean z3) {
        if (z2 == z3) {
            return 0;
        }
        return z2 ? 1 : -1;
    }
}
