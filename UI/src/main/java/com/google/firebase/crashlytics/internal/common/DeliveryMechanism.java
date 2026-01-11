package com.google.firebase.crashlytics.internal.common;

/* loaded from: classes.dex */
public enum DeliveryMechanism {
    DEVELOPER(1),
    USER_SIDELOAD(2),
    TEST_DISTRIBUTION(3),
    APP_STORE(4);

    private final int id;

    DeliveryMechanism(int i3) {
        this.id = i3;
    }

    public static DeliveryMechanism c(String str) {
        return str != null ? APP_STORE : DEVELOPER;
    }

    public int d() {
        return this.id;
    }

    @Override // java.lang.Enum
    public String toString() {
        return Integer.toString(this.id);
    }
}
