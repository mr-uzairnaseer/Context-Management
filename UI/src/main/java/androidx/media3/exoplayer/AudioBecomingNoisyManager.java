package androidx.media3.exoplayer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;

/* loaded from: classes3.dex */
final class AudioBecomingNoisyManager {

    /* renamed from: a, reason: collision with root package name */
    public final Context f39152a;

    /* renamed from: b, reason: collision with root package name */
    public final AudioBecomingNoisyReceiver f39153b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f39154c;

    public final class AudioBecomingNoisyReceiver extends BroadcastReceiver implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final EventListener f39155a;

        /* renamed from: b, reason: collision with root package name */
        public final Handler f39156b;

        public AudioBecomingNoisyReceiver(Handler handler, EventListener eventListener) {
            this.f39156b = handler;
            this.f39155a = eventListener;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.media.AUDIO_BECOMING_NOISY".equals(intent.getAction())) {
                this.f39156b.post(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (AudioBecomingNoisyManager.this.f39154c) {
                this.f39155a.q();
            }
        }
    }

    public interface EventListener {
        void q();
    }

    public AudioBecomingNoisyManager(Context context, Handler handler, EventListener eventListener) {
        this.f39152a = context.getApplicationContext();
        this.f39153b = new AudioBecomingNoisyReceiver(handler, eventListener);
    }

    public void b(boolean z2) {
        if (z2 && !this.f39154c) {
            this.f39152a.registerReceiver(this.f39153b, new IntentFilter("android.media.AUDIO_BECOMING_NOISY"));
            this.f39154c = true;
        } else {
            if (z2 || !this.f39154c) {
                return;
            }
            this.f39152a.unregisterReceiver(this.f39153b);
            this.f39154c = false;
        }
    }
}
