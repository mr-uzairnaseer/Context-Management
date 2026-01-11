package org.locationtech.jts.util;

import java.util.ArrayList;
import org.apache.commons.lang3.SystemProperties;

/* loaded from: classes7.dex */
public class StringUtil {
    public static final String NEWLINE = System.getProperty(SystemProperties.LINE_SEPARATOR);

    public static String[] a(String str, String str2) {
        int i3;
        int length = str2.length();
        ArrayList arrayList = new ArrayList();
        String strSubstring = "" + str;
        int iIndexOf = strSubstring.indexOf(str2);
        while (true) {
            if (iIndexOf < 0) {
                break;
            }
            arrayList.add(strSubstring.substring(0, iIndexOf));
            strSubstring = strSubstring.substring(iIndexOf + length);
            iIndexOf = strSubstring.indexOf(str2);
        }
        if (strSubstring.length() > 0) {
            arrayList.add(strSubstring);
        }
        int size = arrayList.size();
        String[] strArr = new String[size];
        for (i3 = 0; i3 < size; i3++) {
            strArr[i3] = (String) arrayList.get(i3);
        }
        return strArr;
    }
}
