package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import androidx.compose.compiler.plugins.types.analysis.StabilityExternalClassNameMatchingKt;
import com.google.android.gms.wearable.PutDataRequest;

/* loaded from: classes4.dex */
public final class zzie {
    public static IntentFilter a(String str) {
        IntentFilter intentFilter = new IntentFilter(str);
        intentFilter.addDataScheme(PutDataRequest.WEAR_URI_SCHEME);
        intentFilter.addDataAuthority(StabilityExternalClassNameMatchingKt.STABILITY_GENERIC_INCLUDE, null);
        return intentFilter;
    }
}
