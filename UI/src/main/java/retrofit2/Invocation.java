package retrofit2;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public final class Invocation {

    /* renamed from: a, reason: collision with root package name */
    public final Class f165873a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f165874b;

    /* renamed from: c, reason: collision with root package name */
    public final Method f165875c;

    /* renamed from: d, reason: collision with root package name */
    public final List f165876d;

    public Invocation(Class cls, Object obj, Method method, List list) {
        this.f165873a = cls;
        this.f165874b = obj;
        this.f165875c = method;
        this.f165876d = Collections.unmodifiableList(list);
    }

    public Method a() {
        return this.f165875c;
    }

    public Class b() {
        return this.f165873a;
    }

    public String toString() {
        return String.format("%s.%s() %s", this.f165873a.getName(), this.f165875c.getName(), this.f165876d);
    }
}
