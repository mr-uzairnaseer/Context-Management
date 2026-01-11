package org.apache.commons.codec;

import java.io.InputStream;

/* loaded from: classes4.dex */
public class Resources {
    @Deprecated
    public Resources() {
    }

    public static InputStream a(String str) {
        InputStream resourceAsStream = Resources.class.getResourceAsStream(str);
        if (resourceAsStream != null) {
            return resourceAsStream;
        }
        throw new IllegalArgumentException("Unable to resolve required resource: " + str);
    }
}
