package androidx.security.crypto;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;

/* loaded from: classes4.dex */
public final class EncryptedFile {

    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        public static final Object f48430a = new Object();
    }

    public static final class EncryptedFileInputStream extends FileInputStream {

        /* renamed from: a, reason: collision with root package name */
        public final InputStream f48431a;

        /* renamed from: b, reason: collision with root package name */
        public final Object f48432b;

        @Override // java.io.FileInputStream, java.io.InputStream
        public int available() {
            return this.f48431a.available();
        }

        @Override // java.io.FileInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.f48431a.close();
        }

        @Override // java.io.FileInputStream
        public FileChannel getChannel() {
            throw new UnsupportedOperationException("For encrypted files, please open the relevant FileInput/FileOutputStream.");
        }

        @Override // java.io.InputStream
        public void mark(int i3) {
            synchronized (this.f48432b) {
                this.f48431a.mark(i3);
            }
        }

        @Override // java.io.InputStream
        public boolean markSupported() {
            return this.f48431a.markSupported();
        }

        @Override // java.io.FileInputStream, java.io.InputStream
        public int read() {
            return this.f48431a.read();
        }

        @Override // java.io.InputStream
        public void reset() {
            synchronized (this.f48432b) {
                this.f48431a.reset();
            }
        }

        @Override // java.io.FileInputStream, java.io.InputStream
        public long skip(long j3) {
            return this.f48431a.skip(j3);
        }

        @Override // java.io.FileInputStream, java.io.InputStream
        public int read(byte[] bArr) {
            return this.f48431a.read(bArr);
        }

        @Override // java.io.FileInputStream, java.io.InputStream
        public int read(byte[] bArr, int i3, int i4) {
            return this.f48431a.read(bArr, i3, i4);
        }
    }

    public static final class EncryptedFileOutputStream extends FileOutputStream {

        /* renamed from: a, reason: collision with root package name */
        public final OutputStream f48433a;

        @Override // java.io.FileOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.f48433a.close();
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() throws IOException {
            this.f48433a.flush();
        }

        @Override // java.io.FileOutputStream
        public FileChannel getChannel() {
            throw new UnsupportedOperationException("For encrypted files, please open the relevant FileInput/FileOutputStream.");
        }

        @Override // java.io.FileOutputStream, java.io.OutputStream
        public void write(byte[] bArr) throws IOException {
            this.f48433a.write(bArr);
        }

        @Override // java.io.FileOutputStream, java.io.OutputStream
        public void write(int i3) throws IOException {
            this.f48433a.write(i3);
        }

        @Override // java.io.FileOutputStream, java.io.OutputStream
        public void write(byte[] bArr, int i3, int i4) throws IOException {
            this.f48433a.write(bArr, i3, i4);
        }
    }

    public enum FileEncryptionScheme {
        AES256_GCM_HKDF_4KB("AES256_GCM_HKDF_4KB");

        private final String mKeyTemplateName;

        FileEncryptionScheme(String str) {
            this.mKeyTemplateName = str;
        }
    }
}
