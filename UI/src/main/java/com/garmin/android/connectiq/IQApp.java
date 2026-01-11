package com.garmin.android.connectiq;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes4.dex */
public class IQApp implements Parcelable {
    public static final Parcelable.Creator<IQApp> CREATOR = new Parcelable.Creator<IQApp>() { // from class: com.garmin.android.connectiq.IQApp.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public IQApp createFromParcel(Parcel parcel) {
            return new IQApp(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public IQApp[] newArray(int i3) {
            return new IQApp[i3];
        }
    };

    /* renamed from: a, reason: collision with root package name */
    public String f58788a;

    /* renamed from: b, reason: collision with root package name */
    public IQAppStatus f58789b;

    /* renamed from: c, reason: collision with root package name */
    public String f58790c;

    /* renamed from: d, reason: collision with root package name */
    public int f58791d;

    public enum IQAppStatus {
        UNKNOWN,
        INSTALLED,
        NOT_INSTALLED,
        NOT_SUPPORTED
    }

    public IQApp(String str) {
        this.f58788a = str.toUpperCase().replaceAll("[\\s\\-]", "");
        this.f58789b = IQAppStatus.UNKNOWN;
        this.f58790c = "";
        this.f58791d = 0;
    }

    public String a() {
        return this.f58788a;
    }

    public String b() {
        return this.f58790c;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public IQAppStatus e() {
        return this.f58789b;
    }

    public String toString() {
        return this.f58790c;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.f58791d);
        parcel.writeInt(this.f58789b.ordinal());
        parcel.writeString(this.f58788a);
        parcel.writeString(this.f58790c);
    }

    public IQApp(String str, String str2, int i3) {
        this(str.toUpperCase().replaceAll("[\\s\\-]", ""), IQAppStatus.UNKNOWN, str2, i3);
    }

    public IQApp(String str, IQAppStatus iQAppStatus, String str2, int i3) {
        this.f58788a = str.toUpperCase().replaceAll("[\\s\\-]", "");
        this.f58789b = iQAppStatus;
        this.f58790c = str2;
        this.f58791d = i3;
    }

    public IQApp(String str, int i3) {
        this(str.toUpperCase().replaceAll("[\\s\\-]", ""), IQAppStatus.INSTALLED, "", i3);
    }

    public IQApp(Parcel parcel) {
        this.f58791d = parcel.readInt();
        try {
            this.f58789b = IQAppStatus.values()[parcel.readInt()];
        } catch (IndexOutOfBoundsException unused) {
            this.f58789b = IQAppStatus.UNKNOWN;
        }
        this.f58788a = parcel.readString();
        this.f58790c = parcel.readString();
    }
}
