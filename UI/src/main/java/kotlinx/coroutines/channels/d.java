package kotlinx.coroutines.channels;

import java.util.concurrent.atomic.AtomicReferenceArray;

/* loaded from: classes2.dex */
public abstract /* synthetic */ class d {
    public static /* synthetic */ boolean a(AtomicReferenceArray atomicReferenceArray, int i3, Object obj, Object obj2) {
        while (!atomicReferenceArray.compareAndSet(i3, obj, obj2)) {
            if (atomicReferenceArray.get(i3) != obj) {
                return false;
            }
        }
        return true;
    }
}
