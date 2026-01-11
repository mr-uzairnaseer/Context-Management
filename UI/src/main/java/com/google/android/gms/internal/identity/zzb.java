package com.google.android.gms.internal.identity;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes4.dex */
public class zzb extends Binder implements IInterface {
    public zzb(String str) {
        attachInterface(this, str);
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this;
    }

    public boolean n(int i3, Parcel parcel, Parcel parcel2, int i4) {
        throw null;
    }

    @Override // android.os.Binder
    public final boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i4) {
        if (i3 <= 16777215) {
            parcel.enforceInterface(getInterfaceDescriptor());
        } else if (super.onTransact(i3, parcel, parcel2, i4)) {
            return true;
        }
        return n(i3, parcel, parcel2, i4);
    }
}
