package androidx.content.preferences.protobuf;

import java.nio.Buffer;

/* loaded from: classes3.dex */
final class Java8Compatibility {
    private Java8Compatibility() {
    }

    public static void a(Buffer buffer, int i3) {
        buffer.limit(i3);
    }

    public static void b(Buffer buffer) {
        buffer.mark();
    }

    public static void c(Buffer buffer, int i3) {
        buffer.position(i3);
    }

    public static void d(Buffer buffer) {
        buffer.reset();
    }
}
