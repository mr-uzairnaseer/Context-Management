package com.google.firebase.perf.util;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewTreeObserver;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public class PreDrawListener implements ViewTreeObserver.OnPreDrawListener {

    /* renamed from: a, reason: collision with root package name */
    public final Handler f73631a = new Handler(Looper.getMainLooper());

    /* renamed from: b, reason: collision with root package name */
    public final AtomicReference f73632b;

    /* renamed from: c, reason: collision with root package name */
    public final Runnable f73633c;

    /* renamed from: d, reason: collision with root package name */
    public final Runnable f73634d;

    public PreDrawListener(View view, Runnable runnable, Runnable runnable2) {
        this.f73632b = new AtomicReference(view);
        this.f73633c = runnable;
        this.f73634d = runnable2;
    }

    public static void a(View view, Runnable runnable, Runnable runnable2) {
        view.getViewTreeObserver().addOnPreDrawListener(new PreDrawListener(view, runnable, runnable2));
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        View view = (View) this.f73632b.getAndSet(null);
        if (view == null) {
            return true;
        }
        view.getViewTreeObserver().removeOnPreDrawListener(this);
        this.f73631a.post(this.f73633c);
        this.f73631a.postAtFrontOfQueue(this.f73634d);
        return true;
    }
}
