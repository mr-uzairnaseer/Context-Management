package com.google.zxing.oned.rss.expanded.decoders;

/* loaded from: classes5.dex */
final class CurrentParsingState {

    /* renamed from: a, reason: collision with root package name */
    public int f75261a = 0;

    /* renamed from: b, reason: collision with root package name */
    public State f75262b = State.NUMERIC;

    public enum State {
        NUMERIC,
        ALPHA,
        ISO_IEC_646
    }
}
