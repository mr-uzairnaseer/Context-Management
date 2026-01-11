package freemarker.core;

import java.util.Enumeration;
import java.util.NoSuchElementException;

/* loaded from: classes8.dex */
public class _ArrayEnumeration implements Enumeration {

    /* renamed from: a, reason: collision with root package name */
    public final Object[] f149800a;

    /* renamed from: b, reason: collision with root package name */
    public final int f149801b;

    /* renamed from: c, reason: collision with root package name */
    public int f149802c = 0;

    public _ArrayEnumeration(Object[] objArr, int i3) {
        this.f149800a = objArr;
        this.f149801b = i3;
    }

    @Override // java.util.Enumeration
    public boolean hasMoreElements() {
        return this.f149802c < this.f149801b;
    }

    @Override // java.util.Enumeration
    public Object nextElement() {
        int i3 = this.f149802c;
        if (i3 >= this.f149801b) {
            throw new NoSuchElementException();
        }
        Object[] objArr = this.f149800a;
        this.f149802c = i3 + 1;
        return objArr[i3];
    }
}
