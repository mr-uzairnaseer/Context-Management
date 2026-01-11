package freemarker.debug;

import java.rmi.Remote;

/* loaded from: classes8.dex */
public interface DebugModel extends Remote {
    public static final int TYPE_BOOLEAN = 8;
    public static final int TYPE_COLLECTION = 32;
    public static final int TYPE_CONFIGURATION = 8192;
    public static final int TYPE_DATE = 4;
    public static final int TYPE_ENVIRONMENT = 2048;
    public static final int TYPE_HASH = 64;
    public static final int TYPE_HASH_EX = 128;
    public static final int TYPE_METHOD = 256;
    public static final int TYPE_METHOD_EX = 512;
    public static final int TYPE_NUMBER = 2;
    public static final int TYPE_SCALAR = 1;
    public static final int TYPE_SEQUENCE = 16;
    public static final int TYPE_TEMPLATE = 4096;
    public static final int TYPE_TRANSFORM = 1024;
}
