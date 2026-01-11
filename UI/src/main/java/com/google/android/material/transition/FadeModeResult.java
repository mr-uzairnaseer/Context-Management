package com.google.android.material.transition;

/* loaded from: classes4.dex */
class FadeModeResult {

    /* renamed from: a, reason: collision with root package name */
    public final int f67311a;

    /* renamed from: b, reason: collision with root package name */
    public final int f67312b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f67313c;

    public FadeModeResult(int i3, int i4, boolean z2) {
        this.f67311a = i3;
        this.f67312b = i4;
        this.f67313c = z2;
    }

    public static FadeModeResult a(int i3, int i4) {
        return new FadeModeResult(i3, i4, true);
    }

    public static FadeModeResult b(int i3, int i4) {
        return new FadeModeResult(i3, i4, false);
    }
}
