package freemarker.cache;

/* loaded from: classes8.dex */
public interface CacheStorage {
    void clear();

    Object get(Object obj);

    void put(Object obj, Object obj2);
}
