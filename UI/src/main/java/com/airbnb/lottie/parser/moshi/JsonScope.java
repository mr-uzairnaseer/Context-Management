package com.airbnb.lottie.parser.moshi;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes4.dex */
final class JsonScope {
    private JsonScope() {
    }

    public static String a(int i3, int[] iArr, String[] strArr, int[] iArr2) {
        StringBuilder sb = new StringBuilder();
        sb.append('$');
        for (int i4 = 0; i4 < i3; i4++) {
            int i5 = iArr[i4];
            if (i5 == 1 || i5 == 2) {
                sb.append(AbstractJsonLexerKt.BEGIN_LIST);
                sb.append(iArr2[i4]);
                sb.append(AbstractJsonLexerKt.END_LIST);
            } else if (i5 == 3 || i5 == 4 || i5 == 5) {
                sb.append('.');
                String str = strArr[i4];
                if (str != null) {
                    sb.append(str);
                }
            }
        }
        return sb.toString();
    }
}
