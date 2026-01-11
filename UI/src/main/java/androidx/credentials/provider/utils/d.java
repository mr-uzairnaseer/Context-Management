package androidx.credentials.provider.utils;

import android.os.Bundle;
import android.service.credentials.BeginCreateCredentialRequest;
import android.service.credentials.CallingAppInfo;

/* loaded from: classes3.dex */
public abstract /* synthetic */ class d {
    public static /* synthetic */ BeginCreateCredentialRequest a(String str, Bundle bundle, CallingAppInfo callingAppInfo) {
        return new BeginCreateCredentialRequest(str, bundle, callingAppInfo);
    }
}
