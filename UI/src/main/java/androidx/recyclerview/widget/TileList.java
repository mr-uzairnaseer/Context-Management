package androidx.recyclerview.widget;

import android.util.SparseArray;
import java.lang.reflect.Array;

/* loaded from: classes4.dex */
class TileList<T> {

    /* renamed from: a, reason: collision with root package name */
    public final SparseArray f48020a;

    /* renamed from: b, reason: collision with root package name */
    public Tile f48021b;

    public static class Tile<T> {

        /* renamed from: a, reason: collision with root package name */
        public final Object[] f48022a;

        /* renamed from: b, reason: collision with root package name */
        public int f48023b;

        /* renamed from: c, reason: collision with root package name */
        public int f48024c;

        /* renamed from: d, reason: collision with root package name */
        public Tile f48025d;

        public Tile(Class cls, int i3) {
            this.f48022a = (Object[]) Array.newInstance((Class<?>) cls, i3);
        }
    }

    public Tile a(Tile tile) {
        int iIndexOfKey = this.f48020a.indexOfKey(tile.f48023b);
        if (iIndexOfKey < 0) {
            this.f48020a.put(tile.f48023b, tile);
            return null;
        }
        Tile tile2 = (Tile) this.f48020a.valueAt(iIndexOfKey);
        this.f48020a.setValueAt(iIndexOfKey, tile);
        if (this.f48021b == tile2) {
            this.f48021b = tile;
        }
        return tile2;
    }

    public void b() {
        this.f48020a.clear();
    }

    public Tile c(int i3) {
        if (i3 < 0 || i3 >= this.f48020a.size()) {
            return null;
        }
        return (Tile) this.f48020a.valueAt(i3);
    }

    public Tile d(int i3) {
        Tile tile = (Tile) this.f48020a.get(i3);
        if (this.f48021b == tile) {
            this.f48021b = null;
        }
        this.f48020a.delete(i3);
        return tile;
    }

    public int e() {
        return this.f48020a.size();
    }
}
