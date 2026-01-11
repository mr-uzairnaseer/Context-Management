package org.apache.commons.io;

import androidx.compose.compiler.plugins.types.analysis.StabilityExternalClassNameMatchingKt;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.Objects;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes6.dex */
public class ByteOrderMark implements Serializable {
    public static final char UTF_BOM = 65279;

    /* renamed from: a, reason: collision with root package name */
    public final String f161330a;

    /* renamed from: b, reason: collision with root package name */
    public final int[] f161331b;
    public static final ByteOrderMark UTF_8 = new ByteOrderMark(StandardCharsets.UTF_8.name(), 239, 187, 191);
    public static final ByteOrderMark UTF_16BE = new ByteOrderMark(StandardCharsets.UTF_16BE.name(), 254, 255);
    public static final ByteOrderMark UTF_16LE = new ByteOrderMark(StandardCharsets.UTF_16LE.name(), 255, 254);
    public static final ByteOrderMark UTF_32BE = new ByteOrderMark("UTF-32BE", 0, 0, 254, 255);
    public static final ByteOrderMark UTF_32LE = new ByteOrderMark("UTF-32LE", 255, 254, 0, 0);

    public ByteOrderMark(String str, int... iArr) {
        Objects.requireNonNull(str, "charsetName");
        Objects.requireNonNull(iArr, "bytes");
        if (str.isEmpty()) {
            throw new IllegalArgumentException("No charsetName specified");
        }
        if (iArr.length == 0) {
            throw new IllegalArgumentException("No bytes specified");
        }
        this.f161330a = str;
        this.f161331b = (int[]) iArr.clone();
    }

    public int a(int i3) {
        return this.f161331b[i3];
    }

    public String b() {
        return this.f161330a;
    }

    public int c() {
        return this.f161331b.length;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ByteOrderMark)) {
            return false;
        }
        ByteOrderMark byteOrderMark = (ByteOrderMark) obj;
        if (this.f161331b.length != byteOrderMark.c()) {
            return false;
        }
        int i3 = 0;
        while (true) {
            int[] iArr = this.f161331b;
            if (i3 >= iArr.length) {
                return true;
            }
            if (iArr[i3] != byteOrderMark.a(i3)) {
                return false;
            }
            i3++;
        }
    }

    public int hashCode() {
        int iHashCode = getClass().hashCode();
        for (int i3 : this.f161331b) {
            iHashCode += i3;
        }
        return iHashCode;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(AbstractJsonLexerKt.BEGIN_LIST);
        sb.append(this.f161330a);
        sb.append(": ");
        for (int i3 = 0; i3 < this.f161331b.length; i3++) {
            if (i3 > 0) {
                sb.append(StabilityExternalClassNameMatchingKt.STABILITY_GENERIC_SEPARATOR);
            }
            sb.append("0x");
            sb.append(Integer.toHexString(this.f161331b[i3] & 255).toUpperCase(Locale.ROOT));
        }
        sb.append(AbstractJsonLexerKt.END_LIST);
        return sb.toString();
    }
}
