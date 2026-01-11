package com.google.android.material.snackbar;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.common.ConnectionResult;
import java.lang.ref.WeakReference;

/* loaded from: classes4.dex */
class SnackbarManager {

    /* renamed from: e, reason: collision with root package name */
    public static SnackbarManager f66888e;

    /* renamed from: a, reason: collision with root package name */
    public final Object f66889a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public final Handler f66890b = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.google.android.material.snackbar.SnackbarManager.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 0) {
                return false;
            }
            SnackbarManager.this.d((SnackbarRecord) message.obj);
            return true;
        }
    });

    /* renamed from: c, reason: collision with root package name */
    public SnackbarRecord f66891c;

    /* renamed from: d, reason: collision with root package name */
    public SnackbarRecord f66892d;

    public interface Callback {
        void a();

        void b(int i3);
    }

    public static class SnackbarRecord {

        /* renamed from: a, reason: collision with root package name */
        public final WeakReference f66894a;

        /* renamed from: b, reason: collision with root package name */
        public int f66895b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f66896c;

        public SnackbarRecord(int i3, Callback callback) {
            this.f66894a = new WeakReference(callback);
            this.f66895b = i3;
        }

        public boolean a(Callback callback) {
            return callback != null && this.f66894a.get() == callback;
        }
    }

    private SnackbarManager() {
    }

    public static SnackbarManager c() {
        if (f66888e == null) {
            f66888e = new SnackbarManager();
        }
        return f66888e;
    }

    public final boolean a(SnackbarRecord snackbarRecord, int i3) {
        Callback callback = (Callback) snackbarRecord.f66894a.get();
        if (callback == null) {
            return false;
        }
        this.f66890b.removeCallbacksAndMessages(snackbarRecord);
        callback.b(i3);
        return true;
    }

    public void b(Callback callback, int i3) {
        synchronized (this.f66889a) {
            try {
                if (f(callback)) {
                    a(this.f66891c, i3);
                } else if (g(callback)) {
                    a(this.f66892d, i3);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void d(SnackbarRecord snackbarRecord) {
        synchronized (this.f66889a) {
            try {
                if (this.f66891c == snackbarRecord || this.f66892d == snackbarRecord) {
                    a(snackbarRecord, 2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean e(Callback callback) {
        boolean z2;
        synchronized (this.f66889a) {
            try {
                z2 = f(callback) || g(callback);
            } finally {
            }
        }
        return z2;
    }

    public final boolean f(Callback callback) {
        SnackbarRecord snackbarRecord = this.f66891c;
        return snackbarRecord != null && snackbarRecord.a(callback);
    }

    public final boolean g(Callback callback) {
        SnackbarRecord snackbarRecord = this.f66892d;
        return snackbarRecord != null && snackbarRecord.a(callback);
    }

    public void h(Callback callback) {
        synchronized (this.f66889a) {
            try {
                if (f(callback)) {
                    this.f66891c = null;
                    if (this.f66892d != null) {
                        n();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void i(Callback callback) {
        synchronized (this.f66889a) {
            try {
                if (f(callback)) {
                    l(this.f66891c);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void j(Callback callback) {
        synchronized (this.f66889a) {
            try {
                if (f(callback)) {
                    SnackbarRecord snackbarRecord = this.f66891c;
                    if (!snackbarRecord.f66896c) {
                        snackbarRecord.f66896c = true;
                        this.f66890b.removeCallbacksAndMessages(snackbarRecord);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void k(Callback callback) {
        synchronized (this.f66889a) {
            try {
                if (f(callback)) {
                    SnackbarRecord snackbarRecord = this.f66891c;
                    if (snackbarRecord.f66896c) {
                        snackbarRecord.f66896c = false;
                        l(snackbarRecord);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void l(SnackbarRecord snackbarRecord) {
        int i3 = snackbarRecord.f66895b;
        if (i3 == -2) {
            return;
        }
        if (i3 <= 0) {
            i3 = i3 == -1 ? ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED : 2750;
        }
        this.f66890b.removeCallbacksAndMessages(snackbarRecord);
        Handler handler = this.f66890b;
        handler.sendMessageDelayed(Message.obtain(handler, 0, snackbarRecord), i3);
    }

    public void m(int i3, Callback callback) {
        synchronized (this.f66889a) {
            try {
                if (f(callback)) {
                    SnackbarRecord snackbarRecord = this.f66891c;
                    snackbarRecord.f66895b = i3;
                    this.f66890b.removeCallbacksAndMessages(snackbarRecord);
                    l(this.f66891c);
                    return;
                }
                if (g(callback)) {
                    this.f66892d.f66895b = i3;
                } else {
                    this.f66892d = new SnackbarRecord(i3, callback);
                }
                SnackbarRecord snackbarRecord2 = this.f66891c;
                if (snackbarRecord2 == null || !a(snackbarRecord2, 4)) {
                    this.f66891c = null;
                    n();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void n() {
        SnackbarRecord snackbarRecord = this.f66892d;
        if (snackbarRecord != null) {
            this.f66891c = snackbarRecord;
            this.f66892d = null;
            Callback callback = (Callback) snackbarRecord.f66894a.get();
            if (callback != null) {
                callback.a();
            } else {
                this.f66891c = null;
            }
        }
    }
}
