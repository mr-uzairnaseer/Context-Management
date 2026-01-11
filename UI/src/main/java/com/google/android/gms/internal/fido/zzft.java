package com.google.android.gms.internal.fido;

/* loaded from: classes4.dex */
public abstract class zzft {

    /* renamed from: a, reason: collision with root package name */
    public static final char[] f61633a = "0123456789abcdef".toCharArray();
    public static final /* synthetic */ int zzb = 0;

    public abstract int a();

    public abstract int b();

    public abstract boolean c(zzft zzftVar);

    public abstract byte[] d();

    public byte[] e() {
        throw null;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzft) {
            zzft zzftVar = (zzft) obj;
            if (b() == zzftVar.b() && c(zzftVar)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        if (b() >= 32) {
            return a();
        }
        byte[] bArrE = e();
        int i3 = bArrE[0] & 255;
        for (int i4 = 1; i4 < bArrE.length; i4++) {
            i3 |= (bArrE[i4] & 255) << (i4 * 8);
        }
        return i3;
    }

    public final String toString() {
        byte[] bArrE = e();
        int length = bArrE.length;
        StringBuilder sb = new StringBuilder(length + length);
        for (byte b3 : bArrE) {
            char[] cArr = f61633a;
            sb.append(cArr[(b3 >> 4) & 15]);
            sb.append(cArr[b3 & 15]);
        }
        return sb.toString();
    }
}
