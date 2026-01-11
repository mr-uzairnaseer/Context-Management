package com.google.firebase.perf.logging;

/* loaded from: classes.dex */
public final class ConsoleUrlGenerator {
    public static String a(String str, String str2, String str3) {
        return String.format("%s/troubleshooting/trace/DURATION_TRACE/%s?utm_source=%s&utm_medium=%s", d(str, str2), str3, "perf-android-sdk", "android-ide");
    }

    public static String b(String str, String str2) {
        return String.format("%s/trends?utm_source=%s&utm_medium=%s", d(str, str2), "perf-android-sdk", "android-ide");
    }

    public static String c(String str, String str2, String str3) {
        return String.format("%s/troubleshooting/trace/SCREEN_TRACE/%s?utm_source=%s&utm_medium=%s", d(str, str2), str3, "perf-android-sdk", "android-ide");
    }

    public static String d(String str, String str2) {
        return String.format("%s/project/%s/performance/app/android:%s", "https://console.firebase.google.com", str, str2);
    }
}
