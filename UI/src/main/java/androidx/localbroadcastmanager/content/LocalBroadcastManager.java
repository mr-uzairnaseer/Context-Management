package androidx.localbroadcastmanager.content;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

@Deprecated
/* loaded from: classes.dex */
public final class LocalBroadcastManager {

    /* renamed from: f, reason: collision with root package name */
    public static final Object f36738f = new Object();

    /* renamed from: g, reason: collision with root package name */
    public static LocalBroadcastManager f36739g;

    /* renamed from: a, reason: collision with root package name */
    public final Context f36740a;

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f36741b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f36742c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList f36743d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    public final Handler f36744e;

    /* loaded from: classes3.dex */
    public static final class BroadcastRecord {

        /* renamed from: a, reason: collision with root package name */
        public final Intent f36746a;

        /* renamed from: b, reason: collision with root package name */
        public final ArrayList f36747b;

        public BroadcastRecord(Intent intent, ArrayList arrayList) {
            this.f36746a = intent;
            this.f36747b = arrayList;
        }
    }

    public static final class ReceiverRecord {

        /* renamed from: a, reason: collision with root package name */
        public final IntentFilter f36748a;

        /* renamed from: b, reason: collision with root package name */
        public final BroadcastReceiver f36749b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f36750c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f36751d;

        public ReceiverRecord(IntentFilter intentFilter, BroadcastReceiver broadcastReceiver) {
            this.f36748a = intentFilter;
            this.f36749b = broadcastReceiver;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(128);
            sb.append("Receiver{");
            sb.append(this.f36749b);
            sb.append(" filter=");
            sb.append(this.f36748a);
            if (this.f36751d) {
                sb.append(" DEAD");
            }
            sb.append("}");
            return sb.toString();
        }
    }

