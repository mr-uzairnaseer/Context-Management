package com.google.android.recaptcha.internal;

import java.io.IOException;

/* loaded from: classes4.dex */
public class zzox extends IOException {
    private boolean zza;

    public zzox(IOException iOException) {
        super(iOException.getMessage(), iOException);
    }

    public final void zza() {
        this.zza = true;
    }

    public final boolean zzb() {
        return this.zza;
    }

    public zzox(String str) {
        super(str);
    }
}
