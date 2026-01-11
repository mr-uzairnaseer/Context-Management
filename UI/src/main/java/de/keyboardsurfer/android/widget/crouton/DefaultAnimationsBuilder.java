package de.keyboardsurfer.android.widget.crouton;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;

/* loaded from: classes5.dex */
final class DefaultAnimationsBuilder {

    /* renamed from: a, reason: collision with root package name */
    public static Animation f76259a;

    /* renamed from: b, reason: collision with root package name */
    public static Animation f76260b;

    /* renamed from: c, reason: collision with root package name */
    public static int f76261c;

    /* renamed from: d, reason: collision with root package name */
    public static int f76262d;

    private DefaultAnimationsBuilder() {
    }

    public static boolean a(int i3, View view) {
        return i3 == view.getMeasuredHeight();
    }

    public static boolean b(View view) {
        return a(f76261c, view);
    }

    public static boolean c(View view) {
        return a(f76262d, view);
    }

    public static Animation d(View view) {
        if (!b(view) || f76259a == null) {
            TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, -view.getMeasuredHeight(), 0.0f);
            f76259a = translateAnimation;
            translateAnimation.setDuration(400L);
            f(view.getMeasuredHeight());
        }
        return f76259a;
    }

    public static Animation e(View view) {
        if (!c(view) || f76260b == null) {
            TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, -view.getMeasuredHeight());
            f76260b = translateAnimation;
            translateAnimation.setDuration(400L);
            g(view.getMeasuredHeight());
        }
        return f76260b;
    }

    public static void f(int i3) {
        f76261c = i3;
    }

    public static void g(int i3) {
        f76262d = i3;
    }
}
