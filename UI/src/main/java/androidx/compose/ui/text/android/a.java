package androidx.compose.ui.text.android;

import android.text.GraphemeClusterSegmentFinder;
import android.text.TextPaint;

/* loaded from: classes3.dex */
public abstract /* synthetic */ class a {
    public static /* synthetic */ GraphemeClusterSegmentFinder a(CharSequence charSequence, TextPaint textPaint) {
        return new GraphemeClusterSegmentFinder(charSequence, textPaint);
    }
}
