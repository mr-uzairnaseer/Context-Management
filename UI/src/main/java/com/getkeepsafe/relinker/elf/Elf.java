package com.getkeepsafe.relinker.elf;

/* loaded from: classes4.dex */
public interface Elf {

    public static abstract class DynamicStructure {
        public static final int DT_NEEDED = 1;
        public static final int DT_NULL = 0;
        public static final int DT_STRTAB = 5;

        /* renamed from: a, reason: collision with root package name */
        public long f58853a;

        /* renamed from: b, reason: collision with root package name */
        public long f58854b;
    }

    public static abstract class Header {
        public static final int ELFCLASS32 = 1;
        public static final int ELFCLASS64 = 2;
        public static final int ELFDATA2MSB = 2;

        /* renamed from: a, reason: collision with root package name */
        public boolean f58855a;

        /* renamed from: b, reason: collision with root package name */
        public int f58856b;

        /* renamed from: c, reason: collision with root package name */
        public long f58857c;

        /* renamed from: d, reason: collision with root package name */
        public long f58858d;

        /* renamed from: e, reason: collision with root package name */
        public int f58859e;

        /* renamed from: f, reason: collision with root package name */
        public int f58860f;

        /* renamed from: g, reason: collision with root package name */
        public int f58861g;

        /* renamed from: h, reason: collision with root package name */
        public int f58862h;

        /* renamed from: i, reason: collision with root package name */
        public int f58863i;

        public abstract DynamicStructure a(long j3, int i3);

        public abstract ProgramHeader b(long j3);

        public abstract SectionHeader c(int i3);
    }

    public static abstract class ProgramHeader {
        public static final int PT_DYNAMIC = 2;
        public static final int PT_LOAD = 1;

        /* renamed from: a, reason: collision with root package name */
        public long f58864a;

        /* renamed from: b, reason: collision with root package name */
        public long f58865b;

        /* renamed from: c, reason: collision with root package name */
        public long f58866c;

        /* renamed from: d, reason: collision with root package name */
        public long f58867d;
    }

    public static abstract class SectionHeader {

        /* renamed from: a, reason: collision with root package name */
        public long f58868a;
    }
}
