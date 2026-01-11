package org.locationtech.jts;

/* loaded from: classes2.dex */
public class JTSVersion {
    public static final JTSVersion CURRENT_VERSION = new JTSVersion();
    public static final int MAJOR = 1;
    public static final int MINOR = 20;
    public static final int PATCH = 0;

    private JTSVersion() {
    }

    public String toString() {
        return "1.20.0";
    }
}
