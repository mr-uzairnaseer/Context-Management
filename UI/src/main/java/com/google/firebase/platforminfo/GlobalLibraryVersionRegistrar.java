package com.google.firebase.platforminfo;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public class GlobalLibraryVersionRegistrar {

    /* renamed from: b, reason: collision with root package name */
    public static volatile GlobalLibraryVersionRegistrar f73674b;

    /* renamed from: a, reason: collision with root package name */
    public final Set f73675a = new HashSet();

    public static GlobalLibraryVersionRegistrar a() {
        GlobalLibraryVersionRegistrar globalLibraryVersionRegistrar;
        GlobalLibraryVersionRegistrar globalLibraryVersionRegistrar2 = f73674b;
        if (globalLibraryVersionRegistrar2 != null) {
            return globalLibraryVersionRegistrar2;
        }
        synchronized (GlobalLibraryVersionRegistrar.class) {
            try {
                globalLibraryVersionRegistrar = f73674b;
                if (globalLibraryVersionRegistrar == null) {
                    globalLibraryVersionRegistrar = new GlobalLibraryVersionRegistrar();
                    f73674b = globalLibraryVersionRegistrar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return globalLibraryVersionRegistrar;
    }

    public Set b() {
        Set setUnmodifiableSet;
        synchronized (this.f73675a) {
            setUnmodifiableSet = Collections.unmodifiableSet(this.f73675a);
        }
        return setUnmodifiableSet;
    }
}
