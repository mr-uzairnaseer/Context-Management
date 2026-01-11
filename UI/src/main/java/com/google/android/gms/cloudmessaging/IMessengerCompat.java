package com.google.android.gms.cloudmessaging;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Message;
import android.os.Parcel;

/* loaded from: classes4.dex */
interface IMessengerCompat extends IInterface {
    public static final String DESCRIPTOR = "com.google.android.gms.iid.IMessengerCompat";
    public static final int TRANSACTION_SEND = 1;

    public static class Impl extends Binder implements IMessengerCompat {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            throw null;
        }

        @Override // com.google.android.gms.cloudmessaging.IMessengerCompat
        public void e4(Message message) {
            throw null;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i4) {
            throw null;
        }
    }

    public static class Proxy implements IMessengerCompat {

        /* renamed from: a, reason: collision with root package name */
        public final IBinder f59819a;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.f59819a;
        }

        @Override // com.google.android.gms.cloudmessaging.IMessengerCompat
        public void e4(Message message) {
            Parcel parcelObtain = Parcel.obtain();
            parcelObtain.writeInterfaceToken(IMessengerCompat.DESCRIPTOR);
            parcelObtain.writeInt(1);
            message.writeToParcel(parcelObtain, 0);
            try {
                this.f59819a.transact(1, parcelObtain, null, 1);
            } finally {
                parcelObtain.recycle();
            }
        }
    }

    void e4(Message message);
}
