package com.google.android.gms.internal.fido;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes4.dex */
public class zza implements IInterface {

    /* renamed from: a, reason: collision with root package name */
    public final IBinder f61490a;

    /* renamed from: b, reason: collision with root package name */
    public final String f61491b;

    public zza(IBinder iBinder, String str) {
        this.f61490a = iBinder;
        this.f61491b = str;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f61490a;
    }

    public final Parcel n() {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(this.f61491b);
        return parcelObtain;
    }

    public final void t(int i3, Parcel parcel) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            this.f61490a.transact(i3, parcel, parcelObtain, 0);
            parcelObtain.readException();
        } finally {
            parcel.recycle();
            parcelObtain.recycle();
        }
    }
}
