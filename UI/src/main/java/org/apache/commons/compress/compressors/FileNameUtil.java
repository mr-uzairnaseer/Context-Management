package org.apache.commons.compress.compressors;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/* loaded from: classes5.dex */
public class FileNameUtil {

    /* renamed from: a, reason: collision with root package name */
    public final Map f160531a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public final Map f160532b;

    /* renamed from: c, reason: collision with root package name */
    public final int f160533c;

    /* renamed from: d, reason: collision with root package name */
    public final int f160534d;

    /* renamed from: e, reason: collision with root package name */
    public final int f160535e;

    /* renamed from: f, reason: collision with root package name */
    public final int f160536f;

    /* renamed from: g, reason: collision with root package name */
    public final String f160537g;

    public FileNameUtil(Map map, String str) {
        this.f160532b = Collections.unmodifiableMap(map);
        int i3 = Integer.MIN_VALUE;
        int i4 = Integer.MAX_VALUE;
        int i5 = Integer.MAX_VALUE;
        int i6 = Integer.MIN_VALUE;
        for (final Map.Entry entry : map.entrySet()) {
            int length = ((String) entry.getKey()).length();
            i3 = length > i3 ? length : i3;
            i4 = length < i4 ? length : i4;
            String str2 = (String) entry.getValue();
            int length2 = str2.length();
            if (length2 > 0) {
                this.f160531a.computeIfAbsent(str2, new Function() { // from class: org.apache.commons.compress.compressors.a
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        return FileNameUtil.a(entry, (String) obj);
                    }
                });
                i6 = length2 > i6 ? length2 : i6;
                if (length2 < i5) {
                    i5 = length2;
                }
            }
        }
        this.f160533c = i3;
        this.f160535e = i6;
        this.f160534d = i4;
        this.f160536f = i5;
        this.f160537g = str;
    }

    public static /* synthetic */ String a(Map.Entry entry, String str) {
        return (String) entry.getKey();
    }
}
