package org.maplibre.android.attribution;

import android.graphics.Bitmap;
import android.graphics.PointF;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes8.dex */
public class AttributionLayout {

    /* renamed from: a, reason: collision with root package name */
    public Bitmap f164403a;

    /* renamed from: b, reason: collision with root package name */
    public PointF f164404b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f164405c;

    public AttributionLayout(Bitmap bitmap, PointF pointF, boolean z2) {
        this.f164403a = bitmap;
        this.f164404b = pointF;
        this.f164405c = z2;
    }

    public PointF a() {
        return this.f164404b;
    }

    public Bitmap b() {
        return this.f164403a;
    }

    public boolean c() {
        return this.f164405c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            AttributionLayout attributionLayout = (AttributionLayout) obj;
            Bitmap bitmap = this.f164403a;
            if (bitmap == null ? attributionLayout.f164403a != null : !bitmap.equals(attributionLayout.f164403a)) {
                return false;
            }
            PointF pointF = this.f164404b;
            PointF pointF2 = attributionLayout.f164404b;
            if (pointF != null) {
                return pointF.equals(pointF2);
            }
            if (pointF2 == null) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        Bitmap bitmap = this.f164403a;
        int iHashCode = (bitmap != null ? bitmap.hashCode() : 0) * 31;
        PointF pointF = this.f164404b;
        return iHashCode + (pointF != null ? pointF.hashCode() : 0);
    }

    public String toString() {
        return "AttributionLayout{logo=" + this.f164403a + ", anchorPoint=" + this.f164404b + AbstractJsonLexerKt.END_OBJ;
    }
}