    public LocalBroadcastManager(Context context) {
        this.f36740a = context;
        this.f36744e = new Handler(context.getMainLooper()) { // from class: androidx.localbroadcastmanager.content.LocalBroadcastManager.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what != 1) {
                    super.handleMessage(message);
                } else {
                    LocalBroadcastManager.this.a();
                }
            }
        };
    }

    public static LocalBroadcastManager b(Context context) {
        LocalBroadcastManager localBroadcastManager;
        synchronized (f36738f) {
            try {
                if (f36739g == null) {
                    f36739g = new LocalBroadcastManager(context.getApplicationContext());
                }
                localBroadcastManager = f36739g;
            } catch (Throwable th) {
                throw th;
            }
        }
        return localBroadcastManager;
    }

    public void a() {
        int size;
        BroadcastRecord[] broadcastRecordArr;
        while (true) {
            synchronized (this.f36741b) {
                try {
                    size = this.f36743d.size();
                    if (size <= 0) {
                        return;
                    }
                    broadcastRecordArr = new BroadcastRecord[size];
                    this.f36743d.toArray(broadcastRecordArr);
                    this.f36743d.clear();
                } catch (Throwable th) {
                    throw th;
                }
            }
            for (int i3 = 0; i3 < size; i3++) {
                BroadcastRecord broadcastRecord = broadcastRecordArr[i3];
                int size2 = broadcastRecord.f36747b.size();
                for (int i4 = 0; i4 < size2; i4++) {
                    ReceiverRecord receiverRecord = (ReceiverRecord) broadcastRecord.f36747b.get(i4);
                    if (!receiverRecord.f36751d) {
                        receiverRecord.f36749b.onReceive(this.f36740a, broadcastRecord.f36746a);
                    }
                }
            }
        }
    }

    public void c(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        synchronized (this.f36741b) {
            try {
                ReceiverRecord receiverRecord = new ReceiverRecord(intentFilter, broadcastReceiver);
                ArrayList arrayList = (ArrayList) this.f36741b.get(broadcastReceiver);
                if (arrayList == null) {
                    arrayList = new ArrayList(1);
                    this.f36741b.put(broadcastReceiver, arrayList);
                }
                arrayList.add(receiverRecord);
                for (int i3 = 0; i3 < intentFilter.countActions(); i3++) {
                    String action = intentFilter.getAction(i3);
                    ArrayList arrayList2 = (ArrayList) this.f36742c.get(action);
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList(1);
                        this.f36742c.put(action, arrayList2);
                    }
                    arrayList2.add(receiverRecord);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean d(Intent intent) {
        String str;
        synchronized (this.f36741b) {
            try {
                String action = intent.getAction();
                String strResolveTypeIfNeeded = intent.resolveTypeIfNeeded(this.f36740a.getContentResolver());
                Uri data = intent.getData();
                String scheme = intent.getScheme();
                Set<String> categories = intent.getCategories();
                boolean z2 = (intent.getFlags() & 8) != 0;
                if (z2) {
                    Log.v("LocalBroadcastManager", "Resolving type " + strResolveTypeIfNeeded + " scheme " + scheme + " of intent " + intent);
                }
                ArrayList arrayList = (ArrayList) this.f36742c.get(intent.getAction());
                if (arrayList != null) {
                    if (z2) {
                        Log.v("LocalBroadcastManager", "Action list: " + arrayList);
                    }
                    ArrayList arrayList2 = null;
                    int i3 = 0;
                    while (i3 < arrayList.size()) {
                        ReceiverRecord receiverRecord = (ReceiverRecord) arrayList.get(i3);
                        if (z2) {
                            Log.v("LocalBroadcastManager", "Matching against filter " + receiverRecord.f36748a);
                        }
                        if (receiverRecord.f36750c) {
                            if (z2) {
                                Log.v("LocalBroadcastManager", "  Filter's target already added");
                            }
                            str = action;
                        } else {
                            int iMatch = receiverRecord.f36748a.match(action, strResolveTypeIfNeeded, scheme, data, categories, "LocalBroadcastManager");
                            if (iMatch >= 0) {
                                if (z2) {
                                    StringBuilder sb = new StringBuilder();
                                    str = action;
                                    sb.append("  Filter matched!  match=0x");
                                    sb.append(Integer.toHexString(iMatch));
                                    Log.v("LocalBroadcastManager", sb.toString());
                                } else {
                                    str = action;
                                }
                                if (arrayList2 == null) {
                                    arrayList2 = new ArrayList();
                                }
                                arrayList2.add(receiverRecord);
                                receiverRecord.f36750c = true;
                            } else {
                                str = action;
                                if (z2) {
                                    Log.v("LocalBroadcastManager", "  Filter did not match: " + (iMatch != -4 ? iMatch != -3 ? iMatch != -2 ? iMatch != -1 ? "unknown reason" : "type" : "data" : "action" : "category"));
                                }
                            }
                        }
                        i3++;
                        action = str;
                    }
                    if (arrayList2 != null) {
                        for (int i4 = 0; i4 < arrayList2.size(); i4++) {
                            ((ReceiverRecord) arrayList2.get(i4)).f36750c = false;
                        }
                        this.f36743d.add(new BroadcastRecord(intent, arrayList2));
                        if (!this.f36744e.hasMessages(1)) {
                            this.f36744e.sendEmptyMessage(1);
                        }
                        return true;
                    }
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void e(BroadcastReceiver broadcastReceiver) {
        synchronized (this.f36741b) {
            try {
                ArrayList arrayList = (ArrayList) this.f36741b.remove(broadcastReceiver);
                if (arrayList == null) {
                    return;
                }
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    ReceiverRecord receiverRecord = (ReceiverRecord) arrayList.get(size);
                    receiverRecord.f36751d = true;
                    for (int i3 = 0; i3 < receiverRecord.f36748a.countActions(); i3++) {
                        String action = receiverRecord.f36748a.getAction(i3);
                        ArrayList arrayList2 = (ArrayList) this.f36742c.get(action);
                        if (arrayList2 != null) {
                            for (int size2 = arrayList2.size() - 1; size2 >= 0; size2--) {
                                ReceiverRecord receiverRecord2 = (ReceiverRecord) arrayList2.get(size2);
                                if (receiverRecord2.f36749b == broadcastReceiver) {
                                    receiverRecord2.f36751d = true;
                                    arrayList2.remove(size2);
                                }
                            }
                            if (arrayList2.size() <= 0) {
                                this.f36742c.remove(action);
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
