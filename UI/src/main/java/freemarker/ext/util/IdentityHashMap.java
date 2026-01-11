package freemarker.ext.util;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* loaded from: classes8.dex */
public class IdentityHashMap extends AbstractMap implements Map, Cloneable, Serializable {

    /* renamed from: i, reason: collision with root package name */
    public static EmptyHashIterator f150494i = new EmptyHashIterator();
    public static final long serialVersionUID = 362498820763181265L;

    /* renamed from: a, reason: collision with root package name */
    public transient Entry[] f150495a;

    /* renamed from: b, reason: collision with root package name */
    public transient int f150496b;

    /* renamed from: c, reason: collision with root package name */
    public int f150497c;

    /* renamed from: d, reason: collision with root package name */
    public float f150498d;

    /* renamed from: e, reason: collision with root package name */
    public transient int f150499e;

    /* renamed from: f, reason: collision with root package name */
    public transient Set f150500f;

    /* renamed from: g, reason: collision with root package name */
    public transient Set f150501g;

    /* renamed from: h, reason: collision with root package name */
    public transient Collection f150502h;

    public static class EmptyHashIterator implements Iterator {
        @Override // java.util.Iterator
        public boolean hasNext() {
            return false;
        }

        @Override // java.util.Iterator
        public Object next() {
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new IllegalStateException();
        }
    }

    public static class Entry implements Map.Entry {

        /* renamed from: a, reason: collision with root package name */
        public int f150506a;

        /* renamed from: b, reason: collision with root package name */
        public Object f150507b;

        /* renamed from: c, reason: collision with root package name */
        public Object f150508c;

        /* renamed from: d, reason: collision with root package name */
        public Entry f150509d;

        public Entry(int i3, Object obj, Object obj2, Entry entry) {
            this.f150506a = i3;
            this.f150507b = obj;
            this.f150508c = obj2;
            this.f150509d = entry;
        }

        public Object clone() {
            int i3 = this.f150506a;
            Object obj = this.f150507b;
            Object obj2 = this.f150508c;
            Entry entry = this.f150509d;
            return new Entry(i3, obj, obj2, entry == null ? null : (Entry) entry.clone());
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            if (this.f150507b == entry.getKey()) {
                Object obj2 = this.f150508c;
                if (obj2 == null) {
                    if (entry.getValue() == null) {
                        return true;
                    }
                } else if (obj2.equals(entry.getValue())) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public Object getKey() {
            return this.f150507b;
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            return this.f150508c;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            int i3 = this.f150506a;
            Object obj = this.f150508c;
            return i3 ^ (obj == null ? 0 : obj.hashCode());
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            Object obj2 = this.f150508c;
            this.f150508c = obj;
            return obj2;
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(this.f150507b);
            stringBuffer.append("=");
            stringBuffer.append(this.f150508c);
            return stringBuffer.toString();
        }
    }

    public class HashIterator implements Iterator {

        /* renamed from: a, reason: collision with root package name */
        public Entry[] f150510a;

        /* renamed from: b, reason: collision with root package name */
        public int f150511b;

        /* renamed from: c, reason: collision with root package name */
        public Entry f150512c;

        /* renamed from: d, reason: collision with root package name */
        public Entry f150513d;

        /* renamed from: e, reason: collision with root package name */
        public int f150514e;

        /* renamed from: f, reason: collision with root package name */
        public int f150515f;

        public HashIterator(int i3) {
            Entry[] entryArr = IdentityHashMap.this.f150495a;
            this.f150510a = entryArr;
            this.f150511b = entryArr.length;
            this.f150512c = null;
            this.f150513d = null;
            this.f150515f = IdentityHashMap.this.f150499e;
            this.f150514e = i3;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            Entry entry = this.f150512c;
            int i3 = this.f150511b;
            Entry[] entryArr = this.f150510a;
            while (entry == null && i3 > 0) {
                i3--;
                entry = entryArr[i3];
            }
            this.f150512c = entry;
            this.f150511b = i3;
            return entry != null;
        }

        @Override // java.util.Iterator
        public Object next() {
            if (IdentityHashMap.this.f150499e != this.f150515f) {
                throw new ConcurrentModificationException();
            }
            Entry entry = this.f150512c;
            int i3 = this.f150511b;
            Entry[] entryArr = this.f150510a;
            while (entry == null && i3 > 0) {
                i3--;
                entry = entryArr[i3];
            }
            this.f150512c = entry;
            this.f150511b = i3;
            if (entry == null) {
                throw new NoSuchElementException();
            }
            this.f150513d = entry;
            this.f150512c = entry.f150509d;
            int i4 = this.f150514e;
            return i4 == 0 ? entry.f150507b : i4 == 1 ? entry.f150508c : entry;
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.f150513d == null) {
                throw new IllegalStateException();
            }
            if (IdentityHashMap.this.f150499e != this.f150515f) {
                throw new ConcurrentModificationException();
            }
            Entry[] entryArr = IdentityHashMap.this.f150495a;
            int length = (this.f150513d.f150506a & Integer.MAX_VALUE) % entryArr.length;
            Entry entry = null;
            for (Entry entry2 = entryArr[length]; entry2 != null; entry2 = entry2.f150509d) {
                if (entry2 == this.f150513d) {
                    IdentityHashMap.f(IdentityHashMap.this);
                    this.f150515f++;
                    if (entry == null) {
                        entryArr[length] = entry2.f150509d;
                    } else {
                        entry.f150509d = entry2.f150509d;
                    }
                    IdentityHashMap.c(IdentityHashMap.this);
                    this.f150513d = null;
                    return;
                }
                entry = entry2;
            }
            throw new ConcurrentModificationException();
        }
    }

