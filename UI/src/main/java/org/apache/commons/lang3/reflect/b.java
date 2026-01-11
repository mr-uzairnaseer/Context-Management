package org.apache.commons.lang3.reflect;

import java.lang.reflect.Method;
import java.util.function.Function;

/* loaded from: classes7.dex */
public final /* synthetic */ class b implements Function {
    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        return ((Method) obj).toString();
    }
}
