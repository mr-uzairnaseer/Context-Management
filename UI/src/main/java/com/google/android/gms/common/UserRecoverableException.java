package com.google.android.gms.common;

import android.content.Intent;

/* loaded from: classes4.dex */
public class UserRecoverableException extends Exception {

    /* renamed from: a, reason: collision with root package name */
    public final Intent f59912a;

    public UserRecoverableException(String str, Intent intent) {
        super(str);
        this.f59912a = intent;
    }
}
