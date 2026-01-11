package org.locationtech.jts.precision;

/* loaded from: classes7.dex */
public class CommonBits {

    /* renamed from: a, reason: collision with root package name */
    public boolean f164214a = true;

    /* renamed from: b, reason: collision with root package name */
    public int f164215b = 53;

    /* renamed from: c, reason: collision with root package name */
    public long f164216c = 0;

    /* renamed from: d, reason: collision with root package name */
    public long f164217d;

    public static int b(long j3, int i3) {
        return (j3 & (1 << i3)) != 0 ? 1 : 0;
    }

    public static int c(long j3, long j4) {
        int i3 = 0;
        for (int i4 = 52; i4 >= 0; i4--) {
            if (b(j3, i4) != b(j4, i4)) {
                return i3;
            }
            i3++;
        }
        return 52;
    }

    public static long d(long j3) {
        return j3 >> 52;
    }

    public static long e(long j3, int i3) {
        return j3 & (~((1 << i3) - 1));
    }

    public void a(double d3) {
        long jDoubleToLongBits = Double.doubleToLongBits(d3);
        if (this.f164214a) {
            this.f164216c = jDoubleToLongBits;
            this.f164217d = d(jDoubleToLongBits);
            this.f164214a = false;
        } else {
            if (d(jDoubleToLongBits) != this.f164217d) {
                this.f164216c = 0L;
                return;
            }
            int iC = c(this.f164216c, jDoubleToLongBits);
            this.f164215b = iC;
            this.f164216c = e(this.f164216c, 64 - (iC + 12));
        }
    }
}
