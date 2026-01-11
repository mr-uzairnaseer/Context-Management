package com.google.android.gms.internal.fido;

import java.util.logging.Level;
import java.util.logging.Logger;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes4.dex */
public final class zzbo {
    public static String a(String str, Object... objArr) {
        int length;
        int length2;
        int iIndexOf;
        String string;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            length = objArr.length;
            if (i4 >= length) {
                break;
            }
            Object obj = objArr[i4];
            if (obj == null) {
                string = "null";
            } else {
                try {
                    string = obj.toString();
                } catch (Exception e3) {
                    String str2 = obj.getClass().getName() + "@" + Integer.toHexString(System.identityHashCode(obj));
                    Logger.getLogger("com.google.common.base.Strings").logp(Level.WARNING, "com.google.common.base.Strings", "lenientToString", "Exception during lenientFormat for ".concat(str2), (Throwable) e3);
                    string = "<" + str2 + " threw " + e3.getClass().getName() + ">";
                }
            }
            objArr[i4] = string;
            i4++;
        }
        StringBuilder sb = new StringBuilder(str.length() + (length * 16));
        int i5 = 0;
        while (true) {
            length2 = objArr.length;
            if (i3 >= length2 || (iIndexOf = str.indexOf("%s", i5)) == -1) {
                break;
            }
            sb.append((CharSequence) str, i5, iIndexOf);
            sb.append(objArr[i3]);
            i3++;
            i5 = iIndexOf + 2;
        }
        sb.append((CharSequence) str, i5, str.length());
        if (i3 < length2) {
            sb.append(" [");
            sb.append(objArr[i3]);
            for (int i6 = i3 + 1; i6 < objArr.length; i6++) {
                sb.append(", ");
                sb.append(objArr[i6]);
            }
            sb.append(AbstractJsonLexerKt.END_LIST);
        }
        return sb.toString();
    }
}
