package org.apache.commons.lang3.util;

import java.io.Serializable;
import java.util.BitSet;
import java.util.Objects;

/* loaded from: classes7.dex */
public final class FluentBitSet implements Cloneable, Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final BitSet f162358a;

    public FluentBitSet() {
        this(new BitSet());
    }

    public Object clone() {
        return new FluentBitSet((BitSet) this.f162358a.clone());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FluentBitSet) {
            return Objects.equals(this.f162358a, ((FluentBitSet) obj).f162358a);
        }
        return false;
    }

    public int hashCode() {
        return this.f162358a.hashCode();
    }

    public String toString() {
        return this.f162358a.toString();
    }

    public FluentBitSet(BitSet bitSet) {
        Objects.requireNonNull(bitSet, "set");
        this.f162358a = bitSet;
    }
}
