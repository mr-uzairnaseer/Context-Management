package com.google.android.gms.wearable;

import java.io.IOException;

/* loaded from: classes4.dex */
public class ChannelIOException extends IOException {

    /* renamed from: a, reason: collision with root package name */
    public final int f64184a;

    /* renamed from: b, reason: collision with root package name */
    public final int f64185b;

    public ChannelIOException(String str, int i3, int i4) {
        super(str);
        this.f64184a = i3;
        this.f64185b = i4;
    }
}
