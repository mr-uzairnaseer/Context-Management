package com.google.android.gms.internal.play_billing;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes4.dex */
public class zzaq implements IInterface {

    /* renamed from: a, reason: collision with root package name */
    public final IBinder f62522a;

    /* renamed from: b, reason: collision with root package name */
    public final String f62523b;

    public zzaq(IBinder iBinder, String str) {
        this.f62522a = iBinder;
        this.f62523b = str;
    }

    public final void B4(int i3, Parcel parcel) {
        try {
            this.f62522a.transact(i3, parcel, null, 1);
        } finally {
            parcel.recycle();
        }
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f62522a;
    }

    public final Parcel n() {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(this.f62523b);
        return parcelObtain;
    }

    public final Parcel t(int i3, Parcel parcel) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            try {
                this.f62522a.transact(i3, parcel, parcelObtain, 0);
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
            this.f62522a.transact(i3, parcel, parcelObtain, 0);
            parcelObtain.readException();
        } finally {
            parcel.recycle();
            parcelObtain.recycle();
        }
    }
}
