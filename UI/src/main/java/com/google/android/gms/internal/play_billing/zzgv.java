package com.google.android.gms.internal.play_billing;

/* loaded from: classes.dex */
final class zzgv {

    /* renamed from: a, reason: collision with root package name */
    public final Object f62689a;

    /* renamed from: b, reason: collision with root package name */
    public final int f62690b;

    public zzgv(Object obj, int i3) {
        this.f62689a = obj;
        this.f62690b = i3;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzgv)) {
            return false;
        }
        zzgv zzgvVar = (zzgv) obj;
        return this.f62689a == zzgvVar.f62689a && this.f62690b == zzgvVar.f62690b;
    }

    public final int hashCode() {
        return (System.identityHashCode(this.f62689a) * 65535) + this.f62690b;
    }
}
