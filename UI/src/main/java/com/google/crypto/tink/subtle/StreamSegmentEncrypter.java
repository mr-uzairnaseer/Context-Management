package com.google.crypto.tink.subtle;

import java.nio.ByteBuffer;

/* loaded from: classes5.dex */
public interface StreamSegmentEncrypter {
    void a(ByteBuffer byteBuffer, boolean z2, ByteBuffer byteBuffer2);

    void b(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, boolean z2, ByteBuffer byteBuffer3);
}
