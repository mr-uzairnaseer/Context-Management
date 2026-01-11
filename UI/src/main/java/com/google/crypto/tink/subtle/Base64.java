package com.google.crypto.tink.subtle;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import org.apache.commons.compress.archivers.tar.TarConstants;

/* loaded from: classes5.dex */
public final class Base64 {
    public static final int CRLF = 4;
    public static final int DEFAULT = 0;
    public static final int NO_CLOSE = 16;
    public static final int NO_PADDING = 1;
    public static final int NO_WRAP = 2;
    public static final int URL_SAFE = 8;

    /* renamed from: a, reason: collision with root package name */
    public static final Charset f71599a = Charset.forName("UTF-8");

    public static abstract class Coder {

        /* renamed from: a, reason: collision with root package name */
        public byte[] f71600a;

        /* renamed from: b, reason: collision with root package name */
        public int f71601b;
    }

    public static class Decoder extends Coder {

        /* renamed from: f, reason: collision with root package name */
        public static final int[] f71602f = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};

        /* renamed from: g, reason: collision with root package name */
        public static final int[] f71603g = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};

        /* renamed from: c, reason: collision with root package name */
        public int f71604c;

        /* renamed from: d, reason: collision with root package name */
        public int f71605d;

        /* renamed from: e, reason: collision with root package name */
        public final int[] f71606e;

        public Decoder(int i3, byte[] bArr) {
            this.f71600a = bArr;
            this.f71606e = (i3 & 8) == 0 ? f71602f : f71603g;
            this.f71604c = 0;
            this.f71605d = 0;
        }

        public boolean a(byte[] bArr, int i3, int i4, boolean z2) {
            int i5 = this.f71604c;
            if (i5 == 6) {
                return false;
            }
            int i6 = i4 + i3;
            int i7 = this.f71605d;
            byte[] bArr2 = this.f71600a;
            int[] iArr = this.f71606e;
            int i8 = 0;
            int i9 = i7;
            int i10 = i5;
            int i11 = i3;
            while (i11 < i6) {
                if (i10 == 0) {
                    while (true) {
                        int i12 = i11 + 4;
                        if (i12 > i6 || (i9 = (iArr[bArr[i11] & 255] << 18) | (iArr[bArr[i11 + 1] & 255] << 12) | (iArr[bArr[i11 + 2] & 255] << 6) | iArr[bArr[i11 + 3] & 255]) < 0) {
                            break;
                        }
                        bArr2[i8 + 2] = (byte) i9;
                        bArr2[i8 + 1] = (byte) (i9 >> 8);
                        bArr2[i8] = (byte) (i9 >> 16);
                        i8 += 3;
                        i11 = i12;
                    }
                    if (i11 >= i6) {
                        break;
                    }
                }
                int i13 = i11 + 1;
                int i14 = iArr[bArr[i11] & 255];
                if (i10 != 0) {
                    if (i10 == 1) {
                        if (i14 < 0) {
                            if (i14 != -1) {
                                this.f71604c = 6;
                                return false;
                            }
                        }
                        i14 |= i9 << 6;
                    } else if (i10 == 2) {
                        if (i14 < 0) {
                            if (i14 == -2) {
                                bArr2[i8] = (byte) (i9 >> 4);
                                i8++;
                                i10 = 4;
                            } else if (i14 != -1) {
                                this.f71604c = 6;
                                return false;
                            }
                        }
                        i14 |= i9 << 6;
                    } else if (i10 != 3) {
                        if (i10 != 4) {
                            if (i10 == 5 && i14 != -1) {
                                this.f71604c = 6;
                                return false;
                            }
                        } else if (i14 == -2) {
                            i10++;
                        } else if (i14 != -1) {
                            this.f71604c = 6;
                            return false;
                        }
                    } else if (i14 >= 0) {
                        int i15 = i14 | (i9 << 6);
                        bArr2[i8 + 2] = (byte) i15;
                        bArr2[i8 + 1] = (byte) (i15 >> 8);
                        bArr2[i8] = (byte) (i15 >> 16);
                        i8 += 3;
                        i9 = i15;
                        i10 = 0;
                    } else if (i14 == -2) {
                        bArr2[i8 + 1] = (byte) (i9 >> 2);
                        bArr2[i8] = (byte) (i9 >> 10);
                        i8 += 2;
                        i10 = 5;
                    } else if (i14 != -1) {
                        this.f71604c = 6;
                        return false;
                    }
                    i10++;
                    i9 = i14;
                } else if (i14 >= 0) {
                    i10++;
                    i9 = i14;
                } else if (i14 != -1) {
                    this.f71604c = 6;
                    return false;
                }
                i11 = i13;
            }
            if (!z2) {
                this.f71604c = i10;
                this.f71605d = i9;
                this.f71601b = i8;
                return true;
            }
            if (i10 == 1) {
                this.f71604c = 6;
                return false;
            }
            if (i10 == 2) {
                bArr2[i8] = (byte) (i9 >> 4);
                i8++;
            } else if (i10 == 3) {
                int i16 = i8 + 1;
                bArr2[i8] = (byte) (i9 >> 10);
                i8 += 2;
                bArr2[i16] = (byte) (i9 >> 2);
            } else if (i10 == 4) {
                this.f71604c = 6;
                return false;
            }
            this.f71604c = i10;
            this.f71601b = i8;
            return true;
        }
    }

    public static class Encoder extends Coder {
        public static final int LINE_GROUPS = 19;

        /* renamed from: j, reason: collision with root package name */
        public static final byte[] f71607j = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, TarConstants.LF_GNUTYPE_LONGLINK, TarConstants.LF_GNUTYPE_LONGNAME, TarConstants.LF_MULTIVOLUME, 78, 79, 80, 81, 82, TarConstants.LF_GNUTYPE_SPARSE, 84, 85, 86, 87, TarConstants.LF_PAX_EXTENDED_HEADER_UC, 89, 90, 97, 98, 99, 100, 101, 102, TarConstants.LF_PAX_GLOBAL_EXTENDED_HEADER, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, TarConstants.LF_PAX_EXTENDED_HEADER_LC, 121, 122, TarConstants.LF_NORMAL, TarConstants.LF_LINK, TarConstants.LF_SYMLINK, TarConstants.LF_CHR, TarConstants.LF_BLK, TarConstants.LF_DIR, TarConstants.LF_FIFO, TarConstants.LF_CONTIG, 56, 57, 43, 47};

        /* renamed from: k, reason: collision with root package name */
        public static final byte[] f71608k = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, TarConstants.LF_GNUTYPE_LONGLINK, TarConstants.LF_GNUTYPE_LONGNAME, TarConstants.LF_MULTIVOLUME, 78, 79, 80, 81, 82, TarConstants.LF_GNUTYPE_SPARSE, 84, 85, 86, 87, TarConstants.LF_PAX_EXTENDED_HEADER_UC, 89, 90, 97, 98, 99, 100, 101, 102, TarConstants.LF_PAX_GLOBAL_EXTENDED_HEADER, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, TarConstants.LF_PAX_EXTENDED_HEADER_LC, 121, 122, TarConstants.LF_NORMAL, TarConstants.LF_LINK, TarConstants.LF_SYMLINK, TarConstants.LF_CHR, TarConstants.LF_BLK, TarConstants.LF_DIR, TarConstants.LF_FIFO, TarConstants.LF_CONTIG, 56, 57, 45, 95};

        /* renamed from: c, reason: collision with root package name */
        public final byte[] f71609c;

        /* renamed from: d, reason: collision with root package name */
        public int f71610d;

        /* renamed from: e, reason: collision with root package name */
        public int f71611e;

        /* renamed from: f, reason: collision with root package name */
        public final boolean f71612f;

        /* renamed from: g, reason: collision with root package name */
        public final boolean f71613g;

        /* renamed from: h, reason: collision with root package name */
        public final boolean f71614h;

        /* renamed from: i, reason: collision with root package name */
        public final byte[] f71615i;

        public Encoder(int i3, byte[] bArr) {
            this.f71600a = bArr;
            this.f71612f = (i3 & 1) == 0;
            boolean z2 = (i3 & 2) == 0;
            this.f71613g = z2;
            this.f71614h = (i3 & 4) != 0;
            this.f71615i = (i3 & 8) == 0 ? f71607j : f71608k;
            this.f71609c = new byte[2];
            this.f71610d = 0;
            this.f71611e = z2 ? 19 : -1;
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0050  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean a(byte[] r18, int r19, int r20, boolean r21) {
            /*
                Method dump skipped, instructions count: 490
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.subtle.Base64.Encoder.a(byte[], int, int, boolean):boolean");
        }
    }

    private Base64() {
    }

    public static byte[] a(String str) {
        return b(str, 2);
    }

    public static byte[] b(String str, int i3) {
        return c(str.getBytes(f71599a), i3);
    }

    public static byte[] c(byte[] bArr, int i3) {
        return d(bArr, 0, bArr.length, i3);
    }

    public static byte[] d(byte[] bArr, int i3, int i4, int i5) {
        Decoder decoder = new Decoder(i5, new byte[(i4 * 3) / 4]);
        if (!decoder.a(bArr, i3, i4, true)) {
            throw new IllegalArgumentException("bad base-64");
        }
        int i6 = decoder.f71601b;
        byte[] bArr2 = decoder.f71600a;
        if (i6 == bArr2.length) {
            return bArr2;
        }
        byte[] bArr3 = new byte[i6];
        System.arraycopy(bArr2, 0, bArr3, 0, i6);
        return bArr3;
    }

    public static String e(byte[] bArr) {
        return h(bArr, 2);
    }

    public static byte[] f(byte[] bArr, int i3) {
        return g(bArr, 0, bArr.length, i3);
    }

    public static byte[] g(byte[] bArr, int i3, int i4, int i5) {
        Encoder encoder = new Encoder(i5, null);
        int i6 = (i4 / 3) * 4;
        if (!encoder.f71612f) {
            int i7 = i4 % 3;
            if (i7 == 1) {
                i6 += 2;
            } else if (i7 == 2) {
                i6 += 3;
            }
        } else if (i4 % 3 > 0) {
            i6 += 4;
        }
        if (encoder.f71613g && i4 > 0) {
            i6 += (((i4 - 1) / 57) + 1) * (encoder.f71614h ? 2 : 1);
        }
        encoder.f71600a = new byte[i6];
        encoder.a(bArr, i3, i4, true);
        return encoder.f71600a;
    }

    public static String h(byte[] bArr, int i3) {
        try {
            return new String(f(bArr, i3), "US-ASCII");
        } catch (UnsupportedEncodingException e3) {
            throw new AssertionError(e3);
        }
    }

    public static byte[] i(String str) {
        return b(str, 11);
    }
}
