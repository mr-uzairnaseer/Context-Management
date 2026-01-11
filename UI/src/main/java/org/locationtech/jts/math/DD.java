package org.locationtech.jts.math;

import androidx.exifinterface.media.ExifInterface;
import com.facebook.appevents.AppEventsConstants;
import com.google.firebase.crashlytics.internal.common.IdManager;
import java.io.Serializable;

/* loaded from: classes6.dex */
public final class DD implements Serializable, Comparable, Cloneable {
    public static final double EPS = 1.23259516440783E-32d;

    /* renamed from: a, reason: collision with root package name */
    public double f163658a = 0.0d;

    /* renamed from: b, reason: collision with root package name */
    public double f163659b = 0.0d;
    public static final DD PI = new DD(3.141592653589793d, 1.2246467991473532E-16d);
    public static final DD TWO_PI = new DD(6.283185307179586d, 2.4492935982947064E-16d);
    public static final DD PI_2 = new DD(1.5707963267948966d, 6.123233995736766E-17d);
    public static final DD E = new DD(2.718281828459045d, 1.4456468917292502E-16d);
    public static final DD NaN = new DD(Double.NaN, Double.NaN);

    /* renamed from: c, reason: collision with root package name */
    public static final DD f163656c = x0(10.0d);

    /* renamed from: d, reason: collision with root package name */
    public static final DD f163657d = x0(1.0d);

    public DD() {
        v(0.0d);
    }

    public static int G(double d3) {
        double dAbs = Math.abs(d3);
        int iFloor = (int) Math.floor(Math.log(dAbs) / Math.log(10.0d));
        return Math.pow(10.0d, (double) iFloor) * 10.0d <= dAbs ? iFloor + 1 : iFloor;
    }

    public static DD d(DD dd) {
        return new DD(dd);
    }

    public static DD e() {
        return new DD(Double.NaN, Double.NaN);
    }

