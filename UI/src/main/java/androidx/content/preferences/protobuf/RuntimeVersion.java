package androidx.content.preferences.protobuf;

import java.util.logging.Logger;

/* loaded from: classes3.dex */
public final class RuntimeVersion {
    public static final RuntimeDomain DOMAIN;
    public static final int MAJOR = 4;
    public static final int MINOR = 28;
    public static final RuntimeDomain OSS_DOMAIN;
    public static final int OSS_MAJOR = 4;
    public static final int OSS_MINOR = 28;
    public static final int OSS_PATCH = 2;
    public static final String OSS_SUFFIX = "";
    public static final int PATCH = 2;
    public static final String SUFFIX = "";

    /* renamed from: a, reason: collision with root package name */
    public static final String f35265a;

    /* renamed from: b, reason: collision with root package name */
    public static final Logger f35266b;

    public static final class ProtobufRuntimeVersionException extends RuntimeException {
    }

    public enum RuntimeDomain {
        GOOGLE_INTERNAL,
        PUBLIC
    }

    static {
        RuntimeDomain runtimeDomain = RuntimeDomain.PUBLIC;
        OSS_DOMAIN = runtimeDomain;
        DOMAIN = runtimeDomain;
        f35265a = a(4, 28, 2, "");
        f35266b = Logger.getLogger(RuntimeVersion.class.getName());
    }

    private RuntimeVersion() {
    }

    public static String a(int i3, int i4, int i5, String str) {
        return String.format("%d.%d.%d%s", Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), str);
    }
}
