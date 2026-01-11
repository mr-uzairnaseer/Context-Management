package com.google.firebase.crashlytics.internal.metadata;

import android.support.v4.media.session.PlaybackStateCompat;
import de.komoot.android.services.api.RequestParameters;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes.dex */
class QueueFile implements Closeable {

    /* renamed from: g, reason: collision with root package name */
    public static final Logger f72338g = Logger.getLogger(QueueFile.class.getName());

    /* renamed from: a, reason: collision with root package name */
    public final RandomAccessFile f72339a;

    /* renamed from: b, reason: collision with root package name */
    public int f72340b;

    /* renamed from: c, reason: collision with root package name */
    public int f72341c;

    /* renamed from: d, reason: collision with root package name */
    public Element f72342d;

    /* renamed from: e, reason: collision with root package name */
    public Element f72343e;

    /* renamed from: f, reason: collision with root package name */
    public final byte[] f72344f = new byte[16];

    public static class Element {

        /* renamed from: c, reason: collision with root package name */
        public static final Element f72348c = new Element(0, 0);

        /* renamed from: a, reason: collision with root package name */
        public final int f72349a;

        /* renamed from: b, reason: collision with root package name */
        public final int f72350b;

        public Element(int i3, int i4) {
            this.f72349a = i3;
            this.f72350b = i4;
        }

        public String toString() {
            return getClass().getSimpleName() + "[position = " + this.f72349a + ", length = " + this.f72350b + "]";
        }
    }

    /* loaded from: classes5.dex */
    public final class ElementInputStream extends InputStream {

        /* renamed from: a, reason: collision with root package name */
        public int f72351a;

        /* renamed from: b, reason: collision with root package name */
        public int f72352b;

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i3, int i4) throws IOException {
            QueueFile.p(bArr, RequestParameters.BUFFER);
            if ((i3 | i4) < 0 || i4 > bArr.length - i3) {
                throw new ArrayIndexOutOfBoundsException();
            }
            int i5 = this.f72352b;
            if (i5 <= 0) {
                return -1;
            }
            if (i4 > i5) {
                i4 = i5;
            }
            QueueFile.this.x(this.f72351a, bArr, i3, i4);
            this.f72351a = QueueFile.this.C(this.f72351a + i4);
            this.f72352b -= i4;
            return i4;
        }

