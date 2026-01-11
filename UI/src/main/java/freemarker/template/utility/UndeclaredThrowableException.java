package freemarker.template.utility;

/* loaded from: classes8.dex */
public class UndeclaredThrowableException extends RuntimeException {
    public UndeclaredThrowableException(Throwable th) {
        super(th);
    }

    public Throwable a() {
        return getCause();
    }
}
