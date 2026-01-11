package org.apache.commons.lang3;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Objects;

/* loaded from: classes7.dex */
public class Range<T> implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final Comparator f161973a;

    /* renamed from: b, reason: collision with root package name */
    public transient int f161974b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f161975c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f161976d;

    /* renamed from: e, reason: collision with root package name */
    public transient String f161977e;

    public enum ComparableComparator implements Comparator {
        INSTANCE;

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            return ((Comparable) obj).compareTo(obj2);
        }
    }

    public Range(Object obj, Object obj2, Comparator comparator) {
        Objects.requireNonNull(obj, "element1");
        Objects.requireNonNull(obj2, "element2");
        if (comparator == null) {
            this.f161973a = ComparableComparator.INSTANCE;
        } else {
            this.f161973a = comparator;
        }
        if (this.f161973a.compare(obj, obj2) < 1) {
            this.f161976d = obj;
            this.f161975c = obj2;
        } else {
            this.f161976d = obj2;
            this.f161975c = obj;
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && obj.getClass() == getClass()) {
            Range range = (Range) obj;
            if (this.f161976d.equals(range.f161976d) && this.f161975c.equals(range.f161975c)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i3 = this.f161974b;
        if (i3 != 0) {
            return i3;
        }
        int iHashCode = ((((629 + getClass().hashCode()) * 37) + this.f161976d.hashCode()) * 37) + this.f161975c.hashCode();
        this.f161974b = iHashCode;
        return iHashCode;
    }

    public String toString() {
        if (this.f161977e == null) {
            this.f161977e = "[" + this.f161976d + ".." + this.f161975c + "]";
        }
        return this.f161977e;
    }
}
