package com.google.firebase.perf.util;

import java.net.URL;
import java.net.URLConnection;

/* loaded from: classes5.dex */
public class URLWrapper {

    /* renamed from: a, reason: collision with root package name */
    public final URL f73643a;

    public URLWrapper(URL url) {
        this.f73643a = url;
    }

    public URLConnection a() {
        return this.f73643a.openConnection();
    }

    public String toString() {
        return this.f73643a.toString();
    }
}
