package org.apache.commons.compress.utils;

import java.util.Collections;
import java.util.HashSet;

/* loaded from: classes5.dex */
public class Sets {
    private Sets() {
    }

    public static HashSet a(Object... objArr) {
        HashSet hashSet = new HashSet(objArr != null ? objArr.length : 0);
        if (objArr != null) {
            Collections.addAll(hashSet, objArr);
        }
        return hashSet;
    }
}
