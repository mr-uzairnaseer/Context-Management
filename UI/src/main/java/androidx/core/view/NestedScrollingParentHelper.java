package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public class NestedScrollingParentHelper {

    /* renamed from: a, reason: collision with root package name */
    public int f33727a;

    /* renamed from: b, reason: collision with root package name */
    public int f33728b;

    public NestedScrollingParentHelper(ViewGroup viewGroup) {
    }

    public int a() {
        return this.f33727a | this.f33728b;
    }

    public void b(View view, View view2, int i3) {
        c(view, view2, i3, 0);
    }

    public void c(View view, View view2, int i3, int i4) {
        if (i4 == 1) {
            this.f33728b = i3;
        } else {
            this.f33727a = i3;
        }
    }

    public void d(View view) {
        e(view, 0);
    }

    public void e(View view, int i3) {
        if (i3 == 1) {
            this.f33728b = 0;
        } else {
            this.f33727a = 0;
        }
    }
}
