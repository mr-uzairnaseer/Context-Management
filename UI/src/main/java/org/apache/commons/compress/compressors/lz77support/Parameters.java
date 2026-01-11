package org.apache.commons.compress.compressors.lz77support;

/* loaded from: classes5.dex */
public final class Parameters {
    public static final int TRUE_MIN_BACK_REFERENCE_LENGTH = 3;

    /* renamed from: a, reason: collision with root package name */
    public final int f160765a;

    /* renamed from: b, reason: collision with root package name */
    public final int f160766b;

    /* renamed from: c, reason: collision with root package name */
    public final int f160767c;

    /* renamed from: d, reason: collision with root package name */
    public final int f160768d;

    /* renamed from: e, reason: collision with root package name */
    public final int f160769e;

    /* renamed from: f, reason: collision with root package name */
    public final int f160770f;

    /* renamed from: g, reason: collision with root package name */
    public final int f160771g;

    /* renamed from: h, reason: collision with root package name */
    public final int f160772h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f160773i;

    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        public final int f160774a;

        /* renamed from: b, reason: collision with root package name */
        public int f160775b;

        /* renamed from: c, reason: collision with root package name */
        public int f160776c;

        /* renamed from: d, reason: collision with root package name */
        public int f160777d;

        /* renamed from: e, reason: collision with root package name */
        public int f160778e;

        /* renamed from: f, reason: collision with root package name */
        public Integer f160779f;

        /* renamed from: g, reason: collision with root package name */
        public Integer f160780g;

        /* renamed from: h, reason: collision with root package name */
        public Integer f160781h;

        /* renamed from: i, reason: collision with root package name */
        public Boolean f160782i;

        public Parameters a() {
            int iIntValue;
            int i3;
            Integer num = this.f160779f;
            int iIntValue2 = num != null ? num.intValue() : Math.max(this.f160775b, this.f160776c / 2);
            Integer num2 = this.f160780g;
            int iIntValue3 = num2 != null ? num2.intValue() : Math.max(256, this.f160774a / 128);
            Boolean bool = this.f160782i;
            boolean z2 = bool == null || bool.booleanValue();
            if (z2) {
                Integer num3 = this.f160781h;
                if (num3 == null) {
                    i3 = iIntValue2;
                    return new Parameters(this.f160774a, this.f160775b, this.f160776c, this.f160777d, this.f160778e, iIntValue2, iIntValue3, z2, i3);
                }
                iIntValue = num3.intValue();
            } else {
                iIntValue = this.f160775b;
            }
            i3 = iIntValue;
            return new Parameters(this.f160774a, this.f160775b, this.f160776c, this.f160777d, this.f160778e, iIntValue2, iIntValue3, z2, i3);
        }

        public Builder b(int i3) {
            int iMin = this.f160775b;
            if (i3 >= iMin) {
                iMin = Math.min(i3, this.f160774a - 1);
            }
            this.f160776c = iMin;
            return this;
        }

        public Builder c(int i3) {
            this.f160778e = i3 < 1 ? this.f160774a : Math.min(i3, this.f160774a);
            return this;
        }

        public Builder d(int i3) {
            this.f160777d = i3 < 1 ? this.f160774a - 1 : Math.min(i3, this.f160774a - 1);
            return this;
        }

        public Builder e(int i3) {
            int iMax = Math.max(3, i3);
            this.f160775b = iMax;
            if (this.f160774a < iMax) {
                throw new IllegalArgumentException("minBackReferenceLength can't be bigger than windowSize");
            }
            if (this.f160776c < iMax) {
                this.f160776c = iMax;
            }
            return this;
        }

        public Builder(int i3) {
            if (i3 < 2 || !Parameters.l(i3)) {
                throw new IllegalArgumentException("windowSize must be a power of two");
            }
            this.f160774a = i3;
            this.f160775b = 3;
            int i4 = i3 - 1;
            this.f160776c = i4;
            this.f160777d = i4;
            this.f160778e = i3;
        }
    }

    public static Builder b(int i3) {
        return new Builder(i3);
    }

    public static boolean l(int i3) {
        return (i3 & (i3 + (-1))) == 0;
    }

    public boolean c() {
        return this.f160773i;
    }

    public int d() {
        return this.f160772h;
    }

    public int e() {
        return this.f160767c;
    }

    public int f() {
        return this.f160771g;
    }

    public int g() {
        return this.f160769e;
    }

    public int h() {
        return this.f160768d;
    }

    public int i() {
        return this.f160766b;
    }

    public int j() {
        return this.f160770f;
    }

    public int k() {
        return this.f160765a;
    }

    public Parameters(int i3, int i4, int i5, int i6, int i7, int i8, int i9, boolean z2, int i10) {
        this.f160765a = i3;
        this.f160766b = i4;
        this.f160767c = i5;
        this.f160768d = i6;
        this.f160769e = i7;
        this.f160770f = i8;
        this.f160771g = i9;
        this.f160773i = z2;
        this.f160772h = i10;
    }
}
