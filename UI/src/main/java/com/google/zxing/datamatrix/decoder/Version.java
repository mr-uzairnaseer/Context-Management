package com.google.zxing.datamatrix.decoder;

import freemarker.core.FMParserConstants;
import org.apache.commons.compress.archivers.tar.TarConstants;

/* loaded from: classes5.dex */
public final class Version {

    /* renamed from: h, reason: collision with root package name */
    public static final Version[] f75123h = a();

    /* renamed from: a, reason: collision with root package name */
    public final int f75124a;

    /* renamed from: b, reason: collision with root package name */
    public final int f75125b;

    /* renamed from: c, reason: collision with root package name */
    public final int f75126c;

    /* renamed from: d, reason: collision with root package name */
    public final int f75127d;

    /* renamed from: e, reason: collision with root package name */
    public final int f75128e;

    /* renamed from: f, reason: collision with root package name */
    public final ECBlocks f75129f;

    /* renamed from: g, reason: collision with root package name */
    public final int f75130g;

    public static final class ECB {

        /* renamed from: a, reason: collision with root package name */
        public final int f75131a;

        /* renamed from: b, reason: collision with root package name */
        public final int f75132b;

        public int a() {
            return this.f75131a;
        }

        public int b() {
            return this.f75132b;
        }

        public ECB(int i3, int i4) {
            this.f75131a = i3;
            this.f75132b = i4;
        }
    }

    public Version(int i3, int i4, int i5, int i6, int i7, ECBlocks eCBlocks) {
        this.f75124a = i3;
        this.f75125b = i4;
        this.f75126c = i5;
        this.f75127d = i6;
        this.f75128e = i7;
        this.f75129f = eCBlocks;
        int iB = eCBlocks.b();
        int iA = 0;
        for (ECB ecb : eCBlocks.a()) {
            iA += ecb.a() * (ecb.b() + iB);
        }
        this.f75130g = iA;
    }

    public static Version[] a() {
        int i3 = 1;
        int i4 = 5;
        Version version = new Version(1, 10, 10, 8, 8, new ECBlocks(i4, new ECB(i3, 3)));
        Version version2 = new Version(2, 12, 12, 10, 10, new ECBlocks(7, new ECB(i3, i4)));
        Version version3 = new Version(3, 14, 14, 12, 12, new ECBlocks(10, new ECB(i3, 8)));
        int i5 = 12;
        Version version4 = new Version(4, 16, 16, 14, 14, new ECBlocks(i5, new ECB(i3, i5)));
        int i6 = 18;
        Version version5 = new Version(5, 18, 18, 16, 16, new ECBlocks(14, new ECB(i3, i6)));
        Version version6 = new Version(6, 20, 20, 18, 18, new ECBlocks(i6, new ECB(i3, 22)));
        Version version7 = new Version(7, 22, 22, 20, 20, new ECBlocks(20, new ECB(i3, 30)));
        int i7 = 36;
        Version version8 = new Version(8, 24, 24, 22, 22, new ECBlocks(24, new ECB(i3, i7)));
        Version version9 = new Version(9, 26, 26, 24, 24, new ECBlocks(28, new ECB(i3, 44)));
        Version version10 = new Version(10, 32, 32, 14, 14, new ECBlocks(i7, new ECB(i3, 62)));
        int i8 = 42;
        Version version11 = new Version(11, 36, 36, 16, 16, new ECBlocks(i8, new ECB(i3, 86)));
        int i9 = 114;
        int i10 = 48;
        Version version12 = new Version(12, 40, 40, 18, 18, new ECBlocks(i10, new ECB(i3, i9)));
        int i11 = 144;
        int i12 = 56;
        Version version13 = new Version(13, 44, 44, 20, 20, new ECBlocks(i12, new ECB(i3, i11)));
        Version version14 = new Version(14, 48, 48, 22, 22, new ECBlocks(68, new ECB(i3, 174)));
        int i13 = 2;
        Version version15 = new Version(15, 52, 52, 24, 24, new ECBlocks(i8, new ECB(i13, 102)));
        Version version16 = new Version(16, 64, 64, 14, 14, new ECBlocks(i12, new ECB(i13, 140)));
        int i14 = 4;
        Version version17 = new Version(17, 72, 72, 16, 16, new ECBlocks(i7, new ECB(i14, 92)));
        Version version18 = new Version(18, 80, 80, 18, 18, new ECBlocks(i10, new ECB(i14, i9)));
        Version version19 = new Version(19, 88, 88, 20, 20, new ECBlocks(i12, new ECB(i14, i11)));
        Version version20 = new Version(20, 96, 96, 22, 22, new ECBlocks(68, new ECB(i14, 174)));
        Version version21 = new Version(21, 104, 104, 24, 24, new ECBlocks(i12, new ECB(6, 136)));
        Version version22 = new Version(22, 120, 120, 18, 18, new ECBlocks(68, new ECB(6, 175)));
        Version version23 = new Version(23, FMParserConstants.USING, FMParserConstants.USING, 20, 20, new ECBlocks(62, new ECB(8, 163)));
        Version version24 = new Version(24, 144, 144, 22, 22, new ECBlocks(62, new ECB(8, 156), new ECB(i13, TarConstants.PREFIXLEN)));
        int i15 = 1;
        Version version25 = new Version(25, 8, 18, 6, 16, new ECBlocks(7, new ECB(i15, 5)));
        Version version26 = new Version(26, 8, 32, 6, 14, new ECBlocks(11, new ECB(i15, 10)));
        int i16 = 1;
        return new Version[]{version, version2, version3, version4, version5, version6, version7, version8, version9, version10, version11, version12, version13, version14, version15, version16, version17, version18, version19, version20, version21, version22, version23, version24, version25, version26, new Version(27, 12, 26, 10, 24, new ECBlocks(14, new ECB(i16, 16))), new Version(28, 12, 36, 10, 16, new ECBlocks(18, new ECB(i16, 22))), new Version(29, 16, 36, 14, 16, new ECBlocks(24, new ECB(1, 32))), new Version(30, 16, 48, 14, 22, new ECBlocks(28, new ECB(1, 49)))};
    }

    public String toString() {
        return String.valueOf(this.f75124a);
    }

    public static final class ECBlocks {

        /* renamed from: a, reason: collision with root package name */
        public final int f75133a;

        /* renamed from: b, reason: collision with root package name */
        public final ECB[] f75134b;

        public ECB[] a() {
            return this.f75134b;
        }

        public int b() {
            return this.f75133a;
        }

        public ECBlocks(int i3, ECB ecb) {
            this.f75133a = i3;
            this.f75134b = new ECB[]{ecb};
        }

        public ECBlocks(int i3, ECB ecb, ECB ecb2) {
            this.f75133a = i3;
            this.f75134b = new ECB[]{ecb, ecb2};
        }
    }
}
