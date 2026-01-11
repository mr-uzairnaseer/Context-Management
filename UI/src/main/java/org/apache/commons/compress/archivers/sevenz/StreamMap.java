package org.apache.commons.compress.archivers.sevenz;

/* loaded from: classes5.dex */
final class StreamMap {

    /* renamed from: a, reason: collision with root package name */
    public final int[] f160153a;

    /* renamed from: b, reason: collision with root package name */
    public final long[] f160154b;

    /* renamed from: c, reason: collision with root package name */
    public final int[] f160155c;

    /* renamed from: d, reason: collision with root package name */
    public final int[] f160156d;

    public StreamMap(int[] iArr, long[] jArr, int[] iArr2, int[] iArr3) {
        this.f160153a = iArr;
        this.f160154b = jArr;
        this.f160155c = iArr2;
        this.f160156d = iArr3;
    }

    public String toString() {
        return "StreamMap with indices of " + this.f160153a.length + " folders, offsets of " + this.f160154b.length + " packed streams, first files of " + this.f160155c.length + " folders and folder indices for " + this.f160156d.length + " files";
    }
}
