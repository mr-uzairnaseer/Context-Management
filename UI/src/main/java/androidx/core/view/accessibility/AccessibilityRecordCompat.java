package androidx.core.view.accessibility;

import android.view.View;
import android.view.accessibility.AccessibilityRecord;

/* loaded from: classes3.dex */
public class AccessibilityRecordCompat {

    /* renamed from: a, reason: collision with root package name */
    public final AccessibilityRecord f33884a;

    public static void a(AccessibilityRecord accessibilityRecord, int i3) {
        accessibilityRecord.setMaxScrollX(i3);
    }

    public static void b(AccessibilityRecord accessibilityRecord, int i3) {
        accessibilityRecord.setMaxScrollY(i3);
    }

    public static void c(AccessibilityRecord accessibilityRecord, View view, int i3) {
        accessibilityRecord.setSource(view, i3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AccessibilityRecordCompat)) {
            return false;
        }
        AccessibilityRecordCompat accessibilityRecordCompat = (AccessibilityRecordCompat) obj;
        AccessibilityRecord accessibilityRecord = this.f33884a;
        return accessibilityRecord == null ? accessibilityRecordCompat.f33884a == null : accessibilityRecord.equals(accessibilityRecordCompat.f33884a);
    }

    public int hashCode() {
        AccessibilityRecord accessibilityRecord = this.f33884a;
        if (accessibilityRecord == null) {
            return 0;
        }
        return accessibilityRecord.hashCode();
    }
}
