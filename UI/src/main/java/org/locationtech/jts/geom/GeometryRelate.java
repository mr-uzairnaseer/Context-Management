package org.locationtech.jts.geom;

/* loaded from: classes5.dex */
class GeometryRelate {
    public static boolean RELATE_NG_DEFAULT = false;
    public static String RELATE_PROPERTY_NAME = "jts.relate";
    public static String RELATE_PROPERTY_VALUE_NG = "ng";
    public static String RELATE_PROPERTY_VALUE_OLD = "old";

    /* renamed from: a, reason: collision with root package name */
    public static boolean f163372a = false;

    static {
        a(System.getProperty("jts.relate"));
    }

    public static void a(String str) {
        if (str == null) {
            return;
        }
        f163372a = RELATE_NG_DEFAULT;
        if (RELATE_PROPERTY_VALUE_NG.equalsIgnoreCase(str)) {
            f163372a = true;
        }
    }
}
