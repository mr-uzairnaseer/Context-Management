package com.google.common.util.concurrent;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes5.dex */
public class AtomicDouble extends Number {

    /* renamed from: a, reason: collision with root package name */
    public transient AtomicLong f70177a;

    public AtomicDouble(double d3) {
        this.f70177a = new AtomicLong(Double.doubleToRawLongBits(d3));
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.f70177a = new AtomicLong();
        b(objectInputStream.readDouble());
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeDouble(a());
    }

    public final double a() {
        return Double.longBitsToDouble(this.f70177a.get());
    }

    public final void b(double d3) {
        this.f70177a.set(Double.doubleToRawLongBits(d3));
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return a();
    }

    @Override // java.lang.Number
    public float floatValue() {
        return (float) a();
    }

    @Override // java.lang.Number
    public int intValue() {
        return (int) a();
    }

    @Override // java.lang.Number
    public long longValue() {
        return (long) a();
    }

    public String toString() {
        return Double.toString(a());
    }

    public AtomicDouble() {
        this(0.0d);
    }
}
