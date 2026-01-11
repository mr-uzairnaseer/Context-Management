package org.json;

/* loaded from: classes8.dex */
public class ParserConfiguration {
    public static final int DEFAULT_MAXIMUM_NESTING_DEPTH = 512;
    public static final int UNDEFINED_MAXIMUM_NESTING_DEPTH = -1;
    protected boolean keepStrings;
    protected int maxNestingDepth;

    public ParserConfiguration() {
        this.keepStrings = false;
        this.maxNestingDepth = 512;
    }

    public int getMaxNestingDepth() {
        return this.maxNestingDepth;
    }

    public boolean isKeepStrings() {
        return this.keepStrings;
    }

    public <T extends ParserConfiguration> T withKeepStrings(boolean z2) {
        T t2 = (T) clone();
        t2.keepStrings = z2;
        return t2;
    }

    public <T extends ParserConfiguration> T withMaxNestingDepth(int i3) {
        T t2 = (T) clone();
        if (i3 > -1) {
            t2.maxNestingDepth = i3;
            return t2;
        }
        t2.maxNestingDepth = -1;
        return t2;
    }

    @Override // 
    public ParserConfiguration clone() {
        return new ParserConfiguration(this.keepStrings, this.maxNestingDepth);
    }

    public ParserConfiguration(boolean z2, int i3) {
        this.keepStrings = z2;
        this.maxNestingDepth = i3;
    }
}
