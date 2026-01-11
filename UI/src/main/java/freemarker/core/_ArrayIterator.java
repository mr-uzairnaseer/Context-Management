package freemarker.core;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes8.dex */
public class _ArrayIterator implements Iterator {

    /* renamed from: a, reason: collision with root package name */
    public final Object[] f149803a;

    /* renamed from: b, reason: collision with root package name */
    public int f149804b = 0;

    public _ArrayIterator(Object[] objArr) {
        this.f149803a = objArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f149804b < this.f149803a.length;
    }

    @Override // java.util.Iterator
    public Object next() {
        int i3 = this.f149804b;
        Object[] objArr = this.f149803a;
        if (i3 >= objArr.length) {
            throw new NoSuchElementException();
        }
        this.f149804b = i3 + 1;
        return objArr[i3];
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
