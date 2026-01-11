package com.google.j2objc.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX WARN: Method from annotation default annotation not found: value */
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.TYPE})
@Documented
@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes5.dex */
public @interface Property {

    /* JADX WARN: Method from annotation default annotation not found: reason */
    @Target({ElementType.METHOD})
    public @interface Suppress {
    }
}
