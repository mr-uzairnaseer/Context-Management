package com.google.firebase.crashlytics.internal.settings;

/* loaded from: classes.dex */
public class Settings {

    /* renamed from: a, reason: collision with root package name */
    public final SessionData f72858a;

    /* renamed from: b, reason: collision with root package name */
    public final FeatureFlagData f72859b;

    /* renamed from: c, reason: collision with root package name */
    public final long f72860c;

    /* renamed from: d, reason: collision with root package name */
    public final int f72861d;

    /* renamed from: e, reason: collision with root package name */
    public final int f72862e;

    /* renamed from: f, reason: collision with root package name */
    public final double f72863f;

    /* renamed from: g, reason: collision with root package name */
    public final double f72864g;

    /* renamed from: h, reason: collision with root package name */
    public final int f72865h;

    public static class FeatureFlagData {

        /* renamed from: a, reason: collision with root package name */
        public final boolean f72866a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f72867b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f72868c;

        public FeatureFlagData(boolean z2, boolean z3, boolean z4) {
            this.f72866a = z2;
            this.f72867b = z3;
            this.f72868c = z4;
        }
    }

    public static class SessionData {

        /* renamed from: a, reason: collision with root package name */
        public final int f72869a;

        /* renamed from: b, reason: collision with root package name */
        public final int f72870b;

        public SessionData(int i3, int i4) {
            this.f72869a = i3;
            this.f72870b = i4;
        }
    }

    public Settings(long j3, SessionData sessionData, FeatureFlagData featureFlagData, int i3, int i4, double d3, double d4, int i5) {
        this.f72860c = j3;
        this.f72858a = sessionData;
        this.f72859b = featureFlagData;
        this.f72861d = i3;
        this.f72862e = i4;
        this.f72863f = d3;
        this.f72864g = d4;
        this.f72865h = i5;
    }

    public boolean a(long j3) {
        return this.f72860c < j3;
    }
}
