package ai.onnxruntime.providers;

import java.util.EnumSet;
import java.util.Iterator;

/* loaded from: classes2.dex */
public interface OrtFlags {
    static <E extends Enum<E> & OrtFlags> int aggregateToInt(EnumSet<E> enumSet) {
        Iterator<E> it = enumSet.iterator();
        int value = 0;
        while (it.hasNext()) {
            value |= it.next().getValue();
        }
        return value;
    }

    int getValue();
}
