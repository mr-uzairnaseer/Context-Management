package com.google.firebase.perf.util;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewTreeObserver;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public class FirstDrawDoneListener implements ViewTreeObserver.OnDrawListener {

    /* renamed from: a, reason: collision with root package name */
    public final Handler f73624a = new Handler(Looper.getMainLooper());

    /* renamed from: b, reason: collision with root package name */
    public final AtomicReference f73625b;

    /* renamed from: c, reason: collision with root package name */
    public final Runnable f73626c;

    /* renamed from: com.google.firebase.perf.util.FirstDrawDoneListener$1, reason: invalid class name */
    /* loaded from: classes5.dex */
    public class AnonymousClass1 implements View.OnAttachStateChangeListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FirstDrawDoneListener f73627a;

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            view.getViewTreeObserver().addOnDrawListener(this.f73627a);
            view.removeOnAttachStateChangeListener(this);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            view.removeOnAttachStateChangeListener(this);
        }
    }

    public FirstDrawDoneListener(View view, Runnable runnable) {
        this.f73625b = new AtomicReference(view);
        this.f73626c = runnable;
    }

    public static /* synthetic */ void a(FirstDrawDoneListener firstDrawDoneListener, View view) {
        firstDrawDoneListener.getClass();
        view.getViewTreeObserver().removeOnDrawListener(firstDrawDoneListener);
    }

    public static void b(View view, Runnable runnable) {
        view.getViewTreeObserver().addOnDrawListener(new FirstDrawDoneListener(view, runnable));
    }

    @Override // android.view.ViewTreeObserver.OnDrawListener
    public void onDraw() {
        final View view = (View) this.f73625b.getAndSet(null);
        if (view == null) {
            return;
        }
        view.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.google.firebase.perf.util.a
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                FirstDrawDoneListener.a(this.f73645a, view);
            }
        });
        this.f73624a.postAtFrontOfQueue(this.f73626c);
    }
}
