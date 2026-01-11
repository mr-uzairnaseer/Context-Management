package freemarker.core;

/* loaded from: classes8.dex */
public abstract class _DelayedConversionToString {

    /* renamed from: c, reason: collision with root package name */
    public static final String f149810c = new String();

    /* renamed from: a, reason: collision with root package name */
    public Object f149811a;

    /* renamed from: b, reason: collision with root package name */
    public String f149812b = f149810c;

    public _DelayedConversionToString(Object obj) {
        this.f149811a = obj;
    }

    public abstract String a(Object obj);

    public synchronized String toString() {
        try {
            if (this.f149812b == f149810c) {
                this.f149812b = a(this.f149811a);
                this.f149811a = null;
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f149812b;
    }
}
