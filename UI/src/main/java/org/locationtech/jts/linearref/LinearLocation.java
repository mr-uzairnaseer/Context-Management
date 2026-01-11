package org.locationtech.jts.linearref;

/* loaded from: classes6.dex */
public class LinearLocation implements Comparable {

    /* renamed from: a, reason: collision with root package name */
    public int f163653a;

    /* renamed from: b, reason: collision with root package name */
    public int f163654b;

    /* renamed from: c, reason: collision with root package name */
    public double f163655c;

    public LinearLocation() {
        this.f163653a = 0;
        this.f163654b = 0;
        this.f163655c = 0.0d;
    }

    public LinearLocation a() {
        return new LinearLocation(this.f163653a, this.f163654b, this.f163655c);
    }

    public final void c() {
        if (this.f163655c < 0.0d) {
            this.f163655c = 0.0d;
        }
        if (this.f163655c > 1.0d) {
            this.f163655c = 1.0d;
        }
        if (this.f163653a < 0) {
            this.f163653a = 0;
            this.f163654b = 0;
            this.f163655c = 0.0d;
        }
        if (this.f163654b < 0) {
            this.f163654b = 0;
            this.f163655c = 0.0d;
        }
        if (this.f163655c == 1.0d) {
            this.f163655c = 0.0d;
            this.f163654b++;
        }
    }

    public Object clone() {
        return a();
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        LinearLocation linearLocation = (LinearLocation) obj;
        int i3 = this.f163653a;
        int i4 = linearLocation.f163653a;
        if (i3 < i4) {
            return -1;
        }
        if (i3 > i4) {
            return 1;
        }
        int i5 = this.f163654b;
        int i6 = linearLocation.f163654b;
        if (i5 < i6) {
            return -1;
        }
        if (i5 > i6) {
            return 1;
        }
        double d3 = this.f163655c;
        double d4 = linearLocation.f163655c;
        if (d3 < d4) {
            return -1;
        }
        return d3 > d4 ? 1 : 0;
    }

    public String toString() {
        return "LinearLoc[" + this.f163653a + ", " + this.f163654b + ", " + this.f163655c + "]";
    }

    public LinearLocation(int i3, int i4, double d3) {
        this.f163653a = i3;
        this.f163654b = i4;
        this.f163655c = d3;
        c();
    }
}
