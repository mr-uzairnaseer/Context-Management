package androidx.core.os;

@Deprecated
/* loaded from: classes3.dex */
public final class CancellationSignal {

    /* renamed from: a, reason: collision with root package name */
    public boolean f33423a;

    /* renamed from: b, reason: collision with root package name */
    public OnCancelListener f33424b;

    /* renamed from: c, reason: collision with root package name */
    public Object f33425c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f33426d;

    public interface OnCancelListener {
        void onCancel();
    }

    public void a() {
        synchronized (this) {
            try {
                if (this.f33423a) {
                    return;
                }
                this.f33423a = true;
                this.f33426d = true;
                OnCancelListener onCancelListener = this.f33424b;
                Object obj = this.f33425c;
                if (onCancelListener != null) {
                    try {
                        onCancelListener.onCancel();
                    } catch (Throwable th) {
                        synchronized (this) {
                            this.f33426d = false;
                            notifyAll();
                            throw th;
                        }
                    }
                }
                if (obj != null) {
                    ((android.os.CancellationSignal) obj).cancel();
                }
                synchronized (this) {
                    this.f33426d = false;
                    notifyAll();
                }
            } finally {
            }
        }
    }

    public Object b() {
        Object obj;
        synchronized (this) {
            try {
                if (this.f33425c == null) {
                    android.os.CancellationSignal cancellationSignal = new android.os.CancellationSignal();
                    this.f33425c = cancellationSignal;
                    if (this.f33423a) {
                        cancellationSignal.cancel();
                    }
                }
                obj = this.f33425c;
            } catch (Throwable th) {
                throw th;
            }
        }
        return obj;
    }

    public void c(OnCancelListener onCancelListener) {
        synchronized (this) {
            try {
                d();
                if (this.f33424b == onCancelListener) {
                    return;
                }
                this.f33424b = onCancelListener;
                if (this.f33423a && onCancelListener != null) {
                    onCancelListener.onCancel();
                }
            } finally {
            }
        }
    }

    public final void d() throws InterruptedException {
        while (this.f33426d) {
            try {
                wait();
            } catch (InterruptedException unused) {
            }
        }
    }
}
