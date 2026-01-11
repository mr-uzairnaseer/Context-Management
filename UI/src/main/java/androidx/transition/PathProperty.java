package androidx.transition;

import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.util.Property;

/* loaded from: classes4.dex */
class PathProperty<T> extends Property<T, Float> {

    /* renamed from: a, reason: collision with root package name */
    public final Property f48751a;

    /* renamed from: b, reason: collision with root package name */
    public final PathMeasure f48752b;

    /* renamed from: c, reason: collision with root package name */
    public final float f48753c;

    /* renamed from: d, reason: collision with root package name */
    public final float[] f48754d;

    /* renamed from: e, reason: collision with root package name */
    public final PointF f48755e;

    /* renamed from: f, reason: collision with root package name */
    public float f48756f;

    @Override // android.util.Property
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Float get(Object obj) {
        return Float.valueOf(this.f48756f);
    }

    @Override // android.util.Property
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void set(Object obj, Float f3) {
        this.f48756f = f3.floatValue();
        this.f48752b.getPosTan(this.f48753c * f3.floatValue(), this.f48754d, null);
        PointF pointF = this.f48755e;
        float[] fArr = this.f48754d;
        pointF.x = fArr[0];
        pointF.y = fArr[1];
        this.f48751a.set(obj, pointF);
    }
}
