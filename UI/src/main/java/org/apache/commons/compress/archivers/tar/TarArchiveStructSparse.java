package org.apache.commons.compress.archivers.tar;

import java.util.Objects;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes5.dex */
public final class TarArchiveStructSparse {

    /* renamed from: a, reason: collision with root package name */
    public final long f160217a;

    /* renamed from: b, reason: collision with root package name */
    public final long f160218b;

    public TarArchiveStructSparse(long j3, long j4) {
        if (j3 < 0) {
            throw new IllegalArgumentException("offset must not be negative");
        }
        if (j4 < 0) {
            throw new IllegalArgumentException("numbytes must not be negative");
        }
        this.f160217a = j3;
        this.f160218b = j4;
    }

    public long a() {
        return this.f160218b;
    }

    public long b() {
        return this.f160217a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && TarArchiveStructSparse.class == obj.getClass()) {
            TarArchiveStructSparse tarArchiveStructSparse = (TarArchiveStructSparse) obj;
            if (this.f160217a == tarArchiveStructSparse.f160217a && this.f160218b == tarArchiveStructSparse.f160218b) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(Long.valueOf(this.f160217a), Long.valueOf(this.f160218b));
    }

    public String toString() {
        return "TarArchiveStructSparse{offset=" + this.f160217a + ", numbytes=" + this.f160218b + AbstractJsonLexerKt.END_OBJ;
    }
}
