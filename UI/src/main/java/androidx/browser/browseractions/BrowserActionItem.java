package androidx.browser.browseractions;

import android.app.PendingIntent;
import android.net.Uri;

@Deprecated
/* loaded from: classes2.dex */
public class BrowserActionItem {

    /* renamed from: a, reason: collision with root package name */
    public final String f3993a;

    /* renamed from: b, reason: collision with root package name */
    public final PendingIntent f3994b;

    /* renamed from: c, reason: collision with root package name */
    public int f3995c;

    /* renamed from: d, reason: collision with root package name */
    public Uri f3996d;

    /* renamed from: e, reason: collision with root package name */
    public Runnable f3997e;

    public PendingIntent a() {
        PendingIntent pendingIntent = this.f3994b;
        if (pendingIntent != null) {
            return pendingIntent;
        }
        throw new IllegalStateException("Can't call getAction on BrowserActionItem with null action.");
    }

    public int b() {
        return this.f3995c;
    }

    public Uri c() {
        return this.f3996d;
    }

    public Runnable d() {
        return this.f3997e;
    }

    public String e() {
        return this.f3993a;
    }
}
