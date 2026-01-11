package com.google.android.material.animation;

import android.animation.TypeEvaluator;
import android.graphics.Matrix;

/* loaded from: classes4.dex */
public class MatrixEvaluator implements TypeEvaluator<Matrix> {

    /* renamed from: a, reason: collision with root package name */
    public final float[] f64642a = new float[9];

    /* renamed from: b, reason: collision with root package name */
    public final float[] f64643b = new float[9];

    /* renamed from: c, reason: collision with root package name */
    public final Matrix f64644c = new Matrix();

    @Override // android.animation.TypeEvaluator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Matrix evaluate(float f3, Matrix matrix, Matrix matrix2) {
        matrix.getValues(this.f64642a);
        matrix2.getValues(this.f64643b);
        for (int i3 = 0; i3 < 9; i3++) {
            float[] fArr = this.f64643b;
            float f4 = fArr[i3];
            float f5 = this.f64642a[i3];
            fArr[i3] = f5 + ((f4 - f5) * f3);
        }
        this.f64644c.setValues(this.f64643b);
        return this.f64644c;
    }
}
