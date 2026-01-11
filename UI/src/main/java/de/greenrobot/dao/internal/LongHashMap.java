package de.greenrobot.dao.internal;

import java.util.Arrays;

/* loaded from: classes5.dex */
public final class LongHashMap<T> {

    /* renamed from: a, reason: collision with root package name */
    public Entry[] f76159a;

    /* renamed from: b, reason: collision with root package name */
    public int f76160b;

    /* renamed from: c, reason: collision with root package name */
    public int f76161c;

    /* renamed from: d, reason: collision with root package name */
    public int f76162d;

    public static final class Entry<T> {

        /* renamed from: a, reason: collision with root package name */
        public final long f76163a;

        /* renamed from: b, reason: collision with root package name */
        public Object f76164b;

        /* renamed from: c, reason: collision with root package name */
        public Entry f76165c;

        public Entry(long j3, Object obj, Entry entry) {
            this.f76163a = j3;
            this.f76164b = obj;
            this.f76165c = entry;
        }
    }

    public LongHashMap() {
        this(16);
    }

    public void a() {
        this.f76162d = 0;
        Arrays.fill(this.f76159a, (Object) null);
    }

    public Object b(long j3) {
        for (Entry entry = this.f76159a[((((int) (j3 >>> 32)) ^ ((int) j3)) & Integer.MAX_VALUE) % this.f76160b]; entry != null; entry = entry.f76165c) {
            if (entry.f76163a == j3) {
                return entry.f76164b;
            }
        }
        return null;
    }

    public Object c(long j3, Object obj) {
        int i3 = ((((int) (j3 >>> 32)) ^ ((int) j3)) & Integer.MAX_VALUE) % this.f76160b;
        Entry entry = this.f76159a[i3];
        for (Entry entry2 = entry; entry2 != null; entry2 = entry2.f76165c) {
            if (entry2.f76163a == j3) {
                Object obj2 = entry2.f76164b;
                entry2.f76164b = obj;
                return obj2;
            }
        }
        this.f76159a[i3] = new Entry(j3, obj, entry);
        int i4 = this.f76162d + 1;
        this.f76162d = i4;
        if (i4 <= this.f76161c) {
            return null;
        }
        f(this.f76160b * 2);
        return null;
    }

    public Object d(long j3) {
        int i3 = ((((int) (j3 >>> 32)) ^ ((int) j3)) & Integer.MAX_VALUE) % this.f76160b;
        Entry entry = this.f76159a[i3];
        Entry entry2 = null;
        while (entry != null) {
            Entry entry3 = entry.f76165c;
            if (entry.f76163a == j3) {
                if (entry2 == null) {
                    this.f76159a[i3] = entry3;
                } else {
                    entry2.f76165c = entry3;
                }
                this.f76162d--;
                return entry.f76164b;
            }
            entry2 = entry;
            entry = entry3;
        }
        return null;
    }

    public void e(int i3) {
        f((i3 * 5) / 3);
    }

    public void f(int i3) {
        Entry[] entryArr = new Entry[i3];
        int length = this.f76159a.length;
        for (int i4 = 0; i4 < length; i4++) {
            Entry entry = this.f76159a[i4];
            while (entry != null) {
                long j3 = entry.f76163a;
                int i5 = ((((int) j3) ^ ((int) (j3 >>> 32))) & Integer.MAX_VALUE) % i3;
                Entry entry2 = entry.f76165c;
                entry.f76165c = entryArr[i5];
                entryArr[i5] = entry;
                entry = entry2;
            }
        }
        this.f76159a = entryArr;
        this.f76160b = i3;
        this.f76161c = (i3 * 4) / 3;
    }

    public LongHashMap(int i3) {
        this.f76160b = i3;
        this.f76161c = (i3 * 4) / 3;
        this.f76159a = new Entry[i3];
    }
}
