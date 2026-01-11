package org.apache.commons.lang3.function;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;

/* loaded from: classes7.dex */
public class Consumers {

    /* renamed from: a, reason: collision with root package name */
    public static final Consumer f162097a;

    static {
        final Function functionIdentity = Function.identity();
        Objects.requireNonNull(functionIdentity);
        f162097a = new Consumer() { // from class: org.apache.commons.lang3.function.b
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                functionIdentity.apply(obj);
            }
        };
    }

    private Consumers() {
    }
}
