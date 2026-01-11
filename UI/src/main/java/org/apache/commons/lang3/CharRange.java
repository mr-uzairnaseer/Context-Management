package org.apache.commons.lang3;

import java.io.Serializable;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.apache.commons.codec.language.Soundex;

/* loaded from: classes7.dex */
final class CharRange implements Iterable<Character>, Serializable {

    /* renamed from: e, reason: collision with root package name */
    public static final CharRange[] f161919e = new CharRange[0];

    /* renamed from: a, reason: collision with root package name */
    public final char f161920a;

    /* renamed from: b, reason: collision with root package name */
    public final char f161921b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f161922c;

    /* renamed from: d, reason: collision with root package name */
    public transient String f161923d;

    public static final class CharacterIterator implements Iterator<Character> {

        /* renamed from: a, reason: collision with root package name */
        public char f161924a;

        /* renamed from: b, reason: collision with root package name */
        public final CharRange f161925b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f161926c;

        @Override // java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Character next() {
            if (!this.f161926c) {
                throw new NoSuchElementException();
            }
            char c3 = this.f161924a;
            b();
            return Character.valueOf(c3);
        }

        public final void b() {
            if (!this.f161925b.f161922c) {
                if (this.f161924a < this.f161925b.f161921b) {
                    this.f161924a = (char) (this.f161924a + 1);
                    return;
                } else {
                    this.f161926c = false;
                    return;
                }
            }
            char c3 = this.f161924a;
            if (c3 == 65535) {
                this.f161926c = false;
                return;
            }
            if (c3 + 1 != this.f161925b.f161920a) {
                this.f161924a = (char) (this.f161924a + 1);
            } else if (this.f161925b.f161921b == 65535) {
                this.f161926c = false;
            } else {
                this.f161924a = (char) (this.f161925b.f161921b + 1);
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f161926c;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        public CharacterIterator(CharRange charRange) {
            this.f161925b = charRange;
            this.f161926c = true;
            if (!charRange.f161922c) {
                this.f161924a = charRange.f161920a;
                return;
            }
            if (charRange.f161920a != 0) {
                this.f161924a = (char) 0;
            } else if (charRange.f161921b == 65535) {
                this.f161926c = false;
            } else {
                this.f161924a = (char) (charRange.f161921b + 1);
            }
        }
    }

    public CharRange(char c3, char c4, boolean z2) {
        if (c3 > c4) {
            c4 = c3;
            c3 = c4;
        }
        this.f161920a = c3;
        this.f161921b = c4;
        this.f161922c = z2;
    }

    public static CharRange f(char c3) {
        return new CharRange(c3, c3, false);
    }

    public static CharRange g(char c3, char c4) {
        return new CharRange(c3, c4, false);
    }

    public static CharRange i(char c3) {
        return new CharRange(c3, c3, true);
    }

    public static CharRange k(char c3, char c4) {
        return new CharRange(c3, c4, true);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CharRange)) {
            return false;
        }
        CharRange charRange = (CharRange) obj;
        return this.f161920a == charRange.f161920a && this.f161921b == charRange.f161921b && this.f161922c == charRange.f161922c;
    }

    public boolean h() {
        return this.f161922c;
    }

    public int hashCode() {
        return this.f161920a + 'S' + (this.f161921b * 7) + (this.f161922c ? 1 : 0);
    }

    @Override // java.lang.Iterable
    public Iterator<Character> iterator() {
        return new CharacterIterator();
    }

    public String toString() {
        if (this.f161923d == null) {
            StringBuilder sb = new StringBuilder(4);
            if (h()) {
                sb.append('^');
            }
            sb.append(this.f161920a);
            if (this.f161920a != this.f161921b) {
                sb.append(Soundex.SILENT_MARKER);
                sb.append(this.f161921b);
            }
            this.f161923d = sb.toString();
        }
        return this.f161923d;
    }
}
