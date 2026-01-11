package com.google.android.gms.internal.play_billing;

/* loaded from: classes4.dex */
final class zzcd extends zzce {

    /* renamed from: b, reason: collision with root package name */
    public static final zzcd f62538b = new zzcd();

    private zzcd() {
        super("");
    }

    @Override // com.google.android.gms.internal.play_billing.zzce
    public final int a(zzce zzceVar) {
        return zzceVar == this ? 0 : -1;
    }

    @Override // com.google.android.gms.internal.play_billing.zzce
    public final void c(StringBuilder sb) {
        sb.append("(-∞");
    }

    @Override // com.google.android.gms.internal.play_billing.zzce, java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return a((zzce) obj);
    }

    @Override // com.google.android.gms.internal.play_billing.zzce
    public final void d(StringBuilder sb) {
        throw new AssertionError();
    }

    @Override // com.google.android.gms.internal.play_billing.zzce
    public final int hashCode() {
        return System.identityHashCode(this);
    }

    public final String toString() {
        return "-∞";
    }
}
