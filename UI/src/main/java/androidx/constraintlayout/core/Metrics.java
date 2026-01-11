package androidx.constraintlayout.core;

import java.util.ArrayList;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes3.dex */
public class Metrics {
    public long A;
    public long B;
    public long C;
    public ArrayList D = new ArrayList();
    public long E;
    public long F;
    public long G;
    public long H;
    public long I;
    public long J;
    public long K;
    public long L;
    public int M;
    public int N;
    public long O;
    public long P;
    public long Q;
    public long R;
    public long S;
    public long T;
    public long U;

    /* renamed from: a, reason: collision with root package name */
    public long f30935a;

    /* renamed from: b, reason: collision with root package name */
    public long f30936b;

    /* renamed from: c, reason: collision with root package name */
    public long f30937c;

    /* renamed from: d, reason: collision with root package name */
    public long f30938d;

    /* renamed from: e, reason: collision with root package name */
    public long f30939e;

    /* renamed from: f, reason: collision with root package name */
    public long f30940f;

    /* renamed from: g, reason: collision with root package name */
    public long f30941g;

    /* renamed from: h, reason: collision with root package name */
    public long f30942h;

    /* renamed from: i, reason: collision with root package name */
    public long f30943i;

    /* renamed from: j, reason: collision with root package name */
    public long f30944j;

    /* renamed from: k, reason: collision with root package name */
    public long f30945k;

    /* renamed from: l, reason: collision with root package name */
    public long f30946l;

    /* renamed from: m, reason: collision with root package name */
    public long f30947m;

    /* renamed from: n, reason: collision with root package name */
    public long f30948n;

    /* renamed from: o, reason: collision with root package name */
    public long f30949o;

    /* renamed from: p, reason: collision with root package name */
    public long f30950p;

    /* renamed from: q, reason: collision with root package name */
    public long f30951q;

    /* renamed from: r, reason: collision with root package name */
    public long f30952r;

    /* renamed from: s, reason: collision with root package name */
    public long f30953s;

    /* renamed from: t, reason: collision with root package name */
    public long f30954t;

    /* renamed from: u, reason: collision with root package name */
    public long f30955u;

    /* renamed from: v, reason: collision with root package name */
    public long f30956v;

    /* renamed from: w, reason: collision with root package name */
    public long f30957w;

    /* renamed from: x, reason: collision with root package name */
    public long f30958x;

    /* renamed from: y, reason: collision with root package name */
    public long f30959y;

    /* renamed from: z, reason: collision with root package name */
    public long f30960z;

    public void a(Metrics metrics) {
        this.T = metrics.T;
        this.S = metrics.S;
        this.U = metrics.U;
        this.N = metrics.N;
        this.M = metrics.M;
        this.O = metrics.O;
        this.P = metrics.P;
        this.Q = metrics.Q;
        this.f30935a = metrics.f30935a;
        this.R = metrics.R;
        this.f30936b = metrics.f30936b;
        this.f30939e = metrics.f30939e;
        this.F = metrics.F;
        this.f30940f = metrics.f30940f;
        this.f30941g = metrics.f30941g;
        this.f30942h = metrics.f30942h;
        this.f30954t = metrics.f30954t;
        this.E = metrics.E;
        this.A = metrics.A;
        this.B = metrics.B;
        this.f30943i = metrics.f30943i;
        this.f30960z = metrics.f30960z;
        this.f30944j = metrics.f30944j;
        this.f30945k = metrics.f30945k;
        this.f30946l = metrics.f30946l;
        this.f30947m = metrics.f30947m;
        this.f30948n = metrics.f30948n;
        this.f30949o = metrics.f30949o;
        this.f30950p = metrics.f30950p;
        this.f30951q = metrics.f30951q;
        this.f30952r = metrics.f30952r;
        this.f30953s = metrics.f30953s;
        this.f30955u = metrics.f30955u;
        this.f30956v = metrics.f30956v;
        this.f30957w = metrics.f30957w;
        this.f30959y = metrics.f30959y;
        this.C = metrics.C;
    }

    public String toString() {
        return "\n*** Metrics ***\nmeasures: " + this.f30939e + "\nmeasuresWrap: " + this.G + "\nmeasuresWrapInfeasible: " + this.H + "\ndetermineGroups: " + this.J + "\ninfeasibleDetermineGroups: " + this.I + "\ngraphOptimizer: " + this.f30956v + "\nwidgets: " + this.F + "\ngraphSolved: " + this.f30957w + "\nlinearSolved: " + this.f30958x + StringUtils.LF;
    }
}
