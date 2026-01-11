package javax.xml.namespace;

import java.io.Serializable;

/* loaded from: classes8.dex */
public class QName implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public String f152280a;

    /* renamed from: b, reason: collision with root package name */
    public String f152281b;

    /* renamed from: c, reason: collision with root package name */
    public String f152282c;

    public QName(String str) {
        this("", str);
    }

    public String a() {
        return this.f152281b;
    }

    public String b() {
        return this.f152280a;
    }

    public String c() {
        return this.f152282c;
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof QName)) {
            return false;
        }
        QName qName = (QName) obj;
        return this.f152281b.equals(qName.f152281b) && this.f152280a.equals(qName.f152280a);
    }

    public final int hashCode() {
        return this.f152280a.hashCode() ^ this.f152281b.hashCode();
    }

    public String toString() {
        if (this.f152280a.equals("")) {
            return this.f152281b;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("{");
        stringBuffer.append(this.f152280a);
        stringBuffer.append("}");
        stringBuffer.append(this.f152281b);
        return stringBuffer.toString();
    }

    public QName(String str, String str2) {
        this(str, str2, "");
    }

    public QName(String str, String str2, String str3) {
        if (str2 != null) {
            str = str == null ? "" : str;
            str3 = str3 == null ? "" : str3;
            this.f152280a = str;
            this.f152281b = str2;
            this.f152282c = str3;
            return;
        }
        throw new IllegalArgumentException("Local part not allowed to be null");
    }
}
