package org.apache.commons.io;

import java.io.IOException;

/* loaded from: classes6.dex */
public class IOIndexedException extends IOException {

    /* renamed from: a, reason: collision with root package name */
    public final int f161353a;

    public IOIndexedException(int i3, Throwable th) {
        super(a(i3, th), th);
        this.f161353a = i3;
    }

    public static String a(int i3, Throwable th) {
        return String.format("%s #%,d: %s", th == null ? "Null" : th.getClass().getSimpleName(), Integer.valueOf(i3), th != null ? th.getMessage() : "Null");
    }
}
