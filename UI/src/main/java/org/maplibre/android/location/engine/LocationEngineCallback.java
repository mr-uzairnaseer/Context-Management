package org.maplibre.android.location.engine;

/* loaded from: classes9.dex */
public interface LocationEngineCallback<T> {
    void onFailure(Exception exc);

    void onSuccess(Object obj);
}
