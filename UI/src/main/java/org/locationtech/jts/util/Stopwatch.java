package org.locationtech.jts.util;

/* loaded from: classes7.dex */
public class Stopwatch {

    /* renamed from: a, reason: collision with root package name */
    public long f164339a;

    /* renamed from: b, reason: collision with root package name */
    public long f164340b = 0;

    /* renamed from: c, reason: collision with root package name */
    public boolean f164341c = false;

    public Stopwatch() {
        a();
    }

    public void a() {
        if (this.f164341c) {
            return;
        }
        this.f164339a = System.currentTimeMillis();
        this.f164341c = true;
    }
}
