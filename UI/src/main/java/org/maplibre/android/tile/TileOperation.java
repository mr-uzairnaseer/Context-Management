package org.maplibre.android.tile;

/* loaded from: classes9.dex */
public enum TileOperation {
    RequestedFromCache,
    RequestedFromNetwork,
    LoadFromNetwork,
    LoadFromCache,
    StartParse,
    EndParse,
    Error,
    Cancelled,
    NullOp
}
