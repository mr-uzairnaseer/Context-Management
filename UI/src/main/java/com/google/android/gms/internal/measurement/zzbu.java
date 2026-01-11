package com.google.android.gms.internal.measurement;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes4.dex */
public class zzbu implements IInterface {

    /* renamed from: a, reason: collision with root package name */
    public final IBinder f61935a;

    /* renamed from: b, reason: collision with root package name */
    public final String f61936b;

    public zzbu(IBinder iBinder, String str) {
        this.f61935a = iBinder;
        this.f61936b = str;
    }

    public final void B4(int i3, Parcel parcel) {
        try {
            this.f61935a.transact(2, parcel, null, 1);
        } finally {
            parcel.recycle();
        }
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.f61935a;
    }

    public final Parcel n() {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(this.f61936b);
        return parcelObtain;
    }

    public final Parcel t(int i3, Parcel parcel) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            try {
                this.f61935a.transact(i3, parcel, parcelObtain, 0);
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
            this.f61935a.transact(i3, parcel, parcelObtain, 0);
            parcelObtain.readException();
        } finally {
            parcel.recycle();
            parcelObtain.recycle();
        }
    }
}
