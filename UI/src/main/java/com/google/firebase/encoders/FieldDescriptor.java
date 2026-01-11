package com.google.firebase.encoders;

import java.lang.annotation.Annotation;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class FieldDescriptor {

    /* renamed from: a, reason: collision with root package name */
    public final String f72937a;

    /* renamed from: b, reason: collision with root package name */
    public final Map f72938b;

    /* loaded from: classes5.dex */
    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        public final String f72939a;

        /* renamed from: b, reason: collision with root package name */
        public Map f72940b = null;

        public Builder(String str) {
            this.f72939a = str;
        }

        public FieldDescriptor a() {
            return new FieldDescriptor(this.f72939a, this.f72940b == null ? Collections.EMPTY_MAP : Collections.unmodifiableMap(new HashMap(this.f72940b)));
        }

        public Builder b(Annotation annotation) {
            if (this.f72940b == null) {
                this.f72940b = new HashMap();
            }
            this.f72940b.put(annotation.annotationType(), annotation);
            return this;
        }
    }

    public static Builder a(String str) {
        return new Builder(str);
    }

    public static FieldDescriptor d(String str) {
        return new FieldDescriptor(str, Collections.EMPTY_MAP);
    }

    public String b() {
        return this.f72937a;
    }

    public Annotation c(Class cls) {
        return (Annotation) this.f72938b.get(cls);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FieldDescriptor)) {
            return false;
        }
        FieldDescriptor fieldDescriptor = (FieldDescriptor) obj;
        return this.f72937a.equals(fieldDescriptor.f72937a) && this.f72938b.equals(fieldDescriptor.f72938b);
    }

    public int hashCode() {
        return (this.f72937a.hashCode() * 31) + this.f72938b.hashCode();
    }

    public String toString() {
        return "FieldDescriptor{name=" + this.f72937a + ", properties=" + this.f72938b.values() + "}";
    }

    public FieldDescriptor(String str, Map map) {
        this.f72937a = str;
        this.f72938b = map;
    }
}
