package androidx.constraintlayout.core.dsl;

import androidx.compose.compiler.plugins.types.analysis.StabilityExternalClassNameMatchingKt;
import com.facebook.internal.security.CertificateUtil;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class Constraint {
    public static Map K;
    public int A;
    public int B;
    public int C;
    public int D;
    public float E;
    public float F;
    public String[] G;
    public boolean H;
    public boolean I;

    /* renamed from: a, reason: collision with root package name */
    public final String f31009a;

    /* renamed from: b, reason: collision with root package name */
    public String f31010b = null;

    /* renamed from: c, reason: collision with root package name */
    public String f31011c = null;

    /* renamed from: d, reason: collision with root package name */
    public HAnchor f31012d = new HAnchor(HSide.LEFT);

    /* renamed from: e, reason: collision with root package name */
    public HAnchor f31013e = new HAnchor(HSide.RIGHT);

    /* renamed from: f, reason: collision with root package name */
    public VAnchor f31014f = new VAnchor(VSide.TOP);

    /* renamed from: g, reason: collision with root package name */
    public VAnchor f31015g = new VAnchor(VSide.BOTTOM);

    /* renamed from: h, reason: collision with root package name */
    public HAnchor f31016h = new HAnchor(HSide.START);

    /* renamed from: i, reason: collision with root package name */
    public HAnchor f31017i = new HAnchor(HSide.END);

    /* renamed from: j, reason: collision with root package name */
    public VAnchor f31018j = new VAnchor(VSide.BASELINE);

    /* renamed from: k, reason: collision with root package name */
    public int f31019k;

    /* renamed from: l, reason: collision with root package name */
    public int f31020l;

    /* renamed from: m, reason: collision with root package name */
    public float f31021m;

    /* renamed from: n, reason: collision with root package name */
    public float f31022n;

    /* renamed from: o, reason: collision with root package name */
    public String f31023o;

    /* renamed from: p, reason: collision with root package name */
    public String f31024p;

    /* renamed from: q, reason: collision with root package name */
    public int f31025q;

    /* renamed from: r, reason: collision with root package name */
    public float f31026r;

    /* renamed from: s, reason: collision with root package name */
    public int f31027s;

    /* renamed from: t, reason: collision with root package name */
    public int f31028t;

    /* renamed from: u, reason: collision with root package name */
    public float f31029u;

    /* renamed from: v, reason: collision with root package name */
    public float f31030v;

    /* renamed from: w, reason: collision with root package name */
    public ChainMode f31031w;

    /* renamed from: x, reason: collision with root package name */
    public ChainMode f31032x;

    /* renamed from: y, reason: collision with root package name */
    public Behaviour f31033y;

    /* renamed from: z, reason: collision with root package name */
    public Behaviour f31034z;
    public static final Constraint PARENT = new Constraint("parent");
    public static int J = Integer.MIN_VALUE;

    public class Anchor {

        /* renamed from: a, reason: collision with root package name */
        public final Side f31035a;

        /* renamed from: c, reason: collision with root package name */
        public int f31037c;

        /* renamed from: b, reason: collision with root package name */
        public Anchor f31036b = null;

        /* renamed from: d, reason: collision with root package name */
        public int f31038d = Integer.MIN_VALUE;

        public Anchor(Side side) {
            this.f31035a = side;
        }

        public void a(StringBuilder sb) {
            if (this.f31036b != null) {
                sb.append(this.f31035a.toString().toLowerCase());
                sb.append(CertificateUtil.DELIMITER);
                sb.append(this);
                sb.append(",\n");
            }
        }

        public String b() {
            return Constraint.this.f31009a;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("[");
            if (this.f31036b != null) {
                sb.append("'");
                sb.append(this.f31036b.b());
                sb.append("',");
                sb.append("'");
                sb.append(this.f31036b.f31035a.toString().toLowerCase());
                sb.append("'");
            }
            if (this.f31037c != 0) {
                sb.append(StabilityExternalClassNameMatchingKt.STABILITY_GENERIC_SEPARATOR);
                sb.append(this.f31037c);
            }
            if (this.f31038d != Integer.MIN_VALUE) {
                if (this.f31037c == 0) {
                    sb.append(",0,");
                    sb.append(this.f31038d);
                } else {
                    sb.append(StabilityExternalClassNameMatchingKt.STABILITY_GENERIC_SEPARATOR);
                    sb.append(this.f31038d);
                }
            }
            sb.append("]");
            return sb.toString();
        }
    }

    public enum Behaviour {
        SPREAD,
        WRAP,
        PERCENT,
        RATIO,
        RESOLVED
    }

    public enum ChainMode {
        SPREAD,
        SPREAD_INSIDE,
        PACKED
    }

    public class HAnchor extends Anchor {
        public HAnchor(HSide hSide) {
            super(Side.valueOf(hSide.name()));
        }
    }

    public enum HSide {
        LEFT,
        RIGHT,
        START,
        END
    }

    public enum Side {
        LEFT,
        RIGHT,
        TOP,
        BOTTOM,
        START,
        END,
        BASELINE
    }

    public class VAnchor extends Anchor {
        public VAnchor(VSide vSide) {
            super(Side.valueOf(vSide.name()));
        }
    }

    public enum VSide {
        TOP,
        BOTTOM,
        BASELINE
    }

    static {
        HashMap map = new HashMap();
        K = map;
        map.put(ChainMode.SPREAD, "spread");
        K.put(ChainMode.SPREAD_INSIDE, "spread_inside");
        K.put(ChainMode.PACKED, "packed");
    }

    public Constraint(String str) {
        int i3 = J;
        this.f31019k = i3;
        this.f31020l = i3;
        this.f31021m = Float.NaN;
        this.f31022n = Float.NaN;
        this.f31023o = null;
        this.f31024p = null;
        this.f31025q = Integer.MIN_VALUE;
        this.f31026r = Float.NaN;
        this.f31027s = Integer.MIN_VALUE;
        this.f31028t = Integer.MIN_VALUE;
        this.f31029u = Float.NaN;
        this.f31030v = Float.NaN;
        this.f31031w = null;
        this.f31032x = null;
        this.f31033y = null;
        this.f31034z = null;
        this.A = i3;
        this.B = i3;
        this.C = i3;
        this.D = i3;
        this.E = Float.NaN;
        this.F = Float.NaN;
        this.G = null;
        this.H = false;
        this.I = false;
        this.f31009a = str;
    }

    public void b(StringBuilder sb, String str, float f3) {
        if (Float.isNaN(f3)) {
            return;
        }
        sb.append(str);
        sb.append(CertificateUtil.DELIMITER);
        sb.append(f3);
        sb.append(",\n");
    }

    public String c(String[] strArr) {
        StringBuilder sb = new StringBuilder("[");
        int i3 = 0;
        while (i3 < strArr.length) {
            sb.append(i3 == 0 ? "'" : ",'");
            sb.append(strArr[i3]);
            sb.append("'");
            i3++;
        }
        sb.append("]");
        return sb.toString();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(this.f31009a + ":{\n");
        this.f31012d.a(sb);
        this.f31013e.a(sb);
        this.f31014f.a(sb);
        this.f31015g.a(sb);
        this.f31016h.a(sb);
        this.f31017i.a(sb);
        this.f31018j.a(sb);
        if (this.f31019k != J) {
            sb.append("width:");
            sb.append(this.f31019k);
            sb.append(",\n");
        }
        if (this.f31020l != J) {
            sb.append("height:");
            sb.append(this.f31020l);
            sb.append(",\n");
        }
        b(sb, "horizontalBias", this.f31021m);
        b(sb, "verticalBias", this.f31022n);
        if (this.f31023o != null) {
            sb.append("dimensionRatio:'");
            sb.append(this.f31023o);
            sb.append("',\n");
        }
        if (this.f31024p != null && (!Float.isNaN(this.f31026r) || this.f31025q != Integer.MIN_VALUE)) {
            sb.append("circular:['");
            sb.append(this.f31024p);
            sb.append("'");
            if (!Float.isNaN(this.f31026r)) {
                sb.append(StabilityExternalClassNameMatchingKt.STABILITY_GENERIC_SEPARATOR);
                sb.append(this.f31026r);
            }
            if (this.f31025q != Integer.MIN_VALUE) {
                if (Float.isNaN(this.f31026r)) {
                    sb.append(",0,");
                    sb.append(this.f31025q);
                } else {
                    sb.append(StabilityExternalClassNameMatchingKt.STABILITY_GENERIC_SEPARATOR);
                    sb.append(this.f31025q);
                }
            }
            sb.append("],\n");
        }
        b(sb, "verticalWeight", this.f31029u);
        b(sb, "horizontalWeight", this.f31030v);
        if (this.f31031w != null) {
            sb.append("horizontalChainStyle:'");
            sb.append((String) K.get(this.f31031w));
            sb.append("',\n");
        }
        if (this.f31032x != null) {
            sb.append("verticalChainStyle:'");
            sb.append((String) K.get(this.f31032x));
            sb.append("',\n");
        }
        if (this.f31033y != null) {
            int i3 = this.A;
            int i4 = J;
            if (i3 == i4 && this.C == i4) {
                sb.append("width:'");
                sb.append(this.f31033y.toString().toLowerCase());
                sb.append("',\n");
            } else {
                sb.append("width:{value:'");
                sb.append(this.f31033y.toString().toLowerCase());
                sb.append("'");
                if (this.A != J) {
                    sb.append(",max:");
                    sb.append(this.A);
                }
                if (this.C != J) {
                    sb.append(",min:");
                    sb.append(this.C);
                }
                sb.append("},\n");
            }
        }
        if (this.f31034z != null) {
            int i5 = this.B;
            int i6 = J;
            if (i5 == i6 && this.D == i6) {
                sb.append("height:'");
                sb.append(this.f31034z.toString().toLowerCase());
                sb.append("',\n");
            } else {
                sb.append("height:{value:'");
                sb.append(this.f31034z.toString().toLowerCase());
                sb.append("'");
                if (this.B != J) {
                    sb.append(",max:");
                    sb.append(this.B);
                }
                if (this.D != J) {
                    sb.append(",min:");
                    sb.append(this.D);
                }
                sb.append("},\n");
            }
        }
        if (!Double.isNaN(this.E)) {
            sb.append("width:'");
            sb.append((int) this.E);
            sb.append("%',\n");
        }
        if (!Double.isNaN(this.F)) {
            sb.append("height:'");
            sb.append((int) this.F);
            sb.append("%',\n");
        }
        if (this.G != null) {
            sb.append("referenceIds:");
            sb.append(c(this.G));
            sb.append(",\n");
        }
        if (this.H) {
            sb.append("constrainedWidth:");
            sb.append(this.H);
            sb.append(",\n");
        }
        if (this.I) {
            sb.append("constrainedHeight:");
            sb.append(this.I);
            sb.append(",\n");
        }
        sb.append("},\n");
        return sb.toString();
    }
}
