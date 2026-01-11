package kotlin.reflect.jvm.internal.impl.utils;

import androidx.media3.exoplayer.upstream.CmcdData;
import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;

/* loaded from: classes2.dex */
public class SmartList<E> extends AbstractList<E> implements RandomAccess {

    /* renamed from: a, reason: collision with root package name */
    public int f155530a;

    /* renamed from: b, reason: collision with root package name */
    public Object f155531b;

    /* loaded from: classes8.dex */
    public static class EmptyIterator<T> implements Iterator<T> {

        /* renamed from: a, reason: collision with root package name */
        public static final EmptyIterator f155532a = new EmptyIterator();

        private EmptyIterator() {
        }

        public static EmptyIterator a() {
            return f155532a;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return false;
        }

        @Override // java.util.Iterator
        public Object next() {
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new IllegalStateException();
        }
    }

    /* loaded from: classes8.dex */
    public class SingletonIterator extends SingletonIteratorBase<E> {

        /* renamed from: b, reason: collision with root package name */
        public final int f155533b;

        public SingletonIterator() {
            super();
            this.f155533b = ((AbstractList) SmartList.this).modCount;
        }

        @Override // kotlin.reflect.jvm.internal.impl.utils.SmartList.SingletonIteratorBase
        public void a() {
            if (((AbstractList) SmartList.this).modCount == this.f155533b) {
                return;
            }
            throw new ConcurrentModificationException("ModCount: " + ((AbstractList) SmartList.this).modCount + "; expected: " + this.f155533b);
        }

        @Override // kotlin.reflect.jvm.internal.impl.utils.SmartList.SingletonIteratorBase
        public Object b() {
            return SmartList.this.f155531b;
        }

        @Override // java.util.Iterator
        public void remove() {
            a();
            SmartList.this.clear();
        }
    }

    /* loaded from: classes8.dex */
    public static abstract class SingletonIteratorBase<T> implements Iterator<T> {

        /* renamed from: a, reason: collision with root package name */
        public boolean f155535a;

        private SingletonIteratorBase() {
        }

        public abstract void a();

        public abstract Object b();

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return !this.f155535a;
        }

