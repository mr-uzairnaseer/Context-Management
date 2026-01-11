package androidx.core.view;

import android.graphics.Rect;
import android.view.Gravity;

/* loaded from: classes3.dex */
public final class GravityCompat {
    public static final int END = 8388613;
    public static final int RELATIVE_HORIZONTAL_GRAVITY_MASK = 8388615;
    public static final int RELATIVE_LAYOUT_DIRECTION = 8388608;
    public static final int START = 8388611;

    private GravityCompat() {
    }

    public static void a(int i3, int i4, int i5, Rect rect, Rect rect2, int i6) {
        Gravity.apply(i3, i4, i5, rect, rect2, i6);
    }

    public static int b(int i3, int i4) {
        return Gravity.getAbsoluteGravity(i3, i4);
    }
}
