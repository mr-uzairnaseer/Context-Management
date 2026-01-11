package com.google.firebase.crashlytics.internal.common;

import android.content.Context;

/* loaded from: classes.dex */
class InstallerPackageNameProvider {

    /* renamed from: a, reason: collision with root package name */
    public String f72260a;

    public static String b(Context context) {
        String installerPackageName = context.getPackageManager().getInstallerPackageName(context.getPackageName());
        return installerPackageName == null ? "" : installerPackageName;
    }

    public synchronized String a(Context context) {
        try {
            if (this.f72260a == null) {
                this.f72260a = b(context);
            }
        } finally {
        }
        return "".equals(this.f72260a) ? null : this.f72260a;
    }
}
