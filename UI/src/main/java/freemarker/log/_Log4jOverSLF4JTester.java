package freemarker.log;

/* loaded from: classes8.dex */
public class _Log4jOverSLF4JTester {

    /* renamed from: a, reason: collision with root package name */
    public static final String f150572a;

    /* renamed from: b, reason: collision with root package name */
    public static /* synthetic */ Class f150573b;

    static {
        Class clsA = f150573b;
        if (clsA == null) {
            clsA = a("freemarker.log._Log4jOverSLF4JTester");
            f150573b = clsA;
        }
        f150572a = clsA.getName();
    }

    public static /* synthetic */ Class a(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e3) {
            throw new NoClassDefFoundError().initCause(e3);
        }
    }
}
