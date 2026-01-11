package com.google.firebase.messaging;

import java.util.Locale;

/* loaded from: classes5.dex */
public final class SendException extends Exception {
    public static final int ERROR_INVALID_PARAMETERS = 1;
    public static final int ERROR_SIZE = 2;
    public static final int ERROR_TOO_MANY_MESSAGES = 4;
    public static final int ERROR_TTL_EXCEEDED = 3;
    public static final int ERROR_UNKNOWN = 0;

    /* renamed from: a, reason: collision with root package name */
    public final int f73176a;

    public SendException(String str) {
        super(str);
        this.f73176a = a(str);
    }

    public final int a(String str) {
        if (str == null) {
            return 0;
        }
        String lowerCase = str.toLowerCase(Locale.US);
        lowerCase.getClass();
        switch (lowerCase) {
        }
        return 0;
    }
}
