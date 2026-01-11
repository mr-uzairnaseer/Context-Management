package org.locationtech.jts.io;

import com.facebook.appevents.AppEventsConstants;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

/* loaded from: classes6.dex */
public class OrdinateFormat {
    public static OrdinateFormat DEFAULT = new OrdinateFormat();
    public static final int MAX_FRACTION_DIGITS = 325;
    public static final String REP_NAN = "NaN";
    public static final String REP_NEG_INF = "-Inf";
    public static final String REP_POS_INF = "Inf";

    /* renamed from: a, reason: collision with root package name */
    public DecimalFormat f163592a;

    public OrdinateFormat() {
        this.f163592a = b(MAX_FRACTION_DIGITS);
    }

    public static OrdinateFormat a(int i3) {
        return new OrdinateFormat(i3);
    }

    public static DecimalFormat b(int i3) {
        try {
            DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getInstance(Locale.US);
            decimalFormat.applyPattern(AppEventsConstants.EVENT_PARAM_VALUE_NO);
            decimalFormat.setMaximumFractionDigits(i3);
            return decimalFormat;
        } catch (ClassCastException unused) {
            throw new RuntimeException("Unable to create DecimalFormat for Locale.US");
        }
    }

    public synchronized String c(double d3) {
        if (Double.isNaN(d3)) {
            return REP_NAN;
        }
        if (Double.isInfinite(d3)) {
            return d3 > 0.0d ? REP_POS_INF : REP_NEG_INF;
        }
        return this.f163592a.format(d3);
    }

    public OrdinateFormat(int i3) {
        this.f163592a = b(i3);
    }
}
