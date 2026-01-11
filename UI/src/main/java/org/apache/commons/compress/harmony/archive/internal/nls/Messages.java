package org.apache.commons.compress.harmony.archive.internal.nls;

import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/* loaded from: classes5.dex */
public class Messages {

    /* renamed from: a, reason: collision with root package name */
    public static ResourceBundle f160851a;

    static {
        try {
            f160851a = f(Locale.getDefault(), "org.apache.commons.compress.harmony.archive.internal.nls.messages");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static /* synthetic */ Object b(String str, Locale locale, ClassLoader classLoader) {
        if (classLoader == null) {
            classLoader = ClassLoader.getSystemClassLoader();
        }
        return ResourceBundle.getBundle(str, locale, classLoader);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x003e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String c(java.lang.String r9, final java.lang.Object[] r10) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            int r1 = r9.length()
            int r2 = r10.length
            int r2 = r2 * 20
            int r1 = r1 + r2
            r0.<init>(r1)
            int r1 = r10.length
            java.lang.String[] r2 = new java.lang.String[r1]
            org.apache.commons.compress.harmony.archive.internal.nls.b r3 = new org.apache.commons.compress.harmony.archive.internal.nls.b
            r3.<init>()
            java.util.Arrays.setAll(r2, r3)
            r10 = 123(0x7b, float:1.72E-43)
            r3 = 0
        L1b:
            int r4 = r9.indexOf(r10, r3)
            if (r4 < 0) goto L8c
            if (r4 == 0) goto L3e
            int r5 = r4 + (-1)
            char r6 = r9.charAt(r5)
            r7 = 92
            if (r6 != r7) goto L3e
            r6 = 1
            if (r4 == r6) goto L37
            java.lang.String r3 = r9.substring(r3, r5)
            r0.append(r3)
        L37:
            r0.append(r10)
            int r4 = r4 + 1
        L3c:
            r3 = r4
            goto L1b
        L3e:
            int r5 = r9.length()
            int r5 = r5 + (-3)
            if (r4 <= r5) goto L52
            java.lang.String r3 = r9.substring(r3)
            r0.append(r3)
            int r3 = r9.length()
            goto L1b
        L52:
            int r5 = r4 + 1
            char r6 = r9.charAt(r5)
            r7 = 10
            int r6 = java.lang.Character.digit(r6, r7)
            byte r6 = (byte) r6
            if (r6 < 0) goto L83
            int r7 = r4 + 2
            char r7 = r9.charAt(r7)
            r8 = 125(0x7d, float:1.75E-43)
            if (r7 == r8) goto L6c
            goto L83
        L6c:
            java.lang.String r3 = r9.substring(r3, r4)
            r0.append(r3)
            if (r6 < r1) goto L7b
            java.lang.String r3 = "<missing argument>"
            r0.append(r3)
            goto L80
        L7b:
            r3 = r2[r6]
            r0.append(r3)
        L80:
            int r4 = r4 + 3
            goto L3c
        L83:
            java.lang.String r3 = r9.substring(r3, r5)
            r0.append(r3)
            r3 = r5
            goto L1b
        L8c:
            int r10 = r9.length()
            if (r3 >= r10) goto L99
            java.lang.String r9 = r9.substring(r3)
            r0.append(r9)
        L99:
            java.lang.String r9 = r0.toString()
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.compress.harmony.archive.internal.nls.Messages.c(java.lang.String, java.lang.Object[]):java.lang.String");
    }

    public static String d(String str, Object obj) {
        return e(str, new Object[]{obj});
    }

    public static String e(String str, Object[] objArr) {
        ResourceBundle resourceBundle = f160851a;
        if (resourceBundle != null) {
            try {
                str = resourceBundle.getString(str);
            } catch (MissingResourceException unused) {
            }
        }
        return c(str, objArr);
    }

    public static ResourceBundle f(final Locale locale, final String str) {
        final ClassLoader classLoader = null;
        try {
            return (ResourceBundle) AccessController.doPrivileged(new PrivilegedAction() { // from class: org.apache.commons.compress.harmony.archive.internal.nls.a
                @Override // java.security.PrivilegedAction
                public final Object run() {
                    return Messages.b(str, locale, classLoader);
                }
            });
        } catch (MissingResourceException unused) {
            return null;
        }
    }
}
