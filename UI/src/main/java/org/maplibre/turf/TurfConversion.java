package org.maplibre.turf;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes9.dex */
public final class TurfConversion {

    /* renamed from: a, reason: collision with root package name */
    public static final Map f165396a;

    static {
        HashMap map = new HashMap();
        f165396a = map;
        map.put(TurfConstants.UNIT_MILES, Double.valueOf(3960.0d));
        map.put(TurfConstants.UNIT_NAUTICAL_MILES, Double.valueOf(3441.145d));
        map.put(TurfConstants.UNIT_DEGREES, Double.valueOf(57.2957795d));
        map.put(TurfConstants.UNIT_RADIANS, Double.valueOf(1.0d));
        map.put(TurfConstants.UNIT_INCHES, Double.valueOf(2.509056E8d));
        map.put(TurfConstants.UNIT_YARDS, Double.valueOf(6969600.0d));
        Double dValueOf = Double.valueOf(6373000.0d);
        map.put(TurfConstants.UNIT_METERS, dValueOf);
        Double dValueOf2 = Double.valueOf(6.373E8d);
        map.put(TurfConstants.UNIT_CENTIMETERS, dValueOf2);
        Double dValueOf3 = Double.valueOf(6373.0d);
        map.put("kilometers", dValueOf3);
        map.put(TurfConstants.UNIT_FEET, Double.valueOf(2.090879265E7d));
        map.put(TurfConstants.UNIT_CENTIMETRES, dValueOf2);
        map.put(TurfConstants.UNIT_METRES, dValueOf);
        map.put(TurfConstants.UNIT_KILOMETRES, dValueOf3);
    }

    private TurfConversion() {
    }

    public static double a(double d3) {
        return ((d3 % 360.0d) * 3.141592653589793d) / 180.0d;
    }

    public static double b(double d3, String str) {
        return d3 / ((Double) f165396a.get(str)).doubleValue();
    }

    public static double c(double d3) {
        return ((d3 % 6.283185307179586d) * 180.0d) / 3.141592653589793d;
    }

    public static double d(double d3, String str) {
        return d3 * ((Double) f165396a.get(str)).doubleValue();
    }
}