        public ElementInputStream(Element element) {
            this.f72351a = QueueFile.this.C(element.f72349a + 4);
            this.f72352b = element.f72350b;
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            if (this.f72352b == 0) {
                return -1;
            }
            QueueFile.this.f72339a.seek(this.f72351a);
            int i3 = QueueFile.this.f72339a.read();
            this.f72351a = QueueFile.this.C(this.f72351a + 1);
            this.f72352b--;
            return i3;
        }
    }

    /* loaded from: classes5.dex */
    public interface ElementReader {
        void a(InputStream inputStream, int i3);
    }

    public QueueFile(File file) throws IOException {
        if (!file.exists()) {
            n(file);
        }
        this.f72339a = q(file);
        s();
    }

    public static void E(byte[] bArr, int i3, int i4) {
        bArr[i3] = (byte) (i4 >> 24);
        bArr[i3 + 1] = (byte) (i4 >> 16);
        bArr[i3 + 2] = (byte) (i4 >> 8);
        bArr[i3 + 3] = (byte) i4;
    }

    public static void F(byte[] bArr, int... iArr) {
        int i3 = 0;
        for (int i4 : iArr) {
            E(bArr, i3, i4);
            i3 += 4;
        }
    }

    public static void n(File file) throws IOException {
        File file2 = new File(file.getPath() + ".tmp");
        RandomAccessFile randomAccessFileQ = q(file2);
        try {
            randomAccessFileQ.setLength(PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM);
            randomAccessFileQ.seek(0L);
            byte[] bArr = new byte[16];
            F(bArr, 4096, 0, 0, 0);
            randomAccessFileQ.write(bArr);
            randomAccessFileQ.close();
            if (!file2.renameTo(file)) {
                throw new IOException("Rename failed!");
            }
        } catch (Throwable th) {
            randomAccessFileQ.close();
            throw th;
        }
    }

    public static Object p(Object obj, String str) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(str);
    }

    public static RandomAccessFile q(File file) {
        return new RandomAccessFile(file, "rwd");
    }

    public static int u(byte[] bArr, int i3) {
        return ((bArr[i3] & 255) << 24) + ((bArr[i3 + 1] & 255) << 16) + ((bArr[i3 + 2] & 255) << 8) + (bArr[i3 + 3] & 255);
    }

    public int B() {
        if (this.f72341c == 0) {
            return 16;
        }
        Element element = this.f72343e;
        int i3 = element.f72349a;
        int i4 = this.f72342d.f72349a;
        return i3 >= i4 ? (i3 - i4) + 4 + element.f72350b + 16 : (((i3 + 4) + element.f72350b) + this.f72340b) - i4;
    }

    public final int C(int i3) {
        int i4 = this.f72340b;
        return i3 < i4 ? i3 : (i3 + 16) - i4;
    }

    public final void D(int i3, int i4, int i5, int i6) throws IOException {
        F(this.f72344f, i3, i4, i5, i6);
        this.f72339a.seek(0L);
        this.f72339a.write(this.f72344f);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        this.f72339a.close();
    }

    public void f(byte[] bArr) {
        g(bArr, 0, bArr.length);
    }

    public synchronized void g(byte[] bArr, int i3, int i4) {
        int iC;
        try {
            p(bArr, RequestParameters.BUFFER);
            if ((i3 | i4) < 0 || i4 > bArr.length - i3) {
                throw new IndexOutOfBoundsException();
            }
            j(i4);
            boolean zO = o();
            if (zO) {
                iC = 16;
            } else {
                Element element = this.f72343e;
                iC = C(element.f72349a + 4 + element.f72350b);
            }
            Element element2 = new Element(iC, i4);
            E(this.f72344f, 0, i4);
            y(element2.f72349a, this.f72344f, 0, 4);
            y(element2.f72349a + 4, bArr, i3, i4);
            D(this.f72340b, this.f72341c + 1, zO ? element2.f72349a : this.f72342d.f72349a, element2.f72349a);
            this.f72343e = element2;
            this.f72341c++;
            if (zO) {
                this.f72342d = element2;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void i() {
        try {
            D(4096, 0, 0, 0);
            this.f72341c = 0;
            Element element = Element.f72348c;
            this.f72342d = element;
            this.f72343e = element;
            if (this.f72340b > 4096) {
                z(4096);
            }
            this.f72340b = 4096;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void j(int i3) throws IOException {
        int i4 = i3 + 4;
        int iV = v();
        if (iV >= i4) {
            return;
        }
        int i5 = this.f72340b;
        do {
            iV += i5;
            i5 <<= 1;
        } while (iV < i4);
        z(i5);
        Element element = this.f72343e;
        int iC = C(element.f72349a + 4 + element.f72350b);
        if (iC < this.f72342d.f72349a) {
            FileChannel channel = this.f72339a.getChannel();
            channel.position(this.f72340b);
            long j3 = iC - 4;
            if (channel.transferTo(16L, j3, channel) != j3) {
                throw new AssertionError("Copied insufficient number of bytes!");
            }
        }
        int i6 = this.f72343e.f72349a;
        int i7 = this.f72342d.f72349a;
        if (i6 < i7) {
            int i8 = (this.f72340b + i6) - 16;
            D(i5, this.f72341c, i7, i8);
            this.f72343e = new Element(i8, this.f72343e.f72350b);
        } else {
            D(i5, this.f72341c, i7, i6);
        }
        this.f72340b = i5;
    }

    public synchronized void m(ElementReader elementReader) {
        int iC = this.f72342d.f72349a;
        for (int i3 = 0; i3 < this.f72341c; i3++) {
            Element elementR = r(iC);
            elementReader.a(new ElementInputStream(elementR), elementR.f72350b);
            iC = C(elementR.f72349a + 4 + elementR.f72350b);
        }
    }

    public synchronized boolean o() {
        return this.f72341c == 0;
    }

    public final Element r(int i3) throws IOException {
        if (i3 == 0) {
            return Element.f72348c;
        }
        this.f72339a.seek(i3);
        return new Element(i3, this.f72339a.readInt());
    }

    public final void s() throws IOException {
        this.f72339a.seek(0L);
        this.f72339a.readFully(this.f72344f);
        int iU = u(this.f72344f, 0);
        this.f72340b = iU;
        if (iU <= this.f72339a.length()) {
            this.f72341c = u(this.f72344f, 4);
            int iU2 = u(this.f72344f, 8);
            int iU3 = u(this.f72344f, 12);
            this.f72342d = r(iU2);
            this.f72343e = r(iU3);
            return;
        }
        throw new IOException("File is truncated. Expected length: " + this.f72340b + ", Actual length: " + this.f72339a.length());
    }

    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(AbstractJsonLexerKt.BEGIN_LIST);
        sb.append("fileLength=");
        sb.append(this.f72340b);
        sb.append(", size=");
        sb.append(this.f72341c);
        sb.append(", first=");
        sb.append(this.f72342d);
        sb.append(", last=");
        sb.append(this.f72343e);
        sb.append(", element lengths=[");
        try {
            m(new ElementReader() { // from class: com.google.firebase.crashlytics.internal.metadata.QueueFile.1

                /* renamed from: a, reason: collision with root package name */
                public boolean f72345a = true;

                @Override // com.google.firebase.crashlytics.internal.metadata.QueueFile.ElementReader
                public void a(InputStream inputStream, int i3) {
                    if (this.f72345a) {
                        this.f72345a = false;
                    } else {
                        sb.append(", ");
                    }
                    sb.append(i3);
                }
            });
        } catch (IOException e3) {
            f72338g.log(Level.WARNING, "read error", (Throwable) e3);
        }
        sb.append("]]");
        return sb.toString();
    }

    public final int v() {
        return this.f72340b - B();
    }

    public synchronized void w() {
        try {
            if (o()) {
                throw new NoSuchElementException();
            }
            if (this.f72341c == 1) {
                i();
            } else {
                Element element = this.f72342d;
                int iC = C(element.f72349a + 4 + element.f72350b);
                x(iC, this.f72344f, 0, 4);
                int iU = u(this.f72344f, 0);
                D(this.f72340b, this.f72341c - 1, iC, this.f72343e.f72349a);
                this.f72341c--;
                this.f72342d = new Element(iC, iU);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void x(int i3, byte[] bArr, int i4, int i5) throws IOException {
        int iC = C(i3);
        int i6 = iC + i5;
        int i7 = this.f72340b;
        if (i6 <= i7) {
            this.f72339a.seek(iC);
            this.f72339a.readFully(bArr, i4, i5);
            return;
        }
        int i8 = i7 - iC;
        this.f72339a.seek(iC);
        this.f72339a.readFully(bArr, i4, i8);
        this.f72339a.seek(16L);
        this.f72339a.readFully(bArr, i4 + i8, i5 - i8);
    }

    public final void y(int i3, byte[] bArr, int i4, int i5) throws IOException {
        int iC = C(i3);
        int i6 = iC + i5;
        int i7 = this.f72340b;
        if (i6 <= i7) {
            this.f72339a.seek(iC);
            this.f72339a.write(bArr, i4, i5);
            return;
        }
        int i8 = i7 - iC;
        this.f72339a.seek(iC);
        this.f72339a.write(bArr, i4, i8);
        this.f72339a.seek(16L);
        this.f72339a.write(bArr, i4 + i8, i5 - i8);
    }

    public final void z(int i3) throws IOException {
        this.f72339a.setLength(i3);
        this.f72339a.getChannel().force(true);
    }
}
