package com.google.android.material.floatingactionbutton;

import android.animation.Animator;

/* loaded from: classes4.dex */
class AnimatorTracker {

    /* renamed from: a, reason: collision with root package name */
    public Animator f65739a;

    public void a() {
        Animator animator = this.f65739a;
        if (animator != null) {
            animator.cancel();
        }
    }

    public void b() {
        this.f65739a = null;
    }

    public void c(Animator animator) {
        a();
        this.f65739a = animator;
    }
}
