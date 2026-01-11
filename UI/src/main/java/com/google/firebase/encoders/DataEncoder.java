package com.google.firebase.encoders;

import java.io.Writer;

/* loaded from: classes.dex */
public interface DataEncoder {
    String b(Object obj);

    void c(Object obj, Writer writer);
}
