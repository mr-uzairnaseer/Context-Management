package org.apache.commons.io.file;

import com.facebook.appevents.AppEventsConstants;
import java.math.BigInteger;
import java.util.Objects;

/* loaded from: classes6.dex */
public class Counters {

    public static class AbstractPathCounters implements PathCounters {

        /* renamed from: a, reason: collision with root package name */
        public final Counter f161400a;

        /* renamed from: b, reason: collision with root package name */
        public final Counter f161401b;

        /* renamed from: c, reason: collision with root package name */
        public final Counter f161402c;

        public AbstractPathCounters(Counter counter, Counter counter2, Counter counter3) {
            this.f161400a = counter;
            this.f161401b = counter2;
            this.f161402c = counter3;
        }

        @Override // org.apache.commons.io.file.Counters.PathCounters
        public Counter a() {
            return this.f161402c;
        }

        @Override // org.apache.commons.io.file.Counters.PathCounters
        public Counter b() {
            return this.f161400a;
        }

        @Override // org.apache.commons.io.file.Counters.PathCounters
        public Counter c() {
            return this.f161401b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof AbstractPathCounters)) {
                return false;
            }
            AbstractPathCounters abstractPathCounters = (AbstractPathCounters) obj;
            return Objects.equals(this.f161400a, abstractPathCounters.f161400a) && Objects.equals(this.f161401b, abstractPathCounters.f161401b) && Objects.equals(this.f161402c, abstractPathCounters.f161402c);
        }

        public int hashCode() {
            return Objects.hash(this.f161400a, this.f161401b, this.f161402c);
        }

        public String toString() {
            return String.format("%,d files, %,d directories, %,d bytes", Long.valueOf(this.f161402c.get()), Long.valueOf(this.f161401b.get()), Long.valueOf(this.f161400a.get()));
        }
    }

    public static final class BigIntegerCounter implements Counter {

        /* renamed from: a, reason: collision with root package name */
        public BigInteger f161403a;

        private BigIntegerCounter() {
            this.f161403a = BigInteger.ZERO;
        }

        @Override // org.apache.commons.io.file.Counters.Counter
        public void a() {
            this.f161403a = this.f161403a.add(BigInteger.ONE);
        }

        @Override // org.apache.commons.io.file.Counters.Counter
        public void add(long j3) {
            this.f161403a = this.f161403a.add(BigInteger.valueOf(j3));
        }

        @Override // org.apache.commons.io.file.Counters.Counter
        public Long b() {
            return Long.valueOf(this.f161403a.longValueExact());
        }

        @Override // org.apache.commons.io.file.Counters.Counter
        public BigInteger c() {
            return this.f161403a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Counter) {
                return Objects.equals(this.f161403a, ((Counter) obj).c());
            }
            return false;
        }

        @Override // org.apache.commons.io.file.Counters.Counter
        public long get() {
            return this.f161403a.longValueExact();
        }

        public int hashCode() {
            return Objects.hash(this.f161403a);
        }

        public String toString() {
            return this.f161403a.toString();
        }
    }

    public static final class BigIntegerPathCounters extends AbstractPathCounters {
        public BigIntegerPathCounters() {
            super(Counters.a(), Counters.a(), Counters.a());
        }
    }

    public interface Counter {
        void a();

        void add(long j3);

        Long b();

        BigInteger c();

        long get();
    }

    public static final class LongCounter implements Counter {

        /* renamed from: a, reason: collision with root package name */
        public long f161404a;

        private LongCounter() {
        }

        @Override // org.apache.commons.io.file.Counters.Counter
        public void a() {
            this.f161404a++;
        }

        @Override // org.apache.commons.io.file.Counters.Counter
        public void add(long j3) {
            this.f161404a += j3;
        }

        @Override // org.apache.commons.io.file.Counters.Counter
        public Long b() {
            return Long.valueOf(this.f161404a);
        }

        @Override // org.apache.commons.io.file.Counters.Counter
        public BigInteger c() {
            return BigInteger.valueOf(this.f161404a);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Counter) && this.f161404a == ((Counter) obj).get();
        }

        @Override // org.apache.commons.io.file.Counters.Counter
        public long get() {
            return this.f161404a;
        }

        public int hashCode() {
            return Objects.hash(Long.valueOf(this.f161404a));
        }

        public String toString() {
            return Long.toString(this.f161404a);
        }
    }

    public static final class LongPathCounters extends AbstractPathCounters {
        public LongPathCounters() {
            super(Counters.b(), Counters.b(), Counters.b());
        }
    }

    public static final class NoopCounter implements Counter {

        /* renamed from: a, reason: collision with root package name */
        public static final NoopCounter f161405a = new NoopCounter();

        private NoopCounter() {
        }

        @Override // org.apache.commons.io.file.Counters.Counter
        public void a() {
        }

        @Override // org.apache.commons.io.file.Counters.Counter
        public void add(long j3) {
        }

        @Override // org.apache.commons.io.file.Counters.Counter
        public Long b() {
            return 0L;
        }

        @Override // org.apache.commons.io.file.Counters.Counter
        public BigInteger c() {
            return BigInteger.ZERO;
        }

        @Override // org.apache.commons.io.file.Counters.Counter
        public long get() {
            return 0L;
        }

        public String toString() {
            return AppEventsConstants.EVENT_PARAM_VALUE_NO;
        }
    }

    public static final class NoopPathCounters extends AbstractPathCounters {

        /* renamed from: d, reason: collision with root package name */
        public static final NoopPathCounters f161406d = new NoopPathCounters();

        private NoopPathCounters() {
            super(Counters.d(), Counters.d(), Counters.d());
        }
    }

    public interface PathCounters {
        Counter a();

        Counter b();

        Counter c();
    }

    public static Counter a() {
        return new BigIntegerCounter();
    }

    public static Counter b() {
        return new LongCounter();
    }

    public static PathCounters c() {
        return new LongPathCounters();
    }

    public static Counter d() {
        return NoopCounter.f161405a;
    }

    public static PathCounters e() {
        return NoopPathCounters.f161406d;
    }
}
