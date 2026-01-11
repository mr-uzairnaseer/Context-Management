package com.google.android.gms.internal.common;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes4.dex */
public class zza implements IInterface {

    /* renamed from: a, reason: collision with root package name */
    public final IBinder f61454a;

    /* renamed from: b, reason: collision with root package name */
    public final String f61455b;

    public zza(IBinder iBinder, String str) {
        this.f61454a = iBinder;
        this.f61455b = str;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f61454a;
    }

    public final Parcel n(int i3, Parcel parcel) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            try {
                this.f61454a.transact(i3, parcel, parcelObtain, 0);
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

    public final void t(int i3, Parcel parcel) {
        try {
            this.f61454a.transact(2, parcel, null, 1);
        } finally {
            parcel.recycle();
        }
    }

    public final Parcel w() {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(this.f61455b);
        return parcelObtain;
    }
}
