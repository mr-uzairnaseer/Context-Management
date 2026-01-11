package com.google.android.datatransport.runtime.scheduling.persistence;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
final class SchemaManager extends SQLiteOpenHelper {

    /* renamed from: c, reason: collision with root package name */
    public static final String f59369c = "INSERT INTO global_log_event_state VALUES (" + System.currentTimeMillis() + ")";

    /* renamed from: d, reason: collision with root package name */
    public static int f59370d = 7;

    /* renamed from: e, reason: collision with root package name */
    public static final Migration f59371e;

    /* renamed from: f, reason: collision with root package name */
    public static final Migration f59372f;

    /* renamed from: g, reason: collision with root package name */
    public static final Migration f59373g;

    /* renamed from: h, reason: collision with root package name */
    public static final Migration f59374h;

    /* renamed from: i, reason: collision with root package name */
    public static final Migration f59375i;

    /* renamed from: j, reason: collision with root package name */
    public static final Migration f59376j;

    /* renamed from: k, reason: collision with root package name */
    public static final Migration f59377k;

    /* renamed from: l, reason: collision with root package name */
    public static final List f59378l;

    /* renamed from: a, reason: collision with root package name */
    public final int f59379a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f59380b;

    public interface Migration {
        void a(SQLiteDatabase sQLiteDatabase);
    }

    static {
        Migration migration = new Migration() { // from class: com.google.android.datatransport.runtime.scheduling.persistence.b0
            @Override // com.google.android.datatransport.runtime.scheduling.persistence.SchemaManager.Migration
            public final void a(SQLiteDatabase sQLiteDatabase) throws SQLException {
                SchemaManager.a(sQLiteDatabase);
            }
        };
        f59371e = migration;
        Migration migration2 = new Migration() { // from class: com.google.android.datatransport.runtime.scheduling.persistence.c0
            @Override // com.google.android.datatransport.runtime.scheduling.persistence.SchemaManager.Migration
            public final void a(SQLiteDatabase sQLiteDatabase) throws SQLException {
                SchemaManager.g(sQLiteDatabase);
            }
        };
        f59372f = migration2;
        Migration migration3 = new Migration() { // from class: com.google.android.datatransport.runtime.scheduling.persistence.d0
            @Override // com.google.android.datatransport.runtime.scheduling.persistence.SchemaManager.Migration
            public final void a(SQLiteDatabase sQLiteDatabase) throws SQLException {
                sQLiteDatabase.execSQL("ALTER TABLE events ADD COLUMN payload_encoding TEXT");
            }
        };
        f59373g = migration3;
        Migration migration4 = new Migration() { // from class: com.google.android.datatransport.runtime.scheduling.persistence.e0
            @Override // com.google.android.datatransport.runtime.scheduling.persistence.SchemaManager.Migration
            public final void a(SQLiteDatabase sQLiteDatabase) throws SQLException {
                SchemaManager.i(sQLiteDatabase);
            }
        };
        f59374h = migration4;
        Migration migration5 = new Migration() { // from class: com.google.android.datatransport.runtime.scheduling.persistence.f0
            @Override // com.google.android.datatransport.runtime.scheduling.persistence.SchemaManager.Migration
            public final void a(SQLiteDatabase sQLiteDatabase) throws SQLException {
                SchemaManager.e(sQLiteDatabase);
            }
        };
        f59375i = migration5;
        Migration migration6 = new Migration() { // from class: com.google.android.datatransport.runtime.scheduling.persistence.g0
            @Override // com.google.android.datatransport.runtime.scheduling.persistence.SchemaManager.Migration
            public final void a(SQLiteDatabase sQLiteDatabase) throws SQLException {
                sQLiteDatabase.execSQL("ALTER TABLE events ADD COLUMN product_id INTEGER");
            }
        };
        f59376j = migration6;
        Migration migration7 = new Migration() { // from class: com.google.android.datatransport.runtime.scheduling.persistence.h0
            @Override // com.google.android.datatransport.runtime.scheduling.persistence.SchemaManager.Migration
            public final void a(SQLiteDatabase sQLiteDatabase) throws SQLException {
                SchemaManager.c(sQLiteDatabase);
            }
        };
        f59377k = migration7;
        f59378l = Arrays.asList(migration, migration2, migration3, migration4, migration5, migration6, migration7);
    }

