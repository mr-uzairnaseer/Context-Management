package com.google.android.gms.internal.p000authapi;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes4.dex */
public class zba implements IInterface {

    /* renamed from: a, reason: collision with root package name */
    public final IBinder f61151a;

    /* renamed from: b, reason: collision with root package name */
    public final String f61152b;

    public zba(IBinder iBinder, String str) {
        this.f61151a = iBinder;
        this.f61152b = str;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f61151a;
    }

    public final Parcel n() {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(this.f61152b);
        return parcelObtain;
    }

    public final void t(int i3, Parcel parcel) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            this.f61151a.transact(i3, parcel, parcelObtain, 0);
            parcelObtain.readException();
        } finally {
            parcel.recycle();
            parcelObtain.recycle();
        }
    }
}
