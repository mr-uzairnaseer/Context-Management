package org.intellij.lang.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX WARN: Method from annotation default annotation not found: source */
/* JADX WARN: Method from annotation default annotation not found: sourceIsContainer */
/* JADX WARN: Method from annotation default annotation not found: target */
/* JADX WARN: Method from annotation default annotation not found: targetIsContainer */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.CLASS)
/* loaded from: classes7.dex */
public @interface Flow {
    public static final String DEFAULT_SOURCE = "The method argument (if parameter was annotated) or this container (if instance method was annotated)";
    public static final String DEFAULT_TARGET = "This container (if the parameter was annotated) or the return value (if instance method was annotated)";
    public static final String RETURN_METHOD_TARGET = "The return value of this method";
    public static final String THIS_SOURCE = "this";
    public static final String THIS_TARGET = "this";
}
