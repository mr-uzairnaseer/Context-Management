package com.google.android.datatransport;

/* loaded from: classes.dex */
public final class Encoding {

    /* renamed from: a, reason: collision with root package name */
    public final String f58945a;

    public Encoding(String str) {
        if (str == null) {
            throw new NullPointerException("name is null");
        }
        this.f58945a = str;
    }

    public static Encoding b(String str) {
        return new Encoding(str);
    }

    public String a() {
        return this.f58945a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Encoding) {
            return this.f58945a.equals(((Encoding) obj).f58945a);
        }
        return false;
    }

    public int hashCode() {
        return this.f58945a.hashCode() ^ 1000003;
    }

    public String toString() {
        return "Encoding{name=\"" + this.f58945a + "\"}";
    }
}
