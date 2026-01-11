package androidx.transition;

import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes4.dex */
public class TransitionValues {

    /* renamed from: b, reason: collision with root package name */
    public View f48847b;

    /* renamed from: a, reason: collision with root package name */
    public final Map f48846a = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f48848c = new ArrayList();

    @Deprecated
    public TransitionValues() {
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof TransitionValues)) {
            return false;
        }
        TransitionValues transitionValues = (TransitionValues) obj;
        return this.f48847b == transitionValues.f48847b && this.f48846a.equals(transitionValues.f48846a);
    }

    public int hashCode() {
        return (this.f48847b.hashCode() * 31) + this.f48846a.hashCode();
    }

    public String toString() {
        String str = (("TransitionValues@" + Integer.toHexString(hashCode()) + ":\n") + "    view = " + this.f48847b + StringUtils.LF) + "    values:";
        for (String str2 : this.f48846a.keySet()) {
            str = str + "    " + str2 + ": " + this.f48846a.get(str2) + StringUtils.LF;
        }
        return str;
    }

    public TransitionValues(View view) {
        this.f48847b = view;
    }
}
