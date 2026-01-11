package com.sun.xml.stream.xerces.util;

/* loaded from: classes5.dex */
public class SymbolHash {
    protected Entry[] fBuckets;
    protected int fNum;
    protected int fTableSize;

    public SymbolHash() {
        this.fTableSize = 101;
        this.fNum = 0;
        this.fBuckets = new Entry[101];
    }

    public void clear() {
        for (int i3 = 0; i3 < this.fTableSize; i3++) {
            this.fBuckets[i3] = null;
        }
        this.fNum = 0;
    }

    public Object get(Object obj) {
        Entry entrySearch = search(obj, (obj.hashCode() & Integer.MAX_VALUE) % this.fTableSize);
        if (entrySearch != null) {
            return entrySearch.value;
        }
        return null;
    }

    public int getLength() {
        return this.fNum;
    }

    public int getValues(Object[] objArr, int i3) {
        int i4 = 0;
        for (int i5 = 0; i5 < this.fTableSize && i4 < this.fNum; i5++) {
            for (Entry entry = this.fBuckets[i5]; entry != null; entry = entry.next) {
                objArr[i3 + i4] = entry.value;
                i4++;
            }
        }
        return this.fNum;
    }

    public SymbolHash makeClone() {
        SymbolHash symbolHash = new SymbolHash(this.fTableSize);
        symbolHash.fNum = this.fNum;
        for (int i3 = 0; i3 < this.fTableSize; i3++) {
            Entry entry = this.fBuckets[i3];
            if (entry != null) {
                symbolHash.fBuckets[i3] = entry.makeClone();
            }
        }
        return symbolHash;
    }

    public void put(Object obj, Object obj2) {
        int iHashCode = (obj.hashCode() & Integer.MAX_VALUE) % this.fTableSize;
        Entry entrySearch = search(obj, iHashCode);
        if (entrySearch != null) {
            entrySearch.value = obj2;
            return;
        }
        this.fBuckets[iHashCode] = new Entry(obj, obj2, this.fBuckets[iHashCode]);
        this.fNum++;
    }

    public Entry search(Object obj, int i3) {
        for (Entry entry = this.fBuckets[i3]; entry != null; entry = entry.next) {
            if (obj.equals(entry.key)) {
                return entry;
            }
        }
        return null;
    }

    public static final class Entry {
        public Object key;
        public Entry next;
        public Object value;

        public Entry() {
            this.key = null;
            this.value = null;
            this.next = null;
        }

        public Entry makeClone() {
            Entry entry = new Entry();
            entry.key = this.key;
            entry.value = this.value;
            Entry entry2 = this.next;
            if (entry2 != null) {
                entry.next = entry2.makeClone();
            }
            return entry;
        }

        public Entry(Object obj, Object obj2, Entry entry) {
            this.key = obj;
            this.value = obj2;
            this.next = entry;
        }
    }

    public SymbolHash(int i3) {
        this.fNum = 0;
        this.fTableSize = i3;
        this.fBuckets = new Entry[i3];
    }
}
