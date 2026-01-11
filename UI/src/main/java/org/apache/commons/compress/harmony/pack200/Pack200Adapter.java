package org.apache.commons.compress.harmony.pack200;

import java.beans.PropertyChangeSupport;
import java.util.SortedMap;
import java.util.TreeMap;
import org.apache.commons.compress.java.util.jar.Pack200;

/* loaded from: classes5.dex */
public abstract class Pack200Adapter {

    /* renamed from: a, reason: collision with root package name */
    public final PropertyChangeSupport f161102a = new PropertyChangeSupport(this);

    /* renamed from: b, reason: collision with root package name */
    public final SortedMap f161103b = new TreeMap();

    public SortedMap a() {
        return this.f161103b;
    }

    public void c(double d3) {
        d(Pack200.Packer.PROGRESS, null, String.valueOf((int) (d3 * 100.0d)));
    }

    public void d(String str, Object obj, Object obj2) {
        this.f161102a.firePropertyChange(str, obj, obj2);
    }
}
