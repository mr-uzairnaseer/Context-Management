package com.google.android.gms.internal.auth;

import android.net.Uri;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;

/* loaded from: classes4.dex */
public final class zzcb {
    public static final Uri zza = Uri.parse("content://com.google.android.gsf.gservices");
    public static final Uri zzb = Uri.parse("content://com.google.android.gsf.gservices/prefix");
    public static final Pattern zzc = Pattern.compile("^(1|true|t|on|yes|y)$", 2);
    public static final Pattern zzd = Pattern.compile("^(0|false|f|off|no|n)$", 2);

    /* renamed from: a, reason: collision with root package name */
    public static final AtomicBoolean f61231a = new AtomicBoolean();

    /* renamed from: b, reason: collision with root package name */
    public static final HashMap f61232b = new HashMap(16, 1.0f);

    /* renamed from: c, reason: collision with root package name */
    public static final HashMap f61233c = new HashMap(16, 1.0f);

    /* renamed from: d, reason: collision with root package name */
    public static final HashMap f61234d = new HashMap(16, 1.0f);

    /* renamed from: e, reason: collision with root package name */
    public static final HashMap f61235e = new HashMap(16, 1.0f);

    /* renamed from: f, reason: collision with root package name */
    public static final String[] f61236f = new String[0];
}
