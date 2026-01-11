package com.google.android.gms.location;

/* loaded from: classes4.dex */
public interface Geofence {
    public static final int GEOFENCE_TRANSITION_DWELL = 4;
    public static final int GEOFENCE_TRANSITION_ENTER = 1;
    public static final int GEOFENCE_TRANSITION_EXIT = 2;
    public static final long NEVER_EXPIRE = -1;

    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        public String f63028a = null;

        /* renamed from: b, reason: collision with root package name */
        public int f63029b = 3;

        /* renamed from: c, reason: collision with root package name */
        public long f63030c = -1;

        /* renamed from: d, reason: collision with root package name */
        public short f63031d = -1;

        /* renamed from: e, reason: collision with root package name */
        public int f63032e = 0;

        /* renamed from: f, reason: collision with root package name */
        public int f63033f = -1;
    }

    public @interface GeofenceTransition {
    }

    public @interface TransitionTypes {
    }
}
