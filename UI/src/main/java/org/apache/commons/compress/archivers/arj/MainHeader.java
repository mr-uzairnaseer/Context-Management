package org.apache.commons.compress.archivers.arj;

import java.util.Arrays;

/* loaded from: classes5.dex */
final class MainHeader {

    /* renamed from: a, reason: collision with root package name */
    public int f159913a;

    /* renamed from: b, reason: collision with root package name */
    public int f159914b;

    /* renamed from: c, reason: collision with root package name */
    public int f159915c;

    /* renamed from: d, reason: collision with root package name */
    public int f159916d;

    /* renamed from: e, reason: collision with root package name */
    public int f159917e;

    /* renamed from: f, reason: collision with root package name */
    public int f159918f;

    /* renamed from: g, reason: collision with root package name */
    public int f159919g;

    /* renamed from: h, reason: collision with root package name */
    public int f159920h;

    /* renamed from: i, reason: collision with root package name */
    public int f159921i;

    /* renamed from: j, reason: collision with root package name */
    public long f159922j;

    /* renamed from: k, reason: collision with root package name */
    public int f159923k;

    /* renamed from: l, reason: collision with root package name */
    public int f159924l;

    /* renamed from: m, reason: collision with root package name */
    public int f159925m;

    /* renamed from: n, reason: collision with root package name */
    public int f159926n;

    /* renamed from: o, reason: collision with root package name */
    public int f159927o;

    /* renamed from: p, reason: collision with root package name */
    public int f159928p;

    /* renamed from: q, reason: collision with root package name */
    public int f159929q;

    /* renamed from: r, reason: collision with root package name */
    public String f159930r;

    /* renamed from: s, reason: collision with root package name */
    public String f159931s;

    /* renamed from: t, reason: collision with root package name */
    public byte[] f159932t;

    public static final class Flags {
    }

    public static final class HostOS {
    }

    public String toString() {
        return "MainHeader [archiverVersionNumber=" + this.f159913a + ", minVersionToExtract=" + this.f159914b + ", hostOS=" + this.f159915c + ", arjFlags=" + this.f159916d + ", securityVersion=" + this.f159917e + ", fileType=" + this.f159918f + ", reserved=" + this.f159919g + ", dateTimeCreated=" + this.f159920h + ", dateTimeModified=" + this.f159921i + ", archiveSize=" + this.f159922j + ", securityEnvelopeFilePosition=" + this.f159923k + ", fileSpecPosition=" + this.f159924l + ", securityEnvelopeLength=" + this.f159925m + ", encryptionVersion=" + this.f159926n + ", lastChapter=" + this.f159927o + ", arjProtectionFactor=" + this.f159928p + ", arjFlags2=" + this.f159929q + ", name=" + this.f159930r + ", comment=" + this.f159931s + ", extendedHeaderBytes=" + Arrays.toString(this.f159932t) + "]";
    }
}
