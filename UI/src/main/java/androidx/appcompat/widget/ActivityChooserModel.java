package androidx.appcompat.widget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.database.DataSetObservable;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import android.util.Xml;
import de.komoot.android.services.api.JsonKeywords;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* loaded from: classes2.dex */
class ActivityChooserModel extends DataSetObservable {
    public static final String DEFAULT_HISTORY_FILE_NAME = "activity_choser_model_history.xml";
    public static final int DEFAULT_HISTORY_MAX_LENGTH = 50;

    /* renamed from: n, reason: collision with root package name */
    public static final String f3238n = "ActivityChooserModel";

    /* renamed from: o, reason: collision with root package name */
    public static final Object f3239o = new Object();

    /* renamed from: p, reason: collision with root package name */
    public static final Map f3240p = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    public final Context f3244d;

    /* renamed from: e, reason: collision with root package name */
    public final String f3245e;

    /* renamed from: f, reason: collision with root package name */
    public Intent f3246f;

    /* renamed from: m, reason: collision with root package name */
    public OnChooseActivityListener f3253m;

    /* renamed from: a, reason: collision with root package name */
    public final Object f3241a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public final List f3242b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public final List f3243c = new ArrayList();

    /* renamed from: g, reason: collision with root package name */
    public ActivitySorter f3247g = new DefaultSorter();

    /* renamed from: h, reason: collision with root package name */
    public int f3248h = 50;

    /* renamed from: i, reason: collision with root package name */
    public boolean f3249i = true;

    /* renamed from: j, reason: collision with root package name */
    public boolean f3250j = false;

    /* renamed from: k, reason: collision with root package name */
    public boolean f3251k = true;

    /* renamed from: l, reason: collision with root package name */
    public boolean f3252l = false;

    public interface ActivityChooserModelClient {
    }

    public static final class ActivityResolveInfo implements Comparable<ActivityResolveInfo> {

        /* renamed from: a, reason: collision with root package name */
        public final ResolveInfo f3254a;

        /* renamed from: b, reason: collision with root package name */
        public float f3255b;

        public ActivityResolveInfo(ResolveInfo resolveInfo) {
            this.f3254a = resolveInfo;
        }

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(ActivityResolveInfo activityResolveInfo) {
            return Float.floatToIntBits(activityResolveInfo.f3255b) - Float.floatToIntBits(this.f3255b);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && ActivityResolveInfo.class == obj.getClass() && Float.floatToIntBits(this.f3255b) == Float.floatToIntBits(((ActivityResolveInfo) obj).f3255b);
        }

        public int hashCode() {
            return Float.floatToIntBits(this.f3255b) + 31;
        }

        public String toString() {
            return "[resolveInfo:" + this.f3254a.toString() + "; weight:" + new BigDecimal(this.f3255b) + "]";
        }
    }

    public interface ActivitySorter {
        void a(Intent intent, List list, List list2);
    }

    public static final class DefaultSorter implements ActivitySorter {

        /* renamed from: a, reason: collision with root package name */
        public final Map f3256a = new HashMap();

