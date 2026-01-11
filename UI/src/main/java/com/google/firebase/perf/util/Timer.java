package com.google.firebase.perf.util;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class Timer implements Parcelable {
    public static final Parcelable.Creator<Timer> CREATOR = new Parcelable.Creator<Timer>() { // from class: com.google.firebase.perf.util.Timer.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Timer createFromParcel(Parcel parcel) {
            return new Timer(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Timer[] newArray(int i3) {
            return new Timer[i3];
        }
    };

    /* renamed from: a, reason: collision with root package name */
    public long f73640a;

    /* renamed from: b, reason: collision with root package name */
    public long f73641b;

    public static long a() {
        return TimeUnit.NANOSECONDS.toMicros(SystemClock.elapsedRealtimeNanos());
    }

    public static Timer h(long j3) {
        long micros = TimeUnit.MILLISECONDS.toMicros(j3);
        return new Timer(j() + (micros - a()), micros);
    }

    public static long j() {
        return TimeUnit.MILLISECONDS.toMicros(System.currentTimeMillis());
    }

    public long b() {
        return this.f73640a + e();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public long e() {
        return f(new Timer());
    }

    public long f(Timer timer) {
        return timer.f73641b - this.f73641b;
    }

    public long g() {
        return this.f73640a;
    }

    public void i() {
        this.f73640a = j();
        this.f73641b = a();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeLong(this.f73640a);
        parcel.writeLong(this.f73641b);
    }

    public Timer() {
        this(j(), a());
    }

    public Timer(long j3, long j4) {
        this.f73640a = j3;
        this.f73641b = j4;
    }

    public Timer(Parcel parcel) {
        this(parcel.readLong(), parcel.readLong());
    }
}
