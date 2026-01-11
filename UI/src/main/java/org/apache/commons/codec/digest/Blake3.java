package org.apache.commons.codec.digest;

import com.google.common.base.Ascii;

/* loaded from: classes4.dex */
public final class Blake3 {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f159688a = {1779033703, -1150833019, 1013904242, -1521486534, 1359893119, -1694144372, 528734635, 1541459225};

    /* renamed from: b, reason: collision with root package name */
    public static final byte[][] f159689b = {new byte[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, Ascii.CR, 14, 15}, new byte[]{2, 6, 3, 10, 7, 0, 4, Ascii.CR, 1, 11, 12, 5, 9, 14, 15, 8}, new byte[]{3, 4, 10, 12, Ascii.CR, 2, 7, 14, 6, 5, 9, 0, 11, 15, 8, 1}, new byte[]{10, 7, 12, 9, 14, 3, Ascii.CR, 15, 4, 0, 11, 2, 5, 8, 1, 6}, new byte[]{12, Ascii.CR, 9, 11, 15, 10, 14, 8, 7, 2, 5, 3, 0, 1, 6, 4}, new byte[]{9, 14, 11, 5, 8, 12, 15, 1, Ascii.CR, 3, 0, 10, 2, 6, 4, 7}, new byte[]{11, 15, 5, 0, 1, 9, 8, 6, 14, 10, 2, 12, 3, 4, 7, Ascii.CR}};

    public static final class ChunkState {
    }

    public static final class EngineState {
    }

    public static final class Output {
    }
}
