package com.google.android.gms.common.internal.safeparcel;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class SafeParcelReader {

    public static class ParseException extends RuntimeException {
        public ParseException(String str, Parcel parcel) {
            super(str + " Parcel: pos=" + parcel.dataPosition() + " size=" + parcel.dataSize());
        }
    }

    private SafeParcelReader() {
    }

    public static double A(Parcel parcel, int i3) {
        P(parcel, i3, 8);
        return parcel.readDouble();
    }

    public static Double B(Parcel parcel, int i3) {
        int iL = L(parcel, i3);
        if (iL == 0) {
            return null;
        }
        O(parcel, i3, iL, 8);
        return Double.valueOf(parcel.readDouble());
    }

    public static float C(Parcel parcel, int i3) {
        P(parcel, i3, 4);
        return parcel.readFloat();
    }

    public static Float D(Parcel parcel, int i3) {
        int iL = L(parcel, i3);
        if (iL == 0) {
            return null;
        }
        O(parcel, i3, iL, 4);
        return Float.valueOf(parcel.readFloat());
    }

    public static int E(Parcel parcel) {
        return parcel.readInt();
    }

    public static IBinder F(Parcel parcel, int i3) {
        int iL = L(parcel, i3);
        int iDataPosition = parcel.dataPosition();
        if (iL == 0) {
            return null;
        }
        IBinder strongBinder = parcel.readStrongBinder();
        parcel.setDataPosition(iDataPosition + iL);
        return strongBinder;
    }

    public static int G(Parcel parcel, int i3) {
        P(parcel, i3, 4);
        return parcel.readInt();
    }

    public static Integer H(Parcel parcel, int i3) {
        int iL = L(parcel, i3);
        if (iL == 0) {
            return null;
        }
        O(parcel, i3, iL, 4);
        return Integer.valueOf(parcel.readInt());
    }

    public static long I(Parcel parcel, int i3) {
        P(parcel, i3, 8);
        return parcel.readLong();
    }

    public static Long J(Parcel parcel, int i3) {
        int iL = L(parcel, i3);
        if (iL == 0) {
            return null;
        }
        O(parcel, i3, iL, 8);
        return Long.valueOf(parcel.readLong());
    }

    public static short K(Parcel parcel, int i3) {
        P(parcel, i3, 4);
        return (short) parcel.readInt();
    }

    public static int L(Parcel parcel, int i3) {
        return (i3 & (-65536)) != -65536 ? (char) (i3 >> 16) : parcel.readInt();
    }

    public static void M(Parcel parcel, int i3) {
        parcel.setDataPosition(parcel.dataPosition() + L(parcel, i3));
    }

    public static int N(Parcel parcel) {
        int iE = E(parcel);
        int iL = L(parcel, iE);
        int iW = w(iE);
        int iDataPosition = parcel.dataPosition();
        if (iW != 20293) {
            throw new ParseException("Expected object header. Got 0x".concat(String.valueOf(Integer.toHexString(iE))), parcel);
        }
        int i3 = iL + iDataPosition;
        if (i3 >= iDataPosition && i3 <= parcel.dataSize()) {
            return i3;
        }
        throw new ParseException("Size read is invalid start=" + iDataPosition + " end=" + i3, parcel);
    }

    public static void O(Parcel parcel, int i3, int i4, int i5) {
        if (i4 == i5) {
            return;
        }
        throw new ParseException("Expected size " + i5 + " got " + i4 + " (0x" + Integer.toHexString(i4) + ")", parcel);
    }

    public static void P(Parcel parcel, int i3, int i4) {
        int iL = L(parcel, i3);
        if (iL == i4) {
            return;
        }
        throw new ParseException("Expected size " + i4 + " got " + iL + " (0x" + Integer.toHexString(iL) + ")", parcel);
    }

    public static BigDecimal a(Parcel parcel, int i3) {
        int iL = L(parcel, i3);
        int iDataPosition = parcel.dataPosition();
        if (iL == 0) {
            return null;
        }
        byte[] bArrCreateByteArray = parcel.createByteArray();
        int i4 = parcel.readInt();
        parcel.setDataPosition(iDataPosition + iL);
        return new BigDecimal(new BigInteger(bArrCreateByteArray), i4);
    }

    public static BigDecimal[] b(Parcel parcel, int i3) {
        int iL = L(parcel, i3);
        int iDataPosition = parcel.dataPosition();
        if (iL == 0) {
            return null;
        }
        int i4 = parcel.readInt();
        BigDecimal[] bigDecimalArr = new BigDecimal[i4];
        for (int i5 = 0; i5 < i4; i5++) {
            byte[] bArrCreateByteArray = parcel.createByteArray();
            bigDecimalArr[i5] = new BigDecimal(new BigInteger(bArrCreateByteArray), parcel.readInt());
        }
        parcel.setDataPosition(iDataPosition + iL);
        return bigDecimalArr;
    }

    public static BigInteger c(Parcel parcel, int i3) {
        int iL = L(parcel, i3);
        int iDataPosition = parcel.dataPosition();
        if (iL == 0) {
            return null;
        }
        byte[] bArrCreateByteArray = parcel.createByteArray();
        parcel.setDataPosition(iDataPosition + iL);
        return new BigInteger(bArrCreateByteArray);
    }

    public static BigInteger[] d(Parcel parcel, int i3) {
        int iL = L(parcel, i3);
        int iDataPosition = parcel.dataPosition();
        if (iL == 0) {
            return null;
        }
        int i4 = parcel.readInt();
        BigInteger[] bigIntegerArr = new BigInteger[i4];
        for (int i5 = 0; i5 < i4; i5++) {
            bigIntegerArr[i5] = new BigInteger(parcel.createByteArray());
        }
        parcel.setDataPosition(iDataPosition + iL);
        return bigIntegerArr;
    }

    public static boolean[] e(Parcel parcel, int i3) {
        int iL = L(parcel, i3);
        int iDataPosition = parcel.dataPosition();
        if (iL == 0) {
            return null;
        }
        boolean[] zArrCreateBooleanArray = parcel.createBooleanArray();
        parcel.setDataPosition(iDataPosition + iL);
        return zArrCreateBooleanArray;
    }

    public static Bundle f(Parcel parcel, int i3) {
        int iL = L(parcel, i3);
        int iDataPosition = parcel.dataPosition();
        if (iL == 0) {
            return null;
        }
        Bundle bundle = parcel.readBundle();
        parcel.setDataPosition(iDataPosition + iL);
        return bundle;
    }

    public static byte[] g(Parcel parcel, int i3) {
        int iL = L(parcel, i3);
        int iDataPosition = parcel.dataPosition();
        if (iL == 0) {
            return null;
        }
        byte[] bArrCreateByteArray = parcel.createByteArray();
        parcel.setDataPosition(iDataPosition + iL);
        return bArrCreateByteArray;
    }

    public static byte[][] h(Parcel parcel, int i3) {
        int iL = L(parcel, i3);
        int iDataPosition = parcel.dataPosition();
        if (iL == 0) {
            return null;
        }
        int i4 = parcel.readInt();
        byte[][] bArr = new byte[i4][];
        for (int i5 = 0; i5 < i4; i5++) {
            bArr[i5] = parcel.createByteArray();
        }
        parcel.setDataPosition(iDataPosition + iL);
        return bArr;
    }

    public static double[] i(Parcel parcel, int i3) {
        int iL = L(parcel, i3);
        int iDataPosition = parcel.dataPosition();
        if (iL == 0) {
            return null;
        }
        double[] dArrCreateDoubleArray = parcel.createDoubleArray();
        parcel.setDataPosition(iDataPosition + iL);
        return dArrCreateDoubleArray;
    }

    public static float[] j(Parcel parcel, int i3) {
        int iL = L(parcel, i3);
        int iDataPosition = parcel.dataPosition();
        if (iL == 0) {
            return null;
        }
        float[] fArrCreateFloatArray = parcel.createFloatArray();
        parcel.setDataPosition(iDataPosition + iL);
        return fArrCreateFloatArray;
    }

    public static int[] k(Parcel parcel, int i3) {
        int iL = L(parcel, i3);
        int iDataPosition = parcel.dataPosition();
        if (iL == 0) {
            return null;
        }
        int[] iArrCreateIntArray = parcel.createIntArray();
        parcel.setDataPosition(iDataPosition + iL);
        return iArrCreateIntArray;
    }

    public static ArrayList l(Parcel parcel, int i3) {
        int iL = L(parcel, i3);
        int iDataPosition = parcel.dataPosition();
        if (iL == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i4 = parcel.readInt();
        for (int i5 = 0; i5 < i4; i5++) {
            arrayList.add(Integer.valueOf(parcel.readInt()));
        }
        parcel.setDataPosition(iDataPosition + iL);
        return arrayList;
    }

    public static long[] m(Parcel parcel, int i3) {
        int iL = L(parcel, i3);
        int iDataPosition = parcel.dataPosition();
        if (iL == 0) {
            return null;
        }
        long[] jArrCreateLongArray = parcel.createLongArray();
        parcel.setDataPosition(iDataPosition + iL);
        return jArrCreateLongArray;
    }

    public static Parcel n(Parcel parcel, int i3) {
        int iL = L(parcel, i3);
        int iDataPosition = parcel.dataPosition();
        if (iL == 0) {
            return null;
        }
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.appendFrom(parcel, iDataPosition, iL);
        parcel.setDataPosition(iDataPosition + iL);
        return parcelObtain;
    }

    public static Parcel[] o(Parcel parcel, int i3) {
        int iL = L(parcel, i3);
        int iDataPosition = parcel.dataPosition();
        if (iL == 0) {
            return null;
        }
        int i4 = parcel.readInt();
        Parcel[] parcelArr = new Parcel[i4];
        for (int i5 = 0; i5 < i4; i5++) {
            int i6 = parcel.readInt();
            if (i6 != 0) {
                int iDataPosition2 = parcel.dataPosition();
                Parcel parcelObtain = Parcel.obtain();
                parcelObtain.appendFrom(parcel, iDataPosition2, i6);
                parcelArr[i5] = parcelObtain;
                parcel.setDataPosition(iDataPosition2 + i6);
            } else {
                parcelArr[i5] = null;
            }
        }
        parcel.setDataPosition(iDataPosition + iL);
        return parcelArr;
    }

    public static Parcelable p(Parcel parcel, int i3, Parcelable.Creator creator) {
        int iL = L(parcel, i3);
        int iDataPosition = parcel.dataPosition();
        if (iL == 0) {
            return null;
        }
        Parcelable parcelable = (Parcelable) creator.createFromParcel(parcel);
        parcel.setDataPosition(iDataPosition + iL);
        return parcelable;
    }

    public static String q(Parcel parcel, int i3) {
        int iL = L(parcel, i3);
        int iDataPosition = parcel.dataPosition();
        if (iL == 0) {
            return null;
        }
        String string = parcel.readString();
        parcel.setDataPosition(iDataPosition + iL);
        return string;
    }

    public static String[] r(Parcel parcel, int i3) {
        int iL = L(parcel, i3);
        int iDataPosition = parcel.dataPosition();
        if (iL == 0) {
            return null;
        }
        String[] strArrCreateStringArray = parcel.createStringArray();
        parcel.setDataPosition(iDataPosition + iL);
        return strArrCreateStringArray;
    }

    public static ArrayList s(Parcel parcel, int i3) {
        int iL = L(parcel, i3);
        int iDataPosition = parcel.dataPosition();
        if (iL == 0) {
            return null;
        }
        ArrayList<String> arrayListCreateStringArrayList = parcel.createStringArrayList();
        parcel.setDataPosition(iDataPosition + iL);
        return arrayListCreateStringArrayList;
    }

    public static Object[] t(Parcel parcel, int i3, Parcelable.Creator creator) {
        int iL = L(parcel, i3);
        int iDataPosition = parcel.dataPosition();
        if (iL == 0) {
            return null;
        }
        Object[] objArrCreateTypedArray = parcel.createTypedArray(creator);
        parcel.setDataPosition(iDataPosition + iL);
        return objArrCreateTypedArray;
    }

    public static ArrayList u(Parcel parcel, int i3, Parcelable.Creator creator) {
        int iL = L(parcel, i3);
        int iDataPosition = parcel.dataPosition();
        if (iL == 0) {
            return null;
        }
        ArrayList arrayListCreateTypedArrayList = parcel.createTypedArrayList(creator);
        parcel.setDataPosition(iDataPosition + iL);
        return arrayListCreateTypedArrayList;
    }

    public static void v(Parcel parcel, int i3) {
        if (parcel.dataPosition() == i3) {
            return;
        }
        throw new ParseException("Overread allowed size end=" + i3, parcel);
    }

    public static int w(int i3) {
        return (char) i3;
    }

    public static boolean x(Parcel parcel, int i3) {
        P(parcel, i3, 4);
        return parcel.readInt() != 0;
    }

    public static Boolean y(Parcel parcel, int i3) {
        int iL = L(parcel, i3);
        if (iL == 0) {
            return null;
        }
        O(parcel, i3, iL, 4);
        return Boolean.valueOf(parcel.readInt() != 0);
    }

    public static byte z(Parcel parcel, int i3) {
        P(parcel, i3, 4);
        return (byte) parcel.readInt();
    }
}
