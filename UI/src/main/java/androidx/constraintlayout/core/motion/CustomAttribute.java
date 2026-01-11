package androidx.constraintlayout.core.motion;

/* loaded from: classes3.dex */
public class CustomAttribute {

    /* renamed from: a, reason: collision with root package name */
    public AttributeType f31141a;

    /* renamed from: b, reason: collision with root package name */
    public int f31142b;

    /* renamed from: c, reason: collision with root package name */
    public float f31143c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f31144d;

    /* renamed from: e, reason: collision with root package name */
    public int f31145e;

    public enum AttributeType {
        INT_TYPE,
        FLOAT_TYPE,
        COLOR_TYPE,
        COLOR_DRAWABLE_TYPE,
        STRING_TYPE,
        BOOLEAN_TYPE,
        DIMENSION_TYPE,
        REFERENCE_TYPE
    }

    public void a(float[] fArr) {
        switch (this.f31141a) {
            case INT_TYPE:
                fArr[0] = this.f31142b;
                return;
            case FLOAT_TYPE:
                fArr[0] = this.f31143c;
                return;
            case COLOR_TYPE:
            case COLOR_DRAWABLE_TYPE:
                int i3 = (this.f31145e >> 24) & 255;
                float fPow = (float) Math.pow(((r0 >> 16) & 255) / 255.0f, 2.2d);
                float fPow2 = (float) Math.pow(((r0 >> 8) & 255) / 255.0f, 2.2d);
                float fPow3 = (float) Math.pow((r0 & 255) / 255.0f, 2.2d);
                fArr[0] = fPow;
                fArr[1] = fPow2;
                fArr[2] = fPow3;
                fArr[3] = i3 / 255.0f;
                return;
            case STRING_TYPE:
                throw new RuntimeException("Color does not have a single color to interpolate");
            case BOOLEAN_TYPE:
                fArr[0] = this.f31144d ? 1.0f : 0.0f;
                return;
            case DIMENSION_TYPE:
                fArr[0] = this.f31143c;
                return;
            default:
                return;
        }
    }

    public int b() {
        int iOrdinal = this.f31141a.ordinal();
        return (iOrdinal == 2 || iOrdinal == 3) ? 4 : 1;
    }
}
