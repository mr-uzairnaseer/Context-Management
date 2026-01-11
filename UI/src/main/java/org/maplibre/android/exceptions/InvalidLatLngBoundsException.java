package org.maplibre.android.exceptions;

/* loaded from: classes8.dex */
public class InvalidLatLngBoundsException extends RuntimeException {
    public InvalidLatLngBoundsException(int i3) {
        super("Cannot create a LatLngBounds from " + i3 + " items");
    }
}
