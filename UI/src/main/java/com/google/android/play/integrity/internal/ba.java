package com.google.android.play.integrity.internal;

/* loaded from: classes4.dex */
public final class ba {
    public static void a(Object obj, Class cls) {
        if (obj == null) {
            throw new IllegalStateException(String.valueOf(cls.getCanonicalName()).concat(" must be set"));
        }
    }
}
