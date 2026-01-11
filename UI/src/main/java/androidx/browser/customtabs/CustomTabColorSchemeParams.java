package androidx.browser.customtabs;

import android.os.Bundle;

/* loaded from: classes2.dex */
public final class CustomTabColorSchemeParams {

    /* renamed from: a, reason: collision with root package name */
    public final Integer f4034a;

    /* renamed from: b, reason: collision with root package name */
    public final Integer f4035b;

    /* renamed from: c, reason: collision with root package name */
    public final Integer f4036c;

    /* renamed from: d, reason: collision with root package name */
    public final Integer f4037d;

    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        public Integer f4038a;

        /* renamed from: b, reason: collision with root package name */
        public Integer f4039b;

        /* renamed from: c, reason: collision with root package name */
        public Integer f4040c;

        /* renamed from: d, reason: collision with root package name */
        public Integer f4041d;

        public CustomTabColorSchemeParams a() {
            return new CustomTabColorSchemeParams(this.f4038a, this.f4039b, this.f4040c, this.f4041d);
        }
    }

    public CustomTabColorSchemeParams(Integer num, Integer num2, Integer num3, Integer num4) {
        this.f4034a = num;
        this.f4035b = num2;
        this.f4036c = num3;
        this.f4037d = num4;
    }

    public Bundle a() {
        Bundle bundle = new Bundle();
        Integer num = this.f4034a;
        if (num != null) {
            bundle.putInt(CustomTabsIntent.EXTRA_TOOLBAR_COLOR, num.intValue());
        }
        Integer num2 = this.f4035b;
        if (num2 != null) {
            bundle.putInt(CustomTabsIntent.EXTRA_SECONDARY_TOOLBAR_COLOR, num2.intValue());
        }
        Integer num3 = this.f4036c;
        if (num3 != null) {
            bundle.putInt(CustomTabsIntent.EXTRA_NAVIGATION_BAR_COLOR, num3.intValue());
        }
        Integer num4 = this.f4037d;
        if (num4 != null) {
            bundle.putInt(CustomTabsIntent.EXTRA_NAVIGATION_BAR_DIVIDER_COLOR, num4.intValue());
        }
        return bundle;
    }
}
