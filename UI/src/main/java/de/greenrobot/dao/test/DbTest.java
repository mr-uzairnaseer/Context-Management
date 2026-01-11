package de.greenrobot.dao.test;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;
import android.test.AndroidTestCase;
import java.util.Random;

/* loaded from: classes5.dex */
public abstract class DbTest extends AndroidTestCase {
    public static final String DB_NAME = "greendao-unittest-db.temp";

    /* renamed from: a, reason: collision with root package name */
    public final Random f76216a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f76217b;

    /* renamed from: c, reason: collision with root package name */
    public SQLiteDatabase f76218c;

    /* renamed from: d, reason: collision with root package name */
    public Application f76219d;

    public DbTest() {
        this(true);
    }

    public SQLiteDatabase a() {
        if (this.f76217b) {
            return SQLiteDatabase.create(null);
        }
        getContext().deleteDatabase(DB_NAME);
        return getContext().openOrCreateDatabase(DB_NAME, 0, null);
    }

    public void b() {
        AndroidTestCase.assertNotNull("Application not yet created", this.f76219d);
        this.f76219d.onTerminate();
        this.f76219d = null;
    }

    public void setUp() {
        super.setUp();
        this.f76218c = a();
    }

    public void tearDown() {
        if (this.f76219d != null) {
            b();
        }
        this.f76218c.close();
        if (!this.f76217b) {
            getContext().deleteDatabase(DB_NAME);
        }
        super.tearDown();
    }

    public DbTest(boolean z2) {
        this.f76217b = z2;
        this.f76216a = new Random();
    }
}
