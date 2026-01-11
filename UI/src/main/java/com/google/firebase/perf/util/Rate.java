package com.google.firebase.perf.util;

import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class Rate {

    /* renamed from: a, reason: collision with root package name */
    public long f73635a;

    /* renamed from: b, reason: collision with root package name */
    public long f73636b;

    /* renamed from: c, reason: collision with root package name */
    public TimeUnit f73637c;

    /* renamed from: com.google.firebase.perf.util.Rate$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f73638a;

        static {
            int[] iArr = new int[TimeUnit.values().length];
            f73638a = iArr;
            try {
                iArr[TimeUnit.NANOSECONDS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f73638a[TimeUnit.MICROSECONDS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f73638a[TimeUnit.MILLISECONDS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public Rate(long j3, long j4, TimeUnit timeUnit) {
        this.f73635a = j3;
        this.f73636b = j4;
        this.f73637c = timeUnit;
    }

    public double a() {
        int i3 = AnonymousClass1.f73638a[this.f73637c.ordinal()];
        return i3 != 1 ? i3 != 2 ? i3 != 3 ? this.f73635a / this.f73637c.toSeconds(this.f73636b) : (this.f73635a / this.f73636b) * TimeUnit.SECONDS.toMillis(1L) : (this.f73635a / this.f73636b) * TimeUnit.SECONDS.toMicros(1L) : (this.f73635a / this.f73636b) * TimeUnit.SECONDS.toNanos(1L);
    }
}
