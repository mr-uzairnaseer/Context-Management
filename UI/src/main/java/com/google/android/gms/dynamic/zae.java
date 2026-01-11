package com.google.android.gms.dynamic;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;

/* loaded from: classes4.dex */
final class zae implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f60827a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Intent f60828b;

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            this.f60827a.startActivity(this.f60828b);
        } catch (ActivityNotFoundException e3) {
            Log.e("DeferredLifecycleHelper", "Failed to start resolution intent", e3);
        }
    }
}
