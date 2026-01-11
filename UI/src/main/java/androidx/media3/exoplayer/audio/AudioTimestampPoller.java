package androidx.media3.exoplayer.audio;

import android.media.AudioTimestamp;
import android.media.AudioTrack;
import androidx.media3.common.C;

/* loaded from: classes3.dex */
final class AudioTimestampPoller {

    /* renamed from: a, reason: collision with root package name */
    public final AudioTimestampWrapper f40001a;

    /* renamed from: b, reason: collision with root package name */
    public int f40002b;

    /* renamed from: c, reason: collision with root package name */
    public long f40003c;

    /* renamed from: d, reason: collision with root package name */
    public long f40004d;

    /* renamed from: e, reason: collision with root package name */
    public long f40005e;

    /* renamed from: f, reason: collision with root package name */
    public long f40006f;

    public static final class AudioTimestampWrapper {

        /* renamed from: a, reason: collision with root package name */
        public final AudioTrack f40007a;

        /* renamed from: b, reason: collision with root package name */
        public final AudioTimestamp f40008b = new AudioTimestamp();

        /* renamed from: c, reason: collision with root package name */
        public long f40009c;

        /* renamed from: d, reason: collision with root package name */
        public long f40010d;

        /* renamed from: e, reason: collision with root package name */
        public long f40011e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f40012f;

        /* renamed from: g, reason: collision with root package name */
        public long f40013g;

        public AudioTimestampWrapper(AudioTrack audioTrack) {
            this.f40007a = audioTrack;
        }

        public void a() {
            this.f40012f = true;
        }

        public long b() {
            return this.f40011e;
        }

        public long c() {
            return this.f40008b.nanoTime / 1000;
        }

        public boolean d() {
            boolean timestamp = this.f40007a.getTimestamp(this.f40008b);
            if (timestamp) {
                long j3 = this.f40008b.framePosition;
                long j4 = this.f40010d;
                if (j4 > j3) {
                    if (this.f40012f) {
                        this.f40013g += j4;
                        this.f40012f = false;
                    } else {
                        this.f40009c++;
                    }
                }
                this.f40010d = j3;
                this.f40011e = j3 + this.f40013g + (this.f40009c << 32);
            }
            return timestamp;
        }
    }

    public AudioTimestampPoller(AudioTrack audioTrack) {
        this.f40001a = new AudioTimestampWrapper(audioTrack);
        h();
    }

    public void a() {
        if (this.f40002b == 4) {
            h();
        }
    }

    public void b() {
        AudioTimestampWrapper audioTimestampWrapper = this.f40001a;
        if (audioTimestampWrapper != null) {
            audioTimestampWrapper.a();
        }
    }

    public long c() {
        AudioTimestampWrapper audioTimestampWrapper = this.f40001a;
        if (audioTimestampWrapper != null) {
            return audioTimestampWrapper.b();
        }
        return -1L;
    }

    public long d() {
        AudioTimestampWrapper audioTimestampWrapper = this.f40001a;
        return audioTimestampWrapper != null ? audioTimestampWrapper.c() : C.TIME_UNSET;
    }

    public boolean e() {
        return this.f40002b == 2;
    }

    public boolean f(long j3) {
        AudioTimestampWrapper audioTimestampWrapper = this.f40001a;
        if (audioTimestampWrapper == null || j3 - this.f40005e < this.f40004d) {
            return false;
        }
        this.f40005e = j3;
        boolean zD = audioTimestampWrapper.d();
        int i3 = this.f40002b;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            throw new IllegalStateException();
                        }
                    } else if (zD) {
                        h();
                        return zD;
                    }
                } else if (!zD) {
                    h();
                    return zD;
                }
            } else {
                if (!zD) {
                    h();
                    return zD;
                }
                if (this.f40001a.b() > this.f40006f) {
                    i(2);
                    return zD;
                }
            }
        } else {
            if (zD) {
                if (this.f40001a.c() < this.f40003c) {
                    return false;
                }
                this.f40006f = this.f40001a.b();
                i(1);
                return zD;
            }
            if (j3 - this.f40003c > 500000) {
                i(3);
            }
        }
        return zD;
    }

    public void g() {
        i(4);
    }

    public void h() {
        if (this.f40001a != null) {
            i(0);
        }
    }

    public final void i(int i3) {
        this.f40002b = i3;
        if (i3 == 0) {
            this.f40005e = 0L;
            this.f40006f = -1L;
            this.f40003c = System.nanoTime() / 1000;
            this.f40004d = 10000L;
            return;
        }
        if (i3 == 1) {
            this.f40004d = 10000L;
            return;
        }
        if (i3 == 2 || i3 == 3) {
            this.f40004d = 10000000L;
        } else {
            if (i3 != 4) {
                throw new IllegalStateException();
            }
            this.f40004d = 500000L;
        }
    }
}
