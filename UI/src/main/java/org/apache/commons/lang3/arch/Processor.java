package org.apache.commons.lang3.arch;

/* loaded from: classes7.dex */
public class Processor {

    /* renamed from: a, reason: collision with root package name */
    public final Arch f161989a;

    /* renamed from: b, reason: collision with root package name */
    public final Type f161990b;

    public enum Arch {
        BIT_32("32-bit"),
        BIT_64("64-bit"),
        UNKNOWN("Unknown");

        private final String label;

        Arch(String str) {
            this.label = str;
        }

        public String c() {
            return this.label;
        }
    }

    public enum Type {
        AARCH_64("AArch64"),
        X86("x86"),
        IA_64("IA-64"),
        PPC("PPC"),
        RISC_V("RISC-V"),
        UNKNOWN("Unknown");

        private final String label;

        Type(String str) {
            this.label = str;
        }

        public String c() {
            return this.label;
        }
    }

    public Processor(Arch arch, Type type) {
        this.f161989a = arch;
        this.f161990b = type;
    }

    public String toString() {
        return this.f161990b.c() + ' ' + this.f161989a.c();
    }
}
