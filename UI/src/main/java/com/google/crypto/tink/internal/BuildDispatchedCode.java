package com.google.crypto.tink.internal;

import android.os.Build;

/* loaded from: classes5.dex */
final class BuildDispatchedCode {
    private BuildDispatchedCode() {
    }

    public static Integer a() {
        return Integer.valueOf(Build.VERSION.SDK_INT);
    }
}
