package com.google.android.gms.internal.play_billing;

/* loaded from: classes.dex */
final class zzcb extends zzce {

    /* renamed from: b, reason: collision with root package name */
    public static final zzcb f62537b = new zzcb();

    private zzcb() {
        super("");
    }

    @Override // com.google.android.gms.internal.play_billing.zzce
    public final int a(zzce zzceVar) {
        return zzceVar == this ? 0 : 1;
    }

    @Override // com.google.android.gms.internal.play_billing.zzce
    public final void c(StringBuilder sb) {
        throw new AssertionError();
    }

    @Override // com.google.android.gms.internal.play_billing.zzce, java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return a((zzce) obj);
    }

    @Override // com.google.android.gms.internal.play_billing.zzce
    public final void d(StringBuilder sb) {
        sb.append("+∞)");
    }

    @Override // com.google.android.gms.internal.play_billing.zzce
    public final int hashCode() {
        return System.identityHashCode(this);
    }

    public final String toString() {
        return "+∞";
    }
}
