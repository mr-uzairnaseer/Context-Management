package org.apache.commons.compress.harmony.unpack200;

import java.util.Objects;

/* loaded from: classes5.dex */
public class IcTuple {
    public static final int NESTED_CLASS_FLAG = 65536;

    /* renamed from: h, reason: collision with root package name */
    public static final String[] f161202h = new String[0];

    /* renamed from: i, reason: collision with root package name */
    public static final IcTuple[] f161203i = new IcTuple[0];

    /* renamed from: a, reason: collision with root package name */
    public String f161204a;

    /* renamed from: b, reason: collision with root package name */
    public String f161205b;

    /* renamed from: c, reason: collision with root package name */
    public String f161206c;

    /* renamed from: d, reason: collision with root package name */
    public String f161207d;

    /* renamed from: e, reason: collision with root package name */
    public String f161208e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f161209f;

    /* renamed from: g, reason: collision with root package name */
    public int f161210g;

    public final void a() {
        this.f161209f = true;
        this.f161210g = 17;
        String str = this.f161204a;
        if (str != null) {
            this.f161210g = str.hashCode();
        }
        String str2 = this.f161205b;
        if (str2 != null) {
            this.f161210g = str2.hashCode();
        }
        String str3 = this.f161206c;
        if (str3 != null) {
            this.f161210g = str3.hashCode();
        }
    }

    public String b() {
        return this.f161207d;
    }

    public String c() {
        return this.f161208e;
    }

    public boolean equals(Object obj) {
        if (obj != null && obj.getClass() == getClass()) {
            IcTuple icTuple = (IcTuple) obj;
            if (Objects.equals(this.f161204a, icTuple.f161204a) && Objects.equals(this.f161205b, icTuple.f161205b) && Objects.equals(this.f161206c, icTuple.f161206c)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        if (!this.f161209f) {
            a();
        }
        return this.f161210g;
    }

    public String toString() {
        return "IcTuple (" + c() + " in " + b() + ')';
    }
}
