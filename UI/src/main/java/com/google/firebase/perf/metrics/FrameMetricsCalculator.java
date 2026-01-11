package com.google.firebase.perf.metrics;

import android.util.SparseIntArray;

/* loaded from: classes.dex */
public class FrameMetricsCalculator {

    public static class PerfFrameMetrics {

        /* renamed from: a, reason: collision with root package name */
        public int f73458a;

        /* renamed from: b, reason: collision with root package name */
        public int f73459b;

        /* renamed from: c, reason: collision with root package name */
        public int f73460c;

        public PerfFrameMetrics(int i3, int i4, int i5) {
            this.f73458a = i3;
            this.f73459b = i4;
            this.f73460c = i5;
        }

        public PerfFrameMetrics a(PerfFrameMetrics perfFrameMetrics) {
            return new PerfFrameMetrics(this.f73458a - perfFrameMetrics.d(), this.f73459b - perfFrameMetrics.c(), this.f73460c - perfFrameMetrics.b());
        }

        public int b() {
            return this.f73460c;
        }

        public int c() {
            return this.f73459b;
        }

        public int d() {
            return this.f73458a;
        }
    }

    public static PerfFrameMetrics a(SparseIntArray[] sparseIntArrayArr) {
        int i3;
        int i4;
        SparseIntArray sparseIntArray;
        int i5 = 0;
        if (sparseIntArrayArr == null || (sparseIntArray = sparseIntArrayArr[0]) == null) {
            i3 = 0;
            i4 = 0;
        } else {
            int i6 = 0;
            i3 = 0;
            i4 = 0;
            while (i5 < sparseIntArray.size()) {
                int iKeyAt = sparseIntArray.keyAt(i5);
                int iValueAt = sparseIntArray.valueAt(i5);
                i6 += iValueAt;
                if (iKeyAt > 700) {
                    i4 += iValueAt;
                }
                if (iKeyAt > 16) {
                    i3 += iValueAt;
                }
                i5++;
            }
            i5 = i6;
        }
        return new PerfFrameMetrics(i5, i3, i4);
    }
}
