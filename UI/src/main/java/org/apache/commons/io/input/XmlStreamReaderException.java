package org.apache.commons.io.input;

import java.io.IOException;

/* loaded from: classes6.dex */
public class XmlStreamReaderException extends IOException {

    /* renamed from: a, reason: collision with root package name */
    public final String f161729a;

    /* renamed from: b, reason: collision with root package name */
    public final String f161730b;

    /* renamed from: c, reason: collision with root package name */
    public final String f161731c;

    /* renamed from: d, reason: collision with root package name */
    public final String f161732d;

    /* renamed from: e, reason: collision with root package name */
    public final String f161733e;

    public XmlStreamReaderException(String str, String str2, String str3, String str4) {
        this(str, null, null, str2, str3, str4);
    }

    public String a() {
        return this.f161729a;
    }

    public String b() {
        return this.f161733e;
    }

    public String c() {
        return this.f161731c;
    }

    public String d() {
        return this.f161730b;
    }

    public XmlStreamReaderException(String str, String str2, String str3, String str4, String str5, String str6) {
        super(str);
        this.f161732d = str2;
        this.f161733e = str3;
        this.f161729a = str4;
        this.f161730b = str5;
        this.f161731c = str6;
    }
}
