package org.apache.commons.compress.harmony.pack200;

/* loaded from: classes5.dex */
public class IntList {

    /* renamed from: a, reason: collision with root package name */
    public int[] f161040a;

    /* renamed from: b, reason: collision with root package name */
    public int f161041b;

    /* renamed from: c, reason: collision with root package name */
    public int f161042c;

    /* renamed from: d, reason: collision with root package name */
    public int f161043d;

    public IntList() {
        this(10);
    }

    public boolean a(int i3) {
        if (this.f161042c == this.f161040a.length) {
            c(1);
        }
        int[] iArr = this.f161040a;
        int i4 = this.f161042c;
        this.f161042c = i4 + 1;
        iArr[i4] = i3;
        this.f161043d++;
        return true;
    }

    public int b(int i3) {
        if (i3 >= 0) {
            int i4 = this.f161042c;
            int i5 = this.f161041b;
            if (i3 < i4 - i5) {
                return this.f161040a[i5 + i3];
            }
        }
        throw new IndexOutOfBoundsException("" + i3);
    }

    public final void c(int i3) {
        int i4 = this.f161042c;
        int i5 = this.f161041b;
        int i6 = i4 - i5;
        int[] iArr = this.f161040a;
        if (i5 >= i3 - (iArr.length - i4)) {
            int i7 = i4 - i5;
            if (i6 > 0) {
                System.arraycopy(iArr, i5, iArr, 0, i6);
            }
            this.f161041b = 0;
            this.f161042c = i7;
            return;
        }
        int i8 = i6 / 2;
        if (i3 <= i8) {
            i3 = i8;
        }
        if (i3 < 12) {
            i3 = 12;
        }
        int[] iArr2 = new int[i3 + i6];
        if (i6 > 0) {
            System.arraycopy(iArr, i5, iArr2, 0, i6);
            this.f161041b = 0;
            this.f161042c = i6;
        }
        this.f161040a = iArr2;
    }

    public int d(int i3) {
        int i4;
        int i5 = this.f161042c;
        int i6 = this.f161041b;
        int i7 = i5 - i6;
        if (i3 < 0 || i3 >= i7) {
            throw new IndexOutOfBoundsException();
        }
        if (i3 == i7 - 1) {
            int[] iArr = this.f161040a;
            int i8 = i5 - 1;
            this.f161042c = i8;
            i4 = iArr[i8];
            iArr[i8] = 0;
        } else if (i3 == 0) {
            int[] iArr2 = this.f161040a;
            int i9 = iArr2[i6];
            this.f161041b = i6 + 1;
            iArr2[i6] = 0;
            i4 = i9;
        } else {
            int i10 = i6 + i3;
            int[] iArr3 = this.f161040a;
            int i11 = iArr3[i10];
            if (i3 < i7 / 2) {
                System.arraycopy(iArr3, i6, iArr3, i6 + 1, i3);
                int[] iArr4 = this.f161040a;
                int i12 = this.f161041b;
                this.f161041b = i12 + 1;
                iArr4[i12] = 0;
            } else {
                System.arraycopy(iArr3, i10 + 1, iArr3, i10, (i7 - i3) - 1);
                int[] iArr5 = this.f161040a;
                int i13 = this.f161042c - 1;
                this.f161042c = i13;
                iArr5[i13] = 0;
            }
            i4 = i11;
        }
        if (this.f161041b == this.f161042c) {
            this.f161042c = 0;
            this.f161041b = 0;
        }
        this.f161043d++;
        return i4;
    }

    public int e() {
        return this.f161042c - this.f161041b;
    }

    public int[] f() {
        int i3 = this.f161042c;
        int i4 = this.f161041b;
        int i5 = i3 - i4;
        int[] iArr = new int[i5];
        System.arraycopy(this.f161040a, i4, iArr, 0, i5);
        return iArr;
    }

    public IntList(int i3) {
        if (i3 < 0) {
            throw new IllegalArgumentException();
        }
        this.f161042c = 0;
        this.f161041b = 0;
        this.f161040a = new int[i3];
    }
}
