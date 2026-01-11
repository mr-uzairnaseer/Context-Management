package android.support.v4.media.session;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;

@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes2.dex */
public class ParcelableVolumeInfo implements Parcelable {
    public static final Parcelable.Creator<ParcelableVolumeInfo> CREATOR = new Parcelable.Creator<ParcelableVolumeInfo>() { // from class: android.support.v4.media.session.ParcelableVolumeInfo.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ParcelableVolumeInfo createFromParcel(Parcel parcel) {
            return new ParcelableVolumeInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ParcelableVolumeInfo[] newArray(int i3) {
            return new ParcelableVolumeInfo[i3];
        }
    };

    /* renamed from: a, reason: collision with root package name */
    public int f2196a;

    /* renamed from: b, reason: collision with root package name */
    public int f2197b;

    /* renamed from: c, reason: collision with root package name */
    public int f2198c;

    /* renamed from: d, reason: collision with root package name */
    public int f2199d;

    /* renamed from: e, reason: collision with root package name */
    public int f2200e;

    public ParcelableVolumeInfo(int i3, int i4, int i5, int i6, int i7) {
        this.f2196a = i3;
        this.f2197b = i4;
        this.f2198c = i5;
        this.f2199d = i6;
        this.f2200e = i7;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.f2196a);
        parcel.writeInt(this.f2198c);
        parcel.writeInt(this.f2199d);
        parcel.writeInt(this.f2200e);
        parcel.writeInt(this.f2197b);
    }

    public ParcelableVolumeInfo(Parcel parcel) {
        this.f2196a = parcel.readInt();
        this.f2198c = parcel.readInt();
        this.f2199d = parcel.readInt();
        this.f2200e = parcel.readInt();
        this.f2197b = parcel.readInt();
    }
}
