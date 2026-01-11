package org.apache.commons.compress.archivers.arj;

import java.util.Arrays;
import java.util.Objects;

/* loaded from: classes5.dex */
final class LocalFileHeader {

    /* renamed from: a, reason: collision with root package name */
    public int f159891a;

    /* renamed from: b, reason: collision with root package name */
    public int f159892b;

    /* renamed from: c, reason: collision with root package name */
    public int f159893c;

    /* renamed from: d, reason: collision with root package name */
    public int f159894d;

    /* renamed from: e, reason: collision with root package name */
    public int f159895e;

    /* renamed from: f, reason: collision with root package name */
    public int f159896f;

    /* renamed from: g, reason: collision with root package name */
    public int f159897g;

    /* renamed from: h, reason: collision with root package name */
    public int f159898h;

    /* renamed from: i, reason: collision with root package name */
    public long f159899i;

    /* renamed from: j, reason: collision with root package name */
    public long f159900j;

    /* renamed from: k, reason: collision with root package name */
    public long f159901k;

    /* renamed from: l, reason: collision with root package name */
    public int f159902l;

    /* renamed from: m, reason: collision with root package name */
    public int f159903m;

    /* renamed from: n, reason: collision with root package name */
    public int f159904n;

    /* renamed from: o, reason: collision with root package name */
    public int f159905o;

    /* renamed from: p, reason: collision with root package name */
    public int f159906p;

    /* renamed from: q, reason: collision with root package name */
    public int f159907q;

    /* renamed from: r, reason: collision with root package name */
    public int f159908r;

    /* renamed from: s, reason: collision with root package name */
    public int f159909s;

    /* renamed from: t, reason: collision with root package name */
    public String f159910t;

    /* renamed from: u, reason: collision with root package name */
    public String f159911u;

    /* renamed from: v, reason: collision with root package name */
    public byte[][] f159912v;

    public static final class FileTypes {
    }

    public static final class Flags {
    }

    public static final class Methods {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && LocalFileHeader.class == obj.getClass()) {
            LocalFileHeader localFileHeader = (LocalFileHeader) obj;
            if (this.f159891a == localFileHeader.f159891a && this.f159892b == localFileHeader.f159892b && this.f159893c == localFileHeader.f159893c && this.f159894d == localFileHeader.f159894d && this.f159895e == localFileHeader.f159895e && this.f159896f == localFileHeader.f159896f && this.f159897g == localFileHeader.f159897g && this.f159898h == localFileHeader.f159898h && this.f159899i == localFileHeader.f159899i && this.f159900j == localFileHeader.f159900j && this.f159901k == localFileHeader.f159901k && this.f159902l == localFileHeader.f159902l && this.f159903m == localFileHeader.f159903m && this.f159904n == localFileHeader.f159904n && this.f159905o == localFileHeader.f159905o && this.f159906p == localFileHeader.f159906p && this.f159907q == localFileHeader.f159907q && this.f159908r == localFileHeader.f159908r && this.f159909s == localFileHeader.f159909s && Objects.equals(this.f159910t, localFileHeader.f159910t) && Objects.equals(this.f159911u, localFileHeader.f159911u) && Arrays.deepEquals(this.f159912v, localFileHeader.f159912v)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.f159910t;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public String toString() {
        return "LocalFileHeader [archiverVersionNumber=" + this.f159891a + ", minVersionToExtract=" + this.f159892b + ", hostOS=" + this.f159893c + ", arjFlags=" + this.f159894d + ", method=" + this.f159895e + ", fileType=" + this.f159896f + ", reserved=" + this.f159897g + ", dateTimeModified=" + this.f159898h + ", compressedSize=" + this.f159899i + ", originalSize=" + this.f159900j + ", originalCrc32=" + this.f159901k + ", fileSpecPosition=" + this.f159902l + ", fileAccessMode=" + this.f159903m + ", firstChapter=" + this.f159904n + ", lastChapter=" + this.f159905o + ", extendedFilePosition=" + this.f159906p + ", dateTimeAccessed=" + this.f159907q + ", dateTimeCreated=" + this.f159908r + ", originalSizeEvenForVolumes=" + this.f159909s + ", name=" + this.f159910t + ", comment=" + this.f159911u + ", extendedHeaders=" + Arrays.toString(this.f159912v) + "]";
    }
}
