package com.google.firebase.events;

/* loaded from: classes5.dex */
public class Event<T> {

    /* renamed from: a, reason: collision with root package name */
    public final Class f72984a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f72985b;

    public Object a() {
        return this.f72985b;
    }

    public Class b() {
        return this.f72984a;
    }

    public String toString() {
        return String.format("Event{type: %s, payload: %s}", this.f72984a, this.f72985b);
    }
}
