package org.apache.commons.io.input;

import java.io.FilterReader;
import java.io.IOException;
import java.util.function.IntPredicate;

/* loaded from: classes6.dex */
public abstract class AbstractCharacterFilterReader extends FilterReader {

    /* renamed from: b, reason: collision with root package name */
    public static final IntPredicate f161527b = new IntPredicate() { // from class: org.apache.commons.io.input.a
        @Override // java.util.function.IntPredicate
        public final boolean test(int i3) {
            return AbstractCharacterFilterReader.a(i3);
        }
    };

    /* renamed from: a, reason: collision with root package name */
    public final IntPredicate f161528a;

    public static /* synthetic */ boolean a(int i3) {
        return false;
    }

    public boolean c(int i3) {
        return this.f161528a.test(i3);
    }

    @Override // java.io.FilterReader, java.io.Reader
    public int read() throws IOException {
        int i3;
        do {
            i3 = ((FilterReader) this).in.read();
            if (i3 == -1) {
                break;
            }
        } while (c(i3));
        return i3;
    }

    @Override // java.io.FilterReader, java.io.Reader
    public int read(char[] cArr, int i3, int i4) throws IOException {
        int i5 = super.read(cArr, i3, i4);
        if (i5 == -1) {
            return -1;
        }
        int i6 = i3 - 1;
        for (int i7 = i3; i7 < i3 + i5; i7++) {
            if (!c(cArr[i7]) && (i6 = i6 + 1) < i7) {
                cArr[i6] = cArr[i7];
            }
        }
        return (i6 - i3) + 1;
    }
}
