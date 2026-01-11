package org.apache.commons.lang3.math;

/* loaded from: classes7.dex */
public final class Fraction extends Number implements Comparable<Fraction> {

    /* renamed from: a, reason: collision with root package name */
    public final int f162102a;

    /* renamed from: b, reason: collision with root package name */
    public final int f162103b;

    /* renamed from: c, reason: collision with root package name */
    public transient int f162104c;

    /* renamed from: d, reason: collision with root package name */
    public transient String f162105d;
    public static final Fraction ZERO = new Fraction(0, 1);
    public static final Fraction ONE = new Fraction(1, 1);
    public static final Fraction ONE_HALF = new Fraction(1, 2);
    public static final Fraction ONE_THIRD = new Fraction(1, 3);
    public static final Fraction TWO_THIRDS = new Fraction(2, 3);
    public static final Fraction ONE_QUARTER = new Fraction(1, 4);
    public static final Fraction TWO_QUARTERS = new Fraction(2, 4);
    public static final Fraction THREE_QUARTERS = new Fraction(3, 4);
    public static final Fraction ONE_FIFTH = new Fraction(1, 5);
    public static final Fraction TWO_FIFTHS = new Fraction(2, 5);
    public static final Fraction THREE_FIFTHS = new Fraction(3, 5);
    public static final Fraction FOUR_FIFTHS = new Fraction(4, 5);

    public Fraction(int i3, int i4) {
        this.f162102a = i3;
        this.f162103b = i4;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(Fraction fraction) {
        if (this == fraction) {
            return 0;
        }
        int i3 = this.f162102a;
        int i4 = fraction.f162102a;
        if (i3 == i4 && this.f162103b == fraction.f162103b) {
            return 0;
        }
        return Long.compare(i3 * fraction.f162103b, i4 * this.f162103b);
    }

    public int c() {
        return this.f162103b;
    }

    public int d() {
        return this.f162102a;
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return this.f162102a / this.f162103b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Fraction)) {
            return false;
        }
        Fraction fraction = (Fraction) obj;
        return d() == fraction.d() && c() == fraction.c();
    }

    @Override // java.lang.Number
    public float floatValue() {
        return this.f162102a / this.f162103b;
    }

    public int hashCode() {
        if (this.f162104c == 0) {
            this.f162104c = ((d() + 629) * 37) + c();
        }
        return this.f162104c;
    }

    @Override // java.lang.Number
    public int intValue() {
        return this.f162102a / this.f162103b;
    }

    @Override // java.lang.Number
    public long longValue() {
        return this.f162102a / this.f162103b;
    }

    public String toString() {
        if (this.f162105d == null) {
            this.f162105d = d() + "/" + c();
        }
        return this.f162105d;
    }
}
