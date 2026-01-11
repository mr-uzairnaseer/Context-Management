package com.airbnb.lottie;

import android.graphics.Bitmap;

/* loaded from: classes4.dex */
public class LottieImageAsset {

    /* renamed from: a, reason: collision with root package name */
    public final int f50399a;

    /* renamed from: b, reason: collision with root package name */
    public final int f50400b;

    /* renamed from: c, reason: collision with root package name */
    public final String f50401c;

    /* renamed from: d, reason: collision with root package name */
    public final String f50402d;

    /* renamed from: e, reason: collision with root package name */
    public final String f50403e;

    /* renamed from: f, reason: collision with root package name */
    public Bitmap f50404f;

    public LottieImageAsset(int i3, int i4, String str, String str2, String str3) {
        this.f50399a = i3;
        this.f50400b = i4;
        this.f50401c = str;
        this.f50402d = str2;
        this.f50403e = str3;
    }

    public LottieImageAsset a(float f3) {
        LottieImageAsset lottieImageAsset = new LottieImageAsset((int) (this.f50399a * f3), (int) (this.f50400b * f3), this.f50401c, this.f50402d, this.f50403e);
        Bitmap bitmap = this.f50404f;
        if (bitmap != null) {
            lottieImageAsset.g(Bitmap.createScaledBitmap(bitmap, lottieImageAsset.f50399a, lottieImageAsset.f50400b, true));
        }
        return lottieImageAsset;
    }

    public Bitmap b() {
        return this.f50404f;
    }

    public String c() {
        return this.f50402d;
    }

    public int d() {
        return this.f50400b;
    }

    public String e() {
        return this.f50401c;
    }

    public int f() {
        return this.f50399a;
    }

    public void g(Bitmap bitmap) {
        this.f50404f = bitmap;
    }
}
