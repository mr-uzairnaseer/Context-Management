package com.google.android.a;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes4.dex */
public class a implements IInterface {

    /* renamed from: a, reason: collision with root package name */
    public final IBinder f58934a;

    /* renamed from: b, reason: collision with root package name */
    public final String f58935b = "com.google.android.finsky.externalreferrer.IGetInstallReferrerService";

    public a(IBinder iBinder) {
        this.f58934a = iBinder;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f58934a;
    }

    public final Parcel n() {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(this.f58935b);
        return parcelObtain;
    }

    public final Parcel t(Parcel parcel) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            try {
                this.f58934a.transact(1, parcel, parcelObtain, 0);
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