        @Override // androidx.appcompat.widget.ActivityChooserModel.ActivitySorter
        public void a(Intent intent, List list, List list2) {
            Map map = this.f3256a;
            map.clear();
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                ActivityResolveInfo activityResolveInfo = (ActivityResolveInfo) list.get(i3);
                activityResolveInfo.f3255b = 0.0f;
                ActivityInfo activityInfo = activityResolveInfo.f3254a.activityInfo;
                map.put(new ComponentName(activityInfo.packageName, activityInfo.name), activityResolveInfo);
            }
            float f3 = 1.0f;
            for (int size2 = list2.size() - 1; size2 >= 0; size2--) {
                HistoricalRecord historicalRecord = (HistoricalRecord) list2.get(size2);
                ActivityResolveInfo activityResolveInfo2 = (ActivityResolveInfo) map.get(historicalRecord.f3257a);
                if (activityResolveInfo2 != null) {
                    activityResolveInfo2.f3255b += historicalRecord.f3259c * f3;
                    f3 *= 0.95f;
                }
            }
            Collections.sort(list);
        }
    }

    public static final class HistoricalRecord {

        /* renamed from: a, reason: collision with root package name */
        public final ComponentName f3257a;

        /* renamed from: b, reason: collision with root package name */
        public final long f3258b;

        /* renamed from: c, reason: collision with root package name */
        public final float f3259c;

        public HistoricalRecord(String str, long j3, float f3) {
            this(ComponentName.unflattenFromString(str), j3, f3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || HistoricalRecord.class != obj.getClass()) {
                return false;
            }
            HistoricalRecord historicalRecord = (HistoricalRecord) obj;
            ComponentName componentName = this.f3257a;
            if (componentName == null) {
                if (historicalRecord.f3257a != null) {
                    return false;
                }
            } else if (!componentName.equals(historicalRecord.f3257a)) {
                return false;
            }
            return this.f3258b == historicalRecord.f3258b && Float.floatToIntBits(this.f3259c) == Float.floatToIntBits(historicalRecord.f3259c);
        }

        public int hashCode() {
            ComponentName componentName = this.f3257a;
            int iHashCode = componentName == null ? 0 : componentName.hashCode();
            long j3 = this.f3258b;
            return ((((iHashCode + 31) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31) + Float.floatToIntBits(this.f3259c);
        }

        public String toString() {
            return "[; activity:" + this.f3257a + "; time:" + this.f3258b + "; weight:" + new BigDecimal(this.f3259c) + "]";
        }

        public HistoricalRecord(ComponentName componentName, long j3, float f3) {
            this.f3257a = componentName;
            this.f3258b = j3;
            this.f3259c = f3;
        }
    }

    public interface OnChooseActivityListener {
        boolean a(ActivityChooserModel activityChooserModel, Intent intent);
    }

    public final class PersistHistoryAsyncTask extends AsyncTask<Object, Void, Void> {
        public PersistHistoryAsyncTask() {
        }

        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void doInBackground(Object... objArr) throws IOException {
            List list = (List) objArr[0];
            String str = (String) objArr[1];
            try {
                FileOutputStream fileOutputStreamOpenFileOutput = ActivityChooserModel.this.f3244d.openFileOutput(str, 0);
                XmlSerializer xmlSerializerNewSerializer = Xml.newSerializer();
                try {
                    try {
                        try {
                            try {
                                xmlSerializerNewSerializer.setOutput(fileOutputStreamOpenFileOutput, null);
                                xmlSerializerNewSerializer.startDocument("UTF-8", Boolean.TRUE);
                                xmlSerializerNewSerializer.startTag(null, "historical-records");
                                int size = list.size();
                                for (int i3 = 0; i3 < size; i3++) {
                                    HistoricalRecord historicalRecord = (HistoricalRecord) list.remove(0);
                                    xmlSerializerNewSerializer.startTag(null, "historical-record");
                                    xmlSerializerNewSerializer.attribute(null, "activity", historicalRecord.f3257a.flattenToString());
                                    xmlSerializerNewSerializer.attribute(null, JsonKeywords.TIME, String.valueOf(historicalRecord.f3258b));
                                    xmlSerializerNewSerializer.attribute(null, "weight", String.valueOf(historicalRecord.f3259c));
                                    xmlSerializerNewSerializer.endTag(null, "historical-record");
                                }
                                xmlSerializerNewSerializer.endTag(null, "historical-records");
                                xmlSerializerNewSerializer.endDocument();
                                ActivityChooserModel.this.f3249i = true;
                            } catch (IllegalArgumentException e3) {
                                Log.e(ActivityChooserModel.f3238n, "Error writing historical record file: " + ActivityChooserModel.this.f3245e, e3);
                                ActivityChooserModel.this.f3249i = true;
                                if (fileOutputStreamOpenFileOutput != null) {
                                }
                            }
                        } catch (IllegalStateException e4) {
                            Log.e(ActivityChooserModel.f3238n, "Error writing historical record file: " + ActivityChooserModel.this.f3245e, e4);
                            ActivityChooserModel.this.f3249i = true;
                            if (fileOutputStreamOpenFileOutput != null) {
                            }
                        }
                    } catch (IOException e5) {
                        Log.e(ActivityChooserModel.f3238n, "Error writing historical record file: " + ActivityChooserModel.this.f3245e, e5);
                        ActivityChooserModel.this.f3249i = true;
                        if (fileOutputStreamOpenFileOutput != null) {
                        }
                    }
                    if (fileOutputStreamOpenFileOutput != null) {
                        try {
                            fileOutputStreamOpenFileOutput.close();
                        } catch (IOException unused) {
                        }
                    }
                    return null;
                } catch (Throwable th) {
                    ActivityChooserModel.this.f3249i = true;
                    if (fileOutputStreamOpenFileOutput != null) {
                        try {
                            fileOutputStreamOpenFileOutput.close();
                        } catch (IOException unused2) {
                        }
                    }
                    throw th;
                }
            } catch (FileNotFoundException e6) {
                Log.e(ActivityChooserModel.f3238n, "Error writing historical record file: " + str, e6);
                return null;
            }
        }
    }

    public ActivityChooserModel(Context context, String str) {
        this.f3244d = context.getApplicationContext();
        if (TextUtils.isEmpty(str) || str.endsWith(".xml")) {
            this.f3245e = str;
            return;
        }
        this.f3245e = str + ".xml";
    }

    public static ActivityChooserModel d(Context context, String str) {
        ActivityChooserModel activityChooserModel;
        synchronized (f3239o) {
            try {
                Map map = f3240p;
                activityChooserModel = (ActivityChooserModel) map.get(str);
                if (activityChooserModel == null) {
                    activityChooserModel = new ActivityChooserModel(context, str);
                    map.put(str, activityChooserModel);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return activityChooserModel;
    }

    public final boolean a(HistoricalRecord historicalRecord) {
        boolean zAdd = this.f3243c.add(historicalRecord);
        if (zAdd) {
            this.f3251k = true;
            l();
            k();
            p();
            notifyChanged();
        }
        return zAdd;
    }

    public Intent b(int i3) {
        synchronized (this.f3241a) {
            try {
                if (this.f3246f == null) {
                    return null;
                }
                c();
                ActivityInfo activityInfo = ((ActivityResolveInfo) this.f3242b.get(i3)).f3254a.activityInfo;
                ComponentName componentName = new ComponentName(activityInfo.packageName, activityInfo.name);
                Intent intent = new Intent(this.f3246f);
                intent.setComponent(componentName);
                if (this.f3253m != null) {
                    if (this.f3253m.a(this, new Intent(intent))) {
                        return null;
                    }
                }
                a(new HistoricalRecord(componentName, System.currentTimeMillis(), 1.0f));
                return intent;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void c() {
        boolean zJ = j() | m();
        l();
        if (zJ) {
            p();
            notifyChanged();
        }
    }

    public ResolveInfo e(int i3) {
        ResolveInfo resolveInfo;
        synchronized (this.f3241a) {
            c();
            resolveInfo = ((ActivityResolveInfo) this.f3242b.get(i3)).f3254a;
        }
        return resolveInfo;
    }

    public int f() {
        int size;
        synchronized (this.f3241a) {
            c();
            size = this.f3242b.size();
        }
        return size;
    }

    public int g(ResolveInfo resolveInfo) {
        synchronized (this.f3241a) {
            try {
                c();
                List list = this.f3242b;
                int size = list.size();
                for (int i3 = 0; i3 < size; i3++) {
                    if (((ActivityResolveInfo) list.get(i3)).f3254a == resolveInfo) {
                        return i3;
                    }
                }
                return -1;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public ResolveInfo h() {
        synchronized (this.f3241a) {
            try {
                c();
                if (this.f3242b.isEmpty()) {
                    return null;
                }
                return ((ActivityResolveInfo) this.f3242b.get(0)).f3254a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public int i() {
        int size;
        synchronized (this.f3241a) {
            c();
            size = this.f3243c.size();
        }
        return size;
    }

    public final boolean j() {
        if (!this.f3252l || this.f3246f == null) {
            return false;
        }
        this.f3252l = false;
        this.f3242b.clear();
        List<ResolveInfo> listQueryIntentActivities = this.f3244d.getPackageManager().queryIntentActivities(this.f3246f, 0);
        int size = listQueryIntentActivities.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.f3242b.add(new ActivityResolveInfo(listQueryIntentActivities.get(i3)));
        }
        return true;
    }

    public final void k() {
        if (!this.f3250j) {
            throw new IllegalStateException("No preceding call to #readHistoricalData");
        }
        if (this.f3251k) {
            this.f3251k = false;
            if (TextUtils.isEmpty(this.f3245e)) {
                return;
            }
            new PersistHistoryAsyncTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new ArrayList(this.f3243c), this.f3245e);
        }
    }

    public final void l() {
        int size = this.f3243c.size() - this.f3248h;
        if (size <= 0) {
            return;
        }
        this.f3251k = true;
        for (int i3 = 0; i3 < size; i3++) {
        }
    }

    public final boolean m() throws IOException {
        if (!this.f3249i || !this.f3251k || TextUtils.isEmpty(this.f3245e)) {
            return false;
        }
        this.f3249i = false;
        this.f3250j = true;
        n();
        return true;
    }

    public final void n() throws IOException {
        try {
            FileInputStream fileInputStreamOpenFileInput = this.f3244d.openFileInput(this.f3245e);
            try {
                try {
                    XmlPullParser xmlPullParserNewPullParser = Xml.newPullParser();
                    xmlPullParserNewPullParser.setInput(fileInputStreamOpenFileInput, "UTF-8");
                    for (int next = 0; next != 1 && next != 2; next = xmlPullParserNewPullParser.next()) {
                    }
                    if (!"historical-records".equals(xmlPullParserNewPullParser.getName())) {
                        throw new XmlPullParserException("Share records file does not start with historical-records tag.");
                    }
                    List list = this.f3243c;
                    list.clear();
                    while (true) {
                        int next2 = xmlPullParserNewPullParser.next();
                        if (next2 == 1) {
                            if (fileInputStreamOpenFileInput != null) {
                                fileInputStreamOpenFileInput.close();
                                return;
                            }
                            return;
                        } else if (next2 != 3 && next2 != 4) {
                            if (!"historical-record".equals(xmlPullParserNewPullParser.getName())) {
                                throw new XmlPullParserException("Share records file not well-formed.");
                            }
                            list.add(new HistoricalRecord(xmlPullParserNewPullParser.getAttributeValue(null, "activity"), Long.parseLong(xmlPullParserNewPullParser.getAttributeValue(null, JsonKeywords.TIME)), Float.parseFloat(xmlPullParserNewPullParser.getAttributeValue(null, "weight"))));
                        }
                    }
                } catch (IOException e3) {
                    Log.e(f3238n, "Error reading historical recrod file: " + this.f3245e, e3);
                    if (fileInputStreamOpenFileInput == null) {
                        return;
                    }
                    fileInputStreamOpenFileInput.close();
                } catch (XmlPullParserException e4) {
                    Log.e(f3238n, "Error reading historical recrod file: " + this.f3245e, e4);
                    if (fileInputStreamOpenFileInput == null) {
                        return;
                    }
                    fileInputStreamOpenFileInput.close();
                }
            } catch (Throwable th) {
                if (fileInputStreamOpenFileInput != null) {
                    try {
                        fileInputStreamOpenFileInput.close();
                    } catch (IOException unused) {
                    }
                }
                throw th;
            }
        } catch (FileNotFoundException | IOException unused2) {
        }
    }

    public void o(int i3) {
        synchronized (this.f3241a) {
            try {
                c();
                ActivityResolveInfo activityResolveInfo = (ActivityResolveInfo) this.f3242b.get(i3);
                ActivityResolveInfo activityResolveInfo2 = (ActivityResolveInfo) this.f3242b.get(0);
                float f3 = activityResolveInfo2 != null ? (activityResolveInfo2.f3255b - activityResolveInfo.f3255b) + 5.0f : 1.0f;
                ActivityInfo activityInfo = activityResolveInfo.f3254a.activityInfo;
                a(new HistoricalRecord(new ComponentName(activityInfo.packageName, activityInfo.name), System.currentTimeMillis(), f3));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean p() {
        if (this.f3247g == null || this.f3246f == null || this.f3242b.isEmpty() || this.f3243c.isEmpty()) {
            return false;
        }
        this.f3247g.a(this.f3246f, this.f3242b, Collections.unmodifiableList(this.f3243c));
        return true;
    }
}
