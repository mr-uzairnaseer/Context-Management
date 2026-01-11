package com.google.zxing;

/* loaded from: classes5.dex */
public final class Dimension {

    /* renamed from: a, reason: collision with root package name */
    public final int f74942a;

    /* renamed from: b, reason: collision with root package name */
    public final int f74943b;

    public int a() {
        return this.f74943b;
    }

    public int b() {
        return this.f74942a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Dimension) {
            Dimension dimension = (Dimension) obj;
            if (this.f74942a == dimension.f74942a && this.f74943b == dimension.f74943b) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (this.f74942a * 32713) + this.f74943b;
    }

    public String toString() {
        return this.f74942a + "x" + this.f74943b;
    }
}
