package org.apache.commons.io;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* loaded from: classes6.dex */
public class IOExceptionList extends IOException implements Iterable<Throwable> {

    /* renamed from: a, reason: collision with root package name */
    public final List f161352a;

    public IOExceptionList(String str, List list) {
        super(str == null ? g(list) : str, d(list) ? null : (Throwable) list.get(0));
        this.f161352a = list == null ? Collections.EMPTY_LIST : list;
    }

    public static void b(List list, Object obj) throws IOExceptionList {
        if (!d(list)) {
            throw new IOExceptionList(Objects.toString(obj, null), list);
        }
    }

    public static boolean d(List list) {
        return f(list) == 0;
    }

    public static int f(List list) {
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public static String g(List list) {
        return String.format("%,d exception(s): %s", Integer.valueOf(f(list)), list);
    }

    public List c() {
        return new ArrayList(this.f161352a);
    }

    @Override // java.lang.Iterable
    public Iterator<Throwable> iterator() {
        return c().iterator();
    }
}
