package org.apache.commons.compress.utils;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.FilterInputStream;

@Deprecated
/* loaded from: classes5.dex */
public class SkipShieldingInputStream extends FilterInputStream {

    /* renamed from: a, reason: collision with root package name */
    public static final byte[] f161328a = new byte[8192];

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j3) {
        if (j3 < 0) {
            return 0L;
        }
        return read(f161328a, 0, (int) Math.min(j3, PlaybackStateCompat.ACTION_PLAY_FROM_URI));
    }
}
