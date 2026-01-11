package org.apache.commons.compress.archivers.sevenz;

@Deprecated
/* loaded from: classes5.dex */
public class SevenZFileOptions {
    public static final SevenZFileOptions DEFAULT = new SevenZFileOptions(Integer.MAX_VALUE, false, false);

    /* renamed from: a, reason: collision with root package name */
    public final int f160127a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f160128b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f160129c;

    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        public int f160130a = Integer.MAX_VALUE;

        /* renamed from: b, reason: collision with root package name */
        public boolean f160131b = false;

        /* renamed from: c, reason: collision with root package name */
        public boolean f160132c = false;
    }

    public SevenZFileOptions(int i3, boolean z2, boolean z3) {
        this.f160127a = i3;
        this.f160128b = z2;
        this.f160129c = z3;
    }
}
