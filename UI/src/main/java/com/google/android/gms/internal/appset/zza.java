package com.google.android.gms.internal.appset;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes4.dex */
public class zza implements IInterface {

    /* renamed from: a, reason: collision with root package name */
    public final IBinder f61107a;

    /* renamed from: b, reason: collision with root package name */
    public final String f61108b = "com.google.android.gms.appset.internal.IAppSetService";

    public zza(IBinder iBinder, String str) {
        this.f61107a = iBinder;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f61107a;
    }

    public final Parcel n() {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(this.f61108b);
        return parcelObtain;
    }

    public final void t(int i3, Parcel parcel) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            this.f61107a.transact(1, parcel, parcelObtain, 0);
            parcelObtain.readException();
        } finally {
            parcel.recycle();
            parcelObtain.recycle();
        }
    }
}
