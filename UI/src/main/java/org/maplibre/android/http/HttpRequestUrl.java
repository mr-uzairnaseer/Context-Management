package org.maplibre.android.http;

/* loaded from: classes8.dex */
public class HttpRequestUrl {
    private HttpRequestUrl() {
    }

    public static String a(String str, String str2, int i3, boolean z2) {
        String str3;
        if (!b(str)) {
            return str2;
        }
        if (i3 == 0) {
            str3 = str2 + "?";
        } else {
            str3 = str2 + "&";
        }
        if (!z2) {
            return str3;
        }
        return str3 + "offline=true";
    }

    public static boolean b(String str) {
        return str.equals("mapbox.com") || str.endsWith(".mapbox.com") || str.equals("mapbox.cn") || str.endsWith(".mapbox.cn");
    }
}
