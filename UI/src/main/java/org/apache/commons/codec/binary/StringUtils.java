package org.apache.commons.codec.binary;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/* loaded from: classes4.dex */
public class StringUtils {
    @Deprecated
    public StringUtils() {
    }

    public static String a(byte[] bArr, Charset charset) {
        if (bArr == null) {
            return null;
        }
        return new String(bArr, charset);
    }

    public static String b(byte[] bArr) {
        return a(bArr, StandardCharsets.US_ASCII);
    }

    public static String c(byte[] bArr) {
        return a(bArr, StandardCharsets.UTF_8);
    }
}
