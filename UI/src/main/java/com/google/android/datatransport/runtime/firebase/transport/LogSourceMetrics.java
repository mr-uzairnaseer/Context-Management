package com.google.android.datatransport.runtime.firebase.transport;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes4.dex */
public final class LogSourceMetrics {

    /* renamed from: c, reason: collision with root package name */
    public static final LogSourceMetrics f59234c = new Builder().a();

    /* renamed from: a, reason: collision with root package name */
    public final String f59235a;

    /* renamed from: b, reason: collision with root package name */
    public final List f59236b;

    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        public String f59237a = "";

        /* renamed from: b, reason: collision with root package name */
        public List f59238b = new ArrayList();

        public LogSourceMetrics a() {
            return new LogSourceMetrics(this.f59237a, Collections.unmodifiableList(this.f59238b));
        }

        public Builder b(List list) {
            this.f59238b = list;
            return this;
        }

        public Builder c(String str) {
            this.f59237a = str;
            return this;
        }
    }

    public LogSourceMetrics(String str, List list) {
        this.f59235a = str;
        this.f59236b = list;
    }

    public static Builder c() {
        return new Builder();
    }

    public List a() {
        return this.f59236b;
    }

    public String b() {
        return this.f59235a;
    }
}
