package com.google.android.gms.internal.auth;

import sun.misc.Unsafe;

/* loaded from: classes4.dex */
abstract class zzhi {

    /* renamed from: a, reason: collision with root package name */
    public final Unsafe f61396a;

    public zzhi(Unsafe unsafe) {
        this.f61396a = unsafe;
    }

    public abstract double a(Object obj, long j3);

    public abstract float b(Object obj, long j3);

    public abstract void c(Object obj, long j3, boolean z2);

    public abstract void d(Object obj, long j3, double d3);

    public abstract void e(Object obj, long j3, float f3);

    public abstract boolean f(Object obj, long j3);
}
