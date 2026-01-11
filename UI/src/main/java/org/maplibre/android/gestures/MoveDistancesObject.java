package org.maplibre.android.gestures;

/* loaded from: classes8.dex */
public final class MoveDistancesObject {

    /* renamed from: a, reason: collision with root package name */
    public final float f164478a;

    /* renamed from: b, reason: collision with root package name */
    public final float f164479b;

    /* renamed from: c, reason: collision with root package name */
    public float f164480c;

    /* renamed from: d, reason: collision with root package name */
    public float f164481d;

    /* renamed from: e, reason: collision with root package name */
    public float f164482e;

    /* renamed from: f, reason: collision with root package name */
    public float f164483f;

    /* renamed from: g, reason: collision with root package name */
    public float f164484g;

    /* renamed from: h, reason: collision with root package name */
    public float f164485h;

    /* renamed from: i, reason: collision with root package name */
    public float f164486i;

    /* renamed from: j, reason: collision with root package name */
    public float f164487j;

    public MoveDistancesObject(float f3, float f4) {
        this.f164478a = f3;
        this.f164479b = f4;
    }

    public void a(float f3, float f4) {
        float f5 = this.f164482e;
        this.f164480c = f5;
        float f6 = this.f164483f;
        this.f164481d = f6;
        this.f164482e = f3;
        this.f164483f = f4;
        this.f164484g = f5 - f3;
        this.f164485h = f6 - f4;
        this.f164486i = this.f164478a - f3;
        this.f164487j = this.f164479b - f4;
    }

    public float b() {
        return this.f164482e;
    }

    public float c() {
        return this.f164483f;
    }

    public float d() {
        return this.f164484g;
    }

    public float e() {
        return this.f164486i;
    }

    public float f() {
        return this.f164485h;
    }

    public float g() {
        return this.f164487j;
    }
}
