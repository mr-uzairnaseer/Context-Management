package org.apache.commons.lang3.text;

import java.util.Map;

@Deprecated
/* loaded from: classes7.dex */
public abstract class StrLookup<V> {

    /* renamed from: a, reason: collision with root package name */
    public static final StrLookup f162166a = new MapStrLookup(null);

    /* renamed from: b, reason: collision with root package name */
    public static final StrLookup f162167b = new SystemPropertiesStrLookup();

    public static class MapStrLookup<V> extends StrLookup<V> {

        /* renamed from: c, reason: collision with root package name */
        public final Map f162168c;

        public MapStrLookup(Map map) {
            this.f162168c = map;
        }
    }

    public static final class SystemPropertiesStrLookup extends StrLookup<String> {
        private SystemPropertiesStrLookup() {
        }
    }
}
