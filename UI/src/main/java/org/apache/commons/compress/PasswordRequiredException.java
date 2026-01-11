package org.apache.commons.compress;

import java.io.IOException;

/* loaded from: classes5.dex */
public class PasswordRequiredException extends IOException {
    public PasswordRequiredException(String str) {
        super("Cannot read encrypted content from " + str + " without a password.");
    }
}