    public IdentityHashMap(int i3, float f3) {
        this.f150499e = 0;
        this.f150500f = null;
        this.f150501g = null;
        this.f150502h = null;
        if (i3 < 0) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Illegal Initial Capacity: ");
            stringBuffer.append(i3);
            throw new IllegalArgumentException(stringBuffer.toString());
        }
        if (f3 <= 0.0f || Float.isNaN(f3)) {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("Illegal Load factor: ");
            stringBuffer2.append(f3);
            throw new IllegalArgumentException(stringBuffer2.toString());
        }
        i3 = i3 == 0 ? 1 : i3;
        this.f150498d = f3;
        this.f150495a = new Entry[i3];
        this.f150497c = (int) (i3 * f3);
    }

    public static /* synthetic */ int c(IdentityHashMap identityHashMap) {
        int i3 = identityHashMap.f150496b;
        identityHashMap.f150496b = i3 - 1;
        return i3;
    }

    public static /* synthetic */ int f(IdentityHashMap identityHashMap) {
        int i3 = identityHashMap.f150499e;
        identityHashMap.f150499e = i3 + 1;
        return i3;
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.f150495a = new Entry[objectInputStream.readInt()];
        int i3 = objectInputStream.readInt();
        for (int i4 = 0; i4 < i3; i4++) {
            put(objectInputStream.readObject(), objectInputStream.readObject());
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(this.f150495a.length);
        objectOutputStream.writeInt(this.f150496b);
        for (int length = this.f150495a.length - 1; length >= 0; length--) {
            for (Entry entry = this.f150495a[length]; entry != null; entry = entry.f150509d) {
                objectOutputStream.writeObject(entry.f150507b);
                objectOutputStream.writeObject(entry.f150508c);
            }
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        Entry[] entryArr = this.f150495a;
        this.f150499e++;
        int length = entryArr.length;
        while (true) {
            length--;
            if (length < 0) {
                this.f150496b = 0;
                return;
            }
            entryArr[length] = null;
        }
    }

    @Override // java.util.AbstractMap
    public Object clone() {
        try {
            IdentityHashMap identityHashMap = (IdentityHashMap) super.clone();
            identityHashMap.f150495a = new Entry[this.f150495a.length];
            int length = this.f150495a.length;
            while (true) {
                int i3 = length - 1;
                Entry entry = null;
                if (length <= 0) {
                    identityHashMap.f150500f = null;
                    identityHashMap.f150501g = null;
                    identityHashMap.f150502h = null;
                    identityHashMap.f150499e = 0;
                    return identityHashMap;
                }
                Entry[] entryArr = identityHashMap.f150495a;
                Entry entry2 = this.f150495a[i3];
                if (entry2 != null) {
                    entry = (Entry) entry2.clone();
                }
                entryArr[i3] = entry;
                length = i3;
            }
        } catch (CloneNotSupportedException unused) {
            throw new InternalError();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        Entry[] entryArr = this.f150495a;
        if (obj != null) {
            int iIdentityHashCode = System.identityHashCode(obj);
            for (Entry entry = entryArr[(Integer.MAX_VALUE & iIdentityHashCode) % entryArr.length]; entry != null; entry = entry.f150509d) {
                if (entry.f150506a == iIdentityHashCode && obj == entry.f150507b) {
                    return true;
                }
            }
        } else {
            for (Entry entry2 = entryArr[0]; entry2 != null; entry2 = entry2.f150509d) {
                if (entry2.f150507b == null) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object obj) {
        Entry[] entryArr = this.f150495a;
        if (obj == null) {
            int length = entryArr.length;
            while (true) {
                int i3 = length - 1;
                if (length <= 0) {
                    return false;
                }
                for (Entry entry = entryArr[i3]; entry != null; entry = entry.f150509d) {
                    if (entry.f150508c == null) {
                        return true;
                    }
                }
                length = i3;
            }
        } else {
            int length2 = entryArr.length;
            while (true) {
                int i4 = length2 - 1;
                if (length2 <= 0) {
                    return false;
                }
                for (Entry entry2 = entryArr[i4]; entry2 != null; entry2 = entry2.f150509d) {
                    if (obj.equals(entry2.f150508c)) {
                        return true;
                    }
                }
                length2 = i4;
            }
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set entrySet() {
        if (this.f150501g == null) {
            this.f150501g = new AbstractSet() { // from class: freemarker.ext.util.IdentityHashMap.3
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                public void clear() {
                    IdentityHashMap.this.clear();
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                public boolean contains(Object obj) {
                    if (!(obj instanceof Map.Entry)) {
                        return false;
                    }
                    Map.Entry entry = (Map.Entry) obj;
                    Object key = entry.getKey();
                    Entry[] entryArr = IdentityHashMap.this.f150495a;
                    int iIdentityHashCode = key == null ? 0 : System.identityHashCode(key);
                    for (Entry entry2 = entryArr[(Integer.MAX_VALUE & iIdentityHashCode) % entryArr.length]; entry2 != null; entry2 = entry2.f150509d) {
                        if (entry2.f150506a == iIdentityHashCode && entry2.equals(entry)) {
                            return true;
                        }
                    }
                    return false;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
                public Iterator iterator() {
                    return IdentityHashMap.this.h(2);
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                public boolean remove(Object obj) {
                    if (!(obj instanceof Map.Entry)) {
                        return false;
                    }
                    Map.Entry entry = (Map.Entry) obj;
                    Object key = entry.getKey();
                    Entry[] entryArr = IdentityHashMap.this.f150495a;
                    int iIdentityHashCode = key == null ? 0 : System.identityHashCode(key);
                    int length = (Integer.MAX_VALUE & iIdentityHashCode) % entryArr.length;
                    Entry entry2 = null;
                    for (Entry entry3 = entryArr[length]; entry3 != null; entry3 = entry3.f150509d) {
                        if (entry3.f150506a == iIdentityHashCode && entry3.equals(entry)) {
                            IdentityHashMap.f(IdentityHashMap.this);
                            if (entry2 != null) {
                                entry2.f150509d = entry3.f150509d;
                            } else {
                                entryArr[length] = entry3.f150509d;
                            }
                            IdentityHashMap.c(IdentityHashMap.this);
                            entry3.f150508c = null;
                            return true;
                        }
                        entry2 = entry3;
                    }
                    return false;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                public int size() {
                    return IdentityHashMap.this.f150496b;
                }
            };
        }
        return this.f150501g;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object get(Object obj) {
        Entry[] entryArr = this.f150495a;
        if (obj == null) {
            for (Entry entry = entryArr[0]; entry != null; entry = entry.f150509d) {
                if (entry.f150507b == null) {
                    return entry.f150508c;
                }
            }
            return null;
        }
        int iIdentityHashCode = System.identityHashCode(obj);
        for (Entry entry2 = entryArr[(Integer.MAX_VALUE & iIdentityHashCode) % entryArr.length]; entry2 != null; entry2 = entry2.f150509d) {
            if (entry2.f150506a == iIdentityHashCode && obj == entry2.f150507b) {
                return entry2.f150508c;
            }
        }
        return null;
    }

    public final Iterator h(int i3) {
        return this.f150496b == 0 ? f150494i : new HashIterator(i3);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        return this.f150496b == 0;
    }

    public final void j() {
        Entry[] entryArr = this.f150495a;
        int length = entryArr.length;
        int i3 = (length * 2) + 1;
        Entry[] entryArr2 = new Entry[i3];
        this.f150499e++;
        this.f150497c = (int) (i3 * this.f150498d);
        this.f150495a = entryArr2;
        while (true) {
            int i4 = length - 1;
            if (length <= 0) {
                return;
            }
            Entry entry = entryArr[i4];
            while (entry != null) {
                Entry entry2 = entry.f150509d;
                int i5 = (entry.f150506a & Integer.MAX_VALUE) % i3;
                entry.f150509d = entryArr2[i5];
                entryArr2[i5] = entry;
                entry = entry2;
            }
            length = i4;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set keySet() {
        if (this.f150500f == null) {
            this.f150500f = new AbstractSet() { // from class: freemarker.ext.util.IdentityHashMap.1
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                public void clear() {
                    IdentityHashMap.this.clear();
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                public boolean contains(Object obj) {
                    return IdentityHashMap.this.containsKey(obj);
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
                public Iterator iterator() {
                    return IdentityHashMap.this.h(0);
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                public boolean remove(Object obj) {
                    int i3 = IdentityHashMap.this.f150496b;
                    IdentityHashMap.this.remove(obj);
                    return IdentityHashMap.this.f150496b != i3;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                public int size() {
                    return IdentityHashMap.this.f150496b;
                }
            };
        }
        return this.f150500f;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object put(Object obj, Object obj2) {
        int iIdentityHashCode;
        int length;
        Entry[] entryArr = this.f150495a;
        if (obj != null) {
            iIdentityHashCode = System.identityHashCode(obj);
            length = (iIdentityHashCode & Integer.MAX_VALUE) % entryArr.length;
            for (Entry entry = entryArr[length]; entry != null; entry = entry.f150509d) {
                if (entry.f150506a == iIdentityHashCode && obj == entry.f150507b) {
                    Object obj3 = entry.f150508c;
                    entry.f150508c = obj2;
                    return obj3;
                }
            }
        } else {
            iIdentityHashCode = 0;
            for (Entry entry2 = entryArr[0]; entry2 != null; entry2 = entry2.f150509d) {
                if (entry2.f150507b == null) {
                    Object obj4 = entry2.f150508c;
                    entry2.f150508c = obj2;
                    return obj4;
                }
            }
            length = 0;
        }
        this.f150499e++;
        if (this.f150496b >= this.f150497c) {
            j();
            entryArr = this.f150495a;
            length = (Integer.MAX_VALUE & iIdentityHashCode) % entryArr.length;
        }
        entryArr[length] = new Entry(iIdentityHashCode, obj, obj2, entryArr[length]);
        this.f150496b++;
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void putAll(Map map) {
        for (Map.Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object remove(Object obj) {
        Entry[] entryArr = this.f150495a;
        if (obj != null) {
            int iIdentityHashCode = System.identityHashCode(obj);
            int length = (Integer.MAX_VALUE & iIdentityHashCode) % entryArr.length;
            Entry entry = null;
            for (Entry entry2 = entryArr[length]; entry2 != null; entry2 = entry2.f150509d) {
                if (entry2.f150506a == iIdentityHashCode && obj == entry2.f150507b) {
                    this.f150499e++;
                    if (entry != null) {
                        entry.f150509d = entry2.f150509d;
                    } else {
                        entryArr[length] = entry2.f150509d;
                    }
                    this.f150496b--;
                    Object obj2 = entry2.f150508c;
                    entry2.f150508c = null;
                    return obj2;
                }
                entry = entry2;
            }
        } else {
            Entry entry3 = null;
            for (Entry entry4 = entryArr[0]; entry4 != null; entry4 = entry4.f150509d) {
                if (entry4.f150507b == null) {
                    this.f150499e++;
                    if (entry3 != null) {
                        entry3.f150509d = entry4.f150509d;
                    } else {
                        entryArr[0] = entry4.f150509d;
                    }
                    this.f150496b--;
                    Object obj3 = entry4.f150508c;
                    entry4.f150508c = null;
                    return obj3;
                }
                entry3 = entry4;
            }
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.f150496b;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection values() {
        if (this.f150502h == null) {
            this.f150502h = new AbstractCollection() { // from class: freemarker.ext.util.IdentityHashMap.2
                @Override // java.util.AbstractCollection, java.util.Collection
                public void clear() {
                    IdentityHashMap.this.clear();
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public boolean contains(Object obj) {
                    return IdentityHashMap.this.containsValue(obj);
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
                public Iterator iterator() {
                    return IdentityHashMap.this.h(1);
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public int size() {
                    return IdentityHashMap.this.f150496b;
                }
            };
        }
        return this.f150502h;
    }

    public IdentityHashMap() {
        this(11, 0.75f);
    }
}
