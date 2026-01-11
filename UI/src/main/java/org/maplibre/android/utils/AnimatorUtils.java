package org.maplibre.android.utils;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

/* loaded from: classes9.dex */
public class AnimatorUtils {

    /* renamed from: org.maplibre.android.utils.AnimatorUtils$1, reason: invalid class name */
    class AnonymousClass1 extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f165385a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ OnAnimationEndListener f165386b;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            this.f165385a.setLayerType(0, null);
            OnAnimationEndListener onAnimationEndListener = this.f165386b;
            if (onAnimationEndListener != null) {
                onAnimationEndListener.a();
            }
        }
    }

    /* renamed from: org.maplibre.android.utils.AnimatorUtils$2, reason: invalid class name */
    class AnonymousClass2 extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f165387a;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            this.f165387a.setLayerType(0, null);
        }
    }

    /* renamed from: org.maplibre.android.utils.AnimatorUtils$3, reason: invalid class name */
    class AnonymousClass3 extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f165388a;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            this.f165388a.setLayerType(0, null);
        }
    }

    /* renamed from: org.maplibre.android.utils.AnimatorUtils$4, reason: invalid class name */
    class AnonymousClass4 extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f165389a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ OnAnimationEndListener f165390b;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            this.f165389a.setLayerType(0, null);
            OnAnimationEndListener onAnimationEndListener = this.f165390b;
            if (onAnimationEndListener != null) {
                onAnimationEndListener.a();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            this.f165389a.setVisibility(0);
        }
    }

    public interface OnAnimationEndListener {
        void a();
    }
}
