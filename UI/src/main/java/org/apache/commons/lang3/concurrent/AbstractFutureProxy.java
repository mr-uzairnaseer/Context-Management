package org.apache.commons.lang3.concurrent;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* loaded from: classes7.dex */
public abstract class AbstractFutureProxy<V> implements Future<V> {

    /* renamed from: a, reason: collision with root package name */
    public final Future f162051a;

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z2) {
        return this.f162051a.cancel(z2);
    }

    @Override // java.util.concurrent.Future
    public Object get() {
        return this.f162051a.get();
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.f162051a.isCancelled();
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return this.f162051a.isDone();
    }

    @Override // java.util.concurrent.Future
    public Object get(long j3, TimeUnit timeUnit) {
        return this.f162051a.get(j3, timeUnit);
    }
}
