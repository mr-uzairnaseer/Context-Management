package org.apache.commons.lang3.function;

import java.util.function.Supplier;

/* loaded from: classes7.dex */
public class Suppliers {

    /* renamed from: a, reason: collision with root package name */
    public static Supplier f162098a = new Supplier() { // from class: org.apache.commons.lang3.function.k0
        @Override // java.util.function.Supplier
        public final Object get() {
            return Suppliers.a();
        }
    };

    @Deprecated
    public Suppliers() {
    }

    public static /* synthetic */ Object a() {
        return null;
    }

    public static Object b(Supplier supplier) {
        if (supplier == null) {
            return null;
        }
        return supplier.get();
    }

    public static Supplier c() {
        return f162098a;
    }
}
