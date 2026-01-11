package androidx.recyclerview.widget;

import android.view.View;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes.dex */
class ViewBoundsCheck {

    /* renamed from: a, reason: collision with root package name */
    public final Callback f48026a;

    /* renamed from: b, reason: collision with root package name */
    public BoundFlags f48027b = new BoundFlags();

    public static class BoundFlags {

        /* renamed from: a, reason: collision with root package name */
        public int f48028a = 0;

        /* renamed from: b, reason: collision with root package name */
        public int f48029b;

        /* renamed from: c, reason: collision with root package name */
        public int f48030c;

        /* renamed from: d, reason: collision with root package name */
        public int f48031d;

        /* renamed from: e, reason: collision with root package name */
        public int f48032e;

        public void a(int i3) {
            this.f48028a = i3 | this.f48028a;
        }

        public boolean b() {
            int i3 = this.f48028a;
            if ((i3 & 7) != 0 && (i3 & c(this.f48031d, this.f48029b)) == 0) {
                return false;
            }
            int i4 = this.f48028a;
            if ((i4 & 112) != 0 && (i4 & (c(this.f48031d, this.f48030c) << 4)) == 0) {
                return false;
            }
            int i5 = this.f48028a;
            if ((i5 & 1792) != 0 && (i5 & (c(this.f48032e, this.f48029b) << 8)) == 0) {
                return false;
            }
            int i6 = this.f48028a;
            return (i6 & 28672) == 0 || (i6 & (c(this.f48032e, this.f48030c) << 12)) != 0;
        }

        public int c(int i3, int i4) {
            if (i3 > i4) {
                return 1;
            }
            return i3 == i4 ? 2 : 4;
        }

        public void d() {
            this.f48028a = 0;
        }

        public void e(int i3, int i4, int i5, int i6) {
            this.f48029b = i3;
            this.f48030c = i4;
            this.f48031d = i5;
            this.f48032e = i6;
        }
    }

    public interface Callback {
        View a(int i3);

        int b();

        int c();

        int d(View view);

        int e(View view);
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes4.dex */
    public @interface ViewBounds {
    }

    public ViewBoundsCheck(Callback callback) {
        this.f48026a = callback;
    }

    public View a(int i3, int i4, int i5, int i6) {
        int iB = this.f48026a.b();
        int iC = this.f48026a.c();
        int i7 = i4 > i3 ? 1 : -1;
        View view = null;
        while (i3 != i4) {
            View viewA = this.f48026a.a(i3);
            this.f48027b.e(iB, iC, this.f48026a.d(viewA), this.f48026a.e(viewA));
            if (i5 != 0) {
                this.f48027b.d();
                this.f48027b.a(i5);
                if (this.f48027b.b()) {
                    return viewA;
                }
            }
            if (i6 != 0) {
                this.f48027b.d();
                this.f48027b.a(i6);
                if (this.f48027b.b()) {
                    view = viewA;
                }
            }
            i3 += i7;
        }
        return view;
    }

    public boolean b(View view, int i3) {
        this.f48027b.e(this.f48026a.b(), this.f48026a.c(), this.f48026a.d(view), this.f48026a.e(view));
        if (i3 == 0) {
            return false;
        }
        this.f48027b.d();
        this.f48027b.a(i3);
        return this.f48027b.b();
    }
}
