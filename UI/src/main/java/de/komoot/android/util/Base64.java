package de.komoot.android.util;

import com.google.common.base.Ascii;
import java.io.ByteArrayOutputStream;
import java.io.FilterInputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.io.UnsupportedEncodingException;
import java.util.zip.GZIPOutputStream;
import okio.Utf8;
import org.apache.commons.compress.archivers.tar.TarConstants;

/* loaded from: classes2.dex */
public class Base64 {
    public static final int DECODE = 0;
    public static final int DONT_GUNZIP = 4;
    public static final int DO_BREAK_LINES = 8;
    public static final int ENCODE = 1;
    public static final int GZIP = 2;
    public static final int NO_OPTIONS = 0;
    public static final int ORDERED = 32;
    public static final int URL_SAFE = 16;

    /* renamed from: a, reason: collision with root package name */
    public static final byte[] f146589a = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, TarConstants.LF_GNUTYPE_LONGLINK, TarConstants.LF_GNUTYPE_LONGNAME, TarConstants.LF_MULTIVOLUME, 78, 79, 80, 81, 82, TarConstants.LF_GNUTYPE_SPARSE, 84, 85, 86, 87, TarConstants.LF_PAX_EXTENDED_HEADER_UC, 89, 90, 97, 98, 99, 100, 101, 102, TarConstants.LF_PAX_GLOBAL_EXTENDED_HEADER, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, TarConstants.LF_PAX_EXTENDED_HEADER_LC, 121, 122, TarConstants.LF_NORMAL, TarConstants.LF_LINK, TarConstants.LF_SYMLINK, TarConstants.LF_CHR, TarConstants.LF_BLK, TarConstants.LF_DIR, TarConstants.LF_FIFO, TarConstants.LF_CONTIG, 56, 57, 43, 47};

    /* renamed from: b, reason: collision with root package name */
    public static final byte[] f146590b = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, -9, Utf8.REPLACEMENT_BYTE, TarConstants.LF_BLK, TarConstants.LF_DIR, TarConstants.LF_FIFO, TarConstants.LF_CONTIG, 56, 57, 58, 59, 60, kotlin.io.encoding.Base64.padSymbol, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, Ascii.CR, 14, 15, Ascii.DLE, 17, Ascii.DC2, 19, Ascii.DC4, Ascii.NAK, Ascii.SYN, Ascii.ETB, Ascii.CAN, Ascii.EM, -9, -9, -9, -9, -9, -9, Ascii.SUB, Ascii.ESC, Ascii.FS, Ascii.GS, Ascii.RS, Ascii.US, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, TarConstants.LF_NORMAL, TarConstants.LF_LINK, TarConstants.LF_SYMLINK, TarConstants.LF_CHR, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};

    /* renamed from: c, reason: collision with root package name */
    public static final byte[] f146591c = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, TarConstants.LF_GNUTYPE_LONGLINK, TarConstants.LF_GNUTYPE_LONGNAME, TarConstants.LF_MULTIVOLUME, 78, 79, 80, 81, 82, TarConstants.LF_GNUTYPE_SPARSE, 84, 85, 86, 87, TarConstants.LF_PAX_EXTENDED_HEADER_UC, 89, 90, 97, 98, 99, 100, 101, 102, TarConstants.LF_PAX_GLOBAL_EXTENDED_HEADER, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, TarConstants.LF_PAX_EXTENDED_HEADER_LC, 121, 122, TarConstants.LF_NORMAL, TarConstants.LF_LINK, TarConstants.LF_SYMLINK, TarConstants.LF_CHR, TarConstants.LF_BLK, TarConstants.LF_DIR, TarConstants.LF_FIFO, TarConstants.LF_CONTIG, 56, 57, 45, 95};

    /* renamed from: d, reason: collision with root package name */
    public static final byte[] f146592d = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, TarConstants.LF_BLK, TarConstants.LF_DIR, TarConstants.LF_FIFO, TarConstants.LF_CONTIG, 56, 57, 58, 59, 60, kotlin.io.encoding.Base64.padSymbol, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, Ascii.CR, 14, 15, Ascii.DLE, 17, Ascii.DC2, 19, Ascii.DC4, Ascii.NAK, Ascii.SYN, Ascii.ETB, Ascii.CAN, Ascii.EM, -9, -9, -9, -9, Utf8.REPLACEMENT_BYTE, -9, Ascii.SUB, Ascii.ESC, Ascii.FS, Ascii.GS, Ascii.RS, Ascii.US, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, TarConstants.LF_NORMAL, TarConstants.LF_LINK, TarConstants.LF_SYMLINK, TarConstants.LF_CHR, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};

    /* renamed from: e, reason: collision with root package name */
    public static final byte[] f146593e = {45, TarConstants.LF_NORMAL, TarConstants.LF_LINK, TarConstants.LF_SYMLINK, TarConstants.LF_CHR, TarConstants.LF_BLK, TarConstants.LF_DIR, TarConstants.LF_FIFO, TarConstants.LF_CONTIG, 56, 57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, TarConstants.LF_GNUTYPE_LONGLINK, TarConstants.LF_GNUTYPE_LONGNAME, TarConstants.LF_MULTIVOLUME, 78, 79, 80, 81, 82, TarConstants.LF_GNUTYPE_SPARSE, 84, 85, 86, 87, TarConstants.LF_PAX_EXTENDED_HEADER_UC, 89, 90, 95, 97, 98, 99, 100, 101, 102, TarConstants.LF_PAX_GLOBAL_EXTENDED_HEADER, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, TarConstants.LF_PAX_EXTENDED_HEADER_LC, 121, 122};

    /* renamed from: f, reason: collision with root package name */
    public static final byte[] f146594f = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 0, -9, -9, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -9, -9, -9, -1, -9, -9, -9, 11, 12, Ascii.CR, 14, 15, Ascii.DLE, 17, Ascii.DC2, 19, Ascii.DC4, Ascii.NAK, Ascii.SYN, Ascii.ETB, Ascii.CAN, Ascii.EM, Ascii.SUB, Ascii.ESC, Ascii.FS, Ascii.GS, Ascii.RS, Ascii.US, 32, 33, 34, 35, 36, -9, -9, -9, -9, 37, -9, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, TarConstants.LF_NORMAL, TarConstants.LF_LINK, TarConstants.LF_SYMLINK, TarConstants.LF_CHR, TarConstants.LF_BLK, TarConstants.LF_DIR, TarConstants.LF_FIFO, TarConstants.LF_CONTIG, 56, 57, 58, 59, 60, kotlin.io.encoding.Base64.padSymbol, 62, Utf8.REPLACEMENT_BYTE, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};

    /* renamed from: de.komoot.android.util.Base64$1, reason: invalid class name */
    /* loaded from: classes8.dex */
    class AnonymousClass1 extends ObjectInputStream {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ClassLoader f146595a;

        @Override // java.io.ObjectInputStream
        public Class resolveClass(ObjectStreamClass objectStreamClass) throws ClassNotFoundException {
            Class<?> cls = Class.forName(objectStreamClass.getName(), false, this.f146595a);
            return cls == null ? super.resolveClass(objectStreamClass) : cls;
        }
    }

    private Base64() {
    }

    public static byte[] a(String str) {
        return b(str, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:80:0x008e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0093 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0098 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:99:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] b(java.lang.String r5, int r6) throws java.lang.Throwable {
        /*
            if (r5 == 0) goto L9d
            java.lang.String r0 = "US-ASCII"
            byte[] r5 = r5.getBytes(r0)     // Catch: java.io.UnsupportedEncodingException -> L9
            goto Ld
        L9:
            byte[] r5 = r5.getBytes()
        Ld:
            int r0 = r5.length
            r1 = 0
            byte[] r5 = d(r5, r1, r0, r6)
            r0 = 4
            r6 = r6 & r0
            r2 = 1
            if (r6 == 0) goto L1a
            r6 = r2
            goto L1b
        L1a:
            r6 = r1
        L1b:
            if (r5 == 0) goto L9c
            int r3 = r5.length
            if (r3 < r0) goto L9c
            if (r6 != 0) goto L9c
            r6 = r5[r1]
            r6 = r6 & 255(0xff, float:3.57E-43)
            r0 = r5[r2]
            int r0 = r0 << 8
            r2 = 65280(0xff00, float:9.1477E-41)
            r0 = r0 & r2
            r6 = r6 | r0
            r0 = 35615(0x8b1f, float:4.9907E-41)
            if (r0 != r6) goto L9c
            r6 = 2048(0x800, float:2.87E-42)
            byte[] r6 = new byte[r6]
            r0 = 0
            java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L74 java.io.IOException -> L78
            r2.<init>()     // Catch: java.lang.Throwable -> L74 java.io.IOException -> L78
            java.io.ByteArrayInputStream r3 = new java.io.ByteArrayInputStream     // Catch: java.lang.Throwable -> L6c java.io.IOException -> L70
            r3.<init>(r5)     // Catch: java.lang.Throwable -> L6c java.io.IOException -> L70
            java.util.zip.GZIPInputStream r4 = new java.util.zip.GZIPInputStream     // Catch: java.lang.Throwable -> L66 java.io.IOException -> L69
            r4.<init>(r3)     // Catch: java.lang.Throwable -> L66 java.io.IOException -> L69
        L48:
            int r0 = r4.read(r6)     // Catch: java.lang.Throwable -> L52 java.io.IOException -> L55
            if (r0 < 0) goto L58
            r2.write(r6, r1, r0)     // Catch: java.lang.Throwable -> L52 java.io.IOException -> L55
            goto L48
        L52:
            r5 = move-exception
        L53:
            r0 = r2
            goto L8c
        L55:
            r6 = move-exception
        L56:
            r0 = r2
            goto L7b
        L58:
            byte[] r5 = r2.toByteArray()     // Catch: java.lang.Throwable -> L52 java.io.IOException -> L55
            r2.close()     // Catch: java.lang.Throwable -> L5f
        L5f:
            r4.close()     // Catch: java.lang.Throwable -> L62
        L62:
            r3.close()     // Catch: java.lang.Throwable -> L9c
            goto L9c
        L66:
            r5 = move-exception
            r4 = r0
            goto L53
        L69:
            r6 = move-exception
            r4 = r0
            goto L56
        L6c:
            r5 = move-exception
            r3 = r0
            r4 = r3
            goto L53
        L70:
            r6 = move-exception
            r3 = r0
            r4 = r3
            goto L56
        L74:
            r5 = move-exception
            r3 = r0
            r4 = r3
            goto L8c
        L78:
            r6 = move-exception
            r3 = r0
            r4 = r3
        L7b:
            r6.printStackTrace()     // Catch: java.lang.Throwable -> L8b
            if (r0 == 0) goto L83
            r0.close()     // Catch: java.lang.Throwable -> L83
        L83:
            if (r4 == 0) goto L88
            r4.close()     // Catch: java.lang.Throwable -> L88
        L88:
            if (r3 == 0) goto L9c
            goto L62
        L8b:
            r5 = move-exception
        L8c:
            if (r0 == 0) goto L91
            r0.close()     // Catch: java.lang.Throwable -> L91
        L91:
            if (r4 == 0) goto L96
            r4.close()     // Catch: java.lang.Throwable -> L96
        L96:
            if (r3 == 0) goto L9b
            r3.close()     // Catch: java.lang.Throwable -> L9b
        L9b:
            throw r5
        L9c:
            return r5
        L9d:
            java.lang.NullPointerException r5 = new java.lang.NullPointerException
            java.lang.String r6 = "Input string was null."
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: de.komoot.android.util.Base64.b(java.lang.String, int):byte[]");
    }

    public static byte[] c(byte[] bArr) {
        return d(bArr, 0, bArr.length, 0);
    }

    public static byte[] d(byte[] bArr, int i3, int i4, int i5) throws IOException {
        int i6;
        if (bArr == null) {
            throw new NullPointerException("Cannot decode null source array.");
        }
        if (i3 < 0 || (i6 = i3 + i4) > bArr.length) {
            throw new IllegalArgumentException(String.format("Source array with length %d cannot have offset of %d and process %d bytes.", Integer.valueOf(bArr.length), Integer.valueOf(i3), Integer.valueOf(i4)));
        }
        if (i4 == 0) {
            return new byte[0];
        }
        if (i4 < 4) {
            throw new IllegalArgumentException("Base64-encoded string must have at least four characters, but length specified was " + i4);
        }
        byte[] bArrM = m(i5);
        byte[] bArr2 = new byte[(i4 * 3) / 4];
        byte[] bArr3 = new byte[4];
        int i7 = 0;
        int iE = 0;
        while (i3 < i6) {
            byte b3 = bArr[i3];
            byte b4 = bArrM[b3 & 255];
            if (b4 < -5) {
                throw new IOException(String.format("Bad Base64 input character decimal %d in array position %d", Integer.valueOf(bArr[i3] & 255), Integer.valueOf(i3)));
            }
            if (b4 >= -1) {
                int i8 = i7 + 1;
                bArr3[i7] = b3;
                if (i8 > 3) {
                    iE += e(bArr3, 0, bArr2, iE, i5);
                    if (bArr[i3] == 61) {
                        break;
                    }
                    i7 = 0;
                } else {
                    i7 = i8;
                }
            }
            i3++;
        }
        byte[] bArr4 = new byte[iE];
        System.arraycopy(bArr2, 0, bArr4, 0, iE);
        return bArr4;
    }

    public static int e(byte[] bArr, int i3, byte[] bArr2, int i4, int i5) {
        int i6;
        int i7;
        if (bArr == null) {
            throw new NullPointerException("Source array was null.");
        }
        if (bArr2 == null) {
            throw new NullPointerException("Destination array was null.");
        }
        if (i3 < 0 || (i6 = i3 + 3) >= bArr.length) {
            throw new IllegalArgumentException(String.format("Source array with length %d cannot have offset of %d and still process four bytes.", Integer.valueOf(bArr.length), Integer.valueOf(i3)));
        }
        if (i4 < 0 || (i7 = i4 + 2) >= bArr2.length) {
            throw new IllegalArgumentException(String.format("Destination array with length %d cannot have offset of %d and still store three bytes.", Integer.valueOf(bArr2.length), Integer.valueOf(i4)));
        }
        byte[] bArrM = m(i5);
        byte b3 = bArr[i3 + 2];
        if (b3 == 61) {
            bArr2[i4] = (byte) ((((bArrM[bArr[i3 + 1]] & 255) << 12) | ((bArrM[bArr[i3]] & 255) << 18)) >>> 16);
            return 1;
        }
        byte b4 = bArr[i6];
        if (b4 == 61) {
            int i8 = ((bArrM[bArr[i3 + 1]] & 255) << 12) | ((bArrM[bArr[i3]] & 255) << 18) | ((bArrM[b3] & 255) << 6);
            bArr2[i4] = (byte) (i8 >>> 16);
            bArr2[i4 + 1] = (byte) (i8 >>> 8);
            return 2;
        }
        int i9 = ((bArrM[bArr[i3 + 1]] & 255) << 12) | ((bArrM[bArr[i3]] & 255) << 18) | ((bArrM[b3] & 255) << 6) | (bArrM[b4] & 255);
        bArr2[i4] = (byte) (i9 >> 16);
        bArr2[i4 + 1] = (byte) (i9 >> 8);
        bArr2[i7] = (byte) i9;
        return 3;
    }

    public static byte[] f(byte[] bArr, int i3, int i4, byte[] bArr2, int i5, int i6) {
        byte[] bArrL = l(i6);
        int i7 = (i4 > 0 ? (bArr[i3] << Ascii.CAN) >>> 8 : 0) | (i4 > 1 ? (bArr[i3 + 1] << Ascii.CAN) >>> 16 : 0) | (i4 > 2 ? (bArr[i3 + 2] << Ascii.CAN) >>> 24 : 0);
        if (i4 == 1) {
            bArr2[i5] = bArrL[i7 >>> 18];
            bArr2[i5 + 1] = bArrL[(i7 >>> 12) & 63];
            bArr2[i5 + 2] = kotlin.io.encoding.Base64.padSymbol;
            bArr2[i5 + 3] = kotlin.io.encoding.Base64.padSymbol;
            return bArr2;
        }
        if (i4 == 2) {
            bArr2[i5] = bArrL[i7 >>> 18];
            bArr2[i5 + 1] = bArrL[(i7 >>> 12) & 63];
            bArr2[i5 + 2] = bArrL[(i7 >>> 6) & 63];
            bArr2[i5 + 3] = kotlin.io.encoding.Base64.padSymbol;
            return bArr2;
        }
        if (i4 != 3) {
            return bArr2;
        }
        bArr2[i5] = bArrL[i7 >>> 18];
        bArr2[i5 + 1] = bArrL[(i7 >>> 12) & 63];
        bArr2[i5 + 2] = bArrL[(i7 >>> 6) & 63];
        bArr2[i5 + 3] = bArrL[i7 & 63];
        return bArr2;
    }

    public static byte[] g(byte[] bArr, byte[] bArr2, int i3, int i4) {
        f(bArr2, 0, i3, bArr, 0, i4);
        return bArr;
    }

    public static String h(byte[] bArr) {
        try {
            return i(bArr, 0, bArr.length, 0);
        } catch (IOException unused) {
            return null;
        }
    }

    public static String i(byte[] bArr, int i3, int i4, int i5) throws Throwable {
        byte[] bArrK = k(bArr, i3, i4, i5);
        try {
            return new String(bArrK, "US-ASCII");
        } catch (UnsupportedEncodingException unused) {
            return new String(bArrK);
        }
    }

    public static byte[] j(byte[] bArr) {
        try {
            return k(bArr, 0, bArr.length, 0);
        } catch (IOException unused) {
            return null;
        }
    }

    public static byte[] k(byte[] bArr, int i3, int i4, int i5) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream;
        OutputStream outputStream;
        GZIPOutputStream gZIPOutputStream;
        byte[] bArr2 = bArr;
        if (bArr2 == null) {
            throw new NullPointerException("Cannot serialize a null array.");
        }
        if (i3 < 0) {
            throw new IllegalArgumentException("Cannot have negative offset: " + i3);
        }
        if (i4 < 0) {
            throw new IllegalArgumentException("Cannot have length offset: " + i4);
        }
        if (i3 + i4 > bArr2.length) {
            throw new IllegalArgumentException(String.format("Cannot have offset of %d and length of %d with array of length %d", Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(bArr2.length)));
        }
        if ((i5 & 2) == 0) {
            boolean z2 = (i5 & 8) != 0;
            int i6 = ((i4 / 3) * 4) + (i4 % 3 > 0 ? 4 : 0);
            if (z2) {
                i6 += i6 / 76;
            }
            int i7 = i6;
            byte[] bArr3 = new byte[i7];
            int i8 = i4 - 2;
            int i9 = 0;
            int i10 = 0;
            int i11 = 0;
            while (i10 < i8) {
                f(bArr2, i10 + i3, 3, bArr3, i9, i5);
                i11 += 4;
                if (z2 && i11 >= 76) {
                    bArr3[i9 + 4] = 10;
                    i9++;
                    i11 = 0;
                }
                i10 += 3;
                i9 += 4;
                bArr2 = bArr;
            }
            if (i10 < i4) {
                f(bArr, i10 + i3, i4 - i10, bArr3, i9, i5);
                i9 += 4;
            }
            if (i9 > i7 - 1) {
                return bArr3;
            }
            byte[] bArr4 = new byte[i9];
            System.arraycopy(bArr3, 0, bArr4, 0, i9);
            return bArr4;
        }
        GZIPOutputStream gZIPOutputStream2 = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                outputStream = new OutputStream(byteArrayOutputStream, i5 | 1);
                try {
                    gZIPOutputStream = new GZIPOutputStream(outputStream);
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    gZIPOutputStream.write(bArr2, i3, i4);
                    gZIPOutputStream.close();
                    try {
                        gZIPOutputStream.close();
                    } catch (Throwable unused) {
                    }
                    try {
                        outputStream.close();
                    } catch (Throwable unused2) {
                    }
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable unused3) {
                    }
                    return byteArrayOutputStream.toByteArray();
                } catch (Throwable th2) {
                    th = th2;
                    gZIPOutputStream2 = gZIPOutputStream;
                    if (gZIPOutputStream2 != null) {
                        try {
                            gZIPOutputStream2.close();
                        } catch (Throwable unused4) {
                        }
                    }
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (Throwable unused5) {
                        }
                    }
                    if (byteArrayOutputStream == null) {
                        throw th;
                    }
                    try {
                        byteArrayOutputStream.close();
                        throw th;
                    } catch (Throwable unused6) {
                        throw th;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                outputStream = null;
            }
        } catch (Throwable th4) {
            th = th4;
            byteArrayOutputStream = null;
            outputStream = null;
        }
    }

    public static byte[] l(int i3) {
        return (i3 & 16) == 16 ? f146591c : (i3 & 32) == 32 ? f146593e : f146589a;
    }

    public static byte[] m(int i3) {
        return (i3 & 16) == 16 ? f146592d : (i3 & 32) == 32 ? f146594f : f146590b;
    }

    /* loaded from: classes8.dex */
    public static class OutputStream extends FilterOutputStream {

        /* renamed from: a, reason: collision with root package name */
        public boolean f146605a;

        /* renamed from: b, reason: collision with root package name */
        public int f146606b;

        /* renamed from: c, reason: collision with root package name */
        public byte[] f146607c;

        /* renamed from: d, reason: collision with root package name */
        public int f146608d;

        /* renamed from: e, reason: collision with root package name */
        public int f146609e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f146610f;

        /* renamed from: g, reason: collision with root package name */
        public byte[] f146611g;

        /* renamed from: h, reason: collision with root package name */
        public boolean f146612h;

        /* renamed from: i, reason: collision with root package name */
        public int f146613i;

        /* renamed from: j, reason: collision with root package name */
        public byte[] f146614j;

        public OutputStream(java.io.OutputStream outputStream, int i3) {
            super(outputStream);
            this.f146610f = (i3 & 8) != 0;
            boolean z2 = (i3 & 1) != 0;
            this.f146605a = z2;
            int i4 = z2 ? 3 : 4;
            this.f146608d = i4;
            this.f146607c = new byte[i4];
            this.f146606b = 0;
            this.f146609e = 0;
            this.f146612h = false;
            this.f146611g = new byte[4];
            this.f146613i = i3;
            this.f146614j = Base64.m(i3);
        }

        public void a() throws IOException {
            int i3 = this.f146606b;
            if (i3 > 0) {
                if (!this.f146605a) {
                    throw new IOException("Base64 input not properly padded.");
                }
                ((FilterOutputStream) this).out.write(Base64.g(this.f146611g, this.f146607c, i3, this.f146613i));
                this.f146606b = 0;
            }
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            a();
            super.close();
            this.f146607c = null;
            ((FilterOutputStream) this).out = null;
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(int i3) throws IOException {
            if (this.f146612h) {
                ((FilterOutputStream) this).out.write(i3);
                return;
            }
            if (!this.f146605a) {
                byte b3 = this.f146614j[i3 & 127];
                if (b3 <= -5) {
                    if (b3 != -5) {
                        throw new IOException("Invalid character in Base64 data.");
                    }
                    return;
                }
                byte[] bArr = this.f146607c;
                int i4 = this.f146606b;
                int i5 = i4 + 1;
                this.f146606b = i5;
                bArr[i4] = (byte) i3;
                if (i5 >= this.f146608d) {
                    ((FilterOutputStream) this).out.write(this.f146611g, 0, Base64.e(bArr, 0, this.f146611g, 0, this.f146613i));
                    this.f146606b = 0;
                    return;
                }
                return;
            }
            byte[] bArr2 = this.f146607c;
            int i6 = this.f146606b;
            int i7 = i6 + 1;
            this.f146606b = i7;
            bArr2[i6] = (byte) i3;
            int i8 = this.f146608d;
            if (i7 >= i8) {
                ((FilterOutputStream) this).out.write(Base64.g(this.f146611g, bArr2, i8, this.f146613i));
                int i9 = this.f146609e + 4;
                this.f146609e = i9;
                if (this.f146610f && i9 >= 76) {
                    ((FilterOutputStream) this).out.write(10);
                    this.f146609e = 0;
                }
                this.f146606b = 0;
            }
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(byte[] bArr, int i3, int i4) throws IOException {
            if (this.f146612h) {
                ((FilterOutputStream) this).out.write(bArr, i3, i4);
                return;
            }
            for (int i5 = 0; i5 < i4; i5++) {
                write(bArr[i3 + i5]);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class InputStream extends FilterInputStream {

        /* renamed from: a, reason: collision with root package name */
        public boolean f146596a;

        /* renamed from: b, reason: collision with root package name */
        public int f146597b;

        /* renamed from: c, reason: collision with root package name */
        public byte[] f146598c;

        /* renamed from: d, reason: collision with root package name */
        public int f146599d;

        /* renamed from: e, reason: collision with root package name */
        public int f146600e;

        /* renamed from: f, reason: collision with root package name */
        public int f146601f;

        /* renamed from: g, reason: collision with root package name */
        public boolean f146602g;

        /* renamed from: h, reason: collision with root package name */
        public int f146603h;

        /* renamed from: i, reason: collision with root package name */
        public byte[] f146604i;

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() throws IOException {
            int i3;
            if (this.f146597b < 0) {
                if (this.f146596a) {
                    byte[] bArr = new byte[3];
                    int i4 = 0;
                    for (int i5 = 0; i5 < 3; i5++) {
                        int i6 = ((FilterInputStream) this).in.read();
                        if (i6 < 0) {
                            break;
                        }
                        bArr[i5] = (byte) i6;
                        i4++;
                    }
                    if (i4 <= 0) {
                        return -1;
                    }
                    Base64.f(bArr, 0, i4, this.f146598c, 0, this.f146603h);
                    this.f146597b = 0;
                    this.f146600e = 4;
                } else {
                    byte[] bArr2 = new byte[4];
                    int i7 = 0;
                    while (i7 < 4) {
                        do {
                            i3 = ((FilterInputStream) this).in.read();
                            if (i3 < 0) {
                                break;
                            }
                        } while (this.f146604i[i3 & 127] <= -5);
                        if (i3 < 0) {
                            break;
                        }
                        bArr2[i7] = (byte) i3;
                        i7++;
                    }
                    if (i7 != 4) {
                        if (i7 == 0) {
                            return -1;
                        }
                        throw new IOException("Improperly padded Base64 input.");
                    }
                    this.f146600e = Base64.e(bArr2, 0, this.f146598c, 0, this.f146603h);
                    this.f146597b = 0;
                }
            }
            int i8 = this.f146597b;
            if (i8 < 0) {
                throw new IOException("Error in Base64 code reading stream.");
            }
            if (i8 >= this.f146600e) {
                return -1;
            }
            if (this.f146596a && this.f146602g && this.f146601f >= 76) {
                this.f146601f = 0;
                return 10;
            }
            this.f146601f++;
            byte[] bArr3 = this.f146598c;
            int i9 = i8 + 1;
            this.f146597b = i9;
            byte b3 = bArr3[i8];
            if (i9 >= this.f146599d) {
                this.f146597b = -1;
            }
            return b3 & 255;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i3, int i4) throws IOException {
            int i5 = 0;
            while (true) {
                if (i5 >= i4) {
                    break;
                }
                int i6 = read();
                if (i6 >= 0) {
                    bArr[i3 + i5] = (byte) i6;
                    i5++;
                } else if (i5 == 0) {
                    return -1;
                }
            }
            return i5;
        }
    }
}
