package org.apache.commons.compress.archivers.sevenz;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes5.dex */
final class AES256Options {

    /* renamed from: e, reason: collision with root package name */
    public static final byte[] f160031e = new byte[0];

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f160032a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f160033b;

    /* renamed from: c, reason: collision with root package name */
    public final int f160034c;

    /* renamed from: d, reason: collision with root package name */
    public final Cipher f160035d;

    public static SecretKeySpec e(byte[] bArr) {
        return new SecretKeySpec(bArr, "AES");
    }

    public Cipher a() {
        return this.f160035d;
    }

    public byte[] b() {
        return this.f160033b;
    }

    public int c() {
        return this.f160034c;
    }

    public byte[] d() {
        return this.f160032a;
    }
}
