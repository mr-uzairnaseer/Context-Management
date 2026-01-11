package org.maplibre.android.maps;

/* loaded from: classes9.dex */
public final class ImageStretches {

    /* renamed from: a, reason: collision with root package name */
    public final float f164839a;

    /* renamed from: b, reason: collision with root package name */
    public final float f164840b;

    public float a() {
        return this.f164839a;
    }

    public float b() {
        return this.f164840b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ImageStretches)) {
            return false;
        }
        ImageStretches imageStretches = (ImageStretches) obj;
        return this.f164839a == imageStretches.f164839a && this.f164840b == imageStretches.f164840b;
    }

    public int hashCode() {
        float f3 = this.f164839a;
        int iFloatToIntBits = (f3 != 0.0f ? Float.floatToIntBits(f3) : 0) * 31;
        float f4 = this.f164840b;
        return iFloatToIntBits + (f4 != 0.0f ? Float.floatToIntBits(f4) : 0);
    }

    public String toString() {
        return "[ first: " + this.f164839a + ", second: " + this.f164840b + " ]";
    }
}
