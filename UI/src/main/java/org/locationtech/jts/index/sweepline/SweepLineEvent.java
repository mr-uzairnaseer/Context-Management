package org.locationtech.jts.index.sweepline;

/* loaded from: classes6.dex */
public class SweepLineEvent implements Comparable {
    public static final int DELETE = 2;
    public static final int INSERT = 1;

    /* renamed from: a, reason: collision with root package name */
    public double f163582a;

    /* renamed from: b, reason: collision with root package name */
    public int f163583b;

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        SweepLineEvent sweepLineEvent = (SweepLineEvent) obj;
        double d3 = this.f163582a;
        double d4 = sweepLineEvent.f163582a;
        if (d3 < d4) {
            return -1;
        }
        if (d3 > d4) {
            return 1;
        }
        int i3 = this.f163583b;
        int i4 = sweepLineEvent.f163583b;
        if (i3 < i4) {
            return -1;
        }
        return i3 > i4 ? 1 : 0;
    }
}
