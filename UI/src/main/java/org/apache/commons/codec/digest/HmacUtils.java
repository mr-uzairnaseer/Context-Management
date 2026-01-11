package org.apache.commons.codec.digest;

import javax.crypto.Mac;

/* loaded from: classes4.dex */
public final class HmacUtils {

    /* renamed from: a, reason: collision with root package name */
    public final Mac f159691a;

    @Deprecated
    public HmacUtils() {
        this(null);
    }

    public HmacUtils(Mac mac) {
        this.f159691a = mac;
    }
}
