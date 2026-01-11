package androidx.fragment.app;

import android.util.Log;
import java.io.Writer;

/* loaded from: classes3.dex */
final class LogWriter extends Writer {

    /* renamed from: a, reason: collision with root package name */
    public final String f36121a;

    /* renamed from: b, reason: collision with root package name */
    public StringBuilder f36122b = new StringBuilder(128);

    public LogWriter(String str) {
        this.f36121a = str;
    }

    public final void a() {
        if (this.f36122b.length() > 0) {
            Log.d(this.f36121a, this.f36122b.toString());
            StringBuilder sb = this.f36122b;
            sb.delete(0, sb.length());
        }
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        a();
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
        a();
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i3, int i4) {
        for (int i5 = 0; i5 < i4; i5++) {
            char c3 = cArr[i3 + i5];
            if (c3 == '\n') {
                a();
            } else {
                this.f36122b.append(c3);
            }
        }
    }
}
