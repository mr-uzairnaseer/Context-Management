package freemarker.debug;

import java.io.Serializable;

/* loaded from: classes8.dex */
public class Breakpoint implements Serializable, Comparable {

    /* renamed from: a, reason: collision with root package name */
    public final String f149851a;

    /* renamed from: b, reason: collision with root package name */
    public final int f149852b;

    public int a() {
        return this.f149852b;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        Breakpoint breakpoint = (Breakpoint) obj;
        int iCompareTo = this.f149851a.compareTo(breakpoint.f149851a);
        return iCompareTo == 0 ? this.f149852b - breakpoint.f149852b : iCompareTo;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Breakpoint) {
            Breakpoint breakpoint = (Breakpoint) obj;
            if (breakpoint.f149851a.equals(this.f149851a) && breakpoint.f149852b == this.f149852b) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.f149851a.hashCode() + (this.f149852b * 31);
    }
}
