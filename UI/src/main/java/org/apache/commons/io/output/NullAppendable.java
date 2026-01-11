package org.apache.commons.io.output;

/* loaded from: classes6.dex */
public class NullAppendable implements Appendable {
    public static final NullAppendable INSTANCE = new NullAppendable();

    private NullAppendable() {
    }

    @Override // java.lang.Appendable
    public Appendable append(char c3) {
        return this;
    }

    @Override // java.lang.Appendable
    public Appendable append(CharSequence charSequence) {
        return this;
    }

    @Override // java.lang.Appendable
    public Appendable append(CharSequence charSequence, int i3, int i4) {
        return this;
    }
}
