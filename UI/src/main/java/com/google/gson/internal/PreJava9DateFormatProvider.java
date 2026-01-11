package com.google.gson.internal;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* loaded from: classes5.dex */
public class PreJava9DateFormatProvider {
    private PreJava9DateFormatProvider() {
    }

    public static String a(int i3) {
        if (i3 == 0) {
            return "EEEE, MMMM d, yyyy";
        }
        if (i3 == 1) {
            return "MMMM d, yyyy";
        }
        if (i3 == 2) {
            return "MMM d, yyyy";
        }
        if (i3 == 3) {
            return "M/d/yy";
        }
        throw new IllegalArgumentException("Unknown DateFormat style: " + i3);
    }

    public static String b(int i3) {
        if (i3 == 0 || i3 == 1) {
            return "h:mm:ss a z";
        }
        if (i3 == 2) {
            return "h:mm:ss a";
        }
        if (i3 == 3) {
            return "h:mm a";
        }
        throw new IllegalArgumentException("Unknown DateFormat style: " + i3);
    }

    public static DateFormat c(int i3, int i4) {
        return new SimpleDateFormat(a(i3) + " " + b(i4), Locale.US);
    }
}
