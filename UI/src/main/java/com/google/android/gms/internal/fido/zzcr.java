package com.google.android.gms.internal.fido;

/* loaded from: classes4.dex */
public final class zzcr {
    public static Object a(Object obj, int i3) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException("at index " + i3);
    }

    public static Object[] b(Object[] objArr, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            a(objArr[i4], i4);
        }
        return objArr;
    }
}
