package de.komoot.android.util;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public final class AssertUtil {
    public static void A(Object obj) {
        if (obj != null) {
            throw Q("not null");
        }
    }

    public static void B(Object obj, String str) {
        if (obj != null) {
            throw Q(str);
        }
    }

    public static String C(String str) {
        if (str == null || !str.isEmpty()) {
            return str;
        }
        throw Q("empty nullable string");
    }

    public static String D(String str, String str2) {
        if (str == null || !str.isEmpty()) {
            return str;
        }
        throw Q(str2);
    }

    public static double E(double d3) {
        if (d3 >= 0.0d && d3 <= 1.0d) {
            return d3;
        }
        throw Q("value out of range: " + d3);
    }

    public static double F(double d3, double d4, double d5) {
        if (d5 >= d3 && d5 <= d4) {
            if (Double.isNaN(d5)) {
                throw Q("value is NAN");
            }
            return d5;
        }
        throw Q("value '" + d5 + "' is out of range [" + d3 + "::" + d4 + "]");
    }

    public static float G(float f3, float f4, float f5) {
        if (f5 >= f3 && f5 <= f4) {
            if (Float.isNaN(f5)) {
                throw Q("value is NAN");
            }
            return f5;
        }
        throw Q("value '" + f5 + "' is out of range [" + f3 + "::" + f4 + "]");
    }

    public static int H(int i3, int i4, int i5) {
        if (i5 >= i3 && i5 <= i4) {
            return i5;
        }
        throw Q("value '" + i5 + "' is out of range [" + i3 + "::" + i4 + "]");
    }

    public static String I(String str) {
        x(str, "argument is null");
        if (str.isEmpty()) {
            throw Q("empty string");
        }
        return str;
    }

    public static String J(String str, String str2) {
        x(str, "argument is null");
        if (str.isEmpty()) {
            throw Q(str2);
        }
        return str;
    }

    public static boolean K(boolean z2) {
        if (z2) {
            return z2;
        }
        throw Q("pValue is false");
    }

    public static boolean L(boolean z2, String str) {
        if (z2) {
            return z2;
        }
        throw Q(str);
    }

    public static int M(int i3) {
        return d(i3);
    }

    public static int N(int i3, String str) {
        return e(i3, str);
    }

    public static long O(long j3) {
        return f(j3);
    }

    public static long P(long j3, String str) {
        return g(j3, str);
    }

    public static AssertionError Q(String str) {
        StackTraceElement[] stackTraceElementArr;
        AssertionError assertionError = new AssertionError(str);
        StackTraceElement[] stackTrace = assertionError.getStackTrace();
        Object[] objArrCopyOfRange = Arrays.copyOfRange(stackTrace, 2, stackTrace.length);
        while (true) {
            stackTraceElementArr = (StackTraceElement[]) objArrCopyOfRange;
            if (stackTraceElementArr.length <= 0 || !AssertUtil.class.getName().equals(stackTraceElementArr[0].getClassName())) {
                break;
            }
            objArrCopyOfRange = Arrays.copyOfRange(stackTraceElementArr, 1, stackTraceElementArr.length);
        }
        assertionError.setStackTrace(stackTraceElementArr);
        return assertionError;
    }

    public static boolean a(boolean z2) {
        if (z2) {
            throw Q("value is TRUE");
        }
        return z2;
    }

    public static boolean b(boolean z2, String str) {
        if (z2) {
            throw Q(str);
        }
        return z2;
    }

    public static float c(float f3, String str) {
        if (f3 < 0.0f) {
            throw Q(str);
        }
        if (Float.isNaN(f3)) {
            throw Q("value is NAN");
        }
        return f3;
    }

    public static int d(int i3) {
        if (i3 >= 0) {
            return i3;
        }
        throw Q("value " + i3 + " < 0");
    }

    public static int e(int i3, String str) {
        if (i3 >= 0) {
            return i3;
        }
        throw Q(str);
    }

    public static long f(long j3) {
        if (j3 >= 0) {
            return j3;
        }
        throw Q("value " + j3 + " < 0");
    }

    public static long g(long j3, String str) {
        if (j3 >= 0) {
            return j3;
        }
        throw Q(str);
    }

    public static int h(int i3) {
        if (i3 > 0) {
            return i3;
        }
        throw Q("value " + i3 + " <= 0");
    }

    public static int i(int i3, String str) {
        if (i3 > 0) {
            return i3;
        }
        throw Q(str);
    }

    public static long j(long j3) {
        if (j3 > 0) {
            return j3;
        }
        throw Q("value " + j3 + " <= 0");
    }

    public static long k(long j3, String str) {
        if (j3 > 0) {
            return j3;
        }
        throw Q(str);
    }

    public static int l(int i3, int... iArr) {
        for (int i4 : iArr) {
            if (i4 == i3) {
                return i3;
            }
        }
        throw Q("not in valid int[] set");
    }

    public static Object m(Object obj, Collection collection, String str) {
        x(obj, "pCheck is null");
        if (collection.contains(obj)) {
            return obj;
        }
        throw Q(str);
    }

    public static Object n(Object obj, Object[] objArr, String str) {
        x(obj, "pCheck is null");
        for (Object obj2 : objArr) {
            if (obj2.equals(obj)) {
                return obj;
            }
        }
        throw Q(str);
    }

    public static List o(List list, int i3, String str) {
        x(list, "pList is null");
        if (i3 < 0) {
            throw Q(str);
        }
        if (i3 <= list.size() - 1) {
            return list;
        }
        throw Q(str);
    }

    public static long p(long j3, String str) {
        return g(j3, str + " value :: " + j3);
    }

    public static Collection q(Collection collection, String str) {
        x(collection, "pCollection is null");
        Iterator it = collection.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            if (it.next() == null) {
                throw Q("null element at " + i3 + " :: " + str);
            }
            i3++;
        }
        return collection;
    }

    public static Collection r(Collection collection) {
        x(collection, "pCollection is null");
        if (collection.isEmpty()) {
            throw Q("pCollection is empty");
        }
        return collection;
    }

    public static Collection s(Collection collection, String str) {
        x(collection, "pCollection is null");
        if (collection.isEmpty()) {
            throw Q(str);
        }
        return collection;
    }

    public static float[] t(float[] fArr) {
        x(fArr, "pArray is null");
        if (fArr.length > 0) {
            return fArr;
        }
        throw Q("empty float array");
    }

    public static Object[] u(Object[] objArr, String str) {
        x(objArr, "pArray is null");
        if (objArr.length > 0) {
            return objArr;
        }
        throw Q(str);
    }

    public static double v(double d3) {
        if (Double.isNaN(d3)) {
            throw Q("Is NAN");
        }
        return d3;
    }

    public static Object w(Object obj) {
        if (obj != null) {
            return obj;
        }
        throw Q("pObject is null");
    }

    public static Object x(Object obj, String str) {
        if (obj != null) {
            return obj;
        }
        throw Q(str);
    }

    public static void y(Object obj, Object obj2, String str) {
        if (obj == null && obj2 == null) {
            throw Q(str);
        }
    }

    public static void z(Object obj, Object obj2, String str) {
        if ((obj == null && obj2 == null) || (obj != null && obj2 != null)) {
            throw Q(str);
        }
    }
}
