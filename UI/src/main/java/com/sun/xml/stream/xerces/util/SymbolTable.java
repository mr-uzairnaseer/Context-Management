package com.sun.xml.stream.xerces.util;

/* loaded from: classes5.dex */
public class SymbolTable {
    protected static final int TABLE_SIZE = 173;
    protected Entry[] fBuckets;
    protected int fTableSize;
    protected char[] symbolAsArray;

    public SymbolTable() {
        this(173);
    }

    public String addSymbol(String str) {
        int iHash = hash(str);
        int i3 = iHash % this.fTableSize;
        int length = str.length();
        for (Entry entry = this.fBuckets[i3]; entry != null; entry = entry.next) {
            if (length == entry.characters.length && iHash == entry.hashCode && str.regionMatches(0, entry.symbol, 0, length)) {
                this.symbolAsArray = entry.characters;
                return entry.symbol;
            }
        }
        Entry entry2 = new Entry(str, this.fBuckets[i3]);
        entry2.hashCode = iHash;
        this.symbolAsArray = entry2.characters;
        this.fBuckets[i3] = entry2;
        return entry2.symbol;
    }

    public boolean containsSymbol(String str) {
        int iHash = hash(str);
        int i3 = iHash % this.fTableSize;
        int length = str.length();
        for (Entry entry = this.fBuckets[i3]; entry != null; entry = entry.next) {
            if (length == entry.characters.length && iHash == entry.hashCode && str.regionMatches(0, entry.symbol, 0, length)) {
                return true;
            }
        }
        return false;
    }

    public char[] getCharArray() {
        return this.symbolAsArray;
    }

    public int hash(String str) {
        int length = str.length();
        int iCharAt = 0;
        for (int i3 = 0; i3 < length; i3++) {
            iCharAt = (iCharAt * 37) + str.charAt(i3);
        }
        return 134217727 & iCharAt;
    }

    public SymbolTable(int i3) {
        this.symbolAsArray = null;
        this.fBuckets = null;
        this.fTableSize = i3;
        this.fBuckets = new Entry[i3];
    }

    public int hash(char[] cArr, int i3, int i4) {
        int i5 = 0;
        for (int i6 = 0; i6 < i4; i6++) {
            i5 = (i5 * 37) + cArr[i3 + i6];
        }
        return 134217727 & i5;
    }

    public static final class Entry {
        public char[] characters;
        int hashCode = 0;
        public Entry next;
        public String symbol;

        public Entry(String str, Entry entry) {
            this.symbol = str.intern();
            char[] cArr = new char[str.length()];
            this.characters = cArr;
            str.getChars(0, cArr.length, cArr, 0);
            this.next = entry;
        }

        public Entry(char[] cArr, int i3, int i4, Entry entry) {
            char[] cArr2 = new char[i4];
            this.characters = cArr2;
            System.arraycopy(cArr, i3, cArr2, 0, i4);
            this.symbol = new String(this.characters).intern();
            this.next = entry;
        }
    }

    public boolean containsSymbol(char[] cArr, int i3, int i4) {
        int iHash = hash(cArr, i3, i4);
        Entry entry = this.fBuckets[iHash % this.fTableSize];
        while (true) {
            if (entry == null) {
                return false;
            }
            if (i4 == entry.characters.length && iHash == entry.hashCode) {
                for (int i5 = 0; i5 < i4; i5++) {
                    if (cArr[i3 + i5] != entry.characters[i5]) {
                        break;
                    }
                }
                return true;
            }
            entry = entry.next;
        }
    }

    public String addSymbol(char[] cArr, int i3, int i4) {
        int iHash = hash(cArr, i3, i4);
        int i5 = iHash % this.fTableSize;
        for (Entry entry = this.fBuckets[i5]; entry != null; entry = entry.next) {
            if (i4 == entry.characters.length && iHash == entry.hashCode) {
                for (int i6 = 0; i6 < i4; i6++) {
                    if (cArr[i3 + i6] != entry.characters[i6]) {
                        break;
                    }
                }
                this.symbolAsArray = entry.characters;
                return entry.symbol;
            }
        }
        Entry entry2 = new Entry(cArr, i3, i4, this.fBuckets[i5]);
        this.fBuckets[i5] = entry2;
        entry2.hashCode = iHash;
        this.symbolAsArray = entry2.characters;
        return entry2.symbol;
    }
}
