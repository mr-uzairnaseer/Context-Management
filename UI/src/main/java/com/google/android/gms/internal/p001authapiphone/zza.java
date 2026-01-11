package com.google.android.gms.internal.p001authapiphone;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes4.dex */
public class zza implements IInterface {

    /* renamed from: a, reason: collision with root package name */
    public final IBinder f61128a;

    /* renamed from: b, reason: collision with root package name */
    public final String f61129b = "com.google.android.gms.auth.api.phone.internal.ISmsRetrieverApiService";

    public zza(IBinder iBinder, String str) {
        this.f61128a = iBinder;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f61128a;
    }

    public final Parcel n() {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(this.f61129b);
        return parcelObtain;
    }

    public final void t(int i3, Parcel parcel) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            this.f61128a.transact(i3, parcel, parcelObtain, 0);
            parcelObtain.readException();
        } finally {
            parcel.recycle();
            parcelObtain.recycle();
        }
    }
}
