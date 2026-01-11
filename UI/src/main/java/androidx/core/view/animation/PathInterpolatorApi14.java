package androidx.core.view.animation;

import android.view.animation.Interpolator;

/* loaded from: classes3.dex */
class PathInterpolatorApi14 implements Interpolator {

    /* renamed from: a, reason: collision with root package name */
    public final float[] f33887a;

    /* renamed from: b, reason: collision with root package name */
    public final float[] f33888b;

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f3) {
        if (f3 <= 0.0f) {
            return 0.0f;
        }
        if (f3 >= 1.0f) {
            return 1.0f;
        }
        int length = this.f33887a.length - 1;
        int i3 = 0;
        while (length - i3 > 1) {
            int i4 = (i3 + length) / 2;
            if (f3 < this.f33887a[i4]) {
                length = i4;
            } else {
                i3 = i4;
            }
        }
        float[] fArr = this.f33887a;
        float f4 = fArr[length];
        float f5 = fArr[i3];
        float f6 = f4 - f5;
        if (f6 == 0.0f) {
            return this.f33888b[i3];
        }
        float f7 = (f3 - f5) / f6;
        float[] fArr2 = this.f33888b;
        float f8 = fArr2[i3];
        return f8 + (f7 * (fArr2[length] - f8));
    }
}
