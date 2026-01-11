package androidx.core.view;

import android.view.View;
import android.view.ViewTreeObserver;

/* loaded from: classes3.dex */
public final class OneShotPreDrawListener implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final View f33729a;

    /* renamed from: b, reason: collision with root package name */
    public ViewTreeObserver f33730b;

    /* renamed from: c, reason: collision with root package name */
    public final Runnable f33731c;

    public OneShotPreDrawListener(View view, Runnable runnable) {
        this.f33729a = view;
        this.f33730b = view.getViewTreeObserver();
        this.f33731c = runnable;
    }

    public static OneShotPreDrawListener a(View view, Runnable runnable) {
        if (view == null) {
            throw new NullPointerException("view == null");
        }
        if (runnable == null) {
            throw new NullPointerException("runnable == null");
        }
        OneShotPreDrawListener oneShotPreDrawListener = new OneShotPreDrawListener(view, runnable);
        view.getViewTreeObserver().addOnPreDrawListener(oneShotPreDrawListener);
        view.addOnAttachStateChangeListener(oneShotPreDrawListener);
        return oneShotPreDrawListener;
    }

    public void b() {
        if (this.f33730b.isAlive()) {
            this.f33730b.removeOnPreDrawListener(this);
        } else {
            this.f33729a.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        this.f33729a.removeOnAttachStateChangeListener(this);
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        b();
        this.f33731c.run();
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        this.f33730b = view.getViewTreeObserver();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        b();
    }
}
