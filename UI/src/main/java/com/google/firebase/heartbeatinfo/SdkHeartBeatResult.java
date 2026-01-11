package com.google.firebase.heartbeatinfo;

import com.google.auto.value.AutoValue;

@AutoValue
/* loaded from: classes5.dex */
public abstract class SdkHeartBeatResult implements Comparable<SdkHeartBeatResult> {
    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(SdkHeartBeatResult sdkHeartBeatResult) {
        return o() < sdkHeartBeatResult.o() ? -1 : 1;
    }

    public abstract String c();

    public abstract long o();
}
