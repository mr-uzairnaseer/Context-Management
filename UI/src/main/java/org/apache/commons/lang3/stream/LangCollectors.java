package org.apache.commons.lang3.stream;

import java.util.Collections;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/* loaded from: classes7.dex */
public final class LangCollectors {

    /* renamed from: a, reason: collision with root package name */
    public static final Set f162144a = Collections.EMPTY_SET;

    public static final class SimpleCollector<T, A, R> implements Collector<T, A, R> {

        /* renamed from: a, reason: collision with root package name */
        public final BiConsumer f162145a;

        /* renamed from: b, reason: collision with root package name */
        public final Set f162146b;

        /* renamed from: c, reason: collision with root package name */
        public final BinaryOperator f162147c;

        /* renamed from: d, reason: collision with root package name */
        public final Function f162148d;

        /* renamed from: e, reason: collision with root package name */
        public final Supplier f162149e;

        @Override // java.util.stream.Collector
        public BiConsumer accumulator() {
            return this.f162145a;
        }

        @Override // java.util.stream.Collector
        public Set characteristics() {
            return this.f162146b;
        }

        @Override // java.util.stream.Collector
        public BinaryOperator combiner() {
            return this.f162147c;
        }

        @Override // java.util.stream.Collector
        public Function finisher() {
            return this.f162148d;
        }

        @Override // java.util.stream.Collector
        public Supplier supplier() {
            return this.f162149e;
        }
    }

    private LangCollectors() {
    }
}
