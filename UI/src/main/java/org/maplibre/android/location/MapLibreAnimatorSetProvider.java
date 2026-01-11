package org.maplibre.android.location;

import android.animation.AnimatorSet;
import android.view.animation.Interpolator;
import java.util.List;

/* loaded from: classes9.dex */
class MapLibreAnimatorSetProvider {

    /* renamed from: a, reason: collision with root package name */
    public static MapLibreAnimatorSetProvider f164752a;

    private MapLibreAnimatorSetProvider() {
    }

    public static MapLibreAnimatorSetProvider a() {
        if (f164752a == null) {
            f164752a = new MapLibreAnimatorSetProvider();
        }
        return f164752a;
    }

    public void b(List list, Interpolator interpolator, long j3) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(list);
        animatorSet.setInterpolator(interpolator);
        animatorSet.setDuration(j3);
        animatorSet.start();
    }
}
