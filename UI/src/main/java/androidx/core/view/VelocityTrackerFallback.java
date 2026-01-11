package androidx.core.view;

import android.view.MotionEvent;

/* loaded from: classes3.dex */
class VelocityTrackerFallback {

    /* renamed from: a, reason: collision with root package name */
    public final float[] f33741a = new float[20];

    /* renamed from: b, reason: collision with root package name */
    public final long[] f33742b = new long[20];

    /* renamed from: c, reason: collision with root package name */
    public float f33743c = 0.0f;

    /* renamed from: d, reason: collision with root package name */
    public int f33744d = 0;

    /* renamed from: e, reason: collision with root package name */
    public int f33745e = 0;

    public static float f(float f3) {
        return (f3 < 0.0f ? -1.0f : 1.0f) * ((float) Math.sqrt(Math.abs(f3) * 2.0f));
    }

    public void a(MotionEvent motionEvent) {
        long eventTime = motionEvent.getEventTime();
        if (this.f33744d != 0 && eventTime - this.f33742b[this.f33745e] > 40) {
            b();
        }
        int i3 = (this.f33745e + 1) % 20;
        this.f33745e = i3;
        int i4 = this.f33744d;
        if (i4 != 20) {
            this.f33744d = i4 + 1;
        }
        this.f33741a[i3] = motionEvent.getAxisValue(26);
        this.f33742b[this.f33745e] = eventTime;
    }

    public final void b() {
        this.f33744d = 0;
        this.f33743c = 0.0f;
    }

    public void c(int i3, float f3) {
        float fE = e() * i3;
        this.f33743c = fE;
        if (fE < (-Math.abs(f3))) {
            this.f33743c = -Math.abs(f3);
        } else if (this.f33743c > Math.abs(f3)) {
            this.f33743c = Math.abs(f3);
        }
    }

    public float d(int i3) {
        if (i3 != 26) {
            return 0.0f;
        }
        return this.f33743c;
    }

    public final float e() {
        long[] jArr;
        long j3;
        int i3 = this.f33744d;
        if (i3 < 2) {
            return 0.0f;
        }
        int i4 = this.f33745e;
        int i5 = ((i4 + 20) - (i3 - 1)) % 20;
        long j4 = this.f33742b[i4];
        while (true) {
            jArr = this.f33742b;
            j3 = jArr[i5];
            if (j4 - j3 <= 100) {
                break;
            }
            this.f33744d--;
            i5 = (i5 + 1) % 20;
        }
        int i6 = this.f33744d;
        if (i6 < 2) {
            return 0.0f;
        }
        if (i6 == 2) {
            int i7 = (i5 + 1) % 20;
            if (j3 == jArr[i7]) {
                return 0.0f;
            }
            return this.f33741a[i7] / (r2 - j3);
        }
        float fAbs = 0.0f;
        int i8 = 0;
        for (int i9 = 0; i9 < this.f33744d - 1; i9++) {
            int i10 = i9 + i5;
            long[] jArr2 = this.f33742b;
            long j5 = jArr2[i10 % 20];
            int i11 = (i10 + 1) % 20;
            if (jArr2[i11] != j5) {
                i8++;
                float f3 = f(fAbs);
                float f4 = this.f33741a[i11] / (this.f33742b[i11] - j5);
                fAbs += (f4 - f3) * Math.abs(f4);
                if (i8 == 1) {
                    fAbs *= 0.5f;
                }
            }
        }
        return f(fAbs);
    }
}
