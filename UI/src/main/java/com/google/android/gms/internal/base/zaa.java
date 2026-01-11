package com.google.android.gms.internal.base;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes4.dex */
public class zaa implements IInterface {

    /* renamed from: a, reason: collision with root package name */
    public final IBinder f61426a;

    /* renamed from: b, reason: collision with root package name */
    public final String f61427b;

    public zaa(IBinder iBinder, String str) {
        this.f61426a = iBinder;
        this.f61427b = str;
    }

    public final void B4(int i3, Parcel parcel) {
        try {
            this.f61426a.transact(1, parcel, null, 1);
        } finally {
            parcel.recycle();
        }
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f61426a;
    }

    public final Parcel n() {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(this.f61427b);
        return parcelObtain;
    }

    public final Parcel t(int i3, Parcel parcel) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            try {
                this.f61426a.transact(2, parcel, parcelObtain, 0);
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

    public final void w(int i3, Parcel parcel) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            this.f61426a.transact(i3, parcel, parcelObtain, 0);
            parcelObtain.readException();
        } finally {
            parcel.recycle();
            parcelObtain.recycle();
        }
    }
}
