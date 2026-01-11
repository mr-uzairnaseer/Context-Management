package org.jetbrains.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* loaded from: classes7.dex */
public final class Debug {

    /* JADX WARN: Method from annotation default annotation not found: childrenArray */
    /* JADX WARN: Method from annotation default annotation not found: hasChildren */
    /* JADX WARN: Method from annotation default annotation not found: text */
    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.CLASS)
    public @interface Renderer {
    }

    private Debug() {
        throw new AssertionError("Debug should not be instantiated");
    }
}
