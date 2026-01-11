package com.google.android.gms.internal.identity;

import androidx.media3.exoplayer.upstream.CmcdData;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.apache.commons.lang3.time.DateUtils;

/* loaded from: classes4.dex */
public final class zzeo {

    /* renamed from: a, reason: collision with root package name */
    public static final SimpleDateFormat f61855a;

    /* renamed from: b, reason: collision with root package name */
    public static final SimpleDateFormat f61856b;

    /* renamed from: c, reason: collision with root package name */
    public static final StringBuilder f61857c;

    static {
        Locale locale = Locale.ROOT;
        f61855a = new SimpleDateFormat("MM-dd HH:mm:ss.SSS", locale);
        f61856b = new SimpleDateFormat("MM-dd HH:mm:ss", locale);
        f61857c = new StringBuilder(33);
    }

    public static String a(long j3) {
        return j3 >= 0 ? f61855a.format(new Date(j3)) : Long.toString(j3);
    }

    public static String b(long j3) {
        String string;
        StringBuilder sb = f61857c;
        synchronized (sb) {
            sb.setLength(0);
            c(j3, sb);
            string = sb.toString();
        }
        return string;
    }

    public static StringBuilder c(long j3, StringBuilder sb) {
        if (j3 == 0) {
            sb.append("0s");
            return sb;
        }
        sb.ensureCapacity(sb.length() + 27);
        boolean z2 = false;
        if (j3 < 0) {
            sb.append("-");
            if (j3 != Long.MIN_VALUE) {
                j3 = -j3;
            } else {
                j3 = Long.MAX_VALUE;
                z2 = true;
            }
        }
        if (j3 >= 86400000) {
            sb.append(j3 / 86400000);
            sb.append("d");
            j3 %= 86400000;
        }
        if (true == z2) {
            j3 = 25975808;
        }
        if (j3 >= DateUtils.MILLIS_PER_HOUR) {
            sb.append(j3 / DateUtils.MILLIS_PER_HOUR);
            sb.append(CmcdData.Factory.STREAMING_FORMAT_HLS);
            j3 %= DateUtils.MILLIS_PER_HOUR;
        }
        if (j3 >= 60000) {
            sb.append(j3 / 60000);
            sb.append("m");
            j3 %= 60000;
        }
        if (j3 >= 1000) {
            sb.append(j3 / 1000);
            sb.append(CmcdData.Factory.STREAMING_FORMAT_SS);
            j3 %= 1000;
        }
        if (j3 > 0) {
            sb.append(j3);
            sb.append("ms");
        }
        return sb;
    }
}
