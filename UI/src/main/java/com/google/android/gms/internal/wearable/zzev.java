package com.google.android.gms.internal.wearable;

import sun.misc.Unsafe;

/* loaded from: classes4.dex */
abstract class zzev {

    /* renamed from: a, reason: collision with root package name */
    public final Unsafe f62960a;

    public zzev(Unsafe unsafe) {
        this.f62960a = unsafe;
    }

    public abstract double a(Object obj, long j3);

    public abstract float b(Object obj, long j3);

    public abstract void c(Object obj, long j3, boolean z2);

    public abstract void d(Object obj, long j3, byte b3);

    public abstract void e(Object obj, long j3, double d3);

    public abstract void f(Object obj, long j3, float f3);

    public abstract boolean g(Object obj, long j3);
}
