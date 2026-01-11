package org.apache.commons.io.input;

import java.io.Reader;
import java.io.Serializable;
import java.util.Objects;

/* loaded from: classes6.dex */
public class CharSequenceReader extends Reader implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final CharSequence f161568a;

    /* renamed from: b, reason: collision with root package name */
    public int f161569b;

    /* renamed from: c, reason: collision with root package name */
    public int f161570c;

    /* renamed from: d, reason: collision with root package name */
    public final int f161571d;

    /* renamed from: e, reason: collision with root package name */
    public final Integer f161572e;

    public CharSequenceReader(CharSequence charSequence) {
        this(charSequence, 0);
    }

    public final int a() {
        int length = this.f161568a.length();
        Integer num = this.f161572e;
        return Math.min(length, num == null ? Integer.MAX_VALUE : num.intValue());
    }

    public final int c() {
        return Math.min(this.f161568a.length(), this.f161571d);
    }

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        int i3 = this.f161571d;
        this.f161569b = i3;
        this.f161570c = i3;
    }

    @Override // java.io.Reader
    public void mark(int i3) {
        this.f161570c = this.f161569b;
    }

    @Override // java.io.Reader
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.Reader
    public int read() {
        if (this.f161569b >= a()) {
            return -1;
        }
        CharSequence charSequence = this.f161568a;
        int i3 = this.f161569b;
        this.f161569b = i3 + 1;
        return charSequence.charAt(i3);
    }

    @Override // java.io.Reader
    public boolean ready() {
        return this.f161569b < a();
    }

    @Override // java.io.Reader
    public void reset() {
        this.f161569b = this.f161570c;
    }

    @Override // java.io.Reader
    public long skip(long j3) {
        if (j3 < 0) {
            throw new IllegalArgumentException("Number of characters to skip is less than zero: " + j3);
        }
        if (this.f161569b >= a()) {
            return 0L;
        }
        int iMin = (int) Math.min(a(), this.f161569b + j3);
        int i3 = iMin - this.f161569b;
        this.f161569b = iMin;
        return i3;
    }

    public String toString() {
        return this.f161568a.subSequence(c(), a()).toString();
    }

    public CharSequenceReader(CharSequence charSequence, int i3) {
        this(charSequence, i3, Integer.MAX_VALUE);
    }

    public CharSequenceReader(String str, int i3, int i4) {
        if (i3 < 0) {
            throw new IllegalArgumentException("Start index is less than zero: " + i3);
        }
        if (i4 >= i3) {
            this.f161568a = str == null ? "" : str;
            this.f161571d = i3;
            this.f161572e = Integer.valueOf(i4);
            this.f161569b = i3;
            this.f161570c = i3;
            return;
        }
        throw new IllegalArgumentException("End index is less than start " + i3 + ": " + i4);
    }

    @Override // java.io.Reader
    public int read(char[] cArr, int i3, int i4) {
        if (this.f161569b >= a()) {
            return -1;
        }
        Objects.requireNonNull(cArr, "array");
        if (i4 >= 0 && i3 >= 0 && i3 + i4 <= cArr.length) {
            CharSequence charSequence = this.f161568a;
            if (charSequence instanceof String) {
                int iMin = Math.min(i4, a() - this.f161569b);
                String str = (String) this.f161568a;
                int i5 = this.f161569b;
                str.getChars(i5, i5 + iMin, cArr, i3);
                this.f161569b += iMin;
                return iMin;
            }
            if (charSequence instanceof StringBuilder) {
                int iMin2 = Math.min(i4, a() - this.f161569b);
                StringBuilder sb = (StringBuilder) this.f161568a;
                int i6 = this.f161569b;
                sb.getChars(i6, i6 + iMin2, cArr, i3);
                this.f161569b += iMin2;
                return iMin2;
            }
            if (charSequence instanceof StringBuffer) {
                int iMin3 = Math.min(i4, a() - this.f161569b);
                StringBuffer stringBuffer = (StringBuffer) this.f161568a;
                int i7 = this.f161569b;
                stringBuffer.getChars(i7, i7 + iMin3, cArr, i3);
                this.f161569b += iMin3;
                return iMin3;
            }
            int i8 = 0;
            for (int i9 = 0; i9 < i4; i9++) {
                int i10 = read();
                if (i10 == -1) {
                    break;
                }
                cArr[i3 + i9] = (char) i10;
                i8++;
            }
            return i8;
        }
        throw new IndexOutOfBoundsException("Array Size=" + cArr.length + ", offset=" + i3 + ", length=" + i4);
    }
}
