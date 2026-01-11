package com.airbnb.lottie.value;

/* loaded from: classes4.dex */
public class ScaleXY {

    /* renamed from: a, reason: collision with root package name */
    public float f51420a;

    /* renamed from: b, reason: collision with root package name */
    public float f51421b;

    public ScaleXY(float f3, float f4) {
        this.f51420a = f3;
        this.f51421b = f4;
    }

    public boolean a(float f3, float f4) {
        return this.f51420a == f3 && this.f51421b == f4;
    }

    public float b() {
        return this.f51420a;
    }

    public float c() {
        return this.f51421b;
    }

    public void d(float f3, float f4) {
        this.f51420a = f3;
        this.f51421b = f4;
    }

    public String toString() {
        return b() + "x" + c();
    }

    public ScaleXY() {
        this(1.0f, 1.0f);
    }
}
