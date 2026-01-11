package com.garmin.android.connectiq;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes4.dex */
public class IQDevice implements Parcelable {
    public static final Parcelable.Creator<IQDevice> CREATOR = new Parcelable.Creator<IQDevice>() { // from class: com.garmin.android.connectiq.IQDevice.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public IQDevice createFromParcel(Parcel parcel) {
            return new IQDevice(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public IQDevice[] newArray(int i3) {
            return new IQDevice[i3];
        }
    };

    /* renamed from: a, reason: collision with root package name */
    public long f58792a;

    /* renamed from: b, reason: collision with root package name */
    public String f58793b;

    /* renamed from: c, reason: collision with root package name */
    public IQDeviceStatus f58794c;

    public enum IQDeviceStatus {
        NOT_PAIRED,
        NOT_CONNECTED,
        CONNECTED,
        UNKNOWN
    }

    public IQDevice(long j3, String str) {
        this.f58794c = IQDeviceStatus.UNKNOWN;
        this.f58792a = j3;
        this.f58793b = str;
    }

    public long a() {
        return this.f58792a;
    }

    public String b() {
        return this.f58793b;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public IQDeviceStatus e() {
        return this.f58794c;
    }

    public String toString() {
        return this.f58793b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeLong(this.f58792a);
        parcel.writeString(this.f58793b);
        parcel.writeString(this.f58794c.name());
    }

    public IQDevice(Parcel parcel) {
        this.f58794c = IQDeviceStatus.UNKNOWN;
        this.f58792a = parcel.readLong();
        this.f58793b = parcel.readString();
        try {
            this.f58794c = IQDeviceStatus.valueOf(parcel.readString());
        } catch (IllegalArgumentException unused) {
            this.f58794c = IQDeviceStatus.UNKNOWN;
        }
    }
}
