package org.apache.commons.compress.compressors.gzip;

/* loaded from: classes5.dex */
public class GzipParameters {

    /* renamed from: b, reason: collision with root package name */
    public long f160682b;

    /* renamed from: c, reason: collision with root package name */
    public String f160683c;

    /* renamed from: d, reason: collision with root package name */
    public String f160684d;

    /* renamed from: a, reason: collision with root package name */
    public int f160681a = -1;

    /* renamed from: e, reason: collision with root package name */
    public int f160685e = 255;

    /* renamed from: f, reason: collision with root package name */
    public int f160686f = 512;

    /* renamed from: g, reason: collision with root package name */
    public int f160687g = 0;

    public int a() {
        return this.f160686f;
    }

    public String b() {
        return this.f160684d;
    }

    public int c() {
        return this.f160681a;
    }

    public int d() {
        return this.f160687g;
    }

    public String e() {
        return this.f160683c;
    }

    public long f() {
        return this.f160682b;
    }

    public int g() {
        return this.f160685e;
    }

    public void h(String str) {
        this.f160684d = str;
    }

    public void i(int i3) {
        if (i3 >= -1 && i3 <= 9) {
            this.f160681a = i3;
            return;
        }
        throw new IllegalArgumentException("Invalid gzip compression level: " + i3);
    }

    public void j(String str) {
        this.f160683c = str;
    }

    public void k(long j3) {
        this.f160682b = j3;
    }

    public void l(int i3) {
        this.f160685e = i3;
    }
}
