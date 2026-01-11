package org.locationtech.jts.index.strtree;

/* loaded from: classes6.dex */
class BoundablePair implements Comparable {

    /* renamed from: a, reason: collision with root package name */
    public double f163568a;

    public double a() {
        return this.f163568a;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        double d3 = this.f163568a;
        double d4 = ((BoundablePair) obj).f163568a;
        if (d3 < d4) {
            return -1;
        }
        return d3 > d4 ? 1 : 0;
    }
}
