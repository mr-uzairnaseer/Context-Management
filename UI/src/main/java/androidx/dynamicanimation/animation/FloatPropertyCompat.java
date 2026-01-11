package androidx.dynamicanimation.animation;

import android.util.FloatProperty;

/* loaded from: classes3.dex */
public abstract class FloatPropertyCompat<T> {

    /* renamed from: a, reason: collision with root package name */
    public final String f35430a;

    /* renamed from: androidx.dynamicanimation.animation.FloatPropertyCompat$1, reason: invalid class name */
    final class AnonymousClass1 extends FloatPropertyCompat<Object> {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ FloatProperty f35431b;

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public float a(Object obj) {
            return ((Float) this.f35431b.get(obj)).floatValue();
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public void b(Object obj, float f3) {
            this.f35431b.setValue(obj, f3);
        }
    }

    public FloatPropertyCompat(String str) {
        this.f35430a = str;
    }

    public abstract float a(Object obj);

    public abstract void b(Object obj, float f3);
}
