package androidx.transition;

import android.graphics.Matrix;
import android.graphics.RectF;

/* loaded from: classes4.dex */
class MatrixUtils {

    /* renamed from: a, reason: collision with root package name */
    public static final Matrix f48750a = new Matrix() { // from class: androidx.transition.MatrixUtils.1
        public void a() {
            throw new IllegalStateException("Matrix can not be modified");
        }

        @Override // android.graphics.Matrix
        public boolean postConcat(Matrix matrix) {
            a();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean postRotate(float f3, float f4, float f5) {
            a();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean postScale(float f3, float f4, float f5, float f6) {
            a();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean postSkew(float f3, float f4, float f5, float f6) {
            a();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean postTranslate(float f3, float f4) {
            a();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preConcat(Matrix matrix) {
            a();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preRotate(float f3, float f4, float f5) {
            a();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preScale(float f3, float f4, float f5, float f6) {
            a();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preSkew(float f3, float f4, float f5, float f6) {
            a();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preTranslate(float f3, float f4) {
            a();
            return false;
        }

        @Override // android.graphics.Matrix
        public void reset() {
            a();
        }

        @Override // android.graphics.Matrix
        public void set(Matrix matrix) {
            a();
        }

        @Override // android.graphics.Matrix
        public boolean setConcat(Matrix matrix, Matrix matrix2) {
            a();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean setPolyToPoly(float[] fArr, int i3, float[] fArr2, int i4, int i5) {
            a();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean setRectToRect(RectF rectF, RectF rectF2, Matrix.ScaleToFit scaleToFit) {
            a();
            return false;
        }

        @Override // android.graphics.Matrix
        public void setRotate(float f3, float f4, float f5) {
            a();
        }

        @Override // android.graphics.Matrix
        public void setScale(float f3, float f4, float f5, float f6) {
            a();
        }

        @Override // android.graphics.Matrix
        public void setSinCos(float f3, float f4, float f5, float f6) {
            a();
        }

        @Override // android.graphics.Matrix
        public void setSkew(float f3, float f4, float f5, float f6) {
            a();
        }

        @Override // android.graphics.Matrix
        public void setTranslate(float f3, float f4) {
            a();
        }

        @Override // android.graphics.Matrix
        public void setValues(float[] fArr) {
            a();
        }

        @Override // android.graphics.Matrix
        public boolean postRotate(float f3) {
            a();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean postScale(float f3, float f4) {
            a();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean postSkew(float f3, float f4) {
            a();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preRotate(float f3) {
            a();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preScale(float f3, float f4) {
            a();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preSkew(float f3, float f4) {
            a();
            return false;
        }

        @Override // android.graphics.Matrix
        public void setRotate(float f3) {
            a();
        }

        @Override // android.graphics.Matrix
        public void setScale(float f3, float f4) {
            a();
        }

        @Override // android.graphics.Matrix
        public void setSinCos(float f3, float f4) {
            a();
        }

        @Override // android.graphics.Matrix
        public void setSkew(float f3, float f4) {
            a();
        }
    };

    private MatrixUtils() {
    }
}
