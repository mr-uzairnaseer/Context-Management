package org.apache.commons.lang3;

import java.util.Arrays;
import java.util.Comparator;

/* loaded from: classes7.dex */
public class ArraySorter {
    @Deprecated
    public ArraySorter() {
    }

    public static char[] a(char[] cArr) {
        if (cArr != null) {
            Arrays.sort(cArr);
        }
        return cArr;
    }

    public static int[] b(int[] iArr) {
        if (iArr != null) {
            Arrays.sort(iArr);
        }
        return iArr;
    }

    public static Object[] c(Object[] objArr, Comparator comparator) {
        if (objArr != null) {
            Arrays.sort(objArr, comparator);
        }
        return objArr;
    }
}
