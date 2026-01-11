package org.apache.commons.compress.utils;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.ServiceConfigurationError;

@Deprecated
/* loaded from: classes5.dex */
public class ServiceLoaderIterator<E> implements Iterator<E> {

    /* renamed from: a, reason: collision with root package name */
    public Object f161325a;

    /* renamed from: b, reason: collision with root package name */
    public final Class f161326b;

    /* renamed from: c, reason: collision with root package name */
    public final Iterator f161327c;

    @Override // java.util.Iterator
    public boolean hasNext() {
        while (this.f161325a == null) {
            try {
            } catch (ServiceConfigurationError e3) {
                if (!(e3.getCause() instanceof SecurityException)) {
                    throw e3;
                }
            }
            if (!this.f161327c.hasNext()) {
                return false;
            }
            this.f161325a = this.f161327c.next();
        }
        return true;
    }

    @Override // java.util.Iterator
    public Object next() {
        if (hasNext()) {
            Object obj = this.f161325a;
            this.f161325a = null;
            return obj;
        }
        throw new NoSuchElementException("No more elements for service " + this.f161326b.getName());
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("service=" + this.f161326b.getName());
    }
}
