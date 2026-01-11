package org.apache.commons.compress.archivers.zip;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SeekableByteChannel;

/* loaded from: classes5.dex */
class ZipIoUtil {
    private ZipIoUtil() {
    }

    public static void a(SeekableByteChannel seekableByteChannel, ByteBuffer byteBuffer) throws IOException {
        while (byteBuffer.hasRemaining()) {
            int iRemaining = byteBuffer.remaining();
            int iWrite = seekableByteChannel.write(byteBuffer);
            if (iWrite <= 0) {
                throw new IOException("Failed to fully write: channel=" + seekableByteChannel + " length=" + iRemaining + " written=" + iWrite);
            }
        }
    }

    public static void b(FileChannel fileChannel, ByteBuffer byteBuffer, long j3) throws IOException {
        while (byteBuffer.hasRemaining()) {
            int iRemaining = byteBuffer.remaining();
            int iWrite = fileChannel.write(byteBuffer, j3);
            if (iWrite <= 0) {
                throw new IOException("Failed to fully write: channel=" + fileChannel + " length=" + iRemaining + " written=" + iWrite);
            }
            j3 += iWrite;
        }
    }
}
