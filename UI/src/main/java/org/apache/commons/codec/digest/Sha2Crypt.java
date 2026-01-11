package org.apache.commons.codec.digest;

import java.util.regex.Pattern;

/* loaded from: classes4.dex */
public class Sha2Crypt {

    /* renamed from: a, reason: collision with root package name */
    public static final Pattern f159697a = Pattern.compile("^\\$([56])\\$(rounds=(\\d+)\\$)?([\\.\\/a-zA-Z0-9]{1,16}).*");

    @Deprecated
    public Sha2Crypt() {
    }
}
