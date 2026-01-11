package com.google.android.play.integrity.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes4.dex */
public class a implements IInterface {

    /* renamed from: a, reason: collision with root package name */
    public final IBinder f67718a;

    /* renamed from: b, reason: collision with root package name */
    public final String f67719b;

    public a(IBinder iBinder, String str) {
        this.f67718a = iBinder;
        this.f67719b = str;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f67718a;
    }

    public final Parcel n() {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(this.f67719b);
        return parcelObtain;
    }

    public final void t(int i3, Parcel parcel) {
        try {
            this.f67718a.transact(i3, parcel, null, 1);
        } finally {
            parcel.recycle();
        }
    }
}
