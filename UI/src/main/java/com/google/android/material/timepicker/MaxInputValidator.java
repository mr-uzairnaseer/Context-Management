package com.google.android.material.timepicker;

import android.text.InputFilter;
import android.text.Spanned;

/* loaded from: classes4.dex */
class MaxInputValidator implements InputFilter {

    /* renamed from: a, reason: collision with root package name */
    public int f67225a;

    public MaxInputValidator(int i3) {
        this.f67225a = i3;
    }

    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence charSequence, int i3, int i4, Spanned spanned, int i5, int i6) {
        try {
            StringBuilder sb = new StringBuilder(spanned);
            sb.replace(i5, i6, charSequence.subSequence(i3, i4).toString());
            if (Integer.parseInt(sb.toString()) <= this.f67225a) {
                return null;
            }
            return "";
        } catch (NumberFormatException unused) {
            return "";
        }
    }
}
