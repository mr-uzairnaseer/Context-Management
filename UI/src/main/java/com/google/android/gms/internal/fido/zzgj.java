package com.google.android.gms.internal.fido;

/* loaded from: classes4.dex */
public final class zzgj {
    public static byte[] a(byte[]... bArr) {
        int i3 = 0;
        int length = 0;
        while (true) {
            if (i3 >= bArr.length) {
                break;
            }
            length += bArr[i3].length;
            i3++;
        }
        byte[] bArr2 = new byte[length];
        int i4 = 0;
        for (byte[] bArr3 : bArr) {
            int length2 = bArr3.length;
            System.arraycopy(bArr3, 0, bArr2, i4, length2);
            i4 += length2;
        }
        return bArr2;
    }
}
