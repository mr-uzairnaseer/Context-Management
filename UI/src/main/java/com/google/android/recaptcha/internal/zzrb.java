package com.google.android.recaptcha.internal;

import sun.misc.Unsafe;

/* loaded from: classes4.dex */
abstract class zzrb {
    final Unsafe zza;

    public zzrb(Unsafe unsafe) {
        this.zza = unsafe;
    }

    public abstract double zza(Object obj, long j3);

    public abstract float zzb(Object obj, long j3);

    public abstract void zzc(Object obj, long j3, boolean z2);

    public abstract void zzd(Object obj, long j3, byte b3);

    public abstract void zze(Object obj, long j3, double d3);

    public abstract void zzf(Object obj, long j3, float f3);

    public abstract boolean zzg(Object obj, long j3);
}
