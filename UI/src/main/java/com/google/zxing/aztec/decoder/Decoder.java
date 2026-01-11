package com.google.zxing.aztec.decoder;

import androidx.compose.compiler.plugins.types.analysis.StabilityExternalClassNameMatchingKt;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.exoplayer.upstream.CmcdData;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.security.CertificateUtil;
import de.komoot.android.eventtracker.KmtEventTracking;
import de.komoot.android.services.api.JsonKeywords;
import de.komoot.android.services.api.RequestParameters;
import freemarker.template.Template;
import org.apache.commons.lang3.StringUtils;
import org.json.HTTP;
import org.locationtech.jts.io.gml2.GMLConstants;

/* loaded from: classes5.dex */
public final class Decoder {

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f74966a = {"CTRL_PS", " ", "A", "B", KmtEventTracking.SALES_BANNER_BANNER, Template.DEFAULT_NAMESPACE_PREFIX, ExifInterface.LONGITUDE_EAST, "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", ExifInterface.LATITUDE_SOUTH, ExifInterface.GPS_DIRECTION_TRUE, "U", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, ExifInterface.LONGITUDE_WEST, GMLConstants.GML_COORD_X, GMLConstants.GML_COORD_Y, "Z", "CTRL_LL", "CTRL_ML", "CTRL_DL", "CTRL_BS"};

    /* renamed from: b, reason: collision with root package name */
    public static final String[] f74967b = {"CTRL_PS", " ", CmcdData.Factory.OBJECT_TYPE_AUDIO_ONLY, "b", "c", "d", "e", "f", "g", CmcdData.Factory.STREAMING_FORMAT_HLS, CmcdData.Factory.OBJECT_TYPE_INIT_SEGMENT, "j", "k", CmcdData.Factory.STREAM_TYPE_LIVE, "m", "n", "o", TtmlNode.TAG_P, RequestParameters.Q, "r", CmcdData.Factory.STREAMING_FORMAT_SS, JsonKeywords.T, "u", "v", "w", "x", "y", "z", "CTRL_US", "CTRL_ML", "CTRL_DL", "CTRL_BS"};

    /* renamed from: c, reason: collision with root package name */
    public static final String[] f74968c = {"CTRL_PS", " ", "\u0001", "\u0002", "\u0003", "\u0004", "\u0005", "\u0006", "\u0007", "\b", "\t", StringUtils.LF, "\u000b", "\f", StringUtils.CR, "\u001b", "\u001c", "\u001d", "\u001e", "\u001f", "@", "\\", "^", "_", "`", "|", "~", "\u007f", "CTRL_LL", "CTRL_UL", "CTRL_PL", "CTRL_BS"};

    /* renamed from: d, reason: collision with root package name */
    public static final String[] f74969d = {"", StringUtils.CR, HTTP.CRLF, ". ", ", ", ": ", "!", "\"", "#", "$", "%", "&", "'", "(", ")", StabilityExternalClassNameMatchingKt.STABILITY_GENERIC_INCLUDE, "+", StabilityExternalClassNameMatchingKt.STABILITY_GENERIC_SEPARATOR, "-", ".", "/", CertificateUtil.DELIMITER, ";", "<", "=", ">", "?", "[", "]", "{", "}", "CTRL_UL"};

    /* renamed from: e, reason: collision with root package name */
    public static final String[] f74970e = {"CTRL_PS", " ", AppEventsConstants.EVENT_PARAM_VALUE_NO, "1", ExifInterface.GPS_MEASUREMENT_2D, ExifInterface.GPS_MEASUREMENT_3D, "4", "5", "6", "7", "8", "9", StabilityExternalClassNameMatchingKt.STABILITY_GENERIC_SEPARATOR, ".", "CTRL_UL", "CTRL_US"};

    /* renamed from: com.google.zxing.aztec.decoder.Decoder$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f74971a;

        static {
            int[] iArr = new int[Table.values().length];
            f74971a = iArr;
            try {
                iArr[Table.UPPER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f74971a[Table.LOWER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f74971a[Table.MIXED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f74971a[Table.PUNCT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f74971a[Table.DIGIT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public enum Table {
        UPPER,
        LOWER,
        MIXED,
        DIGIT,
        PUNCT,
        BINARY
    }
}
