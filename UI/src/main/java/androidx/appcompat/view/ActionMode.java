package androidx.appcompat.view;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

/* loaded from: classes2.dex */
public abstract class ActionMode {

    /* renamed from: a, reason: collision with root package name */
    public Object f2838a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f2839b;

    public interface Callback {
        boolean a(ActionMode actionMode, Menu menu);

        boolean b(ActionMode actionMode, MenuItem menuItem);

        boolean c(ActionMode actionMode, Menu menu);

        void d(ActionMode actionMode);
    }

    public abstract void c();

    public abstract View d();

    public abstract Menu e();

    public abstract MenuInflater f();

    public abstract CharSequence g();

    public Object h() {
        return this.f2838a;
    }

    public abstract CharSequence i();

    public boolean j() {
        return this.f2839b;
    }

    public abstract void k();

    public boolean l() {
        return false;
    }

    public abstract void m(View view);

    public abstract void n(int i3);

    public abstract void o(CharSequence charSequence);

    public void p(Object obj) {
        this.f2838a = obj;
    }

    public abstract void q(int i3);

    public abstract void r(CharSequence charSequence);

    public void s(boolean z2) {
        this.f2839b = z2;
    }
}
