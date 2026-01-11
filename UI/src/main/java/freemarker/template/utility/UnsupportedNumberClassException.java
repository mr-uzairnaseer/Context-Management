package freemarker.template.utility;

/* loaded from: classes8.dex */
public class UnsupportedNumberClassException extends RuntimeException {

    /* renamed from: a, reason: collision with root package name */
    public final Class f150784a;

    public UnsupportedNumberClassException(Class cls) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Unsupported number class: ");
        stringBuffer.append(cls.getName());
        super(stringBuffer.toString());
        this.f150784a = cls;
    }
}
