package androidx.constraintlayout.core;

/* loaded from: classes3.dex */
final class Pools {

    /* loaded from: classes.dex */
    public interface Pool<T> {
        Object a();

        boolean b(Object obj);

        void c(Object[] objArr, int i3);
    }

    /* loaded from: classes.dex */
    public static class SimplePool<T> implements Pool<T> {

        /* renamed from: a, reason: collision with root package name */
        public final Object[] f30961a;

        /* renamed from: b, reason: collision with root package name */
        public int f30962b;

        public SimplePool(int i3) {
            if (i3 <= 0) {
                throw new IllegalArgumentException("The max pool size must be > 0");
            }
            this.f30961a = new Object[i3];
        }

        @Override // androidx.constraintlayout.core.Pools.Pool
        public Object a() {
            int i3 = this.f30962b;
            if (i3 <= 0) {
                return null;
            }
            int i4 = i3 - 1;
            Object[] objArr = this.f30961a;
            Object obj = objArr[i4];
            objArr[i4] = null;
            this.f30962b = i3 - 1;
            return obj;
        }

        @Override // androidx.constraintlayout.core.Pools.Pool
        public boolean b(Object obj) {
            int i3 = this.f30962b;
            Object[] objArr = this.f30961a;
            if (i3 >= objArr.length) {
                return false;
            }
            objArr[i3] = obj;
            this.f30962b = i3 + 1;
            return true;
        }

        @Override // androidx.constraintlayout.core.Pools.Pool
        public void c(Object[] objArr, int i3) {
            if (i3 > objArr.length) {
                i3 = objArr.length;
            }
            for (int i4 = 0; i4 < i3; i4++) {
                Object obj = objArr[i4];
                int i5 = this.f30962b;
                Object[] objArr2 = this.f30961a;
                if (i5 < objArr2.length) {
                    objArr2[i5] = obj;
                    this.f30962b = i5 + 1;
                }
            }
        }
    }

    private Pools() {
    }
}
