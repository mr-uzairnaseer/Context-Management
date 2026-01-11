package androidx.cursoradapter.widget;

import android.database.Cursor;
import android.widget.Filter;

/* loaded from: classes3.dex */
class CursorFilter extends Filter {

    /* renamed from: a, reason: collision with root package name */
    public CursorFilterClient f34411a;

    public interface CursorFilterClient {
        void a(Cursor cursor);

        Cursor b();

        Cursor c(CharSequence charSequence);

        CharSequence convertToString(Cursor cursor);
    }

    public CursorFilter(CursorFilterClient cursorFilterClient) {
        this.f34411a = cursorFilterClient;
    }

    @Override // android.widget.Filter
    public CharSequence convertResultToString(Object obj) {
        return this.f34411a.convertToString((Cursor) obj);
    }

    @Override // android.widget.Filter
    public Filter.FilterResults performFiltering(CharSequence charSequence) {
        Cursor cursorC = this.f34411a.c(charSequence);
        Filter.FilterResults filterResults = new Filter.FilterResults();
        if (cursorC != null) {
            filterResults.count = cursorC.getCount();
            filterResults.values = cursorC;
            return filterResults;
        }
        filterResults.count = 0;
        filterResults.values = null;
        return filterResults;
    }

    @Override // android.widget.Filter
    public void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
        Cursor cursorB = this.f34411a.b();
        Object obj = filterResults.values;
        if (obj == null || obj == cursorB) {
            return;
        }
        this.f34411a.a((Cursor) obj);
    }
}
