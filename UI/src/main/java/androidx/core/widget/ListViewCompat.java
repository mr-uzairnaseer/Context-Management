package androidx.core.widget;

import android.widget.ListView;

@Deprecated
/* loaded from: classes3.dex */
public final class ListViewCompat {
    private ListViewCompat() {
    }

    public static boolean a(ListView listView, int i3) {
        return listView.canScrollList(i3);
    }
}
