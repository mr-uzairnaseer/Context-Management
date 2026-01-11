package com.google.crypto.tink;

import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.SeekableByteChannel;

/* loaded from: classes5.dex */
public interface StreamingAead {
    SeekableByteChannel a(SeekableByteChannel seekableByteChannel, byte[] bArr);

    ReadableByteChannel b(ReadableByteChannel readableByteChannel, byte[] bArr);

    InputStream c(InputStream inputStream, byte[] bArr);
}
