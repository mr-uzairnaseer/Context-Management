package org.apache.commons.compress.utils;

import java.io.IOException;

/* loaded from: classes5.dex */
public final class ParsingUtils {
    private ParsingUtils() {
    }

    public static int a(String str) {
        return b(str, 10);
    }

    public static int b(String str, int i3) throws IOException {
        try {
            return Integer.parseInt(str, i3);
        } catch (NumberFormatException unused) {
            throw new IOException("Unable to parse int from string value: " + str);
        }
    }

    public static long c(String str) {
        return d(str, 10);
    }

    public static long d(String str, int i3) throws IOException {
        try {
            return Long.parseLong(str, i3);
        } catch (NumberFormatException unused) {
            throw new IOException("Unable to parse long from string value: " + str);
        }
    }
}
