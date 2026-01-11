package com.google.android.recaptcha.internal;

/* loaded from: classes4.dex */
final class zznx {
    private final Object zza;
    private final int zzb;

    public zznx(Object obj, int i3) {
        this.zza = obj;
        this.zzb = i3;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zznx)) {
            return false;
        }
        zznx zznxVar = (zznx) obj;
        return this.zza == zznxVar.zza && this.zzb == zznxVar.zzb;
    }

    public final int hashCode() {
        return (System.identityHashCode(this.zza) * 65535) + this.zzb;
    }
}
