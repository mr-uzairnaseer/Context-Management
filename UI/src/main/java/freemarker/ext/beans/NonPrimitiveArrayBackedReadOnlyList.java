package freemarker.ext.beans;

import java.util.AbstractList;

/* loaded from: classes8.dex */
class NonPrimitiveArrayBackedReadOnlyList extends AbstractList {

    /* renamed from: a, reason: collision with root package name */
    public final Object[] f150110a;

    public NonPrimitiveArrayBackedReadOnlyList(Object[] objArr) {
        this.f150110a = objArr;
    }

    @Override // java.util.AbstractList, java.util.List
    public Object get(int i3) {
        return this.f150110a[i3];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f150110a.length;
    }
}
