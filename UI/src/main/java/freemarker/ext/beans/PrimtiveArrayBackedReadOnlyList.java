package freemarker.ext.beans;

import java.lang.reflect.Array;
import java.util.AbstractList;

/* loaded from: classes8.dex */
class PrimtiveArrayBackedReadOnlyList extends AbstractList {

    /* renamed from: a, reason: collision with root package name */
    public final Object f150190a;

    public PrimtiveArrayBackedReadOnlyList(Object obj) {
        this.f150190a = obj;
    }

    @Override // java.util.AbstractList, java.util.List
    public Object get(int i3) {
        return Array.get(this.f150190a, i3);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return Array.getLength(this.f150190a);
    }
}
