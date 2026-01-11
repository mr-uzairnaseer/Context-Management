package com.google.android.recaptcha.internal;

import java.util.Iterator;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes4.dex */
public abstract class zzks implements Iterable {
    public final String toString() {
        Iterator it = iterator();
        StringBuilder sb = new StringBuilder();
        sb.append(AbstractJsonLexerKt.BEGIN_LIST);
        boolean z2 = true;
        while (it.hasNext()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append(it.next());
            z2 = false;
        }
        sb.append(AbstractJsonLexerKt.END_LIST);
        return sb.toString();
    }
}
