package com.google.android.gms.common.images;

/* loaded from: classes4.dex */
public final class Size {

    /* renamed from: a, reason: collision with root package name */
    public final int f60368a;

    /* renamed from: b, reason: collision with root package name */
    public final int f60369b;

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof Size) {
            Size size = (Size) obj;
            if (this.f60368a == size.f60368a && this.f60369b == size.f60369b) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i3 = this.f60368a;
        return ((i3 >>> 16) | (i3 << 16)) ^ this.f60369b;
    }

    public String toString() {
        return this.f60368a + "x" + this.f60369b;
    }
}
