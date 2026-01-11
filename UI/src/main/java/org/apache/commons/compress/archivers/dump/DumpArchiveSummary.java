package org.apache.commons.compress.archivers.dump;

import java.util.Objects;

/* loaded from: classes5.dex */
public class DumpArchiveSummary {

    /* renamed from: a, reason: collision with root package name */
    public long f160013a;

    /* renamed from: b, reason: collision with root package name */
    public String f160014b;

    /* renamed from: c, reason: collision with root package name */
    public String f160015c;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        DumpArchiveSummary dumpArchiveSummary = (DumpArchiveSummary) obj;
        return Objects.equals(this.f160014b, dumpArchiveSummary.f160014b) && this.f160013a == dumpArchiveSummary.f160013a && Objects.equals(this.f160015c, dumpArchiveSummary.f160015c);
    }

    public int hashCode() {
        return Objects.hash(this.f160014b, Long.valueOf(this.f160013a), this.f160015c);
    }
}
