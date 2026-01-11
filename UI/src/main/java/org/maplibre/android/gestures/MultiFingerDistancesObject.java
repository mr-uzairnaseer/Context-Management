package org.maplibre.android.gestures;

/* loaded from: classes8.dex */
public class MultiFingerDistancesObject {

    /* renamed from: a, reason: collision with root package name */
    public final float f164493a;

    /* renamed from: b, reason: collision with root package name */
    public final float f164494b;

    /* renamed from: c, reason: collision with root package name */
    public final float f164495c;

    /* renamed from: d, reason: collision with root package name */
    public final float f164496d;

    /* renamed from: e, reason: collision with root package name */
    public final float f164497e;

    /* renamed from: f, reason: collision with root package name */
    public final float f164498f;

    public MultiFingerDistancesObject(float f3, float f4, float f5, float f6) {
        this.f164493a = f3;
        this.f164494b = f4;
        this.f164495c = f5;
        this.f164496d = f6;
        this.f164497e = (float) Math.sqrt((f3 * f3) + (f4 * f4));
        this.f164498f = (float) Math.sqrt((f5 * f5) + (f6 * f6));
    }

    public float a() {
        return this.f164495c;
    }

    public float b() {
        return this.f164498f;
    }

    public float c() {
        return this.f164496d;
    }

    public float d() {
        return this.f164493a;
    }

    public float e() {
        return this.f164494b;
    }
}
