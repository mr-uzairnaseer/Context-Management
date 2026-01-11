package com.google.android.material.datepicker;

import java.util.Calendar;
import java.util.TimeZone;

/* loaded from: classes4.dex */
class TimeSource {

    /* renamed from: c, reason: collision with root package name */
    public static final TimeSource f65689c = new TimeSource(null, null);

    /* renamed from: a, reason: collision with root package name */
    public final Long f65690a;

    /* renamed from: b, reason: collision with root package name */
    public final TimeZone f65691b;

    public TimeSource(Long l3, TimeZone timeZone) {
        this.f65690a = l3;
        this.f65691b = timeZone;
    }

    public static TimeSource c() {
        return f65689c;
    }

    public Calendar a() {
        return b(this.f65691b);
    }

    public Calendar b(TimeZone timeZone) {
        Calendar calendar = timeZone == null ? Calendar.getInstance() : Calendar.getInstance(timeZone);
        Long l3 = this.f65690a;
        if (l3 != null) {
            calendar.setTimeInMillis(l3.longValue());
        }
        return calendar;
    }
}
