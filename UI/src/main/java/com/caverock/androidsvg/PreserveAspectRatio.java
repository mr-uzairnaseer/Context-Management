package com.caverock.androidsvg;

/* loaded from: classes4.dex */
public class PreserveAspectRatio {
    public static final PreserveAspectRatio BOTTOM;
    public static final PreserveAspectRatio END;
    public static final PreserveAspectRatio FULLSCREEN;
    public static final PreserveAspectRatio FULLSCREEN_START;
    public static final PreserveAspectRatio LETTERBOX;
    public static final PreserveAspectRatio START;
    public static final PreserveAspectRatio TOP;

    /* renamed from: a, reason: collision with root package name */
    public Alignment f57041a;

    /* renamed from: b, reason: collision with root package name */
    public Scale f57042b;
    public static final PreserveAspectRatio UNSCALED = new PreserveAspectRatio(null, null);
    public static final PreserveAspectRatio STRETCH = new PreserveAspectRatio(Alignment.none, null);

    public enum Alignment {
        none,
        xMinYMin,
        xMidYMin,
        xMaxYMin,
        xMinYMid,
        xMidYMid,
        xMaxYMid,
        xMinYMax,
        xMidYMax,
        xMaxYMax
    }

    public enum Scale {
        meet,
        slice
    }

    static {
        Alignment alignment = Alignment.xMidYMid;
        Scale scale = Scale.meet;
        LETTERBOX = new PreserveAspectRatio(alignment, scale);
        Alignment alignment2 = Alignment.xMinYMin;
        START = new PreserveAspectRatio(alignment2, scale);
        END = new PreserveAspectRatio(Alignment.xMaxYMax, scale);
        TOP = new PreserveAspectRatio(Alignment.xMidYMin, scale);
        BOTTOM = new PreserveAspectRatio(Alignment.xMidYMax, scale);
        Scale scale2 = Scale.slice;
        FULLSCREEN = new PreserveAspectRatio(alignment, scale2);
        FULLSCREEN_START = new PreserveAspectRatio(alignment2, scale2);
    }

    public PreserveAspectRatio(Alignment alignment, Scale scale) {
        this.f57041a = alignment;
        this.f57042b = scale;
    }

    public Alignment a() {
        return this.f57041a;
    }

    public Scale b() {
        return this.f57042b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PreserveAspectRatio preserveAspectRatio = (PreserveAspectRatio) obj;
        return this.f57041a == preserveAspectRatio.f57041a && this.f57042b == preserveAspectRatio.f57042b;
    }

    public String toString() {
        return this.f57041a + " " + this.f57042b;
    }
}
