package org.maplibre.android.maps;

/* loaded from: classes9.dex */
public final class ImageContent {

    /* renamed from: a, reason: collision with root package name */
    public final float f164835a;

    /* renamed from: b, reason: collision with root package name */
    public final float f164836b;

    /* renamed from: c, reason: collision with root package name */
    public final float f164837c;

    /* renamed from: d, reason: collision with root package name */
    public final float f164838d;

    public float[] a() {
        return new float[]{this.f164835a, this.f164836b, this.f164837c, this.f164838d};
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ImageContent)) {
            return false;
        }
        ImageContent imageContent = (ImageContent) obj;
        return this.f164835a == imageContent.f164835a && this.f164836b == imageContent.f164836b && this.f164837c == imageContent.f164837c && this.f164838d == imageContent.f164838d;
    }

    public int hashCode() {
        float f3 = this.f164835a;
        int iFloatToIntBits = (f3 != 0.0f ? Float.floatToIntBits(f3) : 0) * 31;
        float f4 = this.f164836b;
        int iFloatToIntBits2 = (iFloatToIntBits + (f4 != 0.0f ? Float.floatToIntBits(f4) : 0)) * 31;
        float f5 = this.f164837c;
        int iFloatToIntBits3 = (iFloatToIntBits2 + (f5 != 0.0f ? Float.floatToIntBits(f5) : 0)) * 31;
        float f6 = this.f164838d;
        return iFloatToIntBits3 + (f6 != 0.0f ? Float.floatToIntBits(f6) : 0);
    }

    public String toString() {
        return "[ left: " + this.f164835a + ", top: " + this.f164836b + ", right: " + this.f164837c + ", bottom: " + this.f164838d + " ]";
    }
}
