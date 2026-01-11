package com.google.android.gms.internal.wearable;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes4.dex */
public class zza implements IInterface {

    /* renamed from: a, reason: collision with root package name */
    public final IBinder f62831a;

    /* renamed from: b, reason: collision with root package name */
    public final String f62832b;

    public zza(IBinder iBinder, String str) {
        this.f62831a = iBinder;
        this.f62832b = str;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f62831a;
    }

    public final void n(int i3, Parcel parcel) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            this.f62831a.transact(i3, parcel, parcelObtain, 0);
            parcelObtain.readException();
        } finally {
            parcel.recycle();
            parcelObtain.recycle();
        }
    }

    public final void t(int i3, Parcel parcel) {
        try {
            this.f62831a.transact(1, parcel, null, 1);
        } finally {
            parcel.recycle();
        }
    }

    public final Parcel w() {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(this.f62832b);
        return parcelObtain;
    }
}
