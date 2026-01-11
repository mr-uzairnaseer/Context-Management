package io.jenetics.jpx.geom;

/* loaded from: classes8.dex */
final class DoubleAdder extends Number implements Comparable<DoubleAdder> {

    /* renamed from: a, reason: collision with root package name */
    public double f151145a = 0.0d;

    /* renamed from: b, reason: collision with root package name */
    public double f151146b = 0.0d;

    /* renamed from: c, reason: collision with root package name */
    public double f151147c = 0.0d;

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(DoubleAdder doubleAdder) {
        return Double.compare(doubleValue(), doubleAdder.doubleValue());
    }

    public double c() {
        double d3 = this.f151145a + this.f151147c;
        return (Double.isNaN(d3) && Double.isInfinite(this.f151146b)) ? this.f151146b : d3;
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return c();
    }

    public boolean equals(Object obj) {
        return (obj instanceof DoubleAdder) && Double.compare(doubleValue(), ((DoubleAdder) obj).doubleValue()) == 0;
    }

    @Override // java.lang.Number
    public float floatValue() {
        return (float) c();
    }

    public int hashCode() {
        return Double.hashCode(doubleValue());
    }

    @Override // java.lang.Number
    public int intValue() {
        return (int) c();
    }

    @Override // java.lang.Number
    public long longValue() {
        return (long) c();
    }

    public String toString() {
        return Double.toString(doubleValue());
    }
}
