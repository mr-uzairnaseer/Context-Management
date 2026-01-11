package com.airbnb.lottie.utils;

/* loaded from: classes4.dex */
public class MeanCalculator {

    /* renamed from: a, reason: collision with root package name */
    public float f51349a;

    /* renamed from: b, reason: collision with root package name */
    public int f51350b;

    public void a(float f3) {
        float f4 = this.f51349a + f3;
        this.f51349a = f4;
        int i3 = this.f51350b + 1;
        this.f51350b = i3;
        if (i3 == Integer.MAX_VALUE) {
            this.f51349a = f4 / 2.0f;
            this.f51350b = i3 / 2;
        }
    }
}
