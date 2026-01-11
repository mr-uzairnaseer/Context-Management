package com.google.firebase.crashlytics.internal.common;

import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public final class OnDemandCounter {

    /* renamed from: a, reason: collision with root package name */
    public final AtomicInteger f72261a = new AtomicInteger();

    /* renamed from: b, reason: collision with root package name */
    public final AtomicInteger f72262b = new AtomicInteger();

    public void a() {
        this.f72262b.getAndIncrement();
    }

    public void b() {
        this.f72261a.getAndIncrement();
    }

    public void c() {
        this.f72262b.set(0);
    }
}
