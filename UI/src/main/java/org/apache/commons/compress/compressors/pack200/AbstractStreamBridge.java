package org.apache.commons.compress.compressors.pack200;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes5.dex */
abstract class AbstractStreamBridge extends FilterOutputStream {

    /* renamed from: a, reason: collision with root package name */
    public InputStream f160799a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f160800b;

    public AbstractStreamBridge() {
        this(null);
    }

    public abstract InputStream a();

    public InputStream c() {
        synchronized (this.f160800b) {
            try {
                if (this.f160799a == null) {
                    this.f160799a = a();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return this.f160799a;
    }

    public void d() throws IOException {
        close();
        synchronized (this.f160800b) {
            try {
                InputStream inputStream = this.f160799a;
                if (inputStream != null) {
                    inputStream.close();
                    this.f160799a = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public AbstractStreamBridge(OutputStream outputStream) {
        super(outputStream);
        this.f160800b = new Object();
    }
}
