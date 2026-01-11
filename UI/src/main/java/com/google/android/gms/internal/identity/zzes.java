package com.google.android.gms.internal.identity;

import java.util.logging.Level;
import java.util.logging.Logger;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes4.dex */
public final class zzes {
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
                    String name = obj.getClass().getName();
                    String hexString = Integer.toHexString(System.identityHashCode(obj));
                    StringBuilder sb = new StringBuilder(name.length() + 1 + String.valueOf(hexString).length());
                    sb.append(name);
                    sb.append("@");
                    sb.append(hexString);
                    String string2 = sb.toString();
                    Logger.getLogger("com.google.common.base.Strings").logp(Level.WARNING, "com.google.common.base.Strings", "lenientToString", "Exception during lenientFormat for ".concat(string2), (Throwable) e3);
                    String name2 = e3.getClass().getName();
                    StringBuilder sb2 = new StringBuilder(string2.length() + 8 + name2.length() + 1);
                    sb2.append("<");
                    sb2.append(string2);
                    sb2.append(" threw ");
                    sb2.append(name2);
                    sb2.append(">");
                    string = sb2.toString();
                }
            }
            objArr[i4] = string;
            i4++;
        }
        StringBuilder sb3 = new StringBuilder(str.length() + (length * 16));
        int i5 = 0;
        while (true) {
            length2 = objArr.length;
            if (i3 >= length2 || (iIndexOf = str.indexOf("%s", i5)) == -1) {
                break;
            }
            sb3.append((CharSequence) str, i5, iIndexOf);
            sb3.append(objArr[i3]);
            i3++;
            i5 = iIndexOf + 2;
        }
        sb3.append((CharSequence) str, i5, str.length());
        if (i3 < length2) {
            sb3.append(" [");
            sb3.append(objArr[i3]);
            for (int i6 = i3 + 1; i6 < objArr.length; i6++) {
                sb3.append(", ");
                sb3.append(objArr[i6]);
            }
            sb3.append(AbstractJsonLexerKt.END_LIST);
        }
        return sb3.toString();
    }
}
