package org.apache.commons.io.output;

/* loaded from: classes6.dex */
public interface UncheckedAppendable extends Appendable {
    @Override // java.lang.Appendable
    UncheckedAppendable append(char c3);

    @Override // java.lang.Appendable
    UncheckedAppendable append(CharSequence charSequence);

    @Override // java.lang.Appendable
    UncheckedAppendable append(CharSequence charSequence, int i3, int i4);
}
