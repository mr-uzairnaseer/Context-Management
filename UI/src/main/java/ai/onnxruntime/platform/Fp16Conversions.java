package ai.onnxruntime.platform;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
import java.util.logging.Logger;
import kotlin.jvm.internal.ShortCompanionObject;

/* loaded from: classes2.dex */
public final class Fp16Conversions {
    private static final Logger logger = Logger.getLogger(Fp16Conversions.class.getName());

    private Fp16Conversions() {
    }

    public static float bf16ToFloat(short s2) {
        return Float.intBitsToFloat(s2 << 16);
    }

    public static FloatBuffer convertBf16BufferToFloatBuffer(ShortBuffer shortBuffer) {
        int iPosition = shortBuffer.position();
        int iRemaining = shortBuffer.remaining();
        FloatBuffer floatBufferAsFloatBuffer = ByteBuffer.allocateDirect(iRemaining * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        for (int i3 = 0; i3 < iRemaining; i3++) {
            floatBufferAsFloatBuffer.put(i3, bf16ToFloat(shortBuffer.get(i3 + iPosition)));
        }
        return floatBufferAsFloatBuffer;
    }

    public static ShortBuffer convertFloatBufferToBf16Buffer(FloatBuffer floatBuffer) {
        int iPosition = floatBuffer.position();
        int iRemaining = floatBuffer.remaining();
        ShortBuffer shortBufferAsShortBuffer = ByteBuffer.allocateDirect(iRemaining * 2).order(ByteOrder.nativeOrder()).asShortBuffer();
        for (int i3 = 0; i3 < iRemaining; i3++) {
            shortBufferAsShortBuffer.put(i3, floatToBf16(floatBuffer.get(i3 + iPosition)));
        }
        return shortBufferAsShortBuffer;
    }

    public static ShortBuffer convertFloatBufferToFp16Buffer(FloatBuffer floatBuffer) {
        int iPosition = floatBuffer.position();
        int iRemaining = floatBuffer.remaining();
        ShortBuffer shortBufferAsShortBuffer = ByteBuffer.allocateDirect(iRemaining * 2).order(ByteOrder.nativeOrder()).asShortBuffer();
        for (int i3 = 0; i3 < iRemaining; i3++) {
            shortBufferAsShortBuffer.put(i3, floatToFp16(floatBuffer.get(i3 + iPosition)));
        }
        return shortBufferAsShortBuffer;
    }

    public static FloatBuffer convertFp16BufferToFloatBuffer(ShortBuffer shortBuffer) {
        int iPosition = shortBuffer.position();
        int iRemaining = shortBuffer.remaining();
        FloatBuffer floatBufferAsFloatBuffer = ByteBuffer.allocateDirect(iRemaining * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        for (int i3 = 0; i3 < iRemaining; i3++) {
            floatBufferAsFloatBuffer.put(i3, fp16ToFloat(shortBuffer.get(i3 + iPosition)));
        }
        return floatBufferAsFloatBuffer;
    }

    public static short floatToBf16(float f3) {
        int iFloatToIntBits = Float.floatToIntBits(f3);
        return (short) ((iFloatToIntBits + (((iFloatToIntBits >> 16) & 1) + 32767)) >> 16);
    }

    public static short floatToFp16(float f3) {
        return mlasFloatToFp16(f3);
    }

    public static float fp16ToFloat(short s2) {
        return mlasFp16ToFloat(s2);
    }

    public static short mlasFloatToFp16(float f3) {
        short sFloatToIntBits;
        int iFloatToIntBits = Float.floatToIntBits(f3);
        int iFloatToIntBits2 = Float.floatToIntBits(Float.POSITIVE_INFINITY);
        int i3 = Integer.MIN_VALUE & iFloatToIntBits;
        int i4 = iFloatToIntBits ^ i3;
        if (i4 >= 1199570944) {
            sFloatToIntBits = i4 > iFloatToIntBits2 ? (short) 32256 : (short) 31744;
        } else {
            sFloatToIntBits = (short) (i4 < 947912704 ? Float.floatToIntBits(Float.intBitsToFloat(i4) + Float.intBitsToFloat(1056964608)) - 1056964608 : ((i4 - 939520001) + ((i4 >> 13) & 1)) >> 13);
        }
        return (short) (sFloatToIntBits | ((short) (i3 >> 16)));
    }

    public static float mlasFp16ToFloat(short s2) {
        int i3 = (s2 & ShortCompanionObject.MAX_VALUE) << 13;
        int i4 = i3 & 260046848;
        int iFloatToIntBits = 939524096 + i3;
        if (i4 == 260046848) {
            iFloatToIntBits = i3 + 1879048192;
        } else if (i4 == 0) {
            iFloatToIntBits = Float.floatToIntBits(Float.intBitsToFloat(i3 + 947912704) - Float.intBitsToFloat(947912704));
        }
        return Float.intBitsToFloat(((s2 & ShortCompanionObject.MIN_VALUE) << 16) | iFloatToIntBits);
    }
}
