package org.apache.commons.math3.analysis.polynomials;

/* loaded from: classes7.dex */
public class PolynomialFunction {

    /* renamed from: a, reason: collision with root package name */
    public final double[] f162362a;

    public PolynomialFunction(double[] dArr) {
        if (dArr == null) {
            throw new IllegalArgumentException();
        }
        int length = dArr.length;
        if (length == 0) {
            throw new IllegalArgumentException();
        }
        while (length > 1 && dArr[length - 1] == 0.0d) {
            length--;
        }
        double[] dArr2 = new double[length];
        this.f162362a = dArr2;
        System.arraycopy(dArr, 0, dArr2, 0, length);
    }

    public double a(double d3) {
        double[] dArr = this.f162362a;
        if (dArr == null) {
            throw new IllegalArgumentException();
        }
        int length = dArr.length;
        if (length == 0) {
            throw new IllegalArgumentException();
        }
        double d4 = dArr[length - 1];
        for (int i3 = length - 2; i3 >= 0; i3--) {
            d4 = (d4 * d3) + this.f162362a[i3];
        }
        return d4;
    }
}
