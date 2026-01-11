package com.google.android.gms.internal.measurement;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public class zzbx extends Binder implements IInterface {
    public zzbx(String str) {
        attachInterface(this, str);
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }

    public boolean n(int i3, Parcel parcel, Parcel parcel2, int i4) {
        return false;
    }

    @Override // android.os.Binder
    public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i4) throws RemoteException {
        boolean zOnTransact;
        if (i3 > 16777215) {
            zOnTransact = super.onTransact(i3, parcel, parcel2, i4);
        } else {
            parcel.enforceInterface(getInterfaceDescriptor());
            zOnTransact = false;
        }
        if (zOnTransact) {
            return true;
        }
        return n(i3, parcel, parcel2, i4);
    }
}
