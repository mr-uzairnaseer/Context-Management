package com.google.android.gms.internal.play_billing;

/* loaded from: classes4.dex */
final class zzcp {

    /* renamed from: a, reason: collision with root package name */
    public final Object f62550a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f62551b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f62552c;

    public zzcp(Object obj, Object obj2, Object obj3) {
        this.f62550a = obj;
        this.f62551b = obj2;
        this.f62552c = obj3;
    }

    public final IllegalArgumentException a() {
        Object obj = this.f62552c;
        Object obj2 = this.f62551b;
        Object obj3 = this.f62550a;
        return new IllegalArgumentException("Multiple entries with same key: " + String.valueOf(obj3) + "=" + String.valueOf(obj2) + " and " + String.valueOf(obj3) + "=" + String.valueOf(obj));
    }
}
