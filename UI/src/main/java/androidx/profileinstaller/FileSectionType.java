package androidx.profileinstaller;

/* loaded from: classes4.dex */
enum FileSectionType {
    DEX_FILES(0),
    EXTRA_DESCRIPTORS(1),
    CLASSES(2),
    METHODS(3),
    AGGREGATION_COUNT(4);

    private final long mValue;

    FileSectionType(long j3) {
        this.mValue = j3;
    }

    public long c() {
        return this.mValue;
    }
}
