package org.apache.commons.io;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.TemporalAmount;

/* loaded from: classes6.dex */
public final class ThreadUtils {
    @Deprecated
    public ThreadUtils() {
    }

    public static int a(Duration duration) {
        return duration.getNano() % 1000000;
    }

    public static void b(Duration duration) throws InterruptedException {
        Instant instantPlus = Instant.now().plus((TemporalAmount) duration);
        do {
            Thread.sleep(duration.toMillis(), a(duration));
            duration = Duration.between(Instant.now(), instantPlus);
        } while (!duration.isNegative());
    }
}
