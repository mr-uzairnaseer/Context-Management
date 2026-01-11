package com.airbnb.lottie.model;

import org.apache.commons.lang3.StringUtils;

/* loaded from: classes4.dex */
public class Marker {

    /* renamed from: a, reason: collision with root package name */
    public final String f51003a;

    /* renamed from: b, reason: collision with root package name */
    public final float f51004b;

    /* renamed from: c, reason: collision with root package name */
    public final float f51005c;

    public Marker(String str, float f3, float f4) {
        this.f51003a = str;
        this.f51005c = f4;
        this.f51004b = f3;
    }

    public boolean a(String str) {
        if (this.f51003a.equalsIgnoreCase(str)) {
            return true;
        }
        if (this.f51003a.endsWith(StringUtils.CR)) {
            String str2 = this.f51003a;
            if (str2.substring(0, str2.length() - 1).equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }
}
