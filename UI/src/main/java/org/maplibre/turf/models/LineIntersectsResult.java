package org.maplibre.turf.models;

/* loaded from: classes9.dex */
public class LineIntersectsResult {

    /* renamed from: a, reason: collision with root package name */
    public final Double f165397a;

    /* renamed from: b, reason: collision with root package name */
    public final Double f165398b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f165399c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f165400d;

    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        public Double f165401a;

        /* renamed from: b, reason: collision with root package name */
        public Double f165402b;

        /* renamed from: c, reason: collision with root package name */
        public Boolean f165403c;

        /* renamed from: d, reason: collision with root package name */
        public Boolean f165404d;

        public LineIntersectsResult a() {
            String str = "";
            if (this.f165403c == null) {
                str = " onLine1";
            }
            if (this.f165404d == null) {
                str = str + " onLine2";
            }
            if (str.isEmpty()) {
                return new LineIntersectsResult(this.f165401a, this.f165402b, this.f165403c.booleanValue(), this.f165404d.booleanValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public Builder b(Double d3) {
            this.f165401a = d3;
            return this;
        }

        public Builder c(boolean z2) {
            this.f165403c = Boolean.valueOf(z2);
            return this;
        }

        public Builder d(boolean z2) {
            this.f165404d = Boolean.valueOf(z2);
            return this;
        }

        public Builder e(Double d3) {
            this.f165402b = d3;
            return this;
        }

        public Builder() {
            Boolean bool = Boolean.FALSE;
            this.f165403c = bool;
            this.f165404d = bool;
        }

        public Builder(LineIntersectsResult lineIntersectsResult) {
            Boolean bool = Boolean.FALSE;
            this.f165403c = bool;
            this.f165404d = bool;
            this.f165401a = lineIntersectsResult.b();
            this.f165402b = lineIntersectsResult.f();
            this.f165403c = Boolean.valueOf(lineIntersectsResult.c());
            this.f165404d = Boolean.valueOf(lineIntersectsResult.d());
        }
    }

    public static Builder a() {
        return new Builder();
    }

    public Double b() {
        return this.f165397a;
    }

    public boolean c() {
        return this.f165399c;
    }

    public boolean d() {
        return this.f165400d;
    }

    public Builder e() {
        return new Builder();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof LineIntersectsResult) {
            LineIntersectsResult lineIntersectsResult = (LineIntersectsResult) obj;
            Double d3 = this.f165397a;
            if (d3 != null ? d3.equals(lineIntersectsResult.b()) : lineIntersectsResult.b() == null) {
                Double d4 = this.f165398b;
                if (d4 != null ? d4.equals(lineIntersectsResult.f()) : lineIntersectsResult.f() == null) {
                    if (this.f165399c == lineIntersectsResult.c() && this.f165400d == lineIntersectsResult.d()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public Double f() {
        return this.f165398b;
    }

    public int hashCode() {
        Double d3 = this.f165397a;
        int iHashCode = ((d3 == null ? 0 : d3.hashCode()) ^ 1000003) * 1000003;
        Double d4 = this.f165398b;
        return ((((iHashCode ^ (d4 != null ? d4.hashCode() : 0)) * 1000003) ^ (this.f165399c ? 1231 : 1237)) * 1000003) ^ (this.f165400d ? 1231 : 1237);
    }

    public String toString() {
        return "LineIntersectsResult{horizontalIntersection=" + this.f165397a + ", verticalIntersection=" + this.f165398b + ", onLine1=" + this.f165399c + ", onLine2=" + this.f165400d + "}";
    }

    public LineIntersectsResult(Double d3, Double d4, boolean z2, boolean z3) {
        this.f165397a = d3;
        this.f165398b = d4;
        this.f165399c = z2;
        this.f165400d = z3;
    }
}
