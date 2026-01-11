package org.locationtech.jts.algorithm.construct;

/* loaded from: classes5.dex */
public class LargestEmptyCircle {

    public static class Cell implements Comparable<Cell> {

        /* renamed from: a, reason: collision with root package name */
        public double f163286a;

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(Cell cell) {
            return -Double.compare(this.f163286a, cell.f163286a);
        }
    }
}
