package androidx.core.graphics;

import android.graphics.PointF;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes3.dex */
public final class PathSegment {

    /* renamed from: a, reason: collision with root package name */
    public final PointF f33260a;

    /* renamed from: b, reason: collision with root package name */
    public final float f33261b;

    /* renamed from: c, reason: collision with root package name */
    public final PointF f33262c;

    /* renamed from: d, reason: collision with root package name */
    public final float f33263d;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PathSegment)) {
            return false;
        }
        PathSegment pathSegment = (PathSegment) obj;
        return Float.compare(this.f33261b, pathSegment.f33261b) == 0 && Float.compare(this.f33263d, pathSegment.f33263d) == 0 && this.f33260a.equals(pathSegment.f33260a) && this.f33262c.equals(pathSegment.f33262c);
    }

    public int hashCode() {
        int iHashCode = this.f33260a.hashCode() * 31;
        float f3 = this.f33261b;
        int iFloatToIntBits = (((iHashCode + (f3 != 0.0f ? Float.floatToIntBits(f3) : 0)) * 31) + this.f33262c.hashCode()) * 31;
        float f4 = this.f33263d;
        return iFloatToIntBits + (f4 != 0.0f ? Float.floatToIntBits(f4) : 0);
    }

    public String toString() {
        return "PathSegment{start=" + this.f33260a + ", startFraction=" + this.f33261b + ", end=" + this.f33262c + ", endFraction=" + this.f33263d + AbstractJsonLexerKt.END_OBJ;
    }
}
