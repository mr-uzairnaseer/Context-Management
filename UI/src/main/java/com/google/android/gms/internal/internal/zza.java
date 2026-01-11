package com.google.android.gms.internal.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes4.dex */
public class zza implements IInterface {

    /* renamed from: a, reason: collision with root package name */
    public final IBinder f62818a;

    /* renamed from: b, reason: collision with root package name */
    public final String f62819b = "com.google.android.gms.recaptchabase.internal.IRecaptchaBaseService";

    public zza(IBinder iBinder, String str) {
        this.f62818a = iBinder;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f62818a;
    }

    public final Parcel n() {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(this.f62819b);
        return parcelObtain;
    }

    public final void t(int i3, Parcel parcel) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            this.f62818a.transact(i3, parcel, parcelObtain, 0);
            parcelObtain.readException();
        } finally {
            parcel.recycle();
            parcelObtain.recycle();
        }
    }
}
