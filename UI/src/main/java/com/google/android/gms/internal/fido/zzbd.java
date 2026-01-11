package com.google.android.gms.internal.fido;

import java.io.IOException;
import java.util.Iterator;
import java.util.Objects;

/* loaded from: classes4.dex */
public final class zzbd {

    /* renamed from: a, reason: collision with root package name */
    public final String f61516a = ",\n  ";

    public zzbd(String str) {
    }

    public static zzbd a(String str) {
        return new zzbd(",\n  ");
    }

    public static final CharSequence d(Object obj) {
        Objects.requireNonNull(obj);
        return obj instanceof CharSequence ? (CharSequence) obj : obj.toString();
    }

    public final StringBuilder c(StringBuilder sb, Iterator it) throws IOException {
        try {
            if (it.hasNext()) {
                sb.append(d(it.next()));
                while (it.hasNext()) {
                    sb.append((CharSequence) this.f61516a);
                    sb.append(d(it.next()));
                }
            }
            return sb;
        } catch (IOException e3) {
            throw new AssertionError(e3);
        }
    }
}
