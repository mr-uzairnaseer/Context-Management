package androidx.constraintlayout.core.dsl;

import androidx.compose.compiler.plugins.types.analysis.StabilityExternalClassNameMatchingKt;

/* loaded from: classes3.dex */
public class Ref {

    /* renamed from: a, reason: collision with root package name */
    public String f31130a;

    /* renamed from: b, reason: collision with root package name */
    public float f31131b;

    /* renamed from: c, reason: collision with root package name */
    public float f31132c;

    /* renamed from: d, reason: collision with root package name */
    public float f31133d;

    public String toString() {
        String str = this.f31130a;
        if (str == null || str.length() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        boolean z2 = (Float.isNaN(this.f31131b) && Float.isNaN(this.f31132c) && Float.isNaN(this.f31133d)) ? false : true;
        if (z2) {
            sb.append("[");
        }
        sb.append("'");
        sb.append(this.f31130a);
        sb.append("'");
        if (!Float.isNaN(this.f31133d)) {
            sb.append(StabilityExternalClassNameMatchingKt.STABILITY_GENERIC_SEPARATOR);
            sb.append(!Float.isNaN(this.f31131b) ? this.f31131b : 0.0f);
            sb.append(StabilityExternalClassNameMatchingKt.STABILITY_GENERIC_SEPARATOR);
            sb.append(Float.isNaN(this.f31132c) ? 0.0f : this.f31132c);
            sb.append(StabilityExternalClassNameMatchingKt.STABILITY_GENERIC_SEPARATOR);
            sb.append(this.f31133d);
        } else if (!Float.isNaN(this.f31132c)) {
            sb.append(StabilityExternalClassNameMatchingKt.STABILITY_GENERIC_SEPARATOR);
            sb.append(Float.isNaN(this.f31131b) ? 0.0f : this.f31131b);
            sb.append(StabilityExternalClassNameMatchingKt.STABILITY_GENERIC_SEPARATOR);
            sb.append(this.f31132c);
        } else if (!Float.isNaN(this.f31131b)) {
            sb.append(StabilityExternalClassNameMatchingKt.STABILITY_GENERIC_SEPARATOR);
            sb.append(this.f31131b);
        }
        if (z2) {
            sb.append("]");
        }
        sb.append(StabilityExternalClassNameMatchingKt.STABILITY_GENERIC_SEPARATOR);
        return sb.toString();
    }
}
