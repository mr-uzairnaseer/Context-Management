package androidx.viewpager.widget;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes4.dex */
public abstract class PagerAdapter {
    public static final int POSITION_NONE = -2;
    public static final int POSITION_UNCHANGED = -1;

    /* renamed from: a, reason: collision with root package name */
    public final DataSetObservable f49026a = new DataSetObservable();

    /* renamed from: b, reason: collision with root package name */
    public DataSetObserver f49027b;

    public void a(View view, int i3, Object obj) {
        throw new UnsupportedOperationException("Required method destroyItem was not overridden");
    }

    public void b(ViewGroup viewGroup, int i3, Object obj) {
        a(viewGroup, i3, obj);
    }

    public void c(View view) {
    }

    public void d(ViewGroup viewGroup) {
        c(viewGroup);
    }

    public abstract int e();

    public int f(Object obj) {
        return -1;
    }

    public CharSequence g(int i3) {
        return null;
    }

    public float h(int i3) {
        return 1.0f;
    }

    public Object i(View view, int i3) {
        throw new UnsupportedOperationException("Required method instantiateItem was not overridden");
    }

    public Object j(ViewGroup viewGroup, int i3) {
        return i(viewGroup, i3);
    }

    public abstract boolean k(View view, Object obj);

    public void l() {
        synchronized (this) {
            try {
                DataSetObserver dataSetObserver = this.f49027b;
                if (dataSetObserver != null) {
                    dataSetObserver.onChanged();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f49026a.notifyChanged();
    }

    public void m(DataSetObserver dataSetObserver) {
        this.f49026a.registerObserver(dataSetObserver);
    }

    public void n(Parcelable parcelable, ClassLoader classLoader) {
    }

    public Parcelable o() {
        return null;
    }

    public void p(View view, int i3, Object obj) {
    }

    public void q(ViewGroup viewGroup, int i3, Object obj) {
        p(viewGroup, i3, obj);
    }

    public void r(DataSetObserver dataSetObserver) {
        synchronized (this) {
            this.f49027b = dataSetObserver;
        }
    }

    public void s(View view) {
    }

    public void t(ViewGroup viewGroup) {
        s(viewGroup);
    }

    public void u(DataSetObserver dataSetObserver) {
        this.f49026a.unregisterObserver(dataSetObserver);
    }
}
