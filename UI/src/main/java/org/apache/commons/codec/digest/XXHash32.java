package org.apache.commons.codec.digest;

import androidx.media3.muxer.MuxerUtil;
import java.util.zip.Checksum;

/* loaded from: classes4.dex */
public class XXHash32 implements Checksum {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f159704a;

    /* renamed from: b, reason: collision with root package name */
    public final int[] f159705b;

    /* renamed from: c, reason: collision with root package name */
    public final byte[] f159706c;

    /* renamed from: d, reason: collision with root package name */
    public final int f159707d;

    /* renamed from: e, reason: collision with root package name */
    public int f159708e;

    /* renamed from: f, reason: collision with root package name */
    public int f159709f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f159710g;

    public XXHash32() {
        this(0);
    }

    public static int a(byte[] bArr, int i3) {
        return ((bArr[i3 + 3] & 255) << 24) | (bArr[i3] & 255) | ((bArr[i3 + 1] & 255) << 8) | ((bArr[i3 + 2] & 255) << 16);
    }

    public final void b() {
        int[] iArr = this.f159705b;
        int i3 = this.f159707d;
        iArr[0] = 606290984 + i3;
        iArr[1] = (-2048144777) + i3;
        iArr[2] = i3;
        iArr[3] = i3 - (-1640531535);
    }

    public final void c(byte[] bArr, int i3) {
        int[] iArr = this.f159705b;
        int i4 = iArr[0];
        int i5 = iArr[1];
        int i6 = iArr[2];
        int i7 = iArr[3];
        int iRotateLeft = Integer.rotateLeft(i4 + (a(bArr, i3) * (-2048144777)), 13) * (-1640531535);
        int iRotateLeft2 = Integer.rotateLeft(i5 + (a(bArr, i3 + 4) * (-2048144777)), 13) * (-1640531535);
        int iRotateLeft3 = Integer.rotateLeft(i6 + (a(bArr, i3 + 8) * (-2048144777)), 13) * (-1640531535);
        int iRotateLeft4 = Integer.rotateLeft(i7 + (a(bArr, i3 + 12) * (-2048144777)), 13) * (-1640531535);
        int[] iArr2 = this.f159705b;
        iArr2[0] = iRotateLeft;
        iArr2[1] = iRotateLeft2;
        iArr2[2] = iRotateLeft3;
        iArr2[3] = iRotateLeft4;
        this.f159710g = true;
    }

    @Override // java.util.zip.Checksum
    public long getValue() {
        int i3 = 0;
        int iRotateLeft = (this.f159710g ? Integer.rotateLeft(this.f159705b[0], 1) + Integer.rotateLeft(this.f159705b[1], 7) + Integer.rotateLeft(this.f159705b[2], 12) + Integer.rotateLeft(this.f159705b[3], 18) : this.f159705b[2] + 374761393) + this.f159708e;
        int i4 = this.f159709f - 4;
        while (i3 <= i4) {
            iRotateLeft = Integer.rotateLeft(iRotateLeft + (a(this.f159706c, i3) * (-1028477379)), 17) * 668265263;
            i3 += 4;
        }
        while (i3 < this.f159709f) {
            iRotateLeft = Integer.rotateLeft(iRotateLeft + ((this.f159706c[i3] & 255) * 374761393), 11) * (-1640531535);
            i3++;
        }
        int i5 = (iRotateLeft ^ (iRotateLeft >>> 15)) * (-2048144777);
        int i6 = (i5 ^ (i5 >>> 13)) * (-1028477379);
        return (i6 ^ (i6 >>> 16)) & MuxerUtil.UNSIGNED_INT_MAX_VALUE;
    }

    @Override // java.util.zip.Checksum
    public void reset() {
        b();
        this.f159708e = 0;
        this.f159709f = 0;
        this.f159710g = false;
    }

    @Override // java.util.zip.Checksum
    public void update(byte[] bArr, int i3, int i4) {
        if (i4 <= 0) {
            return;
        }
        this.f159708e += i4;
        int i5 = i3 + i4;
        int i6 = this.f159709f;
        if ((i6 + i4) - 16 < 0) {
            System.arraycopy(bArr, i3, this.f159706c, i6, i4);
            this.f159709f += i4;
            return;
        }
        if (i6 > 0) {
            int i7 = 16 - i6;
            System.arraycopy(bArr, i3, this.f159706c, i6, i7);
            c(this.f159706c, 0);
            i3 += i7;
        }
        int i8 = i5 - 16;
        while (i3 <= i8) {
            c(bArr, i3);
            i3 += 16;
        }
        if (i3 >= i5) {
            this.f159709f = 0;
            return;
        }
        int i9 = i5 - i3;
        this.f159709f = i9;
        System.arraycopy(bArr, i3, this.f159706c, 0, i9);
    }

    public XXHash32(int i3) {
        this.f159704a = new byte[1];
        this.f159705b = new int[4];
        this.f159706c = new byte[16];
        this.f159707d = i3;
        b();
    }

    @Override // java.util.zip.Checksum
    public void update(int i3) {
        byte[] bArr = this.f159704a;
        bArr[0] = (byte) (i3 & 255);
        update(bArr, 0, 1);
    }
}
