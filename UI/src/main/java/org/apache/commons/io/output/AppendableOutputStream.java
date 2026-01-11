package org.apache.commons.io.output;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.Appendable;

/* loaded from: classes6.dex */
public class AppendableOutputStream<T extends Appendable> extends OutputStream {

    /* renamed from: a, reason: collision with root package name */
    public final Appendable f161818a;

    @Override // java.io.OutputStream
    public void write(int i3) throws IOException {
        this.f161818a.append((char) i3);
    }
}
