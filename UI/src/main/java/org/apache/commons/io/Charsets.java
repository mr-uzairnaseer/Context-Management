package org.apache.commons.io;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.SortedMap;
import java.util.TreeMap;

/* loaded from: classes6.dex */
public class Charsets {

    @Deprecated
    public static final Charset ISO_8859_1;

    @Deprecated
    public static final Charset US_ASCII;

    @Deprecated
    public static final Charset UTF_16;

    @Deprecated
    public static final Charset UTF_16BE;

    @Deprecated
    public static final Charset UTF_16LE;

    @Deprecated
    public static final Charset UTF_8;

    /* renamed from: a, reason: collision with root package name */
    public static final SortedMap f161332a;

    static {
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        Charset charset = StandardCharsets.ISO_8859_1;
        treeMap.put(charset.name(), charset);
        Charset charset2 = StandardCharsets.US_ASCII;
        treeMap.put(charset2.name(), charset2);
        Charset charset3 = StandardCharsets.UTF_16;
        treeMap.put(charset3.name(), charset3);
        Charset charset4 = StandardCharsets.UTF_16BE;
        treeMap.put(charset4.name(), charset4);
        Charset charset5 = StandardCharsets.UTF_16LE;
        treeMap.put(charset5.name(), charset5);
        Charset charset6 = StandardCharsets.UTF_8;
        treeMap.put(charset6.name(), charset6);
        f161332a = Collections.unmodifiableSortedMap(treeMap);
        ISO_8859_1 = charset;
        US_ASCII = charset2;
        UTF_16 = charset3;
        UTF_16BE = charset4;
        UTF_16LE = charset5;
        UTF_8 = charset6;
    }

    public static Charset a(String str) {
        return b(str, Charset.defaultCharset());
    }

    public static Charset b(String str, Charset charset) {
        return str == null ? charset : Charset.forName(str);
    }

    public static Charset c(Charset charset) {
        return charset == null ? Charset.defaultCharset() : charset;
    }

    public static Charset d(Charset charset, Charset charset2) {
        return charset == null ? charset2 : charset;
    }
}
