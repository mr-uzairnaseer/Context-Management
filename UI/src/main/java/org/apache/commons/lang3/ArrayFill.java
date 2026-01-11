package org.apache.commons.lang3;

import java.util.Arrays;

/* loaded from: classes7.dex */
public final class ArrayFill {
    private ArrayFill() {
    }

    public static byte[] a(byte[] bArr, byte b3) {
        if (bArr != null) {
            Arrays.fill(bArr, b3);
        }
        return bArr;
    }

    public static char[] b(char[] cArr, char c3) {
        if (cArr != null) {
            Arrays.fill(cArr, c3);
        }
        return cArr;
    }

    public static int[] c(int[] iArr, int i3) {
        if (iArr != null) {
            Arrays.fill(iArr, i3);
        }
        return iArr;
    }
}
