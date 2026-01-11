package com.google.zxing.oned.rss.expanded;

import java.util.List;

/* loaded from: classes5.dex */
final class ExpandedRow {

    /* renamed from: a, reason: collision with root package name */
    public final List f75250a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f75251b;

    public List a() {
        return this.f75250a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ExpandedRow)) {
            return false;
        }
        ExpandedRow expandedRow = (ExpandedRow) obj;
        return this.f75250a.equals(expandedRow.a()) && this.f75251b == expandedRow.f75251b;
    }

    public int hashCode() {
        return this.f75250a.hashCode() ^ Boolean.valueOf(this.f75251b).hashCode();
    }

    public String toString() {
        return "{ " + this.f75250a + " }";
    }
}
