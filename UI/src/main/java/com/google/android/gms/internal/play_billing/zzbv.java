package com.google.android.gms.internal.play_billing;

import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/* loaded from: classes4.dex */
final class zzbv {

    /* renamed from: a, reason: collision with root package name */
    public static final Collector f62531a = Collector.of(new Supplier() { // from class: com.google.android.gms.internal.play_billing.zzbj
        @Override // java.util.function.Supplier
        public final Object get() {
            return new zzck(4);
        }
    }, new BiConsumer() { // from class: com.google.android.gms.internal.play_billing.zzbm
        @Override // java.util.function.BiConsumer
        public final void accept(Object obj, Object obj2) {
            ((zzck) obj).e(obj2);
        }
    }, new BinaryOperator() { // from class: com.google.android.gms.internal.play_billing.zzbn
        @Override // java.util.function.BiFunction
        public final Object apply(Object obj, Object obj2) {
            zzck zzckVar = (zzck) obj;
            zzck zzckVar2 = (zzck) obj2;
            zzckVar.c(zzckVar2.f62540a, zzckVar2.f62541b);
            return zzckVar;
        }
    }, new Function() { // from class: com.google.android.gms.internal.play_billing.zzbo
        @Override // java.util.function.Function
        public final Object apply(Object obj) {
            return ((zzck) obj).f();
        }
    }, new Collector.Characteristics[0]);

    static {
        Collector.of(new Supplier() { // from class: com.google.android.gms.internal.play_billing.zzbp
            @Override // java.util.function.Supplier
            public final Object get() {
                return new zzcu();
            }
        }, new BiConsumer() { // from class: com.google.android.gms.internal.play_billing.zzbq
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                ((zzcu) obj).e(obj2);
            }
        }, new BinaryOperator() { // from class: com.google.android.gms.internal.play_billing.zzbr
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                zzcu zzcuVar = (zzcu) obj;
                zzcu zzcuVar2 = (zzcu) obj2;
                zzcuVar.c(zzcuVar2.f62540a, zzcuVar2.f62541b);
                return zzcuVar;
            }
        }, new Function() { // from class: com.google.android.gms.internal.play_billing.zzbs
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                zzcu zzcuVar = (zzcu) obj;
                int i3 = zzcuVar.f62541b;
                if (i3 == 0) {
                    return zzdq.f62593i;
                }
                if (i3 == 1) {
                    Object obj2 = zzcuVar.f62540a[0];
                    Objects.requireNonNull(obj2);
                    return new zzdt(obj2);
                }
                zzcv zzcvVarP = zzcv.p(i3, zzcuVar.f62540a);
                zzcuVar.f62541b = zzcvVarP.size();
                zzcuVar.f62542c = true;
                return zzcvVarP;
            }
        }, new Collector.Characteristics[0]);
        Collector.of(new Supplier() { // from class: com.google.android.gms.internal.play_billing.zzbt
            @Override // java.util.function.Supplier
            public final Object get() {
                return new zzcs();
            }
        }, new BiConsumer() { // from class: com.google.android.gms.internal.play_billing.zzbu
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                ((zzcs) obj).a((zzdh) obj2);
            }
        }, new BinaryOperator() { // from class: com.google.android.gms.internal.play_billing.zzbk
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                zzcs zzcsVar = (zzcs) obj;
                zzcsVar.b((zzcs) obj2);
                return zzcsVar;
            }
        }, new Function() { // from class: com.google.android.gms.internal.play_billing.zzbl
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((zzcs) obj).c();
            }
        }, new Collector.Characteristics[0]);
    }

    public static Collector a() {
        return f62531a;
    }
}
