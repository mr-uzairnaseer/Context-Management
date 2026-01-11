package androidx.core.view;

import android.view.ViewGroup;

@Deprecated
/* loaded from: classes3.dex */
public final class MarginLayoutParamsCompat {
    private MarginLayoutParamsCompat() {
    }

    public static int a(ViewGroup.MarginLayoutParams marginLayoutParams) {
        return marginLayoutParams.getMarginEnd();
    }

    public static int b(ViewGroup.MarginLayoutParams marginLayoutParams) {
        return marginLayoutParams.getMarginStart();
    }

    public static void c(ViewGroup.MarginLayoutParams marginLayoutParams, int i3) {
        marginLayoutParams.resolveLayoutDirection(i3);
    }

    public static void d(ViewGroup.MarginLayoutParams marginLayoutParams, int i3) {
        marginLayoutParams.setMarginEnd(i3);
    }

    public static void e(ViewGroup.MarginLayoutParams marginLayoutParams, int i3) {
        marginLayoutParams.setMarginStart(i3);
    }
}
