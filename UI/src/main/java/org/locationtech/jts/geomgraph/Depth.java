package org.locationtech.jts.geomgraph;

import androidx.compose.compiler.plugins.types.analysis.StabilityExternalClassNameMatchingKt;
import java.lang.reflect.Array;

/* loaded from: classes5.dex */
public class Depth {

    /* renamed from: a, reason: collision with root package name */
    public int[][] f163430a = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, 2, 3);

    public Depth() {
        for (int i3 = 0; i3 < 2; i3++) {
            for (int i4 = 0; i4 < 3; i4++) {
                this.f163430a[i3][i4] = -1;
            }
        }
    }

    public String toString() {
        return "A: " + this.f163430a[0][1] + StabilityExternalClassNameMatchingKt.STABILITY_GENERIC_SEPARATOR + this.f163430a[0][2] + " B: " + this.f163430a[1][1] + StabilityExternalClassNameMatchingKt.STABILITY_GENERIC_SEPARATOR + this.f163430a[1][2];
    }
}
