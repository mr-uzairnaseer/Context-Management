package com.google.android.gms.internal.fido;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;

/* loaded from: classes4.dex */
final class zzht {

    /* renamed from: a, reason: collision with root package name */
    public final Deque f61694a = new ArrayDeque(16);

    public zzht(boolean z2) {
    }

    public static zzht a() {
        return new zzht(false);
    }

    public final void b() throws IOException {
        if (!this.f61694a.isEmpty()) {
            throw new IOException(String.format("data item not completed, stackSize: %s scope: %s", Integer.valueOf(this.f61694a.size()), Long.valueOf(h())));
        }
    }

    public final void c() throws IOException {
        long jH = h();
        if (jH >= 0) {
            throw new IOException(String.format("expected indefinite length scope but found %s", Long.valueOf(jH)));
        }
        if (jH == -5) {
            throw new IOException("expected a value for dangling key in indefinite-length map");
        }
        this.f61694a.pop();
    }

    public final void d() throws IOException {
        long jH = h();
        if (jH != -1) {
            if (jH != -2) {
                return;
            } else {
                jH = -2;
            }
        }
        throw new IOException(String.format("expected non-string scope but found %s", Long.valueOf(jH)));
    }

    public final void e(long j3) throws IOException {
        long jH = h();
        if (jH != j3) {
            if (jH != -1) {
                if (jH != -2) {
                    return;
                } else {
                    jH = -2;
                }
            }
            throw new IOException(String.format("expected non-string scope or scope %s but found %s", Long.valueOf(j3), Long.valueOf(jH)));
        }
    }

    public final void f() {
        long jH = h();
        if (jH == 1) {
            this.f61694a.pop();
            return;
        }
        if (jH > 1) {
            i(jH - 1);
        } else if (jH == -4) {
            i(-5L);
        } else if (jH == -5) {
            i(-4L);
        }
    }

    public final void g(long j3) {
        this.f61694a.push(Long.valueOf(j3));
    }

    public final long h() {
        if (this.f61694a.isEmpty()) {
            return 0L;
        }
        return ((Long) this.f61694a.peek()).longValue();
    }

    public final void i(long j3) {
        this.f61694a.pop();
        this.f61694a.push(Long.valueOf(j3));
    }
}
