package androidx.transition;

import android.animation.TypeEvaluator;

/* loaded from: classes4.dex */
class FloatArrayEvaluator implements TypeEvaluator<float[]> {

    /* renamed from: a, reason: collision with root package name */
    public float[] f48716a;

    public FloatArrayEvaluator(float[] fArr) {
        this.f48716a = fArr;
    }

    @Override // android.animation.TypeEvaluator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public float[] evaluate(float f3, float[] fArr, float[] fArr2) {
        float[] fArr3 = this.f48716a;
        if (fArr3 == null) {
            fArr3 = new float[fArr.length];
        }
        for (int i3 = 0; i3 < fArr3.length; i3++) {
            float f4 = fArr[i3];
            fArr3[i3] = f4 + ((fArr2[i3] - f4) * f3);
        }
        return fArr3;
    }
}
