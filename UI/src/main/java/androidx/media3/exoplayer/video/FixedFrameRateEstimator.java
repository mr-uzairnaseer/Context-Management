package androidx.media3.exoplayer.video;

import androidx.media3.common.C;
import java.util.Arrays;

/* loaded from: classes3.dex */
final class FixedFrameRateEstimator {
    public static final int CONSECUTIVE_MATCHING_FRAME_DURATIONS_FOR_SYNC = 15;

    /* renamed from: c, reason: collision with root package name */
    public boolean f41897c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f41898d;

    /* renamed from: f, reason: collision with root package name */
    public int f41900f;

    /* renamed from: a, reason: collision with root package name */
    public Matcher f41895a = new Matcher();

    /* renamed from: b, reason: collision with root package name */
    public Matcher f41896b = new Matcher();

    /* renamed from: e, reason: collision with root package name */
    public long f41899e = C.TIME_UNSET;

    public static final class Matcher {

        /* renamed from: a, reason: collision with root package name */
        public long f41901a;

        /* renamed from: b, reason: collision with root package name */
        public long f41902b;

        /* renamed from: c, reason: collision with root package name */
        public long f41903c;

        /* renamed from: d, reason: collision with root package name */
        public long f41904d;

        /* renamed from: e, reason: collision with root package name */
        public long f41905e;

        /* renamed from: f, reason: collision with root package name */
        public long f41906f;

        /* renamed from: g, reason: collision with root package name */
        public final boolean[] f41907g = new boolean[15];

        /* renamed from: h, reason: collision with root package name */
        public int f41908h;

        public static int c(long j3) {
            return (int) (j3 % 15);
        }

        public long a() {
            long j3 = this.f41905e;
            if (j3 == 0) {
                return 0L;
            }
            return this.f41906f / j3;
        }

        public long b() {
            return this.f41906f;
        }

        public boolean d() {
            long j3 = this.f41904d;
            if (j3 == 0) {
                return false;
            }
            return this.f41907g[c(j3 - 1)];
        }

        public boolean e() {
            return this.f41904d > 15 && this.f41908h == 0;
        }

        public void f(long j3) {
            long j4 = this.f41904d;
            if (j4 == 0) {
                this.f41901a = j3;
            } else if (j4 == 1) {
                long j5 = j3 - this.f41901a;
                this.f41902b = j5;
                this.f41906f = j5;
                this.f41905e = 1L;
            } else {
                long j6 = j3 - this.f41903c;
                int iC = c(j4);
                if (Math.abs(j6 - this.f41902b) <= 1000000) {
                    this.f41905e++;
                    this.f41906f += j6;
                    boolean[] zArr = this.f41907g;
                    if (zArr[iC]) {
                        zArr[iC] = false;
                        this.f41908h--;
                    }
                } else {
                    boolean[] zArr2 = this.f41907g;
                    if (!zArr2[iC]) {
                        zArr2[iC] = true;
                        this.f41908h++;
                    }
                }
            }
            this.f41904d++;
            this.f41903c = j3;
        }

        public void g() {
            this.f41904d = 0L;
            this.f41905e = 0L;
            this.f41906f = 0L;
            this.f41908h = 0;
            Arrays.fill(this.f41907g, false);
        }
    }

    public long a() {
        return e() ? this.f41895a.a() : C.TIME_UNSET;
    }

    public float b() {
        if (e()) {
            return (float) (1.0E9d / this.f41895a.a());
        }
        return -1.0f;
    }

    public int c() {
        return this.f41900f;
    }

    public long d() {
        return e() ? this.f41895a.b() : C.TIME_UNSET;
    }

    public boolean e() {
        return this.f41895a.e();
    }

    public void f(long j3) {
        this.f41895a.f(j3);
        if (this.f41895a.e() && !this.f41898d) {
            this.f41897c = false;
        } else if (this.f41899e != C.TIME_UNSET) {
            if (!this.f41897c || this.f41896b.d()) {
                this.f41896b.g();
                this.f41896b.f(this.f41899e);
            }
            this.f41897c = true;
            this.f41896b.f(j3);
        }
        if (this.f41897c && this.f41896b.e()) {
            Matcher matcher = this.f41895a;
            this.f41895a = this.f41896b;
            this.f41896b = matcher;
            this.f41897c = false;
            this.f41898d = false;
        }
        this.f41899e = j3;
        this.f41900f = this.f41895a.e() ? 0 : this.f41900f + 1;
    }

    public void g() {
        this.f41895a.g();
        this.f41896b.g();
        this.f41897c = false;
        this.f41899e = C.TIME_UNSET;
        this.f41900f = 0;
    }
}
