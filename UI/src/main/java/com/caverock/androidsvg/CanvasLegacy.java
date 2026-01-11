package com.caverock.androidsvg;

import android.graphics.Canvas;
import de.komoot.android.eventtracker.KmtEventTracking;
import de.komoot.android.services.api.JsonKeywords;
import java.lang.reflect.Method;

/* loaded from: classes4.dex */
class CanvasLegacy {

    /* renamed from: a, reason: collision with root package name */
    public static final int f57034a;

    /* renamed from: b, reason: collision with root package name */
    public static final Method f57035b;

    static {
        try {
            f57034a = ((Integer) Canvas.class.getField("MATRIX_SAVE_FLAG").get(null)).intValue();
            f57035b = Canvas.class.getMethod(KmtEventTracking.FEED_CARD_INTERACTION_ACTION_SAVE, Integer.TYPE);
        } catch (Throwable th) {
            throw a(th);
        }
    }

    public static RuntimeException a(Throwable th) {
        if (th != null) {
            return (RuntimeException) b(th);
        }
        throw new NullPointerException(JsonKeywords.T);
    }

    public static Throwable b(Throwable th) throws Throwable {
        throw th;
    }
}
