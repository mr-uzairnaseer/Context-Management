package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.os.Process;
import android.os.UserManager;
import android.util.Log;

/* loaded from: classes4.dex */
public class zzhd {

    /* renamed from: a, reason: collision with root package name */
    public static UserManager f62140a;

    /* renamed from: b, reason: collision with root package name */
    public static volatile boolean f62141b = !a();

    private zzhd() {
    }

    public static boolean a() {
        return true;
    }

    public static boolean b(Context context) {
        return a() && !d(context);
    }

    public static boolean c(Context context) {
        return !a() || d(context);
    }

    public static boolean d(Context context) {
        if (f62141b) {
            return true;
        }
        synchronized (zzhd.class) {
            try {
                if (f62141b) {
                    return true;
                }
                boolean zE = e(context);
                if (zE) {
                    f62141b = zE;
                }
                return zE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static boolean e(Context context) {
        boolean z2;
        boolean z3 = true;
        int i3 = 1;
        while (true) {
            z2 = false;
            if (i3 > 2) {
                break;
            }
            if (f62140a == null) {
                f62140a = (UserManager) context.getSystemService(UserManager.class);
            }
            UserManager userManager = f62140a;
            if (userManager == null) {
                return true;
            }
            try {
                if (userManager.isUserUnlocked()) {
                    break;
                }
                if (userManager.isUserRunning(Process.myUserHandle())) {
                    z3 = false;
                }
            } catch (NullPointerException e3) {
                Log.w("DirectBootUtils", "Failed to check if user is unlocked.", e3);
                f62140a = null;
                i3++;
            }
        }
        z2 = z3;
        if (z2) {
            f62140a = null;
        }
        return z2;
    }
}
