package com.squareup.picasso;

import java.io.PrintWriter;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes5.dex */
public class StatsSnapshot {

    /* renamed from: a, reason: collision with root package name */
    public final int f75871a;

    /* renamed from: b, reason: collision with root package name */
    public final int f75872b;

    /* renamed from: c, reason: collision with root package name */
    public final long f75873c;

    /* renamed from: d, reason: collision with root package name */
    public final long f75874d;

    /* renamed from: e, reason: collision with root package name */
    public final long f75875e;

    /* renamed from: f, reason: collision with root package name */
    public final long f75876f;

    /* renamed from: g, reason: collision with root package name */
    public final long f75877g;

    /* renamed from: h, reason: collision with root package name */
    public final long f75878h;

    /* renamed from: i, reason: collision with root package name */
    public final long f75879i;

    /* renamed from: j, reason: collision with root package name */
    public final long f75880j;

    /* renamed from: k, reason: collision with root package name */
    public final int f75881k;

    /* renamed from: l, reason: collision with root package name */
    public final int f75882l;

    /* renamed from: m, reason: collision with root package name */
    public final int f75883m;

    /* renamed from: n, reason: collision with root package name */
    public final long f75884n;

    public StatsSnapshot(int i3, int i4, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, int i5, int i6, int i7, long j11) {
        this.f75871a = i3;
        this.f75872b = i4;
        this.f75873c = j3;
        this.f75874d = j4;
        this.f75875e = j5;
        this.f75876f = j6;
        this.f75877g = j7;
        this.f75878h = j8;
        this.f75879i = j9;
        this.f75880j = j10;
        this.f75881k = i5;
        this.f75882l = i6;
        this.f75883m = i7;
        this.f75884n = j11;
    }

    public void a(PrintWriter printWriter) {
        printWriter.println("===============BEGIN PICASSO STATS ===============");
        printWriter.println("Memory Cache Stats");
        printWriter.print("  Max Cache Size: ");
        printWriter.println(this.f75871a);
        printWriter.print("  Cache Size: ");
        printWriter.println(this.f75872b);
        printWriter.print("  Cache % Full: ");
        printWriter.println((int) Math.ceil((this.f75872b / this.f75871a) * 100.0f));
        printWriter.print("  Cache Hits: ");
        printWriter.println(this.f75873c);
        printWriter.print("  Cache Misses: ");
        printWriter.println(this.f75874d);
        printWriter.println("Network Stats");
        printWriter.print("  Download Count: ");
        printWriter.println(this.f75881k);
        printWriter.print("  Total Download Size: ");
        printWriter.println(this.f75875e);
        printWriter.print("  Average Download Size: ");
        printWriter.println(this.f75878h);
        printWriter.println("Bitmap Stats");
        printWriter.print("  Total Bitmaps Decoded: ");
        printWriter.println(this.f75882l);
        printWriter.print("  Total Bitmap Size: ");
        printWriter.println(this.f75876f);
        printWriter.print("  Total Transformed Bitmaps: ");
        printWriter.println(this.f75883m);
        printWriter.print("  Total Transformed Bitmap Size: ");
        printWriter.println(this.f75877g);
        printWriter.print("  Average Bitmap Size: ");
        printWriter.println(this.f75879i);
        printWriter.print("  Average Transformed Bitmap Size: ");
        printWriter.println(this.f75880j);
        printWriter.println("===============END PICASSO STATS ===============");
        printWriter.flush();
    }

    public String toString() {
        return "StatsSnapshot{maxSize=" + this.f75871a + ", size=" + this.f75872b + ", cacheHits=" + this.f75873c + ", cacheMisses=" + this.f75874d + ", downloadCount=" + this.f75881k + ", totalDownloadSize=" + this.f75875e + ", averageDownloadSize=" + this.f75878h + ", totalOriginalBitmapSize=" + this.f75876f + ", totalTransformedBitmapSize=" + this.f75877g + ", averageOriginalBitmapSize=" + this.f75879i + ", averageTransformedBitmapSize=" + this.f75880j + ", originalBitmapCount=" + this.f75882l + ", transformedBitmapCount=" + this.f75883m + ", timeStamp=" + this.f75884n + AbstractJsonLexerKt.END_OBJ;
    }
}
