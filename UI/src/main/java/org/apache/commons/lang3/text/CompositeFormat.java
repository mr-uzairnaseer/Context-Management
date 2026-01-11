package org.apache.commons.lang3.text;

import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;

@Deprecated
/* loaded from: classes7.dex */
public class CompositeFormat extends Format {

    /* renamed from: a, reason: collision with root package name */
    public final Format f162154a;

    /* renamed from: b, reason: collision with root package name */
    public final Format f162155b;

    @Override // java.text.Format
    public StringBuffer format(Object obj, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        return this.f162155b.format(obj, stringBuffer, fieldPosition);
    }

    @Override // java.text.Format
    public Object parseObject(String str, ParsePosition parsePosition) {
        return this.f162154a.parseObject(str, parsePosition);
    }
}
