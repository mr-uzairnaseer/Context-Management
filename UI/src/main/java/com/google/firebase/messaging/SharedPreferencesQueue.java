package com.google.firebase.messaging;

import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
final class SharedPreferencesQueue {

    /* renamed from: a, reason: collision with root package name */
    public final SharedPreferences f73182a;

    /* renamed from: b, reason: collision with root package name */
    public final String f73183b;

    /* renamed from: c, reason: collision with root package name */
    public final String f73184c;

    /* renamed from: e, reason: collision with root package name */
    public final Executor f73186e;

    /* renamed from: d, reason: collision with root package name */
    public final ArrayDeque f73185d = new ArrayDeque();

    /* renamed from: f, reason: collision with root package name */
    public boolean f73187f = false;

    public SharedPreferencesQueue(SharedPreferences sharedPreferences, String str, String str2, Executor executor) {
        this.f73182a = sharedPreferences;
        this.f73183b = str;
        this.f73184c = str2;
        this.f73186e = executor;
    }

    public static SharedPreferencesQueue c(SharedPreferences sharedPreferences, String str, String str2, Executor executor) {
        SharedPreferencesQueue sharedPreferencesQueue = new SharedPreferencesQueue(sharedPreferences, str, str2, executor);
        sharedPreferencesQueue.d();
        return sharedPreferencesQueue;
    }

    public final boolean b(boolean z2) {
        if (z2 && !this.f73187f) {
            i();
        }
        return z2;
    }

    public final void d() {
        synchronized (this.f73185d) {
            try {
                this.f73185d.clear();
                String string = this.f73182a.getString(this.f73183b, "");
                if (!TextUtils.isEmpty(string) && string.contains(this.f73184c)) {
                    String[] strArrSplit = string.split(this.f73184c, -1);
                    if (strArrSplit.length == 0) {
                        Log.e(Constants.TAG, "Corrupted queue. Please check the queue contents and item separator provided");
                    }
                    for (String str : strArrSplit) {
                        if (!TextUtils.isEmpty(str)) {
                            this.f73185d.add(str);
                        }
                    }
                }
            } finally {
            }
        }
    }

    public String e() {
        String str;
        synchronized (this.f73185d) {
            str = (String) this.f73185d.peek();
        }
        return str;
    }

    public boolean f(Object obj) {
        boolean zB;
        synchronized (this.f73185d) {
            zB = b(this.f73185d.remove(obj));
        }
        return zB;
    }

    public String g() {
        StringBuilder sb = new StringBuilder();
        Iterator it = this.f73185d.iterator();
        while (it.hasNext()) {
            sb.append((String) it.next());
            sb.append(this.f73184c);
        }
        return sb.toString();
    }

    public final void h() {
        synchronized (this.f73185d) {
            this.f73182a.edit().putString(this.f73183b, g()).commit();
        }
    }

    public final void i() {
        this.f73186e.execute(new Runnable() { // from class: com.google.firebase.messaging.a0
            @Override // java.lang.Runnable
            public final void run() {
                this.f73239a.h();
            }
        });
    }
}
