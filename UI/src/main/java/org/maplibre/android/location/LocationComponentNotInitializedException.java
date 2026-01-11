package org.maplibre.android.location;

/* loaded from: classes9.dex */
final class LocationComponentNotInitializedException extends RuntimeException {
    public LocationComponentNotInitializedException() {
        super("The LocationComponent has to be activated with one of the LocationComponent#activateLocationComponent overloads before any other methods are invoked.");
    }
}
