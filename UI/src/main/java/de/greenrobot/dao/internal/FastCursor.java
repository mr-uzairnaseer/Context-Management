package de.greenrobot.dao.internal;

import android.content.ContentResolver;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.CursorWindow;
import android.database.DataSetObserver;
import android.net.Uri;
import android.os.Bundle;

/* loaded from: classes5.dex */
public final class FastCursor implements Cursor {

    /* renamed from: a, reason: collision with root package name */
    public final CursorWindow f76156a;

    /* renamed from: b, reason: collision with root package name */
    public int f76157b;

    /* renamed from: c, reason: collision with root package name */
    public final int f76158c;

    public FastCursor(CursorWindow cursorWindow) {
        this.f76156a = cursorWindow;
        this.f76158c = cursorWindow.getNumRows();
    }

    @Override // android.database.Cursor, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new UnsupportedOperationException();
    }

    @Override // android.database.Cursor
    public void copyStringToBuffer(int i3, CharArrayBuffer charArrayBuffer) {
        throw new UnsupportedOperationException();
    }

    @Override // android.database.Cursor
    public void deactivate() {
        throw new UnsupportedOperationException();
    }

    @Override // android.database.Cursor
    public byte[] getBlob(int i3) {
        return this.f76156a.getBlob(this.f76157b, i3);
    }

    @Override // android.database.Cursor
    public int getColumnCount() {
        throw new UnsupportedOperationException();
    }

    @Override // android.database.Cursor
    public int getColumnIndex(String str) {
        throw new UnsupportedOperationException();
    }

    @Override // android.database.Cursor
    public int getColumnIndexOrThrow(String str) {
        throw new UnsupportedOperationException();
    }

    @Override // android.database.Cursor
    public String getColumnName(int i3) {
        throw new UnsupportedOperationException();
    }

    @Override // android.database.Cursor
    public String[] getColumnNames() {
        throw new UnsupportedOperationException();
    }

    @Override // android.database.Cursor
    public int getCount() {
        return this.f76156a.getNumRows();
    }

    @Override // android.database.Cursor
    public double getDouble(int i3) {
        return this.f76156a.getDouble(this.f76157b, i3);
    }

    @Override // android.database.Cursor
    public Bundle getExtras() {
        throw new UnsupportedOperationException();
    }

    @Override // android.database.Cursor
    public float getFloat(int i3) {
        return this.f76156a.getFloat(this.f76157b, i3);
    }

    @Override // android.database.Cursor
    public int getInt(int i3) {
        return this.f76156a.getInt(this.f76157b, i3);
    }

    @Override // android.database.Cursor
    public long getLong(int i3) {
        return this.f76156a.getLong(this.f76157b, i3);
    }

    @Override // android.database.Cursor
    public Uri getNotificationUri() {
        return null;
    }

    @Override // android.database.Cursor
    public int getPosition() {
        return this.f76157b;
    }

    @Override // android.database.Cursor
    public short getShort(int i3) {
        return this.f76156a.getShort(this.f76157b, i3);
    }

    @Override // android.database.Cursor
    public String getString(int i3) {
        return this.f76156a.getString(this.f76157b, i3);
    }

    @Override // android.database.Cursor
    public int getType(int i3) {
        throw new UnsupportedOperationException();
    }

    @Override // android.database.Cursor
    public boolean getWantsAllOnMoveCalls() {
        throw new UnsupportedOperationException();
    }

    @Override // android.database.Cursor
    public boolean isAfterLast() {
        throw new UnsupportedOperationException();
    }

    @Override // android.database.Cursor
    public boolean isBeforeFirst() {
        throw new UnsupportedOperationException();
    }

    @Override // android.database.Cursor
    public boolean isClosed() {
        throw new UnsupportedOperationException();
    }

    @Override // android.database.Cursor
    public boolean isFirst() {
        return this.f76157b == 0;
    }

    @Override // android.database.Cursor
    public boolean isLast() {
        return this.f76157b == this.f76158c - 1;
    }

    @Override // android.database.Cursor
    public boolean isNull(int i3) {
        return this.f76156a.isNull(this.f76157b, i3);
    }

    @Override // android.database.Cursor
    public boolean move(int i3) {
        return moveToPosition(this.f76157b + i3);
    }

    @Override // android.database.Cursor
    public boolean moveToFirst() {
        this.f76157b = 0;
        return this.f76158c > 0;
    }

    @Override // android.database.Cursor
    public boolean moveToLast() {
        int i3 = this.f76158c;
        if (i3 <= 0) {
            return false;
        }
        this.f76157b = i3 - 1;
        return true;
    }

    @Override // android.database.Cursor
    public boolean moveToNext() {
        int i3 = this.f76157b;
        if (i3 >= this.f76158c - 1) {
            return false;
        }
        this.f76157b = i3 + 1;
        return true;
    }

    @Override // android.database.Cursor
    public boolean moveToPosition(int i3) {
        if (i3 < 0 || i3 >= this.f76158c) {
            return false;
        }
        this.f76157b = i3;
        return true;
    }

    @Override // android.database.Cursor
    public boolean moveToPrevious() {
        int i3 = this.f76157b;
        if (i3 <= 0) {
            return false;
        }
        this.f76157b = i3 - 1;
        return true;
    }

    @Override // android.database.Cursor
    public void registerContentObserver(ContentObserver contentObserver) {
        throw new UnsupportedOperationException();
    }

    @Override // android.database.Cursor
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        throw new UnsupportedOperationException();
    }

    @Override // android.database.Cursor
    public boolean requery() {
        throw new UnsupportedOperationException();
    }

    @Override // android.database.Cursor
    public Bundle respond(Bundle bundle) {
        throw new UnsupportedOperationException();
    }

    @Override // android.database.Cursor
    public void setNotificationUri(ContentResolver contentResolver, Uri uri) {
        throw new UnsupportedOperationException();
    }

    @Override // android.database.Cursor
    public void unregisterContentObserver(ContentObserver contentObserver) {
        throw new UnsupportedOperationException();
    }

    @Override // android.database.Cursor
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        throw new UnsupportedOperationException();
    }
}
