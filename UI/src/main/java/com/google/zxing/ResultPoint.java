package com.google.zxing;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes5.dex */
public class ResultPoint {

    /* renamed from: a, reason: collision with root package name */
    public final float f74964a;

    /* renamed from: b, reason: collision with root package name */
    public final float f74965b;

    public final boolean equals(Object obj) {
        if (obj instanceof ResultPoint) {
            ResultPoint resultPoint = (ResultPoint) obj;
            if (this.f74964a == resultPoint.f74964a && this.f74965b == resultPoint.f74965b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (Float.floatToIntBits(this.f74964a) * 31) + Float.floatToIntBits(this.f74965b);
    }

    public final String toString() {
        return "(" + this.f74964a + AbstractJsonLexerKt.COMMA + this.f74965b + ')';
    }
}