    public static String s0(char c3, int i3) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i4 = 0; i4 < i3; i4++) {
            stringBuffer.append(c3);
        }
        return stringBuffer.toString();
    }

    public static DD x0(double d3) {
        return new DD(d3);
    }

    public boolean B() {
        return this.f163658a == 0.0d && this.f163659b == 0.0d;
    }

    public boolean F(DD dd) {
        double d3 = this.f163658a;
        double d4 = dd.f163658a;
        if (d3 >= d4) {
            return d3 == d4 && this.f163659b < dd.f163659b;
        }
        return true;
    }

    public final DD H(DD dd) {
        return dd.y() ? e() : d(this).g0(dd);
    }

    public final DD I() {
        return y() ? this : new DD(-this.f163658a, -this.f163659b);
    }

    public DD N(int i3) {
        if (i3 == 0.0d) {
            return x0(1.0d);
        }
        DD dd = new DD(this);
        DD ddX0 = x0(1.0d);
        int iAbs = Math.abs(i3);
        if (iAbs > 1) {
            while (iAbs > 0) {
                if (iAbs % 2 == 1) {
                    ddX0.g0(dd);
                }
                iAbs /= 2;
                if (iAbs > 0) {
                    dd = dd.p0();
                }
            }
            dd = ddX0;
        }
        return i3 < 0 ? dd.Q() : dd;
    }

    public final DD Q() {
        double d3 = this.f163658a;
        double d4 = 1.0d / d3;
        double d5 = d4 * 1.34217729E8d;
        double d6 = 1.34217729E8d * d3;
        double d7 = d5 - (d5 - d4);
        double d8 = d4 - d7;
        double d9 = d4 * d3;
        double d10 = d6 - (d6 - d3);
        double d11 = d3 - d10;
        double d12 = (((1.0d - d9) - (((((d7 * d10) - d9) + (d7 * d11)) + (d10 * d8)) + (d8 * d11))) - (this.f163659b * d4)) / d3;
        double d13 = d4 + d12;
        return new DD(d13, (d4 - d13) + d12);
    }

    public final DD R(double d3) {
        double d4 = this.f163658a;
        double d5 = d4 + d3;
        double d6 = d5 - d4;
        double d7 = (d3 - d6) + (d4 - (d5 - d6)) + this.f163659b;
        double d8 = d5 + d7;
        double d9 = d7 + (d5 - d8);
        double d10 = d8 + d9;
        this.f163658a = d10;
        this.f163659b = d9 + (d8 - d10);
        return this;
    }

    public final DD Y(double d3, double d4) {
        double d5 = this.f163658a;
        double d6 = d5 + d3;
        double d7 = this.f163659b;
        double d8 = d7 + d4;
        double d9 = d6 - d5;
        double d10 = d8 - d7;
        double d11 = (d3 - d9) + (d5 - (d6 - d9));
        double d12 = (d4 - d10) + (d7 - (d8 - d10));
        double d13 = d11 + d8;
        double d14 = d6 + d13;
        double d15 = d12 + d13 + (d6 - d14);
        double d16 = d14 + d15;
        this.f163658a = d16;
        this.f163659b = d15 + (d14 - d16);
        return this;
    }

    public DD a() {
        return y() ? NaN : z() ? I() : new DD(this);
    }

    public final DD a0(DD dd) {
        return Y(dd.f163658a, dd.f163659b);
    }

    public final DD c(DD dd) {
        return d(this).a0(dd);
    }

    public final DD c0(double d3, double d4) {
        double d5 = this.f163658a;
        double d6 = d5 / d3;
        double d7 = d6 * 1.34217729E8d;
        double d8 = 1.34217729E8d * d3;
        double d9 = d7 - (d7 - d6);
        double d10 = d6 - d9;
        double d11 = d6 * d3;
        double d12 = d8 - (d8 - d3);
        double d13 = d3 - d12;
        double d14 = ((((d5 - d11) - (((((d9 * d12) - d11) + (d9 * d13)) + (d12 * d10)) + (d10 * d13))) + this.f163659b) - (d6 * d4)) / d3;
        double d15 = d6 + d14;
        this.f163658a = d15;
        this.f163659b = (d6 - d15) + d14;
        return this;
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        DD dd = (DD) obj;
        double d3 = this.f163658a;
        double d4 = dd.f163658a;
        if (d3 < d4) {
            return -1;
        }
        if (d3 > d4) {
            return 1;
        }
        double d5 = this.f163659b;
        double d6 = dd.f163659b;
        if (d5 < d6) {
            return -1;
        }
        return d5 > d6 ? 1 : 0;
    }

    public final DD d0(DD dd) {
        return c0(dd.f163658a, dd.f163659b);
    }

    public final DD e0(double d3) {
        return f0(d3, 0.0d);
    }

    public final DD f0(double d3, double d4) {
        double d5 = this.f163658a;
        double d6 = d5 * 1.34217729E8d;
        double d7 = 1.34217729E8d * d3;
        double d8 = d6 - (d6 - d5);
        double d9 = d5 - d8;
        double d10 = d5 * d3;
        double d11 = d7 - (d7 - d3);
        double d12 = d3 - d11;
        double d13 = ((d8 * d11) - d10) + (d8 * d12) + (d11 * d9) + (d9 * d12) + (d5 * d4) + (this.f163659b * d3);
        double d14 = d10 + d13;
        this.f163658a = d14;
        this.f163659b = d13 + (d10 - d14);
        return this;
    }

    public final DD g0(DD dd) {
        return f0(dd.f163658a, dd.f163659b);
    }

    public final DD j(DD dd) {
        double d3 = this.f163658a;
        double d4 = dd.f163658a;
        double d5 = d3 / d4;
        double d6 = d5 * 1.34217729E8d;
        double d7 = 1.34217729E8d * d4;
        double d8 = d6 - (d6 - d5);
        double d9 = d5 - d8;
        double d10 = d5 * d4;
        double d11 = d7 - (d7 - d4);
        double d12 = d4 - d11;
        double d13 = ((((d3 - d10) - (((((d8 * d11) - d10) + (d8 * d12)) + (d11 * d9)) + (d9 * d12))) + this.f163659b) - (dd.f163659b * d5)) / d4;
        double d14 = d5 + d13;
        return new DD(d14, (d5 - d14) + d13);
    }

    public final DD k0(double d3) {
        return y() ? this : Y(-d3, 0.0d);
    }

    public final DD l0(DD dd) {
        return y() ? this : Y(-dd.f163658a, -dd.f163659b);
    }

    public double m() {
        return this.f163658a + this.f163659b;
    }

    public int o0() {
        double d3 = this.f163658a;
        if (d3 > 0.0d) {
            return 1;
        }
        if (d3 < 0.0d) {
            return -1;
        }
        double d4 = this.f163659b;
        if (d4 > 0.0d) {
            return 1;
        }
        return d4 < 0.0d ? -1 : 0;
    }

    public DD p0() {
        return H(this);
    }

    public final String q(boolean z2, int[] iArr) {
        char c3;
        boolean z3;
        DD ddA = a();
        int iG = G(ddA.f163658a);
        DD dd = f163656c;
        DD ddJ = ddA.j(dd.N(iG));
        if (ddJ.u(dd)) {
            ddJ = ddJ.j(dd);
            iG++;
        } else if (ddJ.F(f163657d)) {
            ddJ = ddJ.H(dd);
            iG--;
        }
        int i3 = iG + 1;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i4 = 0; i4 <= 31; i4++) {
            if (z2 && i4 == i3) {
                stringBuffer.append('.');
            }
            int i5 = (int) ddJ.f163658a;
            if (i5 < 0) {
                break;
            }
            if (i5 > 9) {
                z3 = true;
                c3 = '9';
            } else {
                c3 = (char) (i5 + 48);
                z3 = false;
            }
            stringBuffer.append(c3);
            DD ddT0 = ddJ.t0(x0(i5));
            DD dd2 = f163656c;
            ddJ = ddT0.H(dd2);
            if (z3) {
                ddJ.a0(dd2);
            }
            int iG2 = G(ddJ.f163658a);
            if (iG2 < 0 && Math.abs(iG2) >= 31 - i4) {
                break;
            }
        }
        iArr[0] = iG;
        return stringBuffer.toString();
    }

    public final String r() {
        if (B()) {
            return IdManager.DEFAULT_VERSION_NAME;
        }
        if (y()) {
            return "NaN ";
        }
        return null;
    }

    public final DD t0(DD dd) {
        return c(dd.I());
    }

    public String toString() {
        int iG = G(this.f163658a);
        return (iG < -3 || iG > 20) ? v0() : w0();
    }

    public boolean u(DD dd) {
        double d3 = this.f163658a;
        double d4 = dd.f163658a;
        if (d3 <= d4) {
            return d3 == d4 && this.f163659b > dd.f163659b;
        }
        return true;
    }

    public final void v(double d3) {
        this.f163658a = d3;
        this.f163659b = 0.0d;
    }

    public String v0() {
        if (B()) {
            return "0.0E0";
        }
        String strR = r();
        if (strR != null) {
            return strR;
        }
        int[] iArr = new int[1];
        String strQ = q(false, iArr);
        String str = ExifInterface.LONGITUDE_EAST + iArr[0];
        if (strQ.charAt(0) == '0') {
            throw new IllegalStateException("Found leading zero: " + strQ);
        }
        String str2 = strQ.charAt(0) + "." + (strQ.length() > 1 ? strQ.substring(1) : "");
        if (!z()) {
            return str2 + str;
        }
        return "-" + str2 + str;
    }

    public final void w(double d3, double d4) {
        this.f163658a = d3;
        this.f163659b = d4;
    }

    public String w0() {
        String strR = r();
        if (strR != null) {
            return strR;
        }
        int[] iArr = new int[1];
        String strQ = q(true, iArr);
        int i3 = iArr[0] + 1;
        if (strQ.charAt(0) == '.') {
            strQ = AppEventsConstants.EVENT_PARAM_VALUE_NO + strQ;
        } else if (i3 < 0) {
            strQ = "0." + s0('0', -i3) + strQ;
        } else if (strQ.indexOf(46) == -1) {
            strQ = strQ + s0('0', i3 - strQ.length()) + ".0";
        }
        if (!z()) {
            return strQ;
        }
        return "-" + strQ;
    }

    public final void x(DD dd) {
        this.f163658a = dd.f163658a;
        this.f163659b = dd.f163659b;
    }

    public boolean y() {
        return Double.isNaN(this.f163658a);
    }

    public boolean z() {
        double d3 = this.f163658a;
        if (d3 >= 0.0d) {
            return d3 == 0.0d && this.f163659b < 0.0d;
        }
        return true;
    }

    public DD(double d3) {
        v(d3);
    }

    public DD(double d3, double d4) {
        w(d3, d4);
    }

    public DD(DD dd) {
        x(dd);
    }
}
