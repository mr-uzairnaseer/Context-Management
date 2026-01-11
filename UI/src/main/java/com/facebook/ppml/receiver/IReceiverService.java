package com.facebook.ppml.receiver;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes4.dex */
public interface IReceiverService extends IInterface {
    public static final String DESCRIPTOR = "com.facebook.ppml.receiver.IReceiverService";

    public static class Default implements IReceiverService {
        @Override // com.facebook.ppml.receiver.IReceiverService
        public int N2(Bundle bundle) {
            return 0;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IReceiverService {

        public static class Proxy implements IReceiverService {

            /* renamed from: a, reason: collision with root package name */
            public IBinder f58647a;

            public Proxy(IBinder iBinder) {
                this.f58647a = iBinder;
            }

            @Override // com.facebook.ppml.receiver.IReceiverService
            public int N2(Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IReceiverService.DESCRIPTOR);
                    _Parcel.d(parcelObtain, bundle, 0);
                    this.f58647a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f58647a;
            }
        }

        public Stub() {
            attachInterface(this, IReceiverService.DESCRIPTOR);
        }

        public static IReceiverService n(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IReceiverService.DESCRIPTOR);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IReceiverService)) ? new Proxy(iBinder) : (IReceiverService) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i4) {
            if (i3 >= 1 && i3 <= 16777215) {
                parcel.enforceInterface(IReceiverService.DESCRIPTOR);
            }
            if (i3 == 1598968902) {
                parcel2.writeString(IReceiverService.DESCRIPTOR);
                return true;
            }
            if (i3 != 1) {
                return super.onTransact(i3, parcel, parcel2, i4);
            }
            int iN2 = N2((Bundle) _Parcel.c(parcel, Bundle.CREATOR));
            parcel2.writeNoException();
            parcel2.writeInt(iN2);
            return true;
        }
    }

    public static class _Parcel {
        public static Object c(Parcel parcel, Parcelable.Creator creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        public static void d(Parcel parcel, Parcelable parcelable, int i3) {
            if (parcelable == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                parcelable.writeToParcel(parcel, i3);
            }
        }
    }

    int N2(Bundle bundle);
}
