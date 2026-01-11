package com.google.android.recaptcha.internal;

import java.io.IOException;
import java.util.Locale;

/* loaded from: classes4.dex */
public final class zzmu extends IOException {
    public zzmu() {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.");
    }

    public zzmu(long j3, long j4, int i3, Throwable th) {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.: ".concat(String.format(Locale.US, "Pos: %d, limit: %d, len: %d", Long.valueOf(j3), Long.valueOf(j4), Integer.valueOf(i3))), th);
    }

    public zzmu(Throwable th) {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
    }
}
