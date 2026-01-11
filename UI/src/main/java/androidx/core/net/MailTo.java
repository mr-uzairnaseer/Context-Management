package androidx.core.net;

import android.net.Uri;
import java.util.HashMap;
import java.util.Map;
import kotlin.text.Typography;

/* loaded from: classes3.dex */
public final class MailTo {
    public static final String MAILTO_SCHEME = "mailto:";

    /* renamed from: a, reason: collision with root package name */
    public HashMap f33421a = new HashMap();

    private MailTo() {
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(MAILTO_SCHEME);
        sb.append('?');
        for (Map.Entry entry : this.f33421a.entrySet()) {
            sb.append(Uri.encode((String) entry.getKey()));
            sb.append('=');
            sb.append(Uri.encode((String) entry.getValue()));
            sb.append(Typography.amp);
        }
        return sb.toString();
    }
}
