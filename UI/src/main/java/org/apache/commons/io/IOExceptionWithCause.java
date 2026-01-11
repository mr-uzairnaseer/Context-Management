package org.apache.commons.io;

import java.io.IOException;

@Deprecated
/* loaded from: classes6.dex */
public class IOExceptionWithCause extends IOException {
    public IOExceptionWithCause(String str, Throwable th) {
        super(str, th);
    }
}
