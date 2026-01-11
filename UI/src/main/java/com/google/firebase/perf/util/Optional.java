package com.google.firebase.perf.util;

import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class Optional<T> {

    /* renamed from: a, reason: collision with root package name */
    public final Object f73630a;

    private Optional() {
        this.f73630a = null;
    }

    public static Optional a() {
        return new Optional();
    }

    public static Optional b(Object obj) {
        return obj == null ? a() : e(obj);
    }

    public static Optional e(Object obj) {
        return new Optional(obj);
    }

    public Object c() {
        Object obj = this.f73630a;
        if (obj != null) {
            return obj;
        }
        throw new NoSuchElementException("No value present");
    }

    public boolean d() {
        return this.f73630a != null;
    }

    public Optional(Object obj) {
        if (obj != null) {
            this.f73630a = obj;
            return;
        }
        throw new NullPointerException("value for optional is empty.");
    }
}
