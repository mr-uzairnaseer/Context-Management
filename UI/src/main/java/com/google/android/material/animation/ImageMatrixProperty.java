package com.google.android.material.animation;

import android.graphics.Matrix;
import android.util.Property;
import android.widget.ImageView;

/* loaded from: classes4.dex */
public class ImageMatrixProperty extends Property<ImageView, Matrix> {

    /* renamed from: a, reason: collision with root package name */
    public final Matrix f64641a;

    public ImageMatrixProperty() {
        super(Matrix.class, "imageMatrixProperty");
        this.f64641a = new Matrix();
    }

    @Override // android.util.Property
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Matrix get(ImageView imageView) {
        this.f64641a.set(imageView.getImageMatrix());
        return this.f64641a;
    }

    @Override // android.util.Property
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void set(ImageView imageView, Matrix matrix) {
        imageView.setImageMatrix(matrix);
    }
}
