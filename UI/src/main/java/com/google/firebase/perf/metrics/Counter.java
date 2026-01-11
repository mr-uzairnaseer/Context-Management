package com.google.firebase.perf.metrics;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes5.dex */
public class Counter implements Parcelable {
    public static final Parcelable.Creator<Counter> CREATOR = new Parcelable.Creator<Counter>() { // from class: com.google.firebase.perf.metrics.Counter.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Counter createFromParcel(Parcel parcel) {
            return new Counter(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Counter[] newArray(int i3) {
            return new Counter[i3];
        }
    };

    /* renamed from: a, reason: collision with root package name */
    public final String f73456a;

    /* renamed from: b, reason: collision with root package name */
    public final AtomicLong f73457b;

    public long a() {
        return this.f73457b.get();
    }

    public String b() {
        return this.f73456a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void e(long j3) {
        this.f73457b.addAndGet(j3);
    }

    public void f(long j3) {
        this.f73457b.set(j3);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f73456a);
        parcel.writeLong(this.f73457b.get());
    }

    public Counter(String str) {
        this.f73456a = str;
        this.f73457b = new AtomicLong(0L);
    }

    public Counter(Parcel parcel) {
        this.f73456a = parcel.readString();
        this.f73457b = new AtomicLong(parcel.readLong());
    }
}
