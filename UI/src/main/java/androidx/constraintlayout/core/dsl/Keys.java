package androidx.constraintlayout.core.dsl;

import com.facebook.internal.security.CertificateUtil;
import java.util.Arrays;

/* loaded from: classes3.dex */
public class Keys {
    public void a(StringBuilder sb, String str, float f3) {
        if (Float.isNaN(f3)) {
            return;
        }
        sb.append(str);
        sb.append(CertificateUtil.DELIMITER);
        sb.append(f3);
        sb.append(",\n");
    }

    public void b(StringBuilder sb, String str, String str2) {
        if (str2 != null) {
            sb.append(str);
            sb.append(":'");
            sb.append(str2);
            sb.append("',\n");
        }
    }

    public void c(StringBuilder sb, String str, float[] fArr) {
        if (fArr != null) {
            sb.append(str);
            sb.append("percentWidth:");
            sb.append(Arrays.toString(fArr));
            sb.append(",\n");
        }
    }

    public void d(StringBuilder sb, String str, String[] strArr) {
        if (strArr != null) {
            sb.append(str);
            sb.append(CertificateUtil.DELIMITER);
            sb.append(e(strArr));
            sb.append(",\n");
        }
    }

    public String e(String[] strArr) {
        StringBuilder sb = new StringBuilder("[");
        int i3 = 0;
        while (i3 < strArr.length) {
            sb.append(i3 == 0 ? "'" : ",'");
            sb.append(strArr[i3]);
            sb.append("'");
            i3++;
        }
        sb.append("]");
        return sb.toString();
    }
}
