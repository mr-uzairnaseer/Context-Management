package com.google.android.gms.appset;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes4.dex */
public class AppSetIdInfo {
    public static final int SCOPE_APP = 1;
    public static final int SCOPE_DEVELOPER = 2;

    /* renamed from: a, reason: collision with root package name */
    public final String f59540a;

    /* renamed from: b, reason: collision with root package name */
    public final int f59541b;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Scope {
    }

    public AppSetIdInfo(String str, int i3) {
        this.f59540a = str;
        this.f59541b = i3;
    }

    public String a() {
        return this.f59540a;
    }

    public int b() {
        return this.f59541b;
    }
}
