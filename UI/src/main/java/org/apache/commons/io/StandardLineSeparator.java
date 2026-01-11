package org.apache.commons.io;

import java.nio.charset.Charset;
import java.util.Objects;
import org.apache.commons.lang3.StringUtils;
import org.json.HTTP;

/* loaded from: classes6.dex */
public enum StandardLineSeparator {
    CR(StringUtils.CR),
    CRLF(HTTP.CRLF),
    LF(StringUtils.LF);

    private final String lineSeparator;

    StandardLineSeparator(String str) {
        Objects.requireNonNull(str, "lineSeparator");
        this.lineSeparator = str;
    }

    public byte[] c(Charset charset) {
        return this.lineSeparator.getBytes(charset);
    }

    public String d() {
        return this.lineSeparator;
    }
}
