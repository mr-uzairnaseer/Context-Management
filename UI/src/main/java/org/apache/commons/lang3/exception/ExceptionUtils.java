package org.apache.commons.lang3.exception;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

/* loaded from: classes7.dex */
public class ExceptionUtils {

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f162095a = {"getCause", "getNextException", "getTargetException", "getException", "getSourceException", "getRootCause", "getCausedByException", "getNested", "getLinkedException", "getNestedException", "getLinkedCause", "getThrowable"};

    @Deprecated
    public ExceptionUtils() {
    }

    public static RuntimeException a(Throwable th) {
        return (RuntimeException) b(th);
    }

    public static Object b(Throwable th) throws Throwable {
        throw th;
    }

    public static String c(Throwable th) {
        if (th == null) {
            return "";
        }
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter((Writer) stringWriter, true));
        return stringWriter.toString();
    }

    public static boolean d(Throwable th) {
        return (th == null || (th instanceof Error) || (th instanceof RuntimeException)) ? false : true;
    }

    public static boolean e(Throwable th) {
        if (th != null) {
            return (th instanceof Error) || (th instanceof RuntimeException);
        }
        return false;
    }

    public static Object f(Throwable th) {
        return b(th);
    }

    public static Throwable g(Throwable th) {
        if (e(th)) {
            throw a(th);
        }
        return th;
    }
}
