package org.maplibre.android.attribution;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes8.dex */
public class Attribution {

    /* renamed from: c, reason: collision with root package name */
    public static final List f164400c;

    /* renamed from: a, reason: collision with root package name */
    public String f164401a;

    /* renamed from: b, reason: collision with root package name */
    public String f164402b;

    static {
        ArrayList arrayList = new ArrayList();
        f164400c = arrayList;
        arrayList.add("https://www.mapbox.com/feedback/");
        arrayList.add("https://www.mapbox.com/map-feedback/");
        arrayList.add("https://apps.mapbox.com/feedback/");
    }

    public Attribution(String str, String str2) {
        this.f164401a = str;
        this.f164402b = str2;
    }

    public String a() {
        return this.f164401a;
    }

    public String b() {
        return this.f164401a.equals("OpenStreetMap") ? "OSM" : this.f164401a;
    }

    public String c() {
        return this.f164402b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            Attribution attribution = (Attribution) obj;
            String str = this.f164401a;
            if (str == null ? attribution.f164401a != null : !str.equals(attribution.f164401a)) {
                return false;
            }
            String str2 = this.f164402b;
            String str3 = attribution.f164402b;
            if (str2 != null) {
                return str2.equals(str3);
            }
            if (str3 == null) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.f164401a;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f164402b;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }
}
