package org.joda.time.tz;

/* loaded from: classes8.dex */
public class ZoneInfoLogger {

    /* renamed from: a, reason: collision with root package name */
    public static ThreadLocal f163258a = new ThreadLocal<Boolean>() { // from class: org.joda.time.tz.ZoneInfoLogger.1
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean initialValue() {
            return Boolean.FALSE;
        }
    };
}
