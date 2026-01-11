package freemarker.template.utility;

/* loaded from: classes8.dex */
public class NullArgumentException extends IllegalArgumentException {
    public NullArgumentException(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("The \"");
        stringBuffer.append(str);
        stringBuffer.append("\" argument can't be null");
        super(stringBuffer.toString());
    }

    public static void a(Object obj) {
        if (obj == null) {
            throw new NullArgumentException("Argument can't be null");
        }
    }

    public static void b(String str, Object obj) {
        if (obj == null) {
            throw new NullArgumentException(str);
        }
    }
}
