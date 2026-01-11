package androidx.transition;

import java.util.Arrays;

/* loaded from: classes4.dex */
class VelocityTracker1D {

    /* renamed from: a, reason: collision with root package name */
    public long[] f48861a;

    /* renamed from: b, reason: collision with root package name */
    public float[] f48862b = new float[20];

    /* renamed from: c, reason: collision with root package name */
    public int f48863c = 0;

    public VelocityTracker1D() {
        long[] jArr = new long[20];
        this.f48861a = jArr;
        Arrays.fill(jArr, Long.MIN_VALUE);
    }

    public void a(long j3, float f3) {
        int i3 = (this.f48863c + 1) % 20;
        this.f48863c = i3;
        this.f48861a[i3] = j3;
        this.f48862b[i3] = f3;
    }

    public float b() {
        float fC;
        int i3 = this.f48863c;
        if (i3 == 0 && this.f48861a[i3] == Long.MIN_VALUE) {
            return 0.0f;
        }
        long j3 = this.f48861a[i3];
        int i4 = 0;
        long j4 = j3;
        while (true) {
            long j5 = this.f48861a[i3];
            if (j5 == Long.MIN_VALUE) {
                break;
            }
            float f3 = j3 - j5;
            float fAbs = Math.abs(j5 - j4);
            if (f3 > 100.0f || fAbs > 40.0f) {
                break;
            }
            if (i3 == 0) {
                i3 = 20;
            }
            i3--;
            i4++;
            if (i4 >= 20) {
                break;
            }
            j4 = j5;
        }
        if (i4 < 2) {
            return 0.0f;
        }
        if (i4 == 2) {
            int i5 = this.f48863c;
            int i6 = i5 == 0 ? 19 : i5 - 1;
            long[] jArr = this.f48861a;
            float f4 = jArr[i5] - jArr[i6];
            if (f4 == 0.0f) {
                return 0.0f;
            }
            float[] fArr = this.f48862b;
            fC = (fArr[i5] - fArr[i6]) / f4;
        } else {
            int i7 = this.f48863c;
            int i8 = ((i7 - i4) + 21) % 20;
            int i9 = (i7 + 21) % 20;
            long j6 = this.f48861a[i8];
            float f5 = this.f48862b[i8];
            int i10 = i8 + 1;
            float fC2 = 0.0f;
            for (int i11 = i10 % 20; i11 != i9; i11 = (i11 + 1) % 20) {
                long j7 = this.f48861a[i11];
                float f6 = j7 - j6;
                if (f6 != 0.0f) {
                    float f7 = this.f48862b[i11];
                    float f8 = (f7 - f5) / f6;
                    fC2 += (f8 - c(fC2)) * Math.abs(f8);
                    if (i11 == i10) {
                        fC2 *= 0.5f;
                    }
                    f5 = f7;
                    j6 = j7;
                }
            }
            fC = c(fC2);
        }
        return fC * 1000.0f;
    }

    public final float c(float f3) {
        return (float) (Math.signum(f3) * Math.sqrt(Math.abs(f3) * 2.0f));
    }
}
