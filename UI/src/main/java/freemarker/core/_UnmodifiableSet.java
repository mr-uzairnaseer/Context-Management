package freemarker.core;

import java.util.AbstractSet;

/* loaded from: classes8.dex */
public abstract class _UnmodifiableSet extends AbstractSet {
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        if (!isEmpty()) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        if (contains(obj)) {
            throw new UnsupportedOperationException();
        }
        return false;
    }
}
