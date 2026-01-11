package com.google.android.datatransport.runtime.firebase.transport;

/* loaded from: classes4.dex */
public final class StorageMetrics {

    /* renamed from: c, reason: collision with root package name */
    public static final StorageMetrics f59239c = new Builder().a();

    /* renamed from: a, reason: collision with root package name */
    public final long f59240a;

    /* renamed from: b, reason: collision with root package name */
    public final long f59241b;

    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        public long f59242a = 0;

        /* renamed from: b, reason: collision with root package name */
        public long f59243b = 0;

        public StorageMetrics a() {
            return new StorageMetrics(this.f59242a, this.f59243b);
        }

        public Builder b(long j3) {
            this.f59242a = j3;
            return this;
        }

        public Builder c(long j3) {
            this.f59243b = j3;
            return this;
        }
    }

    public StorageMetrics(long j3, long j4) {
        this.f59240a = j3;
        this.f59241b = j4;
    }

    public static Builder c() {
        return new Builder();
    }

    public long a() {
        return this.f59240a;
    }

    public long b() {
        return this.f59241b;
    }
}