        @Override // java.util.Iterator
        public final Object next() {
            if (this.f155535a) {
                throw new NoSuchElementException();
            }
            this.f155535a = true;
            a();
            return b();
        }
    }

    public static /* synthetic */ void b(int i3) {
        String str = (i3 == 2 || i3 == 3 || i3 == 5 || i3 == 6 || i3 == 7) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i3 == 2 || i3 == 3 || i3 == 5 || i3 == 6 || i3 == 7) ? 2 : 3];
        switch (i3) {
            case 2:
            case 3:
            case 5:
            case 6:
            case 7:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/utils/SmartList";
                break;
            case 4:
                objArr[0] = CmcdData.Factory.OBJECT_TYPE_AUDIO_ONLY;
                break;
            default:
                objArr[0] = "elements";
                break;
        }
        if (i3 == 2 || i3 == 3) {
            objArr[1] = "iterator";
        } else if (i3 == 5 || i3 == 6 || i3 == 7) {
            objArr[1] = "toArray";
        } else {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/utils/SmartList";
        }
        switch (i3) {
            case 2:
            case 3:
            case 5:
            case 6:
            case 7:
                break;
            case 4:
                objArr[2] = "toArray";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i3 != 2 && i3 != 3 && i3 != 5 && i3 != 6 && i3 != 7) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(Object obj) {
        int i3 = this.f155530a;
        if (i3 == 0) {
            this.f155531b = obj;
        } else if (i3 == 1) {
            this.f155531b = new Object[]{this.f155531b, obj};
        } else {
            Object[] objArr = (Object[]) this.f155531b;
            int length = objArr.length;
            if (i3 >= length) {
                int i4 = ((length * 3) / 2) + 1;
                int i5 = i3 + 1;
                if (i4 < i5) {
                    i4 = i5;
                }
                Object[] objArr2 = new Object[i4];
                this.f155531b = objArr2;
                System.arraycopy(objArr, 0, objArr2, 0, length);
                objArr = objArr2;
            }
            objArr[this.f155530a] = obj;
        }
        this.f155530a++;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        this.f155531b = null;
        this.f155530a = 0;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public Object get(int i3) {
        int i4;
        if (i3 >= 0 && i3 < (i4 = this.f155530a)) {
            return i4 == 1 ? this.f155531b : ((Object[]) this.f155531b)[i3];
        }
        throw new IndexOutOfBoundsException("Index: " + i3 + ", Size: " + this.f155530a);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator iterator() {
        int i3 = this.f155530a;
        if (i3 == 0) {
            EmptyIterator emptyIteratorA = EmptyIterator.a();
            if (emptyIteratorA == null) {
                b(2);
            }
            return emptyIteratorA;
        }
        if (i3 == 1) {
            return new SingletonIterator();
        }
        Iterator<E> it = super.iterator();
        if (it == null) {
            b(3);
        }
        return it;
    }

    @Override // java.util.AbstractList, java.util.List
    public Object remove(int i3) {
        int i4;
        Object obj;
        if (i3 < 0 || i3 >= (i4 = this.f155530a)) {
            throw new IndexOutOfBoundsException("Index: " + i3 + ", Size: " + this.f155530a);
        }
        if (i4 == 1) {
            obj = this.f155531b;
            this.f155531b = null;
        } else {
            Object[] objArr = (Object[]) this.f155531b;
            Object obj2 = objArr[i3];
            if (i4 == 2) {
                this.f155531b = objArr[1 - i3];
            } else {
                int i5 = (i4 - i3) - 1;
                if (i5 > 0) {
                    System.arraycopy(objArr, i3 + 1, objArr, i3, i5);
                }
                objArr[this.f155530a - 1] = null;
            }
            obj = obj2;
        }
        this.f155530a--;
        ((AbstractList) this).modCount++;
        return obj;
    }

    @Override // java.util.AbstractList, java.util.List
    public Object set(int i3, Object obj) {
        int i4;
        if (i3 < 0 || i3 >= (i4 = this.f155530a)) {
            throw new IndexOutOfBoundsException("Index: " + i3 + ", Size: " + this.f155530a);
        }
        if (i4 == 1) {
            Object obj2 = this.f155531b;
            this.f155531b = obj;
            return obj2;
        }
        Object[] objArr = (Object[]) this.f155531b;
        Object obj3 = objArr[i3];
        objArr[i3] = obj;
        return obj3;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f155530a;
    }

    @Override // java.util.List
    public void sort(Comparator comparator) {
        int i3 = this.f155530a;
        if (i3 >= 2) {
            Arrays.sort((Object[]) this.f155531b, 0, i3, comparator);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray(Object[] objArr) {
        if (objArr == null) {
            b(4);
        }
        int length = objArr.length;
        int i3 = this.f155530a;
        if (i3 == 1) {
            if (length == 0) {
                Object[] objArr2 = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), 1);
                objArr2[0] = this.f155531b;
                return objArr2;
            }
            objArr[0] = this.f155531b;
        } else {
            if (length < i3) {
                Object[] objArrCopyOf = Arrays.copyOf((Object[]) this.f155531b, i3, objArr.getClass());
                if (objArrCopyOf == null) {
                    b(6);
                }
                return objArrCopyOf;
            }
            if (i3 != 0) {
                System.arraycopy(this.f155531b, 0, objArr, 0, i3);
            }
        }
        int i4 = this.f155530a;
        if (length > i4) {
            objArr[i4] = null;
        }
        return objArr;
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i3, Object obj) {
        int i4;
        if (i3 >= 0 && i3 <= (i4 = this.f155530a)) {
            if (i4 == 0) {
                this.f155531b = obj;
            } else if (i4 == 1 && i3 == 0) {
                this.f155531b = new Object[]{obj, this.f155531b};
            } else {
                Object[] objArr = new Object[i4 + 1];
                if (i4 == 1) {
                    objArr[0] = this.f155531b;
                } else {
                    Object[] objArr2 = (Object[]) this.f155531b;
                    System.arraycopy(objArr2, 0, objArr, 0, i3);
                    System.arraycopy(objArr2, i3, objArr, i3 + 1, this.f155530a - i3);
                }
                objArr[i3] = obj;
                this.f155531b = objArr;
            }
            this.f155530a++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("Index: " + i3 + ", Size: " + this.f155530a);
    }
}
