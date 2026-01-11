package org.apache.commons.io;

import java.util.Iterator;
import java.util.stream.Stream;

/* loaded from: classes6.dex */
public final class StreamIterator<E> implements Iterator<E>, AutoCloseable {

    /* renamed from: a, reason: collision with root package name */
    public final Iterator f161361a;

    /* renamed from: b, reason: collision with root package name */
    public final Stream f161362b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f161363c;

    @Override // java.lang.AutoCloseable
    public void close() {
        this.f161363c = true;
        this.f161362b.close();
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.f161363c) {
            return false;
        }
        boolean zHasNext = this.f161361a.hasNext();
        if (!zHasNext) {
            close();
        }
        return zHasNext;
    }

    @Override // java.util.Iterator
    public Object next() {
        Object next = this.f161361a.next();
        if (next == null) {
            close();
        }
        return next;
    }
}
