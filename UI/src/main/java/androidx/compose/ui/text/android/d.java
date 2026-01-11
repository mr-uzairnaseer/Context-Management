package androidx.compose.ui.text.android;

import android.text.BoringLayout;
import android.text.Layout;
import android.text.TextPaint;
import android.text.TextUtils;

/* loaded from: classes.dex */
public abstract /* synthetic */ class d {
    public static /* synthetic */ BoringLayout a(CharSequence charSequence, TextPaint textPaint, int i3, Layout.Alignment alignment, float f3, float f4, BoringLayout.Metrics metrics, boolean z2, TextUtils.TruncateAt truncateAt, int i4, boolean z3) {
        return new BoringLayout(charSequence, textPaint, i3, alignment, f3, f4, metrics, z2, truncateAt, i4, z3);
    }
}
