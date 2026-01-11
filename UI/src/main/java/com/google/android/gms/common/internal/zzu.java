package com.google.android.gms.common.internal;

import android.net.Uri;

/* loaded from: classes4.dex */
public final class zzu {

    /* renamed from: a, reason: collision with root package name */
    public static final Uri f60592a;

    /* renamed from: b, reason: collision with root package name */
    public static final Uri f60593b;
    public static final /* synthetic */ int zza = 0;

    static {
        Uri uri = Uri.parse("https://plus.google.com/");
        f60592a = uri;
        f60593b = uri.buildUpon().appendPath("circles").appendPath("find").build();
    }
}
