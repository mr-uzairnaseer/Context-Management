package org.apache.commons.io.input;

/* loaded from: classes6.dex */
final class UnsupportedOperationExceptions {
    public static UnsupportedOperationException a() {
        return b("mark/reset");
    }

    public static UnsupportedOperationException b(String str) {
        return new UnsupportedOperationException(str + " not supported");
    }

    public static UnsupportedOperationException c() {
        return b("mark/reset");
    }
}
