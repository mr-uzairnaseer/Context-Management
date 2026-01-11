package androidx.credentials.provider.utils;

import android.content.pm.SigningInfo;
import android.service.credentials.CallingAppInfo;

/* loaded from: classes3.dex */
public abstract /* synthetic */ class c {
    public static /* synthetic */ CallingAppInfo a(String str, SigningInfo signingInfo, String str2) {
        return new CallingAppInfo(str, signingInfo, str2);
    }
}
