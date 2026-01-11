package com.google.crypto.tink.subtle;

import java.security.SecureRandom;

/* loaded from: classes5.dex */
public final class Random {

    /* renamed from: a, reason: collision with root package name */
    public static final ThreadLocal f71694a = new ThreadLocal<SecureRandom>() { // from class: com.google.crypto.tink.subtle.Random.1
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public SecureRandom initialValue() {
            return Random.b();
        }
    };

    private Random() {
    }

    public static SecureRandom b() {
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextLong();
        return secureRandom;
    }

    public static byte[] c(int i3) {
        byte[] bArr = new byte[i3];
        ((SecureRandom) f71694a.get()).nextBytes(bArr);
        return bArr;
    }

    public static final int d() {
        return ((SecureRandom) f71694a.get()).nextInt();
    }
}
