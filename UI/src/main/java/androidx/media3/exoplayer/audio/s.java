package androidx.media3.exoplayer.audio;

import android.os.Handler;
import java.util.concurrent.Executor;

/* loaded from: classes3.dex */
public final /* synthetic */ class s implements Executor {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Handler f40238a;

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.f40238a.post(runnable);
    }
}
