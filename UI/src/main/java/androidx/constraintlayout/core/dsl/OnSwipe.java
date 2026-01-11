package androidx.constraintlayout.core.dsl;

/* loaded from: classes3.dex */
public class OnSwipe {
    public static final int FLAG_DISABLE_POST_SCROLL = 1;
    public static final int FLAG_DISABLE_SCROLL = 2;

    /* renamed from: a, reason: collision with root package name */
    public Drag f31114a = null;

    /* renamed from: b, reason: collision with root package name */
    public Side f31115b = null;

    /* renamed from: c, reason: collision with root package name */
    public String f31116c = null;

    /* renamed from: d, reason: collision with root package name */
    public String f31117d = null;

    /* renamed from: e, reason: collision with root package name */
    public TouchUp f31118e = null;

    /* renamed from: f, reason: collision with root package name */
    public String f31119f = null;

    /* renamed from: g, reason: collision with root package name */
    public float f31120g = Float.NaN;

    /* renamed from: h, reason: collision with root package name */
    public float f31121h = Float.NaN;

    /* renamed from: i, reason: collision with root package name */
    public float f31122i = Float.NaN;

    /* renamed from: j, reason: collision with root package name */
    public float f31123j = Float.NaN;

    /* renamed from: k, reason: collision with root package name */
    public float f31124k = Float.NaN;

    /* renamed from: l, reason: collision with root package name */
    public float f31125l = Float.NaN;

    /* renamed from: m, reason: collision with root package name */
    public float f31126m = Float.NaN;

    /* renamed from: n, reason: collision with root package name */
    public float f31127n = Float.NaN;

    /* renamed from: o, reason: collision with root package name */
    public Boundary f31128o = null;

    /* renamed from: p, reason: collision with root package name */
    public Mode f31129p = null;

    public enum Boundary {
        OVERSHOOT,
        BOUNCE_START,
        BOUNCE_END,
        BOUNCE_BOTH
    }

    public enum Drag {
        UP,
        DOWN,
        LEFT,
        RIGHT,
        START,
        END,
        CLOCKWISE,
        ANTICLOCKWISE
    }

    public enum Mode {
        VELOCITY,
        SPRING
    }

    public enum Side {
        TOP,
        LEFT,
        RIGHT,
        BOTTOM,
        MIDDLE,
        START,
        END
    }

    public enum TouchUp {
        AUTOCOMPLETE,
        TO_START,
        NEVER_COMPLETE_END,
        TO_END,
        STOP,
        DECELERATE,
        DECELERATE_COMPLETE,
        NEVER_COMPLETE_START
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("OnSwipe:{\n");
        if (this.f31116c != null) {
            sb.append("anchor:'");
            sb.append(this.f31116c);
            sb.append("',\n");
        }
        if (this.f31114a != null) {
            sb.append("direction:'");
            sb.append(this.f31114a.toString().toLowerCase());
            sb.append("',\n");
        }
        if (this.f31115b != null) {
            sb.append("side:'");
            sb.append(this.f31115b.toString().toLowerCase());
            sb.append("',\n");
        }
        if (!Float.isNaN(this.f31122i)) {
            sb.append("scale:'");
            sb.append(this.f31122i);
            sb.append("',\n");
        }
        if (!Float.isNaN(this.f31123j)) {
            sb.append("threshold:'");
            sb.append(this.f31123j);
            sb.append("',\n");
        }
        if (!Float.isNaN(this.f31120g)) {
            sb.append("maxVelocity:'");
            sb.append(this.f31120g);
            sb.append("',\n");
        }
        if (!Float.isNaN(this.f31121h)) {
            sb.append("maxAccel:'");
            sb.append(this.f31121h);
            sb.append("',\n");
        }
        if (this.f31117d != null) {
            sb.append("limitBounds:'");
            sb.append(this.f31117d);
            sb.append("',\n");
        }
        if (this.f31129p != null) {
            sb.append("mode:'");
            sb.append(this.f31129p.toString().toLowerCase());
            sb.append("',\n");
        }
        if (this.f31118e != null) {
            sb.append("touchUp:'");
            sb.append(this.f31118e.toString().toLowerCase());
            sb.append("',\n");
        }
        if (!Float.isNaN(this.f31125l)) {
            sb.append("springMass:'");
            sb.append(this.f31125l);
            sb.append("',\n");
        }
        if (!Float.isNaN(this.f31126m)) {
            sb.append("springStiffness:'");
            sb.append(this.f31126m);
            sb.append("',\n");
        }
        if (!Float.isNaN(this.f31124k)) {
            sb.append("springDamping:'");
            sb.append(this.f31124k);
            sb.append("',\n");
        }
        if (!Float.isNaN(this.f31127n)) {
            sb.append("stopThreshold:'");
            sb.append(this.f31127n);
            sb.append("',\n");
        }
        if (this.f31128o != null) {
            sb.append("springBoundary:'");
            sb.append(this.f31128o);
            sb.append("',\n");
        }
        if (this.f31119f != null) {
            sb.append("around:'");
            sb.append(this.f31119f);
            sb.append("',\n");
        }
        sb.append("},\n");
        return sb.toString();
    }
}
