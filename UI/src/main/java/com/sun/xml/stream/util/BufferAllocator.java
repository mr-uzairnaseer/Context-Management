package com.sun.xml.stream.util;

/* loaded from: classes5.dex */
public class BufferAllocator {
    public static int LARGE_SIZE_LIMIT = 8192;
    public static int MEDIUM_SIZE_LIMIT = 2048;
    public static int SMALL_SIZE_LIMIT = 128;
    byte[] largeByteBuffer;
    char[] largeCharBuffer;
    byte[] mediumByteBuffer;
    char[] mediumCharBuffer;
    byte[] smallByteBuffer;
    char[] smallCharBuffer;

    public byte[] getByteBuffer(int i3) {
        if (i3 <= SMALL_SIZE_LIMIT) {
            byte[] bArr = this.smallByteBuffer;
            this.smallByteBuffer = null;
            return bArr;
        }
        if (i3 <= MEDIUM_SIZE_LIMIT) {
            byte[] bArr2 = this.mediumByteBuffer;
            this.mediumByteBuffer = null;
            return bArr2;
        }
        if (i3 > LARGE_SIZE_LIMIT) {
            return null;
        }
        byte[] bArr3 = this.largeByteBuffer;
        this.largeByteBuffer = null;
        return bArr3;
    }

    public char[] getCharBuffer(int i3) {
        if (i3 <= SMALL_SIZE_LIMIT) {
            char[] cArr = this.smallCharBuffer;
            this.smallCharBuffer = null;
            return cArr;
        }
        if (i3 <= MEDIUM_SIZE_LIMIT) {
            char[] cArr2 = this.mediumCharBuffer;
            this.mediumCharBuffer = null;
            return cArr2;
        }
        if (i3 > LARGE_SIZE_LIMIT) {
            return null;
        }
        char[] cArr3 = this.largeCharBuffer;
        this.largeCharBuffer = null;
        return cArr3;
    }

    public void returnByteBuffer(byte[] bArr) {
        if (bArr == null) {
            return;
        }
        if (bArr.length <= SMALL_SIZE_LIMIT) {
            this.smallByteBuffer = bArr;
        } else if (bArr.length <= MEDIUM_SIZE_LIMIT) {
            this.mediumByteBuffer = bArr;
        } else if (bArr.length <= LARGE_SIZE_LIMIT) {
            this.largeByteBuffer = bArr;
        }
    }

    public void returnCharBuffer(char[] cArr) {
        if (cArr == null) {
            return;
        }
        if (cArr.length <= SMALL_SIZE_LIMIT) {
            this.smallCharBuffer = cArr;
        } else if (cArr.length <= MEDIUM_SIZE_LIMIT) {
            this.mediumCharBuffer = cArr;
        } else if (cArr.length <= LARGE_SIZE_LIMIT) {
            this.largeCharBuffer = cArr;
        }
    }
}
