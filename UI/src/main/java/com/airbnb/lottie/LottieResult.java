package com.airbnb.lottie;

import java.util.Arrays;

/* loaded from: classes4.dex */
public final class LottieResult<V> {

    /* renamed from: a, reason: collision with root package name */
    public final Object f50405a;

    /* renamed from: b, reason: collision with root package name */
    public final Throwable f50406b;

    public LottieResult(Object obj) {
        this.f50405a = obj;
        this.f50406b = null;
    }

    public Throwable a() {
        return this.f50406b;
    }

    public Object b() {
        return this.f50405a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LottieResult)) {
            return false;
        }
        LottieResult lottieResult = (LottieResult) obj;
        if (b() != null && b().equals(lottieResult.b())) {
            return true;
        }
        if (a() == null || lottieResult.a() == null) {
            return false;
        }
        return a().toString().equals(a().toString());
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{b(), a()});
    }

    public LottieResult(Throwable th) {
        this.f50406b = th;
        this.f50405a = null;
    }
}
