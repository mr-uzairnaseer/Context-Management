package org.apache.commons.io.charset;

import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.function.Supplier;

/* loaded from: classes6.dex */
public final class CharsetEncoders {
    private CharsetEncoders() {
    }

    public static CharsetEncoder b(CharsetEncoder charsetEncoder) {
        return c(charsetEncoder, new Supplier() { // from class: org.apache.commons.io.charset.a
            @Override // java.util.function.Supplier
            public final Object get() {
                return Charset.defaultCharset().newEncoder();
            }
        });
    }

    public static CharsetEncoder c(CharsetEncoder charsetEncoder, Supplier supplier) {
        return charsetEncoder != null ? charsetEncoder : (CharsetEncoder) supplier.get();
    }
}
