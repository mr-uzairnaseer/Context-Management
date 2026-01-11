package retrofit2;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
final class AndroidMainExecutor implements Executor {

    /* renamed from: a, reason: collision with root package name */
    public final Handler f165839a = new Handler(Looper.getMainLooper());

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.f165839a.post(runnable);
    }
}
