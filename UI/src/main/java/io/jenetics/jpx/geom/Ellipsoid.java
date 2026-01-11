package io.jenetics.jpx.geom;

import java.io.Serializable;
import java.util.Objects;

/* loaded from: classes8.dex */
public final class Ellipsoid implements Serializable {
    public static final Ellipsoid DEFAULT;
    public static final Ellipsoid IERS_1989;
    public static final Ellipsoid IERS_2003;
    public static final Ellipsoid WGS84;

    /* renamed from: a, reason: collision with root package name */
    public final String f151148a;

    /* renamed from: b, reason: collision with root package name */
    public final double f151149b;

    /* renamed from: c, reason: collision with root package name */
    public final double f151150c;

    /* renamed from: d, reason: collision with root package name */
    public final double f151151d;

    static {
        Ellipsoid ellipsoidD = d("WGS-84", 6378137.0d, 6356752.314245d, 298.257223563d);
        WGS84 = ellipsoidD;
        IERS_1989 = d("IERS-1989", 6378136.0d, 6356751.302d, 298.257d);
        IERS_2003 = d("IERS-2003", 6378136.6d, 6356751.9d, 298.25642d);
        DEFAULT = ellipsoidD;
    }

    public Ellipsoid(String str, double d3, double d4, double d5) {
        Objects.requireNonNull(str);
        this.f151148a = str;
        this.f151149b = d3;
        this.f151150c = d4;
        this.f151151d = d5;
    }

    public static Ellipsoid d(String str, double d3, double d4, double d5) {
        return new Ellipsoid(str, d3, d4, d5);
    }

    public double a() {
        return this.f151149b;
    }

    public double b() {
        return this.f151150c;
    }

    public double c() {
        return this.f151151d;
    }
}
