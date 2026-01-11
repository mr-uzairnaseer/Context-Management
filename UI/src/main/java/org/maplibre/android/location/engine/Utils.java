package org.maplibre.android.location.engine;

import android.location.Location;

/* loaded from: classes9.dex */
final class Utils {
    private Utils() {
    }

    public static Object a(Object obj, String str) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(str);
    }

    public static boolean b(Location location, Location location2) {
        if (location2 == null) {
            return true;
        }
        long time = location.getTime() - location2.getTime();
        boolean z2 = time > 120000;
        boolean z3 = time < -120000;
        boolean z4 = time > 0;
        if (z2) {
            return true;
        }
        if (z3) {
            return false;
        }
        int accuracy = (int) (location.getAccuracy() - location2.getAccuracy());
        boolean z5 = accuracy > 0;
        boolean z6 = accuracy < 0;
        boolean z7 = accuracy > 200;
        boolean zC = c(location.getProvider(), location2.getProvider());
        if (z6) {
            return true;
        }
        if (!z4 || z5) {
            return z4 && !z7 && zC;
        }
        return true;
    }

    public static boolean c(String str, String str2) {
        return str == null ? str2 == null : str.equals(str2);
    }
}
