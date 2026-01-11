package androidx.vectordrawable.graphics.drawable;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Animatable2;
import android.graphics.drawable.Drawable;

/* loaded from: classes4.dex */
public interface Animatable2Compat extends Animatable {

    public static abstract class AnimationCallback {

        /* renamed from: a, reason: collision with root package name */
        public Animatable2.AnimationCallback f48909a;

        public Animatable2.AnimationCallback a() {
            if (this.f48909a == null) {
                this.f48909a = new Animatable2.AnimationCallback() { // from class: androidx.vectordrawable.graphics.drawable.Animatable2Compat.AnimationCallback.1
                    @Override // android.graphics.drawable.Animatable2.AnimationCallback
                    public void onAnimationEnd(Drawable drawable) {
                        AnimationCallback.this.b(drawable);
                    }

                    @Override // android.graphics.drawable.Animatable2.AnimationCallback
                    public void onAnimationStart(Drawable drawable) {
                        AnimationCallback.this.c(drawable);
                    }
                };
            }
            return this.f48909a;
        }

        public void b(Drawable drawable) {
        }

        public void c(Drawable drawable) {
        }
    }
}
