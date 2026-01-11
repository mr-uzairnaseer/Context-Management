package org.joda.time.tz;

import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import androidx.media3.exoplayer.upstream.CmcdData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes8.dex */
public class ZoneInfoCompiler {

    /* renamed from: e, reason: collision with root package name */
    public static final Set f163226e = a("rule", "r");

    /* renamed from: f, reason: collision with root package name */
    public static final Set f163227f = a("zone", "z");

    /* renamed from: g, reason: collision with root package name */
    public static final Set f163228g = a("link", CmcdData.Factory.STREAM_TYPE_LIVE);

    /* renamed from: h, reason: collision with root package name */
    public static final Set f163229h = a("minimum", "mi");

    /* renamed from: i, reason: collision with root package name */
    public static final Set f163230i = a("maximum", "ma");

    /* renamed from: j, reason: collision with root package name */
    public static final Set f163231j = a("only", "o");

    /* renamed from: k, reason: collision with root package name */
    public static final Map f163232k;

    /* renamed from: l, reason: collision with root package name */
    public static final Map f163233l;

    /* renamed from: a, reason: collision with root package name */
    public Map f163234a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public List f163235b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public List f163236c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    public List f163237d = new ArrayList();

    public static class DateTimeOfYear {

        /* renamed from: a, reason: collision with root package name */
        public final int f163238a = 1;

        /* renamed from: b, reason: collision with root package name */
        public final int f163239b = 1;

        /* renamed from: c, reason: collision with root package name */
        public final int f163240c = 0;

        /* renamed from: d, reason: collision with root package name */
        public final boolean f163241d = false;

        /* renamed from: e, reason: collision with root package name */
        public final int f163242e = 0;

        /* renamed from: f, reason: collision with root package name */
        public final char f163243f = 'w';

        public String toString() {
            return "MonthOfYear: " + this.f163238a + "\nDayOfMonth: " + this.f163239b + "\nDayOfWeek: " + this.f163240c + "\nAdvanceDayOfWeek: " + this.f163241d + "\nMillisOfDay: " + this.f163242e + "\nZoneChar: " + this.f163243f + StringUtils.LF;
        }
    }

    public static class Rule {

        /* renamed from: a, reason: collision with root package name */
        public final String f163244a;

        /* renamed from: b, reason: collision with root package name */
        public final int f163245b;

        /* renamed from: c, reason: collision with root package name */
        public final int f163246c;

        /* renamed from: d, reason: collision with root package name */
        public final String f163247d;

        /* renamed from: e, reason: collision with root package name */
        public final DateTimeOfYear f163248e;

        /* renamed from: f, reason: collision with root package name */
        public final int f163249f;

        /* renamed from: g, reason: collision with root package name */
        public final String f163250g;

        public String toString() {
            return "[Rule]\nName: " + this.f163244a + "\nFromYear: " + this.f163245b + "\nToYear: " + this.f163246c + "\nType: " + this.f163247d + StringUtils.LF + this.f163248e + "SaveMillis: " + this.f163249f + "\nLetterS: " + this.f163250g + StringUtils.LF;
        }
    }

    public static class RuleSet {
    }

    public static class Zone {

        /* renamed from: a, reason: collision with root package name */
        public final String f163251a;

        /* renamed from: b, reason: collision with root package name */
        public final int f163252b;

        /* renamed from: c, reason: collision with root package name */
        public final String f163253c;

        /* renamed from: d, reason: collision with root package name */
        public final String f163254d;

        /* renamed from: e, reason: collision with root package name */
        public final int f163255e;

        /* renamed from: f, reason: collision with root package name */
        public final DateTimeOfYear f163256f;

        /* renamed from: g, reason: collision with root package name */
        public Zone f163257g;

        public String toString() {
            String str = "[Zone]\nName: " + this.f163251a + "\nOffsetMillis: " + this.f163252b + "\nRules: " + this.f163253c + "\nFormat: " + this.f163254d + "\nUntilYear: " + this.f163255e + StringUtils.LF + this.f163256f;
            if (this.f163257g == null) {
                return str;
            }
            return str + "...\n" + this.f163257g.toString();
        }
    }

    static {
        HashMap map = new HashMap();
        f163232k = map;
        b(a("january", "ja"), 1, map);
        b(a("february", "f"), 2, map);
        b(a("march", "mar"), 3, map);
        b(a("april", "ap"), 4, map);
        b(a("may", "may"), 5, map);
        b(a("june", "jun"), 6, map);
        b(a("july", "jul"), 7, map);
        b(a("august", "au"), 8, map);
        b(a("september", CmcdData.Factory.STREAMING_FORMAT_SS), 9, map);
        b(a("october", "o"), 10, map);
        b(a("november", "n"), 11, map);
        b(a("december", "d"), 12, map);
        HashMap map2 = new HashMap();
        f163233l = map2;
        b(a("monday", "m"), 1, map2);
        b(a("tuesday", "tu"), 2, map2);
        b(a("wednesday", "w"), 3, map2);
        b(a("thursday", "th"), 4, map2);
        b(a("friday", "f"), 5, map2);
        b(a("saturday", "sa"), 6, map2);
        b(a("sunday", CmcdConfiguration.KEY_STARTUP), 7, map2);
    }

    public static Set a(String str, String str2) {
        HashSet hashSet = new HashSet();
        while (!str.equals(str2)) {
            hashSet.add(str);
            str = str.substring(0, str.length() - 1);
        }
        hashSet.add(str);
        return hashSet;
    }

    public static void b(Set set, int i3, Map map) {
        Iterator it = set.iterator();
        while (it.hasNext()) {
            map.put(it.next(), Integer.valueOf(i3));
        }
    }
}
