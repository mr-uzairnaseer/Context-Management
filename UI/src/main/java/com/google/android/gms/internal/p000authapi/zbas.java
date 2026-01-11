package com.google.android.gms.internal.p000authapi;

import android.util.Base64;
import java.security.SecureRandom;

/* loaded from: classes4.dex */
public final class zbas {

    /* renamed from: a, reason: collision with root package name */
    public static final SecureRandom f61178a = new SecureRandom();

    public static String a() {
        byte[] bArr = new byte[16];
        f61178a.nextBytes(bArr);
        return Base64.encodeToString(bArr, 11);
    }
}
