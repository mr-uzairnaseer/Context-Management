package androidx.media3.common;

import android.view.View;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* loaded from: classes3.dex */
public final class AdOverlayInfo {
    public static final int PURPOSE_CLOSE_AD = 2;
    public static final int PURPOSE_CONTROLS = 1;
    public static final int PURPOSE_NOT_VISIBLE = 4;
    public static final int PURPOSE_OTHER = 3;

    /* renamed from: a, reason: collision with root package name */
    public final View f36916a;

    /* renamed from: b, reason: collision with root package name */
    public final int f36917b;

    /* renamed from: c, reason: collision with root package name */
    public final String f36918c;

    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        public final View f36919a;

        /* renamed from: b, reason: collision with root package name */
        public final int f36920b;

        /* renamed from: c, reason: collision with root package name */
        public String f36921c;

        public Builder(View view, int i3) {
            this.f36919a = view;
            this.f36920b = i3;
        }

        public AdOverlayInfo a() {
            return new AdOverlayInfo(this.f36919a, this.f36920b, this.f36921c);
        }

        public Builder b(String str) {
            this.f36921c = str;
            return this;
        }
    }

    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Purpose {
    }

    public AdOverlayInfo(View view, int i3, String str) {
        this.f36916a = view;
        this.f36917b = i3;
        this.f36918c = str;
    }
}
