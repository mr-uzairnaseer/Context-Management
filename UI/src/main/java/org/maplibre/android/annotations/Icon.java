package org.maplibre.android.annotations;

import android.graphics.Bitmap;
import java.nio.ByteBuffer;

@Deprecated
/* loaded from: classes8.dex */
public class Icon {

    /* renamed from: a, reason: collision with root package name */
    public Bitmap f164375a;

    /* renamed from: b, reason: collision with root package name */
    public String f164376b;

    public Icon(String str, Bitmap bitmap) {
        this.f164376b = str;
        this.f164375a = bitmap;
    }

    public Bitmap a() {
        Bitmap bitmap = this.f164375a;
        if (bitmap != null) {
            Bitmap.Config config = bitmap.getConfig();
            Bitmap.Config config2 = Bitmap.Config.ARGB_8888;
            if (config != config2) {
                this.f164375a = this.f164375a.copy(config2, false);
            }
        }
        return this.f164375a;
    }

    public String b() {
        return this.f164376b;
    }

    public float c() {
        Bitmap bitmap = this.f164375a;
        if (bitmap == null) {
            throw new IllegalStateException("Required to set a Icon before calling getScale");
        }
        float density = bitmap.getDensity();
        if (density == 0.0f) {
            density = 160.0f;
        }
        return density / 160.0f;
    }

    public byte[] d() {
        Bitmap bitmap = this.f164375a;
        if (bitmap == null) {
            throw new IllegalStateException("Required to set a Icon before calling toBytes");
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(bitmap.getRowBytes() * this.f164375a.getHeight());
        this.f164375a.copyPixelsToBuffer(byteBufferAllocate);
        return byteBufferAllocate.array();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            Icon icon = (Icon) obj;
            if (this.f164375a.equals(icon.f164375a) && this.f164376b.equals(icon.f164376b)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        Bitmap bitmap = this.f164375a;
        int iHashCode = bitmap != null ? bitmap.hashCode() : 0;
        String str = this.f164376b;
        return str != null ? (iHashCode * 31) + str.hashCode() : iHashCode;
    }
}
