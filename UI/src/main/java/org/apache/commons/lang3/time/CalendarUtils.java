package org.apache.commons.lang3.time;

import java.util.Calendar;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;

/* loaded from: classes7.dex */
public class CalendarUtils {
    public static final CalendarUtils INSTANCE = b();

    /* renamed from: a, reason: collision with root package name */
    public final Calendar f162225a;

    /* renamed from: b, reason: collision with root package name */
    public final Locale f162226b;

    public CalendarUtils(Calendar calendar) {
        this(calendar, Locale.getDefault());
    }

    public static /* synthetic */ void a(String[] strArr, String str, Integer num) {
        strArr[num.intValue()] = str;
    }

    public static CalendarUtils b() {
        return new CalendarUtils(Calendar.getInstance());
    }

    public static CalendarUtils c(Locale locale) {
        return new CalendarUtils(Calendar.getInstance(locale), locale);
    }

    public String[] d(int i3) {
        Map<String, Integer> displayNames = this.f162225a.getDisplayNames(2, i3, this.f162226b);
        if (displayNames == null) {
            return null;
        }
        final String[] strArr = new String[displayNames.size()];
        displayNames.forEach(new BiConsumer() { // from class: org.apache.commons.lang3.time.b
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                CalendarUtils.a(strArr, (String) obj, (Integer) obj2);
            }
        });
        return strArr;
    }

    public String[] e() {
        return d(32770);
    }

    public String[] f() {
        return d(32769);
    }

    public CalendarUtils(Calendar calendar, Locale locale) {
        Objects.requireNonNull(calendar, "calendar");
        this.f162225a = calendar;
        Objects.requireNonNull(locale, "locale");
        this.f162226b = locale;
    }
}
