package com.google.gson.internal;

import org.apache.commons.lang3.SystemProperties;

/* loaded from: classes5.dex */
public final class JavaVersion {

    /* renamed from: a, reason: collision with root package name */
    public static final int f74235a = a();

    private JavaVersion() {
    }

    public static int a() {
        return e(System.getProperty(SystemProperties.JAVA_VERSION));
    }

    public static int b(String str) {
        try {
            StringBuilder sb = new StringBuilder();
            for (int i3 = 0; i3 < str.length(); i3++) {
                char cCharAt = str.charAt(i3);
                if (!Character.isDigit(cCharAt)) {
                    break;
                }
                sb.append(cCharAt);
            }
            return Integer.parseInt(sb.toString());
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public static boolean c() {
        return f74235a >= 9;
    }

    public static int d(String str) throws NumberFormatException {
        try {
            String[] strArrSplit = str.split("[._]", 3);
            int i3 = Integer.parseInt(strArrSplit[0]);
            return (i3 != 1 || strArrSplit.length <= 1) ? i3 : Integer.parseInt(strArrSplit[1]);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public static int e(String str) throws NumberFormatException {
        int iD = d(str);
        if (iD == -1) {
            iD = b(str);
        }
        if (iD == -1) {
            return 6;
        }
        return iD;
    }
}
