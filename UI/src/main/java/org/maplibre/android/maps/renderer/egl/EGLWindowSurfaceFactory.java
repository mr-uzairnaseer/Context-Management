package org.maplibre.android.maps.renderer.egl;

import android.opengl.GLSurfaceView;
import android.util.Log;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

/* loaded from: classes9.dex */
public class EGLWindowSurfaceFactory implements GLSurfaceView.EGLWindowSurfaceFactory {
    @Override // android.opengl.GLSurfaceView.EGLWindowSurfaceFactory
    public EGLSurface createWindowSurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj) {
        if (eGLDisplay != null && eGLConfig != null && obj != null) {
            try {
                return egl10.eglCreateWindowSurface(eGLDisplay, eGLConfig, obj, null);
            } catch (Exception e3) {
                Log.e("EGLWindowSurfaceFactory", "eglCreateWindowSurface", e3);
            }
        }
        return null;
    }

    @Override // android.opengl.GLSurfaceView.EGLWindowSurfaceFactory
    public void destroySurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
        egl10.eglDestroySurface(eGLDisplay, eGLSurface);
    }
}
