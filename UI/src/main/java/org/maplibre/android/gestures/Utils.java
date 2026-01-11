package org.maplibre.android.gestures;

import android.graphics.PointF;
import android.view.MotionEvent;

/* loaded from: classes8.dex */
public class Utils {
    public static PointF a(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        float x2 = 0.0f;
        float y2 = 0.0f;
        for (int i3 = 0; i3 < pointerCount; i3++) {
            x2 += motionEvent.getX(i3);
            y2 += motionEvent.getY(i3);
        }
        float f3 = pointerCount;
        return new PointF(x2 / f3, y2 / f3);
    }

    public static float b(MotionEvent motionEvent, int i3) {
        float rawX = motionEvent.getRawX() - motionEvent.getX();
        if (i3 < motionEvent.getPointerCount()) {
            return motionEvent.getX(i3) + rawX;
        }
        return 0.0f;
    }

    public static float c(MotionEvent motionEvent, int i3) {
        float rawY = motionEvent.getRawY() - motionEvent.getY();
        if (i3 < motionEvent.getPointerCount()) {
            return motionEvent.getY(i3) + rawY;
        }
        return 0.0f;
    }
}
