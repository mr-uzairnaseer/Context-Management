package androidx.constraintlayout.widget;

import android.util.SparseIntArray;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class SharedValues {
    public static final int UNSET = -1;

    /* renamed from: a, reason: collision with root package name */
    public SparseIntArray f32834a = new SparseIntArray();

    /* renamed from: b, reason: collision with root package name */
    public HashMap f32835b = new HashMap();

    public interface SharedValuesListener {
    }

    public void a(int i3, SharedValuesListener sharedValuesListener) {
        HashSet hashSet = (HashSet) this.f32835b.get(Integer.valueOf(i3));
        if (hashSet == null) {
            hashSet = new HashSet();
            this.f32835b.put(Integer.valueOf(i3), hashSet);
        }
        hashSet.add(new WeakReference(sharedValuesListener));
    }

    public void b(int i3, SharedValuesListener sharedValuesListener) {
        HashSet hashSet = (HashSet) this.f32835b.get(Integer.valueOf(i3));
        if (hashSet == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            SharedValuesListener sharedValuesListener2 = (SharedValuesListener) weakReference.get();
            if (sharedValuesListener2 == null || sharedValuesListener2 == sharedValuesListener) {
                arrayList.add(weakReference);
            }
        }
        hashSet.removeAll(arrayList);
    }
}