    public SchemaManager(Context context, String str, int i3) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, i3);
        this.f59380b = false;
        this.f59379a = i3;
    }

    public static /* synthetic */ void a(SQLiteDatabase sQLiteDatabase) throws SQLException {
        sQLiteDatabase.execSQL("CREATE TABLE events (_id INTEGER PRIMARY KEY, context_id INTEGER NOT NULL, transport_name TEXT NOT NULL, timestamp_ms INTEGER NOT NULL, uptime_ms INTEGER NOT NULL, payload BLOB NOT NULL, code INTEGER, num_attempts INTEGER NOT NULL,FOREIGN KEY (context_id) REFERENCES transport_contexts(_id) ON DELETE CASCADE)");
        sQLiteDatabase.execSQL("CREATE TABLE event_metadata (_id INTEGER PRIMARY KEY, event_id INTEGER NOT NULL, name TEXT NOT NULL, value TEXT NOT NULL,FOREIGN KEY (event_id) REFERENCES events(_id) ON DELETE CASCADE)");
        sQLiteDatabase.execSQL("CREATE TABLE transport_contexts (_id INTEGER PRIMARY KEY, backend_name TEXT NOT NULL, priority INTEGER NOT NULL, next_request_ms INTEGER NOT NULL)");
        sQLiteDatabase.execSQL("CREATE INDEX events_backend_id on events(context_id)");
        sQLiteDatabase.execSQL("CREATE UNIQUE INDEX contexts_backend_priority on transport_contexts(backend_name, priority)");
    }

    public static /* synthetic */ void c(SQLiteDatabase sQLiteDatabase) throws SQLException {
        sQLiteDatabase.execSQL("ALTER TABLE events ADD COLUMN pseudonymous_id TEXT");
        sQLiteDatabase.execSQL("ALTER TABLE events ADD COLUMN experiment_ids_clear_blob BLOB");
        sQLiteDatabase.execSQL("ALTER TABLE events ADD COLUMN experiment_ids_encrypted_blob BLOB");
    }

    public static /* synthetic */ void e(SQLiteDatabase sQLiteDatabase) throws SQLException {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS log_event_dropped");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS global_log_event_state");
        sQLiteDatabase.execSQL("CREATE TABLE log_event_dropped (log_source VARCHAR(45) NOT NULL,reason INTEGER NOT NULL,events_dropped_count BIGINT NOT NULL,PRIMARY KEY(log_source, reason))");
        sQLiteDatabase.execSQL("CREATE TABLE global_log_event_state (last_metrics_upload_ms BIGINT PRIMARY KEY)");
        sQLiteDatabase.execSQL(f59369c);
    }

    public static /* synthetic */ void g(SQLiteDatabase sQLiteDatabase) throws SQLException {
        sQLiteDatabase.execSQL("ALTER TABLE transport_contexts ADD COLUMN extras BLOB");
        sQLiteDatabase.execSQL("CREATE UNIQUE INDEX contexts_backend_priority_extras on transport_contexts(backend_name, priority, extras)");
        sQLiteDatabase.execSQL("DROP INDEX contexts_backend_priority");
    }

    public static /* synthetic */ void i(SQLiteDatabase sQLiteDatabase) throws SQLException {
        sQLiteDatabase.execSQL("ALTER TABLE events ADD COLUMN inline BOOLEAN NOT NULL DEFAULT 1");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS event_payloads");
        sQLiteDatabase.execSQL("CREATE TABLE event_payloads (sequence_num INTEGER NOT NULL, event_id INTEGER NOT NULL, bytes BLOB NOT NULL,FOREIGN KEY (event_id) REFERENCES events(_id) ON DELETE CASCADE,PRIMARY KEY (sequence_num, event_id))");
    }

    public final void j(SQLiteDatabase sQLiteDatabase) {
        if (this.f59380b) {
            return;
        }
        onConfigure(sQLiteDatabase);
    }

    public final void m(SQLiteDatabase sQLiteDatabase, int i3) {
        j(sQLiteDatabase);
        n(sQLiteDatabase, 0, i3);
    }

    public final void n(SQLiteDatabase sQLiteDatabase, int i3, int i4) {
        List list = f59378l;
        if (i4 <= list.size()) {
            while (i3 < i4) {
                ((Migration) f59378l.get(i3)).a(sQLiteDatabase);
                i3++;
            }
            return;
        }
        throw new IllegalArgumentException("Migration from " + i3 + " to " + i4 + " was requested, but cannot be performed. Only " + list.size() + " migrations are provided");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onConfigure(SQLiteDatabase sQLiteDatabase) {
        this.f59380b = true;
        sQLiteDatabase.rawQuery("PRAGMA busy_timeout=0;", new String[0]).close();
        sQLiteDatabase.setForeignKeyConstraintsEnabled(true);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        m(sQLiteDatabase, this.f59379a);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i3, int i4) throws SQLException {
        sQLiteDatabase.execSQL("DROP TABLE events");
        sQLiteDatabase.execSQL("DROP TABLE event_metadata");
        sQLiteDatabase.execSQL("DROP TABLE transport_contexts");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS event_payloads");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS log_event_dropped");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS global_log_event_state");
        m(sQLiteDatabase, i4);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        j(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i3, int i4) {
        j(sQLiteDatabase);
        n(sQLiteDatabase, i3, i4);
    }
}
