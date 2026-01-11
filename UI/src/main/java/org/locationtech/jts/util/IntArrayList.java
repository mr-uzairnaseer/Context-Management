package org.locationtech.jts.util;

import java.util.Arrays;

/* loaded from: classes7.dex */
public class IntArrayList {

    /* renamed from: a, reason: collision with root package name */
    public int[] f164333a;

    /* renamed from: b, reason: collision with root package name */
    public int f164334b;

    public IntArrayList() {
        this(10);
    }

    public void a(int i3) {
        b(this.f164334b + 1);
        int[] iArr = this.f164333a;
        int i4 = this.f164334b;
        iArr[i4] = i3;
        this.f164334b = i4 + 1;
    }

    public void b(int i3) {
        int[] iArr = this.f164333a;
        if (i3 <= iArr.length) {
            return;
        }
        this.f164333a = Arrays.copyOf(this.f164333a, Math.max(i3, iArr.length * 2));
    }

    public int[] c() {
        int i3 = this.f164334b;
        int[] iArr = new int[i3];
        System.arraycopy(this.f164333a, 0, iArr, 0, i3);
        return iArr;
    }

    public IntArrayList(int i3) {
        this.f164334b = 0;
        this.f164333a = new int[i3];
    }
}
