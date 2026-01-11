package com.google.firebase.heartbeatinfo;

/* loaded from: classes.dex */
public interface HeartBeatInfo {

    /* loaded from: classes5.dex */
    public enum HeartBeat {
        NONE(0),
        SDK(1),
        GLOBAL(2),
        COMBINED(3);

        private final int code;

        HeartBeat(int i3) {
            this.code = i3;
        }

        public int c() {
            return this.code;
        }
    }

    HeartBeat a(String str);
}
