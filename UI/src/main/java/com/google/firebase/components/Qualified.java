package com.google.firebase.components;

/* loaded from: classes.dex */
public final class Qualified<T> {

    /* renamed from: a, reason: collision with root package name */
    public final Class f71981a;

    /* renamed from: b, reason: collision with root package name */
    public final Class f71982b;

    public @interface Unqualified {
    }

    public Qualified(Class cls, Class cls2) {
        this.f71981a = cls;
        this.f71982b = cls2;
    }

    public static Qualified a(Class cls, Class cls2) {
        return new Qualified(cls, cls2);
    }

    public static Qualified b(Class cls) {
        return new Qualified(Unqualified.class, cls);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Qualified.class != obj.getClass()) {
            return false;
        }
        Qualified qualified = (Qualified) obj;
        if (this.f71982b.equals(qualified.f71982b)) {
            return this.f71981a.equals(qualified.f71981a);
        }
        return false;
    }

    public int hashCode() {
        return (this.f71982b.hashCode() * 31) + this.f71981a.hashCode();
    }

    public String toString() {
        if (this.f71981a == Unqualified.class) {
            return this.f71982b.getName();
        }
        return "@" + this.f71981a.getName() + " " + this.f71982b.getName();
    }
}
