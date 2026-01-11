package com.google.android.gms.internal.wearable;

/* loaded from: classes4.dex */
final class zzca {

    /* renamed from: a, reason: collision with root package name */
    public final Object f62874a;

    /* renamed from: b, reason: collision with root package name */
    public final int f62875b;

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzca)) {
            return false;
        }
        zzca zzcaVar = (zzca) obj;
        return this.f62874a == zzcaVar.f62874a && this.f62875b == zzcaVar.f62875b;
    }

    public final int hashCode() {
        return (System.identityHashCode(this.f62874a) * 65535) + this.f62875b;
    }
}
