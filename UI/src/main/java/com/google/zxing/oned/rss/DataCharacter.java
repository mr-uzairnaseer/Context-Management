package com.google.zxing.oned.rss;

/* loaded from: classes5.dex */
public class DataCharacter {

    /* renamed from: a, reason: collision with root package name */
    public final int f75235a;

    /* renamed from: b, reason: collision with root package name */
    public final int f75236b;

    public final boolean equals(Object obj) {
        if (!(obj instanceof DataCharacter)) {
            return false;
        }
        DataCharacter dataCharacter = (DataCharacter) obj;
        return this.f75235a == dataCharacter.f75235a && this.f75236b == dataCharacter.f75236b;
    }

    public final int hashCode() {
        return this.f75235a ^ this.f75236b;
    }

    public final String toString() {
        return this.f75235a + "(" + this.f75236b + ')';
    }
}
