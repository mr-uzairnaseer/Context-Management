package androidx.preference;

import java.util.Set;

/* loaded from: classes2.dex */
public abstract class PreferenceDataStore {
    public boolean a(String str, boolean z2) {
        return z2;
    }

    public int b(String str, int i3) {
        return i3;
    }

    public String c(String str, String str2) {
        return str2;
    }

    public Set d(String str, Set set) {
        return set;
    }

    public void e(String str, boolean z2) {
        throw new UnsupportedOperationException("Not implemented on this data store");
    }

    public void f(String str, int i3) {
        throw new UnsupportedOperationException("Not implemented on this data store");
    }

    public void g(String str, String str2) {
        throw new UnsupportedOperationException("Not implemented on this data store");
    }

    public void h(String str, Set set) {
        throw new UnsupportedOperationException("Not implemented on this data store");
    }
}
