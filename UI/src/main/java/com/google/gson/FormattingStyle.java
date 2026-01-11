package com.google.gson;

import com.squareup.kotlinpoet.FileSpecKt;
import java.util.Objects;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes5.dex */
public class FormattingStyle {
    public static final FormattingStyle COMPACT = new FormattingStyle("", "", false);
    public static final FormattingStyle PRETTY = new FormattingStyle(StringUtils.LF, FileSpecKt.DEFAULT_INDENT, true);

    /* renamed from: a, reason: collision with root package name */
    public final String f74156a;

    /* renamed from: b, reason: collision with root package name */
    public final String f74157b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f74158c;

    public FormattingStyle(String str, String str2, boolean z2) {
        Objects.requireNonNull(str, "newline == null");
        Objects.requireNonNull(str2, "indent == null");
        if (!str.matches("[\r\n]*")) {
            throw new IllegalArgumentException("Only combinations of \\n and \\r are allowed in newline.");
        }
        if (!str2.matches("[ \t]*")) {
            throw new IllegalArgumentException("Only combinations of spaces and tabs are allowed in indent.");
        }
        this.f74156a = str;
        this.f74157b = str2;
        this.f74158c = z2;
    }

    public String a() {
        return this.f74157b;
    }

    public String b() {
        return this.f74156a;
    }

    public boolean c() {
        return this.f74158c;
    }
}
