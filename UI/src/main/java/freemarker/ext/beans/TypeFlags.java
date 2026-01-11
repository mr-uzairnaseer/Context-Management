package freemarker.ext.beans;

/* loaded from: classes8.dex */
class TypeFlags {

    /* renamed from: a, reason: collision with root package name */
    public static /* synthetic */ Class f150209a;

    /* renamed from: b, reason: collision with root package name */
    public static /* synthetic */ Class f150210b;

    /* renamed from: c, reason: collision with root package name */
    public static /* synthetic */ Class f150211c;

    /* renamed from: d, reason: collision with root package name */
    public static /* synthetic */ Class f150212d;

    /* renamed from: e, reason: collision with root package name */
    public static /* synthetic */ Class f150213e;

    /* renamed from: f, reason: collision with root package name */
    public static /* synthetic */ Class f150214f;

    /* renamed from: g, reason: collision with root package name */
    public static /* synthetic */ Class f150215g;

    /* renamed from: h, reason: collision with root package name */
    public static /* synthetic */ Class f150216h;

    /* renamed from: i, reason: collision with root package name */
    public static /* synthetic */ Class f150217i;

    /* renamed from: j, reason: collision with root package name */
    public static /* synthetic */ Class f150218j;

    /* renamed from: k, reason: collision with root package name */
    public static /* synthetic */ Class f150219k;

    /* renamed from: l, reason: collision with root package name */
    public static /* synthetic */ Class f150220l;

    /* renamed from: m, reason: collision with root package name */
    public static /* synthetic */ Class f150221m;

    /* renamed from: n, reason: collision with root package name */
    public static /* synthetic */ Class f150222n;

    /* renamed from: o, reason: collision with root package name */
    public static /* synthetic */ Class f150223o;

    /* renamed from: p, reason: collision with root package name */
    public static /* synthetic */ Class f150224p;

    /* renamed from: q, reason: collision with root package name */
    public static /* synthetic */ Class f150225q;

    public static /* synthetic */ Class a(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e3) {
            throw new NoClassDefFoundError().initCause(e3);
        }
    }

    public static int b(Class cls) throws Throwable {
        Class clsA = f150209a;
        if (clsA == null) {
            clsA = a("java.lang.Object");
            f150209a = clsA;
        }
        if (cls == clsA) {
            return 522240;
        }
        Class clsA2 = f150210b;
        if (clsA2 == null) {
            clsA2 = a("java.lang.String");
            f150210b = clsA2;
        }
        if (cls == clsA2) {
            return 8192;
        }
        if (cls.isPrimitive()) {
            if (cls == Integer.TYPE) {
                return 2064;
            }
            if (cls == Long.TYPE) {
                return 2080;
            }
            if (cls == Double.TYPE) {
                return 2176;
            }
            if (cls == Float.TYPE) {
                return 2112;
            }
            if (cls == Byte.TYPE) {
                return 2052;
            }
            if (cls == Short.TYPE) {
                return 2056;
            }
            if (cls == Character.TYPE) {
                return 524288;
            }
            return cls == Boolean.TYPE ? 16384 : 0;
        }
        Class clsA3 = f150211c;
        if (clsA3 == null) {
            clsA3 = a("java.lang.Number");
            f150211c = clsA3;
        }
        if (!clsA3.isAssignableFrom(cls)) {
            if (cls.isArray()) {
                return 262144;
            }
            Class<?> clsA4 = f150210b;
            if (clsA4 == null) {
                clsA4 = a("java.lang.String");
                f150210b = clsA4;
            }
            int i3 = cls.isAssignableFrom(clsA4) ? 8192 : 0;
            Class<?> clsA5 = f150220l;
            if (clsA5 == null) {
                clsA5 = a("java.util.Date");
                f150220l = clsA5;
            }
            if (cls.isAssignableFrom(clsA5)) {
                i3 |= 4096;
            }
            Class<?> clsA6 = f150221m;
            if (clsA6 == null) {
                clsA6 = a("java.lang.Boolean");
                f150221m = clsA6;
            }
            if (cls.isAssignableFrom(clsA6)) {
                i3 |= 16384;
            }
            Class<?> clsA7 = f150222n;
            if (clsA7 == null) {
                clsA7 = a("java.util.Map");
                f150222n = clsA7;
            }
            if (cls.isAssignableFrom(clsA7)) {
                i3 |= 32768;
            }
            Class<?> clsA8 = f150223o;
            if (clsA8 == null) {
                clsA8 = a("java.util.List");
                f150223o = clsA8;
            }
            if (cls.isAssignableFrom(clsA8)) {
                i3 |= 65536;
            }
            Class<?> clsA9 = f150224p;
            if (clsA9 == null) {
                clsA9 = a("java.util.Set");
                f150224p = clsA9;
            }
            if (cls.isAssignableFrom(clsA9)) {
                i3 |= 131072;
            }
            Class clsA10 = f150225q;
            if (clsA10 == null) {
                clsA10 = a("java.lang.Character");
                f150225q = clsA10;
            }
            return cls == clsA10 ? i3 | 524288 : i3;
        }
        Class clsA11 = f150212d;
        if (clsA11 == null) {
            clsA11 = a("java.lang.Integer");
            f150212d = clsA11;
        }
        if (cls == clsA11) {
            return 2064;
        }
        Class clsA12 = f150213e;
        if (clsA12 == null) {
            clsA12 = a("java.lang.Long");
            f150213e = clsA12;
        }
        if (cls == clsA12) {
            return 2080;
        }
        Class clsA13 = f150214f;
        if (clsA13 == null) {
            clsA13 = a("java.lang.Double");
            f150214f = clsA13;
        }
        if (cls == clsA13) {
            return 2176;
        }
        Class clsA14 = f150215g;
        if (clsA14 == null) {
            clsA14 = a("java.lang.Float");
            f150215g = clsA14;
        }
        if (cls == clsA14) {
            return 2112;
        }
        Class clsA15 = f150216h;
        if (clsA15 == null) {
            clsA15 = a("java.lang.Byte");
            f150216h = clsA15;
        }
        if (cls == clsA15) {
            return 2052;
        }
        Class clsA16 = f150217i;
        if (clsA16 == null) {
            clsA16 = a("java.lang.Short");
            f150217i = clsA16;
        }
        if (cls == clsA16) {
            return 2056;
        }
        Class clsA17 = f150218j;
        if (clsA17 == null) {
            clsA17 = a("java.math.BigDecimal");
            f150218j = clsA17;
        }
        if (clsA17.isAssignableFrom(cls)) {
            return 2560;
        }
        Class clsA18 = f150219k;
        if (clsA18 == null) {
            clsA18 = a("java.math.BigInteger");
            f150219k = clsA18;
        }
        return clsA18.isAssignableFrom(cls) ? 2304 : 3072;
    }
}
