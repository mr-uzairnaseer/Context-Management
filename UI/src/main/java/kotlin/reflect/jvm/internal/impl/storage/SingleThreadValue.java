package kotlin.reflect.jvm.internal.impl.storage;

/* loaded from: classes2.dex */
class SingleThreadValue<T> {

    /* renamed from: a, reason: collision with root package name */
    public final Object f155296a;

    /* renamed from: b, reason: collision with root package name */
    public final Thread f155297b = Thread.currentThread();

    public SingleThreadValue(Object obj) {
        this.f155296a = obj;
    }

    public Object a() {
        if (b()) {
            return this.f155296a;
        }
        throw new IllegalStateException("No value in this thread (hasValue should be checked before)");
    }

    public boolean b() {
        return this.f155297b == Thread.currentThread();
    }
}
