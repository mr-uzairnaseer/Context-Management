package org.apache.commons.lang3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* loaded from: classes7.dex */
public class LocaleUtils {

    /* renamed from: a, reason: collision with root package name */
    public static final ConcurrentMap f161958a = new ConcurrentHashMap();

    /* renamed from: b, reason: collision with root package name */
    public static final ConcurrentMap f161959b = new ConcurrentHashMap();

    public static class SyncAvoid {

        /* renamed from: a, reason: collision with root package name */
        public static final List f161960a;

        /* renamed from: b, reason: collision with root package name */
        public static final Set f161961b;

        static {
            ArrayList arrayList = new ArrayList(Arrays.asList(Locale.getAvailableLocales()));
            f161960a = Collections.unmodifiableList(arrayList);
            f161961b = Collections.unmodifiableSet(new HashSet(arrayList));
        }
    }

    @Deprecated
    public LocaleUtils() {
    }

    public static Locale a(Locale locale) {
        return locale != null ? locale : Locale.getDefault();
    }
}
