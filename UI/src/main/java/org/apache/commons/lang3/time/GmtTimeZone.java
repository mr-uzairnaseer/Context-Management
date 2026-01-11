package org.apache.commons.lang3.time;

import com.google.openlocationcode.OpenLocationCode;
import java.util.Date;
import java.util.Objects;
import java.util.TimeZone;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.apache.commons.codec.language.Soundex;
import org.joda.time.DateTimeConstants;

/* loaded from: classes7.dex */
final class GmtTimeZone extends TimeZone {

    /* renamed from: a, reason: collision with root package name */
    public final int f162321a;

    /* renamed from: b, reason: collision with root package name */
    public final String f162322b;

    public GmtTimeZone(boolean z2, int i3, int i4) {
        if (i3 >= 24) {
            throw new IllegalArgumentException(i3 + " hours out of range");
        }
        if (i4 >= 60) {
            throw new IllegalArgumentException(i4 + " minutes out of range");
        }
        int i5 = ((i3 * 60) + i4) * DateTimeConstants.MILLIS_PER_MINUTE;
        this.f162321a = z2 ? -i5 : i5;
        StringBuilder sb = new StringBuilder(9);
        sb.append(TimeZones.GMT_ID);
        sb.append(z2 ? Soundex.SILENT_MARKER : OpenLocationCode.SEPARATOR);
        StringBuilder sbA = a(sb, i3);
        sbA.append(AbstractJsonLexerKt.COLON);
        this.f162322b = a(sbA, i4).toString();
    }

    public static StringBuilder a(StringBuilder sb, int i3) {
        sb.append((char) ((i3 / 10) + 48));
        sb.append((char) ((i3 % 10) + 48));
        return sb;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GmtTimeZone)) {
            return false;
        }
        GmtTimeZone gmtTimeZone = (GmtTimeZone) obj;
        return this.f162321a == gmtTimeZone.f162321a && Objects.equals(this.f162322b, gmtTimeZone.f162322b);
    }

    @Override // java.util.TimeZone
    public String getID() {
        return this.f162322b;
    }

    @Override // java.util.TimeZone
    public int getOffset(int i3, int i4, int i5, int i6, int i7, int i8) {
        return this.f162321a;
    }

    @Override // java.util.TimeZone
    public int getRawOffset() {
        return this.f162321a;
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.f162321a), this.f162322b);
    }

    @Override // java.util.TimeZone
    public boolean inDaylightTime(Date date) {
        return false;
    }

    @Override // java.util.TimeZone
    public void setRawOffset(int i3) {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        return "[GmtTimeZone id=\"" + this.f162322b + "\",offset=" + this.f162321a + AbstractJsonLexerKt.END_LIST;
    }

    @Override // java.util.TimeZone
    public boolean useDaylightTime() {
        return false;
    }
}
