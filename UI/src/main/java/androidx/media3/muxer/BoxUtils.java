package androidx.media3.muxer;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.List;

/* loaded from: classes3.dex */
final class BoxUtils {
    private BoxUtils() {
    }

    public static ByteBuffer a(ByteBuffer... byteBufferArr) {
        int iRemaining = 0;
        for (ByteBuffer byteBuffer : byteBufferArr) {
            iRemaining += byteBuffer.remaining();
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(iRemaining);
        for (ByteBuffer byteBuffer2 : byteBufferArr) {
            byteBufferAllocate.put(byteBuffer2);
        }
        byteBufferAllocate.flip();
        return byteBufferAllocate;
    }

    public static ByteBuffer b(String str, List list) {
        int iRemaining = 8;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iRemaining += ((ByteBuffer) list.get(i3)).remaining();
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(iRemaining);
        byteBufferAllocate.putInt(iRemaining);
        byteBufferAllocate.put(str.getBytes(StandardCharsets.UTF_8), 0, 4);
        for (int i4 = 0; i4 < list.size(); i4++) {
            byteBufferAllocate.put((ByteBuffer) list.get(i4));
        }
        byteBufferAllocate.flip();
        return byteBufferAllocate;
    }

    public static ByteBuffer c(String str, ByteBuffer byteBuffer) {
        return d(str.getBytes(StandardCharsets.UTF_8), byteBuffer);
    }

    public static ByteBuffer d(byte[] bArr, ByteBuffer byteBuffer) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(byteBuffer.remaining() + 8);
        byteBufferAllocate.putInt(byteBuffer.remaining() + 8);
        byteBufferAllocate.put(bArr, 0, 4);
        byteBufferAllocate.put(byteBuffer);
        byteBufferAllocate.flip();
        return byteBufferAllocate;
    }
}
