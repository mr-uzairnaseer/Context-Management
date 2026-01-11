package com.caverock.androidsvg;

import androidx.collection.SieveCacheKt;
import androidx.media3.muxer.MuxerUtil;

/* loaded from: classes4.dex */
class IntegerParser {

    /* renamed from: a, reason: collision with root package name */
    public int f57036a;

    /* renamed from: b, reason: collision with root package name */
    public long f57037b;

    public IntegerParser(long j3, int i3) {
        this.f57037b = j3;
        this.f57036a = i3;
    }

    public static IntegerParser b(String str, int i3, int i4) {
        long j3;
        int i5;
        if (i3 >= i4) {
            return null;
        }
        long j4 = 0;
        int i6 = i3;
        while (i6 < i4) {
            char cCharAt = str.charAt(i6);
            if (cCharAt < '0' || cCharAt > '9') {
                if (cCharAt >= 'A' && cCharAt <= 'F') {
                    j3 = j4 * 16;
                    i5 = cCharAt - 'A';
                } else {
                    if (cCharAt < 'a' || cCharAt > 'f') {
                        break;
                    }
                    j3 = j4 * 16;
                    i5 = cCharAt - 'a';
                }
                j4 = j3 + i5 + 10;
            } else {
                j4 = (j4 * 16) + (cCharAt - '0');
            }
            if (j4 > MuxerUtil.UNSIGNED_INT_MAX_VALUE) {
                return null;
            }
            i6++;
        }
        if (i6 == i3) {
            return null;
        }
        return new IntegerParser(j4, i6);
    }

    public static IntegerParser c(String str, int i3, int i4, boolean z2) {
        if (i3 >= i4) {
            return null;
        }
        boolean z3 = false;
        if (z2) {
            char cCharAt = str.charAt(i3);
            if (cCharAt == '+') {
                i3++;
            } else if (cCharAt == '-') {
                z3 = true;
                i3++;
            }
        }
        long j3 = 0;
        int i5 = i3;
        while (i5 < i4) {
            char cCharAt2 = str.charAt(i5);
            if (cCharAt2 < '0' || cCharAt2 > '9') {
                break;
            }
            if (z3) {
                j3 = (j3 * 10) - (cCharAt2 - '0');
                if (j3 < SieveCacheKt.NodeMetaAndPreviousMask) {
                    return null;
                }
            } else {
                j3 = (j3 * 10) + (cCharAt2 - '0');
                if (j3 > SieveCacheKt.NodeLinkMask) {
                    return null;
                }
            }
            i5++;
        }
        if (i5 == i3) {
            return null;
        }
        return new IntegerParser(j3, i5);
    }

    public int a() {
        return this.f57036a;
    }

    public int d() {
        return (int) this.f57037b;
    }
}
