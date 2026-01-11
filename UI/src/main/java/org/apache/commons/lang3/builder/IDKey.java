package org.apache.commons.lang3.builder;

/* loaded from: classes7.dex */
final class IDKey {

    /* renamed from: a, reason: collision with root package name */
    public final Object f162008a;

    /* renamed from: b, reason: collision with root package name */
    public final int f162009b;

    public boolean equals(Object obj) {
        if (!(obj instanceof IDKey)) {
            return false;
        }
        IDKey iDKey = (IDKey) obj;
        return this.f162009b == iDKey.f162009b && this.f162008a == iDKey.f162008a;
    }

    public int hashCode() {
        return this.f162009b;
    }
}
