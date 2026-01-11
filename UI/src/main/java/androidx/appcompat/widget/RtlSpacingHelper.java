package androidx.appcompat.widget;

/* loaded from: classes2.dex */
class RtlSpacingHelper {
    public static final int UNDEFINED = Integer.MIN_VALUE;

    /* renamed from: a, reason: collision with root package name */
    public int f3661a = 0;

    /* renamed from: b, reason: collision with root package name */
    public int f3662b = 0;

    /* renamed from: c, reason: collision with root package name */
    public int f3663c = Integer.MIN_VALUE;

    /* renamed from: d, reason: collision with root package name */
    public int f3664d = Integer.MIN_VALUE;

    /* renamed from: e, reason: collision with root package name */
    public int f3665e = 0;

    /* renamed from: f, reason: collision with root package name */
    public int f3666f = 0;

    /* renamed from: g, reason: collision with root package name */
    public boolean f3667g = false;

    /* renamed from: h, reason: collision with root package name */
    public boolean f3668h = false;

    public int a() {
        return this.f3667g ? this.f3661a : this.f3662b;
    }

    public int b() {
        return this.f3661a;
    }

    public int c() {
        return this.f3662b;
    }

    public int d() {
        return this.f3667g ? this.f3662b : this.f3661a;
    }

    public void e(int i3, int i4) {
        this.f3668h = false;
        if (i3 != Integer.MIN_VALUE) {
            this.f3665e = i3;
            this.f3661a = i3;
        }
        if (i4 != Integer.MIN_VALUE) {
            this.f3666f = i4;
            this.f3662b = i4;
        }
    }

    public void f(boolean z2) {
        if (z2 == this.f3667g) {
            return;
        }
        this.f3667g = z2;
        if (!this.f3668h) {
            this.f3661a = this.f3665e;
            this.f3662b = this.f3666f;
            return;
        }
        if (z2) {
            int i3 = this.f3664d;
            if (i3 == Integer.MIN_VALUE) {
                i3 = this.f3665e;
            }
            this.f3661a = i3;
            int i4 = this.f3663c;
            if (i4 == Integer.MIN_VALUE) {
                i4 = this.f3666f;
            }
            this.f3662b = i4;
            return;
        }
        int i5 = this.f3663c;
        if (i5 == Integer.MIN_VALUE) {
            i5 = this.f3665e;
        }
        this.f3661a = i5;
        int i6 = this.f3664d;
        if (i6 == Integer.MIN_VALUE) {
            i6 = this.f3666f;
        }
        this.f3662b = i6;
    }

    public void g(int i3, int i4) {
        this.f3663c = i3;
        this.f3664d = i4;
        this.f3668h = true;
        if (this.f3667g) {
            if (i4 != Integer.MIN_VALUE) {
                this.f3661a = i4;
            }
            if (i3 != Integer.MIN_VALUE) {
                this.f3662b = i3;
                return;
            }
            return;
        }
        if (i3 != Integer.MIN_VALUE) {
            this.f3661a = i3;
        }
        if (i4 != Integer.MIN_VALUE) {
            this.f3662b = i4;
        }
    }
}
