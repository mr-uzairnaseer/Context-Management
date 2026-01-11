package androidx.interpolator.view.animation;

import android.view.animation.Interpolator;

/* loaded from: classes.dex */
abstract class LookupTableInterpolator implements Interpolator {

    /* renamed from: a, reason: collision with root package name */
    public final float[] f36242a;

    /* renamed from: b, reason: collision with root package name */
    public final float f36243b;

    public LookupTableInterpolator(float[] fArr) {
        this.f36242a = fArr;
        this.f36243b = 1.0f / (fArr.length - 1);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f3) {
        if (f3 >= 1.0f) {
            return 1.0f;
        }
        if (f3 <= 0.0f) {
            return 0.0f;
        }
        float[] fArr = this.f36242a;
        int iMin = Math.min((int) ((fArr.length - 1) * f3), fArr.length - 2);
        float f4 = this.f36243b;
        float f5 = (f3 - (iMin * f4)) / f4;
        float[] fArr2 = this.f36242a;
        float f6 = fArr2[iMin];
        return f6 + (f5 * (fArr2[iMin + 1] - f6));
    }
}
