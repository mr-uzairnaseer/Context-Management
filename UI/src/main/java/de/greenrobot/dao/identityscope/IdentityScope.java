package de.greenrobot.dao.identityscope;

/* loaded from: classes5.dex */
public interface IdentityScope<K, T> {
    void a(Iterable iterable);

    void b(int i3);

    void c(Object obj, Object obj2);

    void clear();

    Object d(Object obj);

    Object get(Object obj);

    void lock();

    void put(Object obj, Object obj2);

    void remove(Object obj);

    void unlock();
}
