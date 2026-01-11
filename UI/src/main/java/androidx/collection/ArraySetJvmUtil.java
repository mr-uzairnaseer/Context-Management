package androidx.collection;

import java.lang.reflect.Array;

/* loaded from: classes2.dex */
class ArraySetJvmUtil {
    private ArraySetJvmUtil() {
    }

    public static Object[] a(Object[] objArr, int i3) {
        if (objArr.length < i3) {
            return (Object[]) Array.newInstance(objArr.getClass().getComponentType(), i3);
        }
        if (objArr.length > i3) {
            objArr[i3] = null;
        }
        return objArr;
    }
}
