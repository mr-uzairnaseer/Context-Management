package org.maplibre.android.location.engine;

import android.location.Location;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes9.dex */
public final class LocationEngineResult {

    /* renamed from: a, reason: collision with root package name */
    public final List f164784a;

    public LocationEngineResult(List list) {
        this.f164784a = Collections.unmodifiableList(list);
    }

    public static LocationEngineResult a(Location location) {
        ArrayList arrayList = new ArrayList();
        if (location != null) {
            arrayList.add(location);
        }
        return new LocationEngineResult(arrayList);
    }

    public Location b() {
        if (this.f164784a.isEmpty()) {
            return null;
        }
        return (Location) this.f164784a.get(0);
    }
}
