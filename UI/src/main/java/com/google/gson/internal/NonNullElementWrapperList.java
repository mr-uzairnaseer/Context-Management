package com.google.gson.internal;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
import java.util.RandomAccess;

/* loaded from: classes5.dex */
public class NonNullElementWrapperList<E> extends AbstractList<E> implements RandomAccess {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f74263a;

    public NonNullElementWrapperList(ArrayList arrayList) {
        Objects.requireNonNull(arrayList);
        this.f74263a = arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractList, java.util.List
    public void add(int i3, Object obj) {
        this.f74263a.add(i3, b(obj));
    }

    public final Object b(Object obj) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException("Element must be non-null");
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        this.f74263a.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        return this.f74263a.contains(obj);
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        return this.f74263a.equals(obj);
    }

    @Override // java.util.AbstractList, java.util.List
    public Object get(int i3) {
        return this.f74263a.get(i3);
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        return this.f74263a.hashCode();
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        return this.f74263a.indexOf(obj);
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(Object obj) {
        return this.f74263a.lastIndexOf(obj);
    }

    @Override // java.util.AbstractList, java.util.List
    public Object remove(int i3) {
        return this.f74263a.remove(i3);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(Collection collection) {
        return this.f74263a.removeAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(Collection collection) {
        return this.f74263a.retainAll(collection);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractList, java.util.List
    public Object set(int i3, Object obj) {
        return this.f74263a.set(i3, b(obj));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f74263a.size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray() {
        return this.f74263a.toArray();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        return this.f74263a.remove(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray(Object[] objArr) {
        return this.f74263a.toArray(objArr);
    }
}
