package org.apache.commons.lang3;

import java.util.function.Predicate;

/* loaded from: classes7.dex */
public class ThreadUtils {

    @Deprecated
    public static final AlwaysTruePredicate ALWAYS_TRUE_PREDICATE = new AlwaysTruePredicate();

    /* renamed from: a, reason: collision with root package name */
    public static final Predicate f161987a = new Predicate() { // from class: org.apache.commons.lang3.y
        @Override // java.util.function.Predicate
        public final boolean test(Object obj) {
            return ThreadUtils.a(obj);
        }
    };

    @Deprecated
    public static final class AlwaysTruePredicate implements ThreadPredicate, ThreadGroupPredicate {
        private AlwaysTruePredicate() {
        }
    }

    @Deprecated
    public static class NamePredicate implements ThreadPredicate, ThreadGroupPredicate {
    }

    @FunctionalInterface
    @Deprecated
    public interface ThreadGroupPredicate {
    }

    @Deprecated
    public static class ThreadIdPredicate implements ThreadPredicate {
    }

    @FunctionalInterface
    @Deprecated
    public interface ThreadPredicate {
    }

    @Deprecated
    public ThreadUtils() {
    }

    public static /* synthetic */ boolean a(Object obj) {
        return true;
    }
}
