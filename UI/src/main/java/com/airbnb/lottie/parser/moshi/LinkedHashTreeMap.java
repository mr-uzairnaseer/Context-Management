package com.airbnb.lottie.parser.moshi;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* loaded from: classes4.dex */
final class LinkedHashTreeMap<K, V> extends AbstractMap<K, V> implements Serializable {

    /* renamed from: i, reason: collision with root package name */
    public static final Comparator f51279i = new Comparator<Comparable>() { // from class: com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.1
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Comparable comparable, Comparable comparable2) {
            return comparable.compareTo(comparable2);
        }
    };

    /* renamed from: a, reason: collision with root package name */
    public Comparator f51280a;

    /* renamed from: b, reason: collision with root package name */
    public Node[] f51281b;

    /* renamed from: c, reason: collision with root package name */
    public final Node f51282c;

    /* renamed from: d, reason: collision with root package name */
    public int f51283d;

    /* renamed from: e, reason: collision with root package name */
    public int f51284e;

    /* renamed from: f, reason: collision with root package name */
    public int f51285f;

    /* renamed from: g, reason: collision with root package name */
    public EntrySet f51286g;

    /* renamed from: h, reason: collision with root package name */
    public KeySet f51287h;

    public static final class AvlBuilder<K, V> {

        /* renamed from: a, reason: collision with root package name */
        public Node f51288a;

        /* renamed from: b, reason: collision with root package name */
        public int f51289b;

        /* renamed from: c, reason: collision with root package name */
        public int f51290c;

        /* renamed from: d, reason: collision with root package name */
        public int f51291d;

        public void a(Node node) {
            node.f51303c = null;
            node.f51301a = null;
            node.f51302b = null;
            node.f51309i = 1;
            int i3 = this.f51289b;
            if (i3 > 0) {
                int i4 = this.f51291d;
                if ((i4 & 1) == 0) {
                    this.f51291d = i4 + 1;
                    this.f51289b = i3 - 1;
                    this.f51290c++;
                }
            }
            node.f51301a = this.f51288a;
            this.f51288a = node;
            int i5 = this.f51291d;
            int i6 = i5 + 1;
            this.f51291d = i6;
            int i7 = this.f51289b;
            if (i7 > 0 && (i6 & 1) == 0) {
                this.f51291d = i5 + 2;
                this.f51289b = i7 - 1;
                this.f51290c++;
            }
            int i8 = 4;
            while (true) {
                int i9 = i8 - 1;
                if ((this.f51291d & i9) != i9) {
                    return;
                }
                int i10 = this.f51290c;
                if (i10 == 0) {
                    Node node2 = this.f51288a;
                    Node node3 = node2.f51301a;
                    Node node4 = node3.f51301a;
                    node3.f51301a = node4.f51301a;
                    this.f51288a = node3;
                    node3.f51302b = node4;
                    node3.f51303c = node2;
                    node3.f51309i = node2.f51309i + 1;
                    node4.f51301a = node3;
                    node2.f51301a = node3;
                } else if (i10 == 1) {
                    Node node5 = this.f51288a;
                    Node node6 = node5.f51301a;
                    this.f51288a = node6;
                    node6.f51303c = node5;
                    node6.f51309i = node5.f51309i + 1;
                    node5.f51301a = node6;
                    this.f51290c = 0;
                } else if (i10 == 2) {
                    this.f51290c = 0;
                }
                i8 *= 2;
            }
        }

        public void b(int i3) {
            this.f51289b = ((Integer.highestOneBit(i3) * 2) - 1) - i3;
            this.f51291d = 0;
            this.f51290c = 0;
            this.f51288a = null;
        }

        public Node c() {
            Node node = this.f51288a;
            if (node.f51301a == null) {
                return node;
            }
            throw new IllegalStateException();
        }
    }

    public static class AvlIterator<K, V> {

        /* renamed from: a, reason: collision with root package name */
        public Node f51292a;

        public Node a() {
            Node node = this.f51292a;
            if (node == null) {
                return null;
            }
            Node node2 = node.f51301a;
            node.f51301a = null;
            Node node3 = node.f51303c;
            while (true) {
                Node node4 = node2;
                node2 = node3;
                if (node2 == null) {
                    this.f51292a = node4;
                    return node;
                }
                node2.f51301a = node4;
                node3 = node2.f51302b;
            }
        }

        public void b(Node node) {
            Node node2 = null;
            while (node != null) {
                node.f51301a = node2;
                node2 = node;
                node = node.f51302b;
            }
            this.f51292a = node2;
        }
    }

    public final class EntrySet extends AbstractSet<Map.Entry<K, V>> {
        public EntrySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            LinkedHashTreeMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return (obj instanceof Map.Entry) && LinkedHashTreeMap.this.e((Map.Entry) obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return new LinkedHashTreeMap<K, V>.LinkedTreeMapIterator<Map.Entry<K, V>>() { // from class: com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.EntrySet.1
                {
                    LinkedHashTreeMap linkedHashTreeMap = LinkedHashTreeMap.this;
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
            Node nodeE;
            if (!(obj instanceof Map.Entry) || (nodeE = LinkedHashTreeMap.this.e((Map.Entry) obj)) == null) {
                return false;
            }
            LinkedHashTreeMap.this.h(nodeE, true);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return LinkedHashTreeMap.this.f51283d;
        }
    }

    public final class KeySet extends AbstractSet<K> {
        public KeySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            LinkedHashTreeMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return LinkedHashTreeMap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return new LinkedHashTreeMap<K, V>.LinkedTreeMapIterator<K>() { // from class: com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.KeySet.1
                {
                    LinkedHashTreeMap linkedHashTreeMap = LinkedHashTreeMap.this;
                }

                @Override // java.util.Iterator
                public Object next() {
                    return a().f51306f;
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return LinkedHashTreeMap.this.i(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return LinkedHashTreeMap.this.f51283d;
        }
    }

    public abstract class LinkedTreeMapIterator<T> implements Iterator<T> {

        /* renamed from: a, reason: collision with root package name */
        public Node f51297a;

        /* renamed from: b, reason: collision with root package name */
        public Node f51298b = null;

        /* renamed from: c, reason: collision with root package name */
        public int f51299c;

        public LinkedTreeMapIterator() {
            this.f51297a = LinkedHashTreeMap.this.f51282c.f51304d;
            this.f51299c = LinkedHashTreeMap.this.f51284e;
        }

        public final Node a() {
            Node node = this.f51297a;
            LinkedHashTreeMap linkedHashTreeMap = LinkedHashTreeMap.this;
            if (node == linkedHashTreeMap.f51282c) {
                throw new NoSuchElementException();
            }
            if (linkedHashTreeMap.f51284e != this.f51299c) {
                throw new ConcurrentModificationException();
            }
            this.f51297a = node.f51304d;
            this.f51298b = node;
            return node;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f51297a != LinkedHashTreeMap.this.f51282c;
        }

        @Override // java.util.Iterator
        public final void remove() {
            Node node = this.f51298b;
            if (node == null) {
                throw new IllegalStateException();
            }
            LinkedHashTreeMap.this.h(node, true);
            this.f51298b = null;
            this.f51299c = LinkedHashTreeMap.this.f51284e;
        }
    }

    public LinkedHashTreeMap() {
        this(null);
    }

    public static Node[] b(Node[] nodeArr) {
        int length = nodeArr.length;
        Node[] nodeArr2 = new Node[length * 2];
        AvlIterator avlIterator = new AvlIterator();
        AvlBuilder avlBuilder = new AvlBuilder();
        AvlBuilder avlBuilder2 = new AvlBuilder();
        for (int i3 = 0; i3 < length; i3++) {
            Node node = nodeArr[i3];
            if (node != null) {
                avlIterator.b(node);
                int i4 = 0;
                int i5 = 0;
                while (true) {
                    Node nodeA = avlIterator.a();
                    if (nodeA == null) {
                        break;
                    }
                    if ((nodeA.f51307g & length) == 0) {
                        i4++;
                    } else {
                        i5++;
                    }
                }
                avlBuilder.b(i4);
                avlBuilder2.b(i5);
                avlIterator.b(node);
                while (true) {
                    Node nodeA2 = avlIterator.a();
                    if (nodeA2 == null) {
                        break;
                    }
                    if ((nodeA2.f51307g & length) == 0) {
                        avlBuilder.a(nodeA2);
                    } else {
                        avlBuilder2.a(nodeA2);
                    }
                }
                nodeArr2[i3] = i4 > 0 ? avlBuilder.c() : null;
                nodeArr2[i3 + length] = i5 > 0 ? avlBuilder2.c() : null;
            }
        }
        return nodeArr2;
    }

    public static int m(int i3) {
        int i4 = i3 ^ ((i3 >>> 20) ^ (i3 >>> 12));
        return (i4 >>> 4) ^ ((i4 >>> 7) ^ i4);
    }

    private Object writeReplace() throws ObjectStreamException {
        return new LinkedHashMap(this);
    }

    public final void a() {
        Node[] nodeArrB = b(this.f51281b);
        this.f51281b = nodeArrB;
        this.f51285f = (nodeArrB.length / 2) + (nodeArrB.length / 4);
    }

    public final boolean c(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        Arrays.fill(this.f51281b, (Object) null);
        this.f51283d = 0;
        this.f51284e++;
        Node node = this.f51282c;
        Node node2 = node.f51304d;
        while (node2 != node) {
            Node node3 = node2.f51304d;
            node2.f51305e = null;
            node2.f51304d = null;
            node2 = node3;
        }
        node.f51305e = node;
        node.f51304d = node;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return f(obj) != null;
    }

    public Node d(Object obj, boolean z2) {
        int iCompareTo;
        Node node;
        Comparator comparator = this.f51280a;
        Node[] nodeArr = this.f51281b;
        int iM = m(obj.hashCode());
        int length = (nodeArr.length - 1) & iM;
        Node node2 = nodeArr[length];
        if (node2 != null) {
            Comparable comparable = comparator == f51279i ? (Comparable) obj : null;
            while (true) {
                iCompareTo = comparable != null ? comparable.compareTo(node2.f51306f) : comparator.compare(obj, node2.f51306f);
                if (iCompareTo == 0) {
                    return node2;
                }
                Node node3 = iCompareTo < 0 ? node2.f51302b : node2.f51303c;
                if (node3 == null) {
                    break;
                }
                node2 = node3;
            }
        } else {
            iCompareTo = 0;
        }
        int i3 = iCompareTo;
        if (!z2) {
            return null;
        }
        Node node4 = this.f51282c;
        if (node2 != null) {
            Node node5 = node2;
            node = new Node(node5, obj, iM, node4, node4.f51305e);
            if (i3 < 0) {
                node5.f51302b = node;
            } else {
                node5.f51303c = node;
            }
            g(node5, true);
        } else {
            if (comparator == f51279i && !(obj instanceof Comparable)) {
                throw new ClassCastException(obj.getClass().getName() + " is not Comparable");
            }
            node = new Node(node2, obj, iM, node4, node4.f51305e);
            nodeArr[length] = node;
        }
        int i4 = this.f51283d;
        this.f51283d = i4 + 1;
        if (i4 > this.f51285f) {
            a();
        }
        this.f51284e++;
        return node;
    }

    public Node e(Map.Entry entry) {
        Node nodeF = f(entry.getKey());
        if (nodeF == null || !c(nodeF.f51308h, entry.getValue())) {
            return null;
        }
        return nodeF;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set entrySet() {
        EntrySet entrySet = this.f51286g;
        if (entrySet != null) {
            return entrySet;
        }
        EntrySet entrySet2 = new EntrySet();
        this.f51286g = entrySet2;
        return entrySet2;
    }

    public Node f(Object obj) {
        if (obj != null) {
            try {
                return d(obj, false);
            } catch (ClassCastException unused) {
            }
        }
        return null;
    }

    public final void g(Node node, boolean z2) {
        while (node != null) {
            Node node2 = node.f51302b;
            Node node3 = node.f51303c;
            int i3 = node2 != null ? node2.f51309i : 0;
            int i4 = node3 != null ? node3.f51309i : 0;
            int i5 = i3 - i4;
            if (i5 == -2) {
                Node node4 = node3.f51302b;
                Node node5 = node3.f51303c;
                int i6 = (node4 != null ? node4.f51309i : 0) - (node5 != null ? node5.f51309i : 0);
                if (i6 == -1 || (i6 == 0 && !z2)) {
                    k(node);
                } else {
                    l(node3);
                    k(node);
                }
                if (z2) {
                    return;
                }
            } else if (i5 == 2) {
                Node node6 = node2.f51302b;
                Node node7 = node2.f51303c;
                int i7 = (node6 != null ? node6.f51309i : 0) - (node7 != null ? node7.f51309i : 0);
                if (i7 == 1 || (i7 == 0 && !z2)) {
                    l(node);
                } else {
                    k(node2);
                    l(node);
                }
                if (z2) {
                    return;
                }
            } else if (i5 == 0) {
                node.f51309i = i3 + 1;
                if (z2) {
                    return;
                }
            } else {
                node.f51309i = Math.max(i3, i4) + 1;
                if (!z2) {
                    return;
                }
            }
            node = node.f51301a;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object get(Object obj) {
        Node nodeF = f(obj);
        if (nodeF != null) {
            return nodeF.f51308h;
        }
        return null;
    }

    public void h(Node node, boolean z2) {
        int i3;
        if (z2) {
            Node node2 = node.f51305e;
            node2.f51304d = node.f51304d;
            node.f51304d.f51305e = node2;
            node.f51305e = null;
            node.f51304d = null;
        }
        Node node3 = node.f51302b;
        Node node4 = node.f51303c;
        Node node5 = node.f51301a;
        int i4 = 0;
        if (node3 == null || node4 == null) {
            if (node3 != null) {
                j(node, node3);
                node.f51302b = null;
            } else if (node4 != null) {
                j(node, node4);
                node.f51303c = null;
            } else {
                j(node, null);
            }
            g(node5, false);
            this.f51283d--;
            this.f51284e++;
            return;
        }
        Node nodeB = node3.f51309i > node4.f51309i ? node3.b() : node4.a();
        h(nodeB, false);
        Node node6 = node.f51302b;
        if (node6 != null) {
            i3 = node6.f51309i;
            nodeB.f51302b = node6;
            node6.f51301a = nodeB;
            node.f51302b = null;
        } else {
            i3 = 0;
        }
        Node node7 = node.f51303c;
        if (node7 != null) {
            i4 = node7.f51309i;
            nodeB.f51303c = node7;
            node7.f51301a = nodeB;
            node.f51303c = null;
        }
        nodeB.f51309i = Math.max(i3, i4) + 1;
        j(node, nodeB);
    }

    public Node i(Object obj) {
        Node nodeF = f(obj);
        if (nodeF != null) {
            h(nodeF, true);
        }
        return nodeF;
    }

    public final void j(Node node, Node node2) {
        Node node3 = node.f51301a;
        node.f51301a = null;
        if (node2 != null) {
            node2.f51301a = node3;
        }
        if (node3 == null) {
            int i3 = node.f51307g;
            this.f51281b[i3 & (r0.length - 1)] = node2;
        } else if (node3.f51302b == node) {
            node3.f51302b = node2;
        } else {
            node3.f51303c = node2;
        }
    }

    public final void k(Node node) {
        Node node2 = node.f51302b;
        Node node3 = node.f51303c;
        Node node4 = node3.f51302b;
        Node node5 = node3.f51303c;
        node.f51303c = node4;
        if (node4 != null) {
            node4.f51301a = node;
        }
        j(node, node3);
        node3.f51302b = node;
        node.f51301a = node3;
        int iMax = Math.max(node2 != null ? node2.f51309i : 0, node4 != null ? node4.f51309i : 0) + 1;
        node.f51309i = iMax;
        node3.f51309i = Math.max(iMax, node5 != null ? node5.f51309i : 0) + 1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set keySet() {
        KeySet keySet = this.f51287h;
        if (keySet != null) {
            return keySet;
        }
        KeySet keySet2 = new KeySet();
        this.f51287h = keySet2;
        return keySet2;
    }

    public final void l(Node node) {
        Node node2 = node.f51302b;
        Node node3 = node.f51303c;
        Node node4 = node2.f51302b;
        Node node5 = node2.f51303c;
        node.f51302b = node5;
        if (node5 != null) {
            node5.f51301a = node;
        }
        j(node, node2);
        node2.f51303c = node;
        node.f51301a = node2;
        int iMax = Math.max(node3 != null ? node3.f51309i : 0, node5 != null ? node5.f51309i : 0) + 1;
        node.f51309i = iMax;
        node2.f51309i = Math.max(iMax, node4 != null ? node4.f51309i : 0) + 1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object put(Object obj, Object obj2) {
        if (obj == null) {
            throw new NullPointerException("key == null");
        }
        Node nodeD = d(obj, true);
        Object obj3 = nodeD.f51308h;
        nodeD.f51308h = obj2;
        return obj3;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object remove(Object obj) {
        Node nodeI = i(obj);
        if (nodeI != null) {
            return nodeI.f51308h;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.f51283d;
    }

    public LinkedHashTreeMap(Comparator comparator) {
        this.f51283d = 0;
        this.f51284e = 0;
        this.f51280a = comparator == null ? f51279i : comparator;
        this.f51282c = new Node();
        Node[] nodeArr = new Node[16];
        this.f51281b = nodeArr;
        this.f51285f = (nodeArr.length / 2) + (nodeArr.length / 4);
    }

    public static final class Node<K, V> implements Map.Entry<K, V> {

        /* renamed from: a, reason: collision with root package name */
        public Node f51301a;

        /* renamed from: b, reason: collision with root package name */
        public Node f51302b;

        /* renamed from: c, reason: collision with root package name */
        public Node f51303c;

        /* renamed from: d, reason: collision with root package name */
        public Node f51304d;

        /* renamed from: e, reason: collision with root package name */
        public Node f51305e;

        /* renamed from: f, reason: collision with root package name */
        public final Object f51306f;

        /* renamed from: g, reason: collision with root package name */
        public final int f51307g;

        /* renamed from: h, reason: collision with root package name */
        public Object f51308h;

        /* renamed from: i, reason: collision with root package name */
        public int f51309i;

        public Node() {
            this.f51306f = null;
            this.f51307g = -1;
            this.f51305e = this;
            this.f51304d = this;
        }

        public Node a() {
            Node<K, V> node = this;
            for (Node<K, V> node2 = this.f51302b; node2 != null; node2 = node2.f51302b) {
                node = node2;
            }
            return node;
        }

        public Node b() {
            Node<K, V> node = this;
            for (Node<K, V> node2 = this.f51303c; node2 != null; node2 = node2.f51303c) {
                node = node2;
            }
            return node;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                Object obj2 = this.f51306f;
                if (obj2 != null ? obj2.equals(entry.getKey()) : entry.getKey() == null) {
                    Object obj3 = this.f51308h;
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
            return this.f51306f;
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            return this.f51308h;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            Object obj = this.f51306f;
            int iHashCode = obj == null ? 0 : obj.hashCode();
            Object obj2 = this.f51308h;
            return iHashCode ^ (obj2 != null ? obj2.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            Object obj2 = this.f51308h;
            this.f51308h = obj;
            return obj2;
        }

        public String toString() {
            return this.f51306f + "=" + this.f51308h;
        }

        public Node(Node node, Object obj, int i3, Node node2, Node node3) {
            this.f51301a = node;
            this.f51306f = obj;
            this.f51307g = i3;
            this.f51309i = 1;
            this.f51304d = node2;
            this.f51305e = node3;
            node3.f51304d = this;
            node2.f51305e = this;
        }
    }
}
