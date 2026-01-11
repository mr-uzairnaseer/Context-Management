package org.locationtech.jts.geomgraph.index;

/* loaded from: classes5.dex */
public class SweepLineEvent implements Comparable {

    /* renamed from: a, reason: collision with root package name */
    public double f163491a;

    /* renamed from: b, reason: collision with root package name */
    public int f163492b;

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        SweepLineEvent sweepLineEvent = (SweepLineEvent) obj;
        double d3 = this.f163491a;
        double d4 = sweepLineEvent.f163491a;
        if (d3 < d4) {
            return -1;
        }
        if (d3 > d4) {
            return 1;
        }
        int i3 = this.f163492b;
        int i4 = sweepLineEvent.f163492b;
        if (i3 < i4) {
            return -1;
        }
        return i3 > i4 ? 1 : 0;
    }
}
