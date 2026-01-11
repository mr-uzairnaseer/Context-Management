package org.apache.commons.compress.archivers.dump;

/* loaded from: classes5.dex */
final class Dirent {

    /* renamed from: a, reason: collision with root package name */
    public final int f159969a;

    /* renamed from: b, reason: collision with root package name */
    public final int f159970b;

    /* renamed from: c, reason: collision with root package name */
    public final int f159971c;

    /* renamed from: d, reason: collision with root package name */
    public final String f159972d;

    public Dirent(int i3, int i4, int i5, String str) {
        this.f159969a = i3;
        this.f159970b = i4;
        this.f159971c = i5;
        this.f159972d = str;
    }

    public int a() {
        return this.f159969a;
    }

    public String b() {
        return this.f159972d;
    }

    public int c() {
        return this.f159970b;
    }

    public String toString() {
        return String.format("[%d]: %s", Integer.valueOf(this.f159969a), this.f159972d);
    }
}
