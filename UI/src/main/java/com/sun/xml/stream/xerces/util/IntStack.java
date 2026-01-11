package com.sun.xml.stream.xerces.util;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes5.dex */
public final class IntStack {
    private int[] fData;
    private int fDepth;

    private void ensureCapacity(int i3) {
        int[] iArr = this.fData;
        if (iArr == null) {
            this.fData = new int[32];
        } else if (iArr.length <= i3) {
            int[] iArr2 = new int[iArr.length * 2];
            System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
            this.fData = iArr2;
        }
    }

    public void clear() {
        this.fDepth = 0;
    }

    public int peek() {
        return this.fData[this.fDepth - 1];
    }

    public int pop() {
        int[] iArr = this.fData;
        int i3 = this.fDepth - 1;
        this.fDepth = i3;
        return iArr[i3];
    }

    public void print() {
        System.out.print('(');
        System.out.print(this.fDepth);
        System.out.print(") {");
        int i3 = 0;
        while (true) {
            if (i3 >= this.fDepth) {
                break;
            }
            if (i3 == 3) {
                System.out.print(" ...");
                break;
            }
            System.out.print(' ');
            System.out.print(this.fData[i3]);
            if (i3 < this.fDepth - 1) {
                System.out.print(AbstractJsonLexerKt.COMMA);
            }
            i3++;
        }
        System.out.print(" }");
        System.out.println();
    }

    public void push(int i3) {
        ensureCapacity(this.fDepth + 1);
        int[] iArr = this.fData;
        int i4 = this.fDepth;
        this.fDepth = i4 + 1;
        iArr[i4] = i3;
    }

    public int size() {
        return this.fDepth;
    }
}
