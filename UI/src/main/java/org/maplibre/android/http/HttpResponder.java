package org.maplibre.android.http;

/* loaded from: classes8.dex */
public interface HttpResponder {
    void handleFailure(int i3, String str);

    void onResponse(int i3, String str, String str2, String str3, String str4, String str5, String str6, byte[] bArr);
}
