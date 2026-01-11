package com.google.zxing.common;

import java.nio.charset.Charset;

/* loaded from: classes5.dex */
public final class StringUtils {
    public static final String GB2312 = "GB2312";
    public static final String SHIFT_JIS = "SJIS";

    /* renamed from: a, reason: collision with root package name */
    public static final String f75100a;

    /* renamed from: b, reason: collision with root package name */
    public static final boolean f75101b;

    static {
        String strName = Charset.defaultCharset().name();
        f75100a = strName;
        f75101b = SHIFT_JIS.equalsIgnoreCase(strName) || "EUC_JP".equalsIgnoreCase(strName);
    }

    private StringUtils() {
    }
}
