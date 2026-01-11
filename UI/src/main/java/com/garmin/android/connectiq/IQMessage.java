package com.garmin.android.connectiq;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes4.dex */
public class IQMessage implements Parcelable {
    public static final Parcelable.Creator<IQMessage> CREATOR = new Parcelable.Creator<IQMessage>() { // from class: com.garmin.android.connectiq.IQMessage.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public IQMessage createFromParcel(Parcel parcel) {
            return new IQMessage(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public IQMessage[] newArray(int i3) {
            return new IQMessage[i3];
        }
    };

    /* renamed from: a, reason: collision with root package name */
    public byte[] f58801a;

    /* renamed from: b, reason: collision with root package name */
    public String f58802b;

    /* renamed from: c, reason: collision with root package name */
    public String f58803c;

    public IQMessage(byte[] bArr, String str, String str2) {
        byte[] bArr2 = new byte[bArr.length];
        this.f58801a = bArr2;
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        this.f58802b = str;
        this.f58803c = str2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        byte[] bArr = this.f58801a;
        if (bArr != null) {
            parcel.writeInt(bArr.length);
            parcel.writeByteArray(this.f58801a);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.f58802b);
        parcel.writeString(this.f58803c);
    }

    public IQMessage(Parcel parcel) {
        if (parcel.readInt() > 0) {
            this.f58801a = parcel.createByteArray();
        }
        this.f58802b = parcel.readString();
        this.f58803c = parcel.readString();
    }
}
