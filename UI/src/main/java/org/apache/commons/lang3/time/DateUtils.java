package org.apache.commons.lang3.time;

import java.util.Calendar;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes7.dex */
public class DateUtils {
    public static final long MILLIS_PER_DAY = 86400000;
    public static final long MILLIS_PER_HOUR = 3600000;
    public static final long MILLIS_PER_MINUTE = 60000;
    public static final long MILLIS_PER_SECOND = 1000;
    public static final int RANGE_MONTH_MONDAY = 6;
    public static final int RANGE_MONTH_SUNDAY = 5;
    public static final int RANGE_WEEK_CENTER = 4;
    public static final int RANGE_WEEK_MONDAY = 2;
    public static final int RANGE_WEEK_RELATIVE = 3;
    public static final int RANGE_WEEK_SUNDAY = 1;
    public static final int SEMI_MONTH = 1001;

    /* renamed from: a, reason: collision with root package name */
    public static final int[][] f162228a = {new int[]{14}, new int[]{13}, new int[]{12}, new int[]{11, 10}, new int[]{5, 5, 9}, new int[]{2, 1001}, new int[]{1}, new int[]{0}};

    public static class DateIterator implements Iterator<Calendar> {

        /* renamed from: a, reason: collision with root package name */
        public final Calendar f162229a;

        /* renamed from: b, reason: collision with root package name */
        public final Calendar f162230b;

        @Override // java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Calendar next() {
            if (this.f162230b.equals(this.f162229a)) {
                throw new NoSuchElementException();
            }
            this.f162230b.add(5, 1);
            return (Calendar) this.f162230b.clone();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f162230b.before(this.f162229a);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public enum ModifyType {
        TRUNCATE,
        ROUND,
        CEILING
    }

    @Deprecated
    public DateUtils() {
    }
}
