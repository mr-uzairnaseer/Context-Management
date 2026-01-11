package com.google.gson.internal;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

/* loaded from: classes5.dex */
public final class LinkedTreeMap<K, V> extends AbstractMap<K, V> implements Serializable {

    /* renamed from: i, reason: collision with root package name */
    public static final Comparator f74237i = new Comparator<Comparable>() { // from class: com.google.gson.internal.LinkedTreeMap.1
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Comparable comparable, Comparable comparable2) {
            return comparable.compareTo(comparable2);
        }
    };

    /* renamed from: a, reason: collision with root package name */
    public final Comparator f74238a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f74239b;

    /* renamed from: c, reason: collision with root package name */
    public Node f74240c;

    /* renamed from: d, reason: collision with root package name */
    public int f74241d;

    /* renamed from: e, reason: collision with root package name */
    public int f74242e;

    /* renamed from: f, reason: collision with root package name */
    public final Node f74243f;

    /* renamed from: g, reason: collision with root package name */
    public EntrySet f74244g;

    /* renamed from: h, reason: collision with root package name */
    public KeySet f74245h;

    public class EntrySet extends AbstractSet<Map.Entry<K, V>> {
        public EntrySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            LinkedTreeMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return (obj instanceof Map.Entry) && LinkedTreeMap.this.c((Map.Entry) obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return new LinkedTreeMap<K, V>.LinkedTreeMapIterator<Map.Entry<K, V>>() { // from class: com.google.gson.internal.LinkedTreeMap.EntrySet.1
                {
                    LinkedTreeMap linkedTreeMap = LinkedTreeMap.this;
                }

                @Override // java.util.Iterator
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public Map.Entry next() {
                    return a();
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Node nodeC;
            if (!(obj instanceof Map.Entry) || (nodeC = LinkedTreeMap.this.c((Map.Entry) obj)) == null) {
                return false;
            }
            LinkedTreeMap.this.f(nodeC, true);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return LinkedTreeMap.this.f74241d;
        }
    }

    public final class KeySet extends AbstractSet<K> {
        public KeySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            LinkedTreeMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return LinkedTreeMap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return new LinkedTreeMap<K, V>.LinkedTreeMapIterator<K>() { // from class: com.google.gson.internal.LinkedTreeMap.KeySet.1
                {
                    LinkedTreeMap linkedTreeMap = LinkedTreeMap.this;
                }

                @Override // java.util.Iterator
                public Object next() {
                    return a().f74259f;
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return LinkedTreeMap.this.g(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return LinkedTreeMap.this.f74241d;
        }
    }

    public abstract class LinkedTreeMapIterator<T> implements Iterator<T> {

        /* renamed from: a, reason: collision with root package name */
        public Node f74250a;

        /* renamed from: b, reason: collision with root package name */
        public Node f74251b = null;

        /* renamed from: c, reason: collision with root package name */
        public int f74252c;

        public LinkedTreeMapIterator() {
            this.f74250a = LinkedTreeMap.this.f74243f.f74257d;
            this.f74252c = LinkedTreeMap.this.f74242e;
        }

        public final Node a() {
            Node node = this.f74250a;
            LinkedTreeMap linkedTreeMap = LinkedTreeMap.this;
            if (node == linkedTreeMap.f74243f) {
                throw new NoSuchElementException();
            }
            if (linkedTreeMap.f74242e != this.f74252c) {
                throw new ConcurrentModificationException();
            }
            this.f74250a = node.f74257d;
            this.f74251b = node;
            return node;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f74250a != LinkedTreeMap.this.f74243f;
        }

        @Override // java.util.Iterator
        public final void remove() {
            Node node = this.f74251b;
            if (node == null) {
                throw new IllegalStateException();
            }
            LinkedTreeMap.this.f(node, true);
            this.f74251b = null;
            this.f74252c = LinkedTreeMap.this.f74242e;
        }
    }

    public LinkedTreeMap() {
        this(f74237i, true);
    }

    public static boolean a(Object obj, Object obj2) {
        return Objects.equals(obj, obj2);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        throw new InvalidObjectException("Deserialization is unsupported");
    }

    private Object writeReplace() throws ObjectStreamException {
        return new LinkedHashMap(this);
    }

    public Node b(Object obj, boolean z2) {
        int iCompareTo;
        Node node;
        Comparator comparator = this.f74238a;
        Node node2 = this.f74240c;
        if (node2 != null) {
            Comparable comparable = comparator == f74237i ? (Comparable) obj : null;
            while (true) {
                iCompareTo = comparable != null ? comparable.compareTo(node2.f74259f) : comparator.compare(obj, node2.f74259f);
                if (iCompareTo == 0) {
                    return node2;
                }
                Node node3 = iCompareTo < 0 ? node2.f74255b : node2.f74256c;
                if (node3 == null) {
                    break;
                }
                node2 = node3;
            }
        } else {
            iCompareTo = 0;
        }
        Node node4 = node2;
        if (!z2) {
            return null;
        }
        Node node5 = this.f74243f;
        if (node4 != null) {
            node = new Node(this.f74239b, node4, obj, node5, node5.f74258e);
            if (iCompareTo < 0) {
                node4.f74255b = node;
            } else {
                node4.f74256c = node;
            }
            e(node4, true);
        } else {
            if (comparator == f74237i && !(obj instanceof Comparable)) {
                throw new ClassCastException(obj.getClass().getName() + " is not Comparable");
            }
            node = new Node(this.f74239b, node4, obj, node5, node5.f74258e);
            this.f74240c = node;
        }
        this.f74241d++;
        this.f74242e++;
        return node;
    }

    public Node c(Map.Entry entry) {
        Node nodeD = d(entry.getKey());
        if (nodeD == null || !a(nodeD.f74261h, entry.getValue())) {
            return null;
        }
        return nodeD;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this.f74240c = null;
        this.f74241d = 0;
        this.f74242e++;
        Node node = this.f74243f;
        node.f74258e = node;
        node.f74257d = node;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return d(obj) != null;
    }

    public Node d(Object obj) {
        if (obj != null) {
            try {
                return b(obj, false);
            } catch (ClassCastException unused) {
            }
        }
        return null;
    }

    public final void e(Node node, boolean z2) {
        while (node != null) {
            Node node2 = node.f74255b;
            Node node3 = node.f74256c;
            int i3 = node2 != null ? node2.f74262i : 0;
            int i4 = node3 != null ? node3.f74262i : 0;
            int i5 = i3 - i4;
            if (i5 == -2) {
                Node node4 = node3.f74255b;
                Node node5 = node3.f74256c;
                int i6 = (node4 != null ? node4.f74262i : 0) - (node5 != null ? node5.f74262i : 0);
                if (i6 == -1 || (i6 == 0 && !z2)) {
                    i(node);
                } else {
                    j(node3);
                    i(node);
                }
                if (z2) {
                    return;
                }
            } else if (i5 == 2) {
                Node node6 = node2.f74255b;
                Node node7 = node2.f74256c;
                int i7 = (node6 != null ? node6.f74262i : 0) - (node7 != null ? node7.f74262i : 0);
                if (i7 == 1 || (i7 == 0 && !z2)) {
                    j(node);
                } else {
                    i(node2);
                    j(node);
                }
                if (z2) {
                    return;
                }
            } else if (i5 == 0) {
                node.f74262i = i3 + 1;
                if (z2) {
                    return;
                }
            } else {
                node.f74262i = Math.max(i3, i4) + 1;
                if (!z2) {
                    return;
                }
            }
            node = node.f74254a;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set entrySet() {
        EntrySet entrySet = this.f74244g;
        if (entrySet != null) {
            return entrySet;
        }
        EntrySet entrySet2 = new EntrySet();
        this.f74244g = entrySet2;
        return entrySet2;
    }

    public void f(Node node, boolean z2) {
        int i3;
        if (z2) {
            Node node2 = node.f74258e;
            node2.f74257d = node.f74257d;
            node.f74257d.f74258e = node2;
        }
        Node node3 = node.f74255b;
        Node node4 = node.f74256c;
        Node node5 = node.f74254a;
        int i4 = 0;
        if (node3 == null || node4 == null) {
            if (node3 != null) {
                h(node, node3);
                node.f74255b = null;
            } else if (node4 != null) {
                h(node, node4);
                node.f74256c = null;
            } else {
                h(node, null);
            }
            e(node5, false);
            this.f74241d--;
            this.f74242e++;
            return;
        }
        Node nodeB = node3.f74262i > node4.f74262i ? node3.b() : node4.a();
        f(nodeB, false);
        Node node6 = node.f74255b;
        if (node6 != null) {
            i3 = node6.f74262i;
            nodeB.f74255b = node6;
            node6.f74254a = nodeB;
            node.f74255b = null;
        } else {
            i3 = 0;
        }
        Node node7 = node.f74256c;
        if (node7 != null) {
            i4 = node7.f74262i;
            nodeB.f74256c = node7;
            node7.f74254a = nodeB;
            node.f74256c = null;
        }
        nodeB.f74262i = Math.max(i3, i4) + 1;
        h(node, nodeB);
    }

    public Node g(Object obj) {
        Node nodeD = d(obj);
        if (nodeD != null) {
            f(nodeD, true);
        }
        return nodeD;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object get(Object obj) {
        Node nodeD = d(obj);
        if (nodeD != null) {
            return nodeD.f74261h;
        }
        return null;
    }

    public final void h(Node node, Node node2) {
        Node node3 = node.f74254a;
        node.f74254a = null;
        if (node2 != null) {
            node2.f74254a = node3;
        }
        if (node3 == null) {
            this.f74240c = node2;
        } else if (node3.f74255b == node) {
            node3.f74255b = node2;
        } else {
            node3.f74256c = node2;
        }
    }

    public final void i(Node node) {
        Node node2 = node.f74255b;
        Node node3 = node.f74256c;
        Node node4 = node3.f74255b;
        Node node5 = node3.f74256c;
        node.f74256c = node4;
        if (node4 != null) {
            node4.f74254a = node;
        }
        h(node, node3);
        node3.f74255b = node;
        node.f74254a = node3;
        int iMax = Math.max(node2 != null ? node2.f74262i : 0, node4 != null ? node4.f74262i : 0) + 1;
        node.f74262i = iMax;
        node3.f74262i = Math.max(iMax, node5 != null ? node5.f74262i : 0) + 1;
    }

    public final void j(Node node) {
        Node node2 = node.f74255b;
        Node node3 = node.f74256c;
        Node node4 = node2.f74255b;
        Node node5 = node2.f74256c;
        node.f74255b = node5;
        if (node5 != null) {
            node5.f74254a = node;
        }
        h(node, node2);
        node2.f74256c = node;
        node.f74254a = node2;
        int iMax = Math.max(node3 != null ? node3.f74262i : 0, node5 != null ? node5.f74262i : 0) + 1;
        node.f74262i = iMax;
        node2.f74262i = Math.max(iMax, node4 != null ? node4.f74262i : 0) + 1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set keySet() {
        KeySet keySet = this.f74245h;
        if (keySet != null) {
            return keySet;
        }
        KeySet keySet2 = new KeySet();
        this.f74245h = keySet2;
        return keySet2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object put(Object obj, Object obj2) {
        if (obj == null) {
            throw new NullPointerException("key == null");
        }
        if (obj2 == null && !this.f74239b) {
            throw new NullPointerException("value == null");
        }
        Node nodeB = b(obj, true);
        Object obj3 = nodeB.f74261h;
        nodeB.f74261h = obj2;
        return obj3;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object remove(Object obj) {
        Node nodeG = g(obj);
        if (nodeG != null) {
            return nodeG.f74261h;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.f74241d;
    }

    public LinkedTreeMap(boolean z2) {
        this(f74237i, z2);
    }

    public LinkedTreeMap(Comparator comparator, boolean z2) {
        this.f74241d = 0;
        this.f74242e = 0;
        this.f74238a = comparator == null ? f74237i : comparator;
        this.f74239b = z2;
        this.f74243f = new Node(z2);
    }

    public static final class Node<K, V> implements Map.Entry<K, V> {

        /* renamed from: a, reason: collision with root package name */
        public Node f74254a;

        /* renamed from: b, reason: collision with root package name */
        public Node f74255b;

        /* renamed from: c, reason: collision with root package name */
        public Node f74256c;

        /* renamed from: d, reason: collision with root package name */
        public Node f74257d;

        /* renamed from: e, reason: collision with root package name */
        public Node f74258e;

        /* renamed from: f, reason: collision with root package name */
        public final Object f74259f;

        /* renamed from: g, reason: collision with root package name */
        public final boolean f74260g;

        /* renamed from: h, reason: collision with root package name */
        public Object f74261h;

        /* renamed from: i, reason: collision with root package name */
        public int f74262i;

        public Node(boolean z2) {
            this.f74259f = null;
            this.f74260g = z2;
            this.f74258e = this;
            this.f74257d = this;
        }

        public Node a() {
            Node<K, V> node = this;
            for (Node<K, V> node2 = this.f74255b; node2 != null; node2 = node2.f74255b) {
                node = node2;
            }
            return node;
        }

        public Node b() {
            Node<K, V> node = this;
            for (Node<K, V> node2 = this.f74256c; node2 != null; node2 = node2.f74256c) {
                node = node2;
            }
            return node;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                Object obj2 = this.f74259f;
                if (obj2 != null ? obj2.equals(entry.getKey()) : entry.getKey() == null) {
                    Object obj3 = this.f74261h;
                    if (obj3 == null) {
                        if (entry.getValue() == null) {
                            return true;
                        }
                    } else if (obj3.equals(entry.getValue())) {
                        return true;
                    }
                }
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public Object getKey() {
            return this.f74259f;
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            return this.f74261h;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            Object obj = this.f74259f;
            int iHashCode = obj == null ? 0 : obj.hashCode();
            Object obj2 = this.f74261h;
            return iHashCode ^ (obj2 != null ? obj2.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            if (obj == null && !this.f74260g) {
                throw new NullPointerException("value == null");
            }
            Object obj2 = this.f74261h;
            this.f74261h = obj;
            return obj2;
        }

        public String toString() {
            return this.f74259f + "=" + this.f74261h;
        }

        public Node(boolean z2, Node node, Object obj, Node node2, Node node3) {
            this.f74254a = node;
            this.f74259f = obj;
            this.f74260g = z2;
            this.f74262i = 1;
            this.f74257d = node2;
            this.f74258e = node3;
            node3.f74257d = this;
            node2.f74258e = this;
        }
    }
}
