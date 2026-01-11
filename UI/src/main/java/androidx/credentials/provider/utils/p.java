package androidx.credentials.provider.utils;

import android.app.slice.Slice;
import android.service.credentials.BeginGetCredentialOption;
import android.service.credentials.CredentialEntry;

/* loaded from: classes3.dex */
public abstract /* synthetic */ class p {
    public static /* synthetic */ CredentialEntry a(BeginGetCredentialOption beginGetCredentialOption, Slice slice) {
        return new CredentialEntry(beginGetCredentialOption, slice);
    }
}
