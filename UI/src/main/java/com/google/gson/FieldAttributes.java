package com.google.gson;

import java.lang.reflect.Field;
import java.util.Objects;

/* loaded from: classes5.dex */
public final class FieldAttributes {

    /* renamed from: a, reason: collision with root package name */
    public final Field f74155a;

    public FieldAttributes(Field field) {
        Objects.requireNonNull(field);
        this.f74155a = field;
    }

    public String toString() {
        return this.f74155a.toString();
    }
}
