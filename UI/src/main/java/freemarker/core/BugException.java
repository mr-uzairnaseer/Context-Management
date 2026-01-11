package freemarker.core;

/* loaded from: classes8.dex */
public class BugException extends RuntimeException {
    public BugException() {
        this((Throwable) null);
    }

    public BugException(String str) {
        this(str, null);
    }

    public BugException(Throwable th) {
        super("A bug was detected in FreeMarker; please report it with stack-trace", th);
    }

    public BugException(String str, Throwable th) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("A bug was detected in FreeMarker; please report it with stack-trace: ");
        stringBuffer.append(str);
        super(stringBuffer.toString(), th);
    }

    public BugException(int i3) {
        this(String.valueOf(i3));
    }
}
