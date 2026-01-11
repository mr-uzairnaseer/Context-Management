package com.google.android.datatransport.runtime.firebase.transport;

/* loaded from: classes4.dex */
public final class TimeWindow {

    /* renamed from: c, reason: collision with root package name */
    public static final TimeWindow f59244c = new Builder().a();

    /* renamed from: a, reason: collision with root package name */
    public final long f59245a;

    /* renamed from: b, reason: collision with root package name */
    public final long f59246b;

    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        public long f59247a = 0;

        /* renamed from: b, reason: collision with root package name */
        public long f59248b = 0;

        public TimeWindow a() {
            return new TimeWindow(this.f59247a, this.f59248b);
        }

        public Builder b(long j3) {
            this.f59248b = j3;
            return this;
        }

        public Builder c(long j3) {
            this.f59247a = j3;
            return this;
        }
    }

    public TimeWindow(long j3, long j4) {
        this.f59245a = j3;
        this.f59246b = j4;
    }

    public static Builder c() {
        return new Builder();
    }

    public long a() {
        return this.f59246b;
    }

    public long b() {
        return this.f59245a;
    }
}
