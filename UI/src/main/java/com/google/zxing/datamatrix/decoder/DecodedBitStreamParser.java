package com.google.zxing.datamatrix.decoder;

import com.google.common.base.Ascii;
import com.google.openlocationcode.OpenLocationCode;
import de.komoot.android.ui.comments.viewmodel.CommentEditorViewModel;
import kotlin.text.Typography;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.apache.commons.codec.language.Soundex;
import org.apache.commons.io.IOUtils;
import org.locationtech.jts.geom.Dimension;

/* loaded from: classes5.dex */
final class DecodedBitStreamParser {

    /* renamed from: a, reason: collision with root package name */
    public static final char[] f75116a = {'*', '*', '*', ' ', '0', Dimension.SYM_L, Dimension.SYM_A, '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', Dimension.SYM_FALSE, 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', Dimension.SYM_TRUE, 'U', 'V', 'W', 'X', 'Y', 'Z'};

    /* renamed from: b, reason: collision with root package name */
    public static final char[] f75117b;

    /* renamed from: c, reason: collision with root package name */
    public static final char[] f75118c;

    /* renamed from: d, reason: collision with root package name */
    public static final char[] f75119d;

    /* renamed from: e, reason: collision with root package name */
    public static final char[] f75120e;

    /* renamed from: com.google.zxing.datamatrix.decoder.DecodedBitStreamParser$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f75121a;

        static {
            int[] iArr = new int[Mode.values().length];
            f75121a = iArr;
            try {
                iArr[Mode.C40_ENCODE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f75121a[Mode.TEXT_ENCODE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f75121a[Mode.ANSIX12_ENCODE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f75121a[Mode.EDIFACT_ENCODE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f75121a[Mode.BASE256_ENCODE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public enum Mode {
        PAD_ENCODE,
        ASCII_ENCODE,
        C40_ENCODE,
        TEXT_ENCODE,
        ANSIX12_ENCODE,
        EDIFACT_ENCODE,
        BASE256_ENCODE
    }

    static {
        char[] cArr = {'!', '\"', '#', '$', '%', Typography.amp, '\'', '(', ')', '*', OpenLocationCode.SEPARATOR, AbstractJsonLexerKt.COMMA, Soundex.SILENT_MARKER, '.', IOUtils.DIR_SEPARATOR_UNIX, AbstractJsonLexerKt.COLON, ';', '<', '=', '>', '?', CommentEditorViewModel.MENTION_CHAR, AbstractJsonLexerKt.BEGIN_LIST, '\\', AbstractJsonLexerKt.END_LIST, '^', '_'};
        f75117b = cArr;
        f75118c = new char[]{'*', '*', '*', ' ', '0', Dimension.SYM_L, Dimension.SYM_A, '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', AbstractJsonLexerKt.UNICODE_ESC, 'v', 'w', 'x', 'y', 'z'};
        f75119d = cArr;
        f75120e = new char[]{'`', 'A', 'B', 'C', 'D', 'E', Dimension.SYM_FALSE, 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', Dimension.SYM_TRUE, 'U', 'V', 'W', 'X', 'Y', 'Z', AbstractJsonLexerKt.BEGIN_OBJ, '|', AbstractJsonLexerKt.END_OBJ, '~', Ascii.MAX};
    }

    private DecodedBitStreamParser() {
    }
}
