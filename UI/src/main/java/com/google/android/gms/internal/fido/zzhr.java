package com.google.android.gms.internal.fido;

/* loaded from: classes4.dex */
public final class zzhr {

    /* renamed from: a, reason: collision with root package name */
    public final byte f61688a;

    /* renamed from: b, reason: collision with root package name */
    public final byte f61689b;

    public zzhr(int i3) {
        this.f61688a = (byte) (i3 & 224);
        this.f61689b = (byte) (i3 & 31);
    }

    public final byte a() {
        return this.f61689b;
    }

    public final byte b() {
        return this.f61688a;
    }

    public final int c() {
        return (this.f61688a >> 5) & 7;
    }
}
