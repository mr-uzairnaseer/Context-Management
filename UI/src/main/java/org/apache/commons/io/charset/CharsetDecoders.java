package org.apache.commons.io.charset;

import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

/* loaded from: classes6.dex */
public final class CharsetDecoders {
    private CharsetDecoders() {
    }

    public static CharsetDecoder a(CharsetDecoder charsetDecoder) {
        return charsetDecoder != null ? charsetDecoder : Charset.defaultCharset().newDecoder();
    }
}
