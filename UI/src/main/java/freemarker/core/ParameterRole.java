package freemarker.core;

import de.komoot.android.services.api.JsonKeywords;

/* loaded from: classes8.dex */
final class ParameterRole {

    /* renamed from: a, reason: collision with root package name */
    public final String f149686a;

    /* renamed from: b, reason: collision with root package name */
    public static final ParameterRole f149661b = new ParameterRole("[unknown role]");

    /* renamed from: c, reason: collision with root package name */
    public static final ParameterRole f149662c = new ParameterRole("left-hand operand");

    /* renamed from: d, reason: collision with root package name */
    public static final ParameterRole f149663d = new ParameterRole("right-hand operand");

    /* renamed from: e, reason: collision with root package name */
    public static final ParameterRole f149664e = new ParameterRole("enclosed operand");

    /* renamed from: f, reason: collision with root package name */
    public static final ParameterRole f149665f = new ParameterRole("item value");

    /* renamed from: g, reason: collision with root package name */
    public static final ParameterRole f149666g = new ParameterRole("item key");

    /* renamed from: h, reason: collision with root package name */
    public static final ParameterRole f149667h = new ParameterRole("assignment target");

    /* renamed from: i, reason: collision with root package name */
    public static final ParameterRole f149668i = new ParameterRole("assignment operator");

    /* renamed from: j, reason: collision with root package name */
    public static final ParameterRole f149669j = new ParameterRole("assignment source");

    /* renamed from: k, reason: collision with root package name */
    public static final ParameterRole f149670k = new ParameterRole("variable scope");

    /* renamed from: l, reason: collision with root package name */
    public static final ParameterRole f149671l = new ParameterRole("namespace");

    /* renamed from: m, reason: collision with root package name */
    public static final ParameterRole f149672m = new ParameterRole("error handler");

    /* renamed from: n, reason: collision with root package name */
    public static final ParameterRole f149673n = new ParameterRole("passed value");

    /* renamed from: o, reason: collision with root package name */
    public static final ParameterRole f149674o = new ParameterRole("condition");

    /* renamed from: p, reason: collision with root package name */
    public static final ParameterRole f149675p = new ParameterRole("value");

    /* renamed from: q, reason: collision with root package name */
    public static final ParameterRole f149676q = new ParameterRole("AST-node subtype");

    /* renamed from: r, reason: collision with root package name */
    public static final ParameterRole f149677r = new ParameterRole("placeholder variable");

    /* renamed from: s, reason: collision with root package name */
    public static final ParameterRole f149678s = new ParameterRole("expression template");

    /* renamed from: t, reason: collision with root package name */
    public static final ParameterRole f149679t = new ParameterRole("list source");

    /* renamed from: u, reason: collision with root package name */
    public static final ParameterRole f149680u = new ParameterRole("target loop variable");

    /* renamed from: v, reason: collision with root package name */
    public static final ParameterRole f149681v = new ParameterRole("template name");

    /* renamed from: w, reason: collision with root package name */
    public static final ParameterRole f149682w = new ParameterRole("\"parse\" parameter");

    /* renamed from: x, reason: collision with root package name */
    public static final ParameterRole f149683x = new ParameterRole("\"encoding\" parameter");

    /* renamed from: y, reason: collision with root package name */
    public static final ParameterRole f149684y = new ParameterRole("\"ignore_missing\" parameter");

    /* renamed from: z, reason: collision with root package name */
    public static final ParameterRole f149685z = new ParameterRole("parameter name");
    public static final ParameterRole A = new ParameterRole("parameter default");
    public static final ParameterRole B = new ParameterRole("catch-all parameter name");
    public static final ParameterRole C = new ParameterRole("argument name");
    public static final ParameterRole D = new ParameterRole("argument value");
    public static final ParameterRole E = new ParameterRole("content");
    public static final ParameterRole F = new ParameterRole("embedded template");
    public static final ParameterRole G = new ParameterRole("minimum decimals");
    public static final ParameterRole H = new ParameterRole("maximum decimals");
    public static final ParameterRole I = new ParameterRole(JsonKeywords.NODE);
    public static final ParameterRole J = new ParameterRole("callee");
    public static final ParameterRole K = new ParameterRole("message");

    public ParameterRole(String str) {
        this.f149686a = str;
    }

    public static ParameterRole a(int i3) {
        if (i3 == 0) {
            return f149662c;
        }
        if (i3 == 1) {
            return f149663d;
        }
        throw new IndexOutOfBoundsException();
    }

    public String toString() {
        return this.f149686a;
    }
}
