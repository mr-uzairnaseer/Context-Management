package androidx.transition;

import android.animation.TypeEvaluator;
import android.graphics.Rect;

/* loaded from: classes4.dex */
class RectEvaluator implements TypeEvaluator<Rect> {

    /* renamed from: a, reason: collision with root package name */
    public Rect f48760a;

    public RectEvaluator() {
    }

    @Override // android.animation.TypeEvaluator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Rect evaluate(float f3, Rect rect, Rect rect2) {
        int i3 = rect.left + ((int) ((rect2.left - r0) * f3));
        int i4 = rect.top + ((int) ((rect2.top - r1) * f3));
        int i5 = rect.right + ((int) ((rect2.right - r2) * f3));
        int i6 = rect.bottom + ((int) ((rect2.bottom - r6) * f3));
        Rect rect3 = this.f48760a;
        if (rect3 == null) {
            return new Rect(i3, i4, i5, i6);
        }
        rect3.set(i3, i4, i5, i6);
        return this.f48760a;
    }

    public RectEvaluator(Rect rect) {
        this.f48760a = rect;
    }
}
