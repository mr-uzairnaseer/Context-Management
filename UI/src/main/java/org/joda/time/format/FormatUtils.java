package org.joda.time.format;

import java.io.IOException;
import org.apache.commons.codec.language.Soundex;

/* loaded from: classes8.dex */
public class FormatUtils {

    /* renamed from: a, reason: collision with root package name */
    public static final double f163095a = Math.log(10.0d);

    private FormatUtils() {
    }

    public static void a(Appendable appendable, int i3, int i4) throws IOException {
        if (i3 < 0) {
            appendable.append(Soundex.SILENT_MARKER);
            if (i3 == Integer.MIN_VALUE) {
                while (i4 > 10) {
                    appendable.append('0');
                    i4--;
                }
                appendable.append("2147483648");
                return;
            }
            i3 = -i3;
        }
        if (i3 < 10) {
            while (i4 > 1) {
                appendable.append('0');
                i4--;
            }
            appendable.append((char) (i3 + 48));
            return;
        }
        if (i3 >= 100) {
            int iLog = i3 < 1000 ? 3 : i3 < 10000 ? 4 : ((int) (Math.log(i3) / f163095a)) + 1;
            while (i4 > iLog) {
                appendable.append('0');
                i4--;
            }
            appendable.append(Integer.toString(i3));
            return;
        }
        while (i4 > 2) {
            appendable.append('0');
            i4--;
        }
        int i5 = ((i3 + 1) * 13421772) >> 27;
        appendable.append((char) (i5 + 48));
        appendable.append((char) (((i3 - (i5 << 3)) - (i5 << 1)) + 48));
    }

    public static void b(StringBuffer stringBuffer, int i3, int i4) {
        try {
            a(stringBuffer, i3, i4);
        } catch (IOException unused) {
        }
    }

    public static void c(Appendable appendable, int i3) throws IOException {
        if (i3 < 0) {
            appendable.append(Soundex.SILENT_MARKER);
            if (i3 == Integer.MIN_VALUE) {
                appendable.append("2147483648");
                return;
            }
            i3 = -i3;
        }
        if (i3 < 10) {
            appendable.append((char) (i3 + 48));
        } else {
            if (i3 >= 100) {
                appendable.append(Integer.toString(i3));
                return;
            }
            int i4 = ((i3 + 1) * 13421772) >> 27;
            appendable.append((char) (i4 + 48));
            appendable.append((char) (((i3 - (i4 << 3)) - (i4 << 1)) + 48));
        }
    }

    public static void d(Appendable appendable, long j3) throws IOException {
        int i3 = (int) j3;
        if (i3 == j3) {
            c(appendable, i3);
        } else {
            appendable.append(Long.toString(j3));
        }
    }

    public static void e(StringBuffer stringBuffer, int i3) {
        try {
            c(stringBuffer, i3);
        } catch (IOException unused) {
        }
    }

    public static void f(StringBuffer stringBuffer, long j3) {
        try {
            d(stringBuffer, j3);
        } catch (IOException unused) {
        }
    }

    public static int g(long j3) {
        int iLog;
        if (j3 < 0) {
            if (j3 == Long.MIN_VALUE) {
                return 20;
            }
            iLog = g(-j3);
        } else {
            if (j3 < 10) {
                return 1;
            }
            if (j3 < 100) {
                return 2;
            }
            if (j3 < 1000) {
                return 3;
            }
            if (j3 < 10000) {
                return 4;
            }
            iLog = (int) (Math.log(j3) / f163095a);
        }
        return iLog + 1;
    }

    public static String h(String str, int i3) {
        String strConcat = str.length() <= i3 + 35 ? str : str.substring(0, i3 + 32).concat("...");
        if (i3 <= 0) {
            return "Invalid format: \"" + strConcat + '\"';
        }
        if (i3 >= str.length()) {
            return "Invalid format: \"" + strConcat + "\" is too short";
        }
        return "Invalid format: \"" + strConcat + "\" is malformed at \"" + strConcat.substring(i3) + '\"';
    }

    public static int i(CharSequence charSequence, int i3) {
        int iCharAt = charSequence.charAt(i3) - '0';
        return (((iCharAt << 3) + (iCharAt << 1)) + charSequence.charAt(i3 + 1)) - 48;
    }
}
