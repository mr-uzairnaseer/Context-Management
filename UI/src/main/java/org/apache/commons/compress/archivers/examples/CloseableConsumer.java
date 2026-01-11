package org.apache.commons.compress.archivers.examples;

import java.io.Closeable;
import java.io.IOException;

/* loaded from: classes5.dex */
public interface CloseableConsumer {
    public static final CloseableConsumer CLOSING_CONSUMER = new CloseableConsumer() { // from class: org.apache.commons.compress.archivers.examples.a
        @Override // org.apache.commons.compress.archivers.examples.CloseableConsumer
        public final void b(Closeable closeable) throws IOException {
            closeable.close();
        }
    };
    public static final CloseableConsumer NULL_CONSUMER = new CloseableConsumer() { // from class: org.apache.commons.compress.archivers.examples.b
        @Override // org.apache.commons.compress.archivers.examples.CloseableConsumer
        public final void b(Closeable closeable) {
            CloseableConsumer.a(closeable);
        }
    };

    static /* synthetic */ void a(Closeable closeable) {
    }

    void b(Closeable closeable);
}
