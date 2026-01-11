package org.locationtech.jts.simplify;

/* loaded from: classes7.dex */
class RingHull {

    public static class Corner implements Comparable<Corner> {

        /* renamed from: a, reason: collision with root package name */
        public double f164259a;

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(Corner corner) {
            return Double.compare(this.f164259a, corner.f164259a);
        }
    }
}
