package androidx.constraintlayout.core.motion.utils;

import java.util.Arrays;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class KeyCache {

    /* renamed from: a, reason: collision with root package name */
    public HashMap f31372a = new HashMap();

    public float a(Object obj, String str, int i3) {
        HashMap map;
        float[] fArr;
        if (this.f31372a.containsKey(obj) && (map = (HashMap) this.f31372a.get(obj)) != null && map.containsKey(str) && (fArr = (float[]) map.get(str)) != null && fArr.length > i3) {
            return fArr[i3];
        }
        return Float.NaN;
    }

    public void b(Object obj, String str, int i3, float f3) {
        if (!this.f31372a.containsKey(obj)) {
            HashMap map = new HashMap();
            float[] fArr = new float[i3 + 1];
            fArr[i3] = f3;
            map.put(str, fArr);
            this.f31372a.put(obj, map);
            return;
        }
        HashMap map2 = (HashMap) this.f31372a.get(obj);
        if (map2 == null) {
            map2 = new HashMap();
        }
        if (!map2.containsKey(str)) {
            float[] fArr2 = new float[i3 + 1];
            fArr2[i3] = f3;
            map2.put(str, fArr2);
            this.f31372a.put(obj, map2);
            return;
        }
        float[] fArrCopyOf = (float[]) map2.get(str);
        if (fArrCopyOf == null) {
            fArrCopyOf = new float[0];
        }
        if (fArrCopyOf.length <= i3) {
            fArrCopyOf = Arrays.copyOf(fArrCopyOf, i3 + 1);
        }
        fArrCopyOf[i3] = f3;
        map2.put(str, fArrCopyOf);
    }
}
