package com.google.android.gms.internal.ads_identifier;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes4.dex */
public class zza implements IInterface {

    /* renamed from: a, reason: collision with root package name */
    public final IBinder f61104a;

    /* renamed from: b, reason: collision with root package name */
    public final String f61105b = "com.google.android.gms.ads.identifier.internal.IAdvertisingIdService";

    public zza(IBinder iBinder, String str) {
        this.f61104a = iBinder;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f61104a;
    }

    public final Parcel n() {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(this.f61105b);
        return parcelObtain;
    }

    public final Parcel t(int i3, Parcel parcel) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            try {
                this.f61104a.transact(i3, parcel, parcelObtain, 0);
                parcelObtain.readException();
                return parcelObtain;
            } catch (RuntimeException e3) {
                parcelObtain.recycle();
                throw e3;
            }
        } finally {
            parcel.recycle();
        }
    }
}
