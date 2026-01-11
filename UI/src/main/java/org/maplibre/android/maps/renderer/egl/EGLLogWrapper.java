package org.maplibre.android.maps.renderer.egl;

import android.opengl.GLException;
import java.io.IOException;
import java.io.Writer;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGL11;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

/* loaded from: classes9.dex */
public class EGLLogWrapper implements EGL11 {

    /* renamed from: a, reason: collision with root package name */
    public EGL10 f165108a;

    /* renamed from: b, reason: collision with root package name */
    public Writer f165109b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f165110c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f165111d;

    /* renamed from: e, reason: collision with root package name */
    public int f165112e;

    public static String m(int i3) {
        switch (i3) {
            case 12288:
                return "EGL_SUCCESS";
            case 12289:
                return "EGL_NOT_INITIALIZED";
            case 12290:
                return "EGL_BAD_ACCESS";
            case 12291:
                return "EGL_BAD_ALLOC";
            case 12292:
                return "EGL_BAD_ATTRIBUTE";
            case 12293:
                return "EGL_BAD_CONFIG";
            case 12294:
                return "EGL_BAD_CONTEXT";
            case 12295:
                return "EGL_BAD_CURRENT_SURFACE";
            case 12296:
                return "EGL_BAD_DISPLAY";
            case 12297:
                return "EGL_BAD_MATCH";
            case 12298:
                return "EGL_BAD_NATIVE_PIXMAP";
            case 12299:
                return "EGL_BAD_NATIVE_WINDOW";
            case 12300:
                return "EGL_BAD_PARAMETER";
            case 12301:
                return "EGL_BAD_SURFACE";
            case 12302:
                return "EGL_CONTEXT_LOST";
            default:
                return n(i3);
        }
    }

    public static String n(int i3) {
        return "0x" + Integer.toHexString(i3);
    }

    public final void a(String str, int i3) throws IOException {
        c(str, Integer.toString(i3));
    }

    public final void b(String str, Object obj) throws IOException {
        c(str, w(obj));
    }

    public final void c(String str, String str2) throws IOException {
        int i3 = this.f165112e;
        this.f165112e = i3 + 1;
        if (i3 > 0) {
            o(", ");
        }
        if (this.f165110c) {
            o(str + "=");
        }
        o(str2);
    }

    public final void d(String str, EGLContext eGLContext) throws IOException {
        if (eGLContext == EGL10.EGL_NO_CONTEXT) {
            c(str, "EGL10.EGL_NO_CONTEXT");
        } else {
            c(str, w(eGLContext));
        }
    }

    public final void e(String str, EGLDisplay eGLDisplay) throws IOException {
        if (eGLDisplay == EGL10.EGL_DEFAULT_DISPLAY) {
            c(str, "EGL10.EGL_DEFAULT_DISPLAY");
        } else if (eGLDisplay == EGL11.EGL_NO_DISPLAY) {
            c(str, "EGL10.EGL_NO_DISPLAY");
        } else {
            c(str, w(eGLDisplay));
        }
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglChooseConfig(EGLDisplay eGLDisplay, int[] iArr, EGLConfig[] eGLConfigArr, int i3, int[] iArr2) throws IOException {
        i("eglChooseConfig");
        e("display", eGLDisplay);
        g("attrib_list", iArr);
        a("config_size", i3);
        k();
        boolean zEglChooseConfig = this.f165108a.eglChooseConfig(eGLDisplay, iArr, eGLConfigArr, i3, iArr2);
        h("configs", eGLConfigArr);
        g("num_config", iArr2);
        t(zEglChooseConfig);
        j();
        return zEglChooseConfig;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglCopyBuffers(EGLDisplay eGLDisplay, EGLSurface eGLSurface, Object obj) throws IOException {
        i("eglCopyBuffers");
        e("display", eGLDisplay);
        f("surface", eGLSurface);
        b("native_pixmap", obj);
        k();
        boolean zEglCopyBuffers = this.f165108a.eglCopyBuffers(eGLDisplay, eGLSurface, obj);
        t(zEglCopyBuffers);
        j();
        return zEglCopyBuffers;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLContext eglCreateContext(EGLDisplay eGLDisplay, EGLConfig eGLConfig, EGLContext eGLContext, int[] iArr) throws IOException {
        i("eglCreateContext");
        e("display", eGLDisplay);
        b("config", eGLConfig);
        d("share_context", eGLContext);
        g("attrib_list", iArr);
        k();
        EGLContext eGLContextEglCreateContext = this.f165108a.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        r(eGLContextEglCreateContext);
        j();
        return eGLContextEglCreateContext;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLSurface eglCreatePbufferSurface(EGLDisplay eGLDisplay, EGLConfig eGLConfig, int[] iArr) throws IOException {
        i("eglCreatePbufferSurface");
        e("display", eGLDisplay);
        b("config", eGLConfig);
        g("attrib_list", iArr);
        k();
        EGLSurface eGLSurfaceEglCreatePbufferSurface = this.f165108a.eglCreatePbufferSurface(eGLDisplay, eGLConfig, iArr);
        r(eGLSurfaceEglCreatePbufferSurface);
        j();
        return eGLSurfaceEglCreatePbufferSurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLSurface eglCreatePixmapSurface(EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj, int[] iArr) throws IOException {
        i("eglCreatePixmapSurface");
        e("display", eGLDisplay);
        b("config", eGLConfig);
        b("native_pixmap", obj);
        g("attrib_list", iArr);
        k();
        EGLSurface eGLSurfaceEglCreatePixmapSurface = this.f165108a.eglCreatePixmapSurface(eGLDisplay, eGLConfig, obj, iArr);
        r(eGLSurfaceEglCreatePixmapSurface);
        j();
        return eGLSurfaceEglCreatePixmapSurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLSurface eglCreateWindowSurface(EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj, int[] iArr) throws IOException {
        i("eglCreateWindowSurface");
        e("display", eGLDisplay);
        b("config", eGLConfig);
        b("native_window", obj);
        g("attrib_list", iArr);
        k();
        EGLSurface eGLSurfaceEglCreateWindowSurface = this.f165108a.eglCreateWindowSurface(eGLDisplay, eGLConfig, obj, iArr);
        r(eGLSurfaceEglCreateWindowSurface);
        j();
        return eGLSurfaceEglCreateWindowSurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglDestroyContext(EGLDisplay eGLDisplay, EGLContext eGLContext) throws IOException {
        i("eglDestroyContext");
        e("display", eGLDisplay);
        d("context", eGLContext);
        k();
        boolean zEglDestroyContext = this.f165108a.eglDestroyContext(eGLDisplay, eGLContext);
        t(zEglDestroyContext);
        j();
        return zEglDestroyContext;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglDestroySurface(EGLDisplay eGLDisplay, EGLSurface eGLSurface) throws IOException {
        i("eglDestroySurface");
        e("display", eGLDisplay);
        f("surface", eGLSurface);
        k();
        boolean zEglDestroySurface = this.f165108a.eglDestroySurface(eGLDisplay, eGLSurface);
        t(zEglDestroySurface);
        j();
        return zEglDestroySurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglGetConfigAttrib(EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i3, int[] iArr) throws IOException {
        i("eglGetConfigAttrib");
        e("display", eGLDisplay);
        b("config", eGLConfig);
        a("attribute", i3);
        k();
        boolean zEglGetConfigAttrib = this.f165108a.eglGetConfigAttrib(eGLDisplay, eGLConfig, i3, iArr);
        g("value", iArr);
        t(zEglGetConfigAttrib);
        j();
        return false;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglGetConfigs(EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr, int i3, int[] iArr) throws IOException {
        i("eglGetConfigs");
        e("display", eGLDisplay);
        a("config_size", i3);
        k();
        boolean zEglGetConfigs = this.f165108a.eglGetConfigs(eGLDisplay, eGLConfigArr, i3, iArr);
        h("configs", eGLConfigArr);
        g("num_config", iArr);
        t(zEglGetConfigs);
        j();
        return zEglGetConfigs;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLContext eglGetCurrentContext() throws IOException {
        i("eglGetCurrentContext");
        k();
        EGLContext eGLContextEglGetCurrentContext = this.f165108a.eglGetCurrentContext();
        r(eGLContextEglGetCurrentContext);
        j();
        return eGLContextEglGetCurrentContext;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLDisplay eglGetCurrentDisplay() throws IOException {
        i("eglGetCurrentDisplay");
        k();
        EGLDisplay eGLDisplayEglGetCurrentDisplay = this.f165108a.eglGetCurrentDisplay();
        r(eGLDisplayEglGetCurrentDisplay);
        j();
        return eGLDisplayEglGetCurrentDisplay;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLSurface eglGetCurrentSurface(int i3) throws IOException {
        i("eglGetCurrentSurface");
        a("readdraw", i3);
        k();
        EGLSurface eGLSurfaceEglGetCurrentSurface = this.f165108a.eglGetCurrentSurface(i3);
        r(eGLSurfaceEglGetCurrentSurface);
        j();
        return eGLSurfaceEglGetCurrentSurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLDisplay eglGetDisplay(Object obj) throws IOException {
        i("eglGetDisplay");
        b("native_display", obj);
        k();
        EGLDisplay eGLDisplayEglGetDisplay = this.f165108a.eglGetDisplay(obj);
        r(eGLDisplayEglGetDisplay);
        j();
        return eGLDisplayEglGetDisplay;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public int eglGetError() throws IOException {
        i("eglGetError");
        k();
        int iEglGetError = this.f165108a.eglGetError();
        s(m(iEglGetError));
        return iEglGetError;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglInitialize(EGLDisplay eGLDisplay, int[] iArr) throws IOException {
        i("eglInitialize");
        e("display", eGLDisplay);
        k();
        boolean zEglInitialize = this.f165108a.eglInitialize(eGLDisplay, iArr);
        t(zEglInitialize);
        g("major_minor", iArr);
        j();
        return zEglInitialize;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglMakeCurrent(EGLDisplay eGLDisplay, EGLSurface eGLSurface, EGLSurface eGLSurface2, EGLContext eGLContext) throws IOException {
        i("eglMakeCurrent");
        e("display", eGLDisplay);
        f("draw", eGLSurface);
        f("read", eGLSurface2);
        d("context", eGLContext);
        k();
        boolean zEglMakeCurrent = this.f165108a.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface2, eGLContext);
        t(zEglMakeCurrent);
        j();
        return zEglMakeCurrent;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglQueryContext(EGLDisplay eGLDisplay, EGLContext eGLContext, int i3, int[] iArr) throws IOException {
        i("eglQueryContext");
        e("display", eGLDisplay);
        d("context", eGLContext);
        a("attribute", i3);
        k();
        boolean zEglQueryContext = this.f165108a.eglQueryContext(eGLDisplay, eGLContext, i3, iArr);
        q(iArr[0]);
        t(zEglQueryContext);
        j();
        return zEglQueryContext;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public String eglQueryString(EGLDisplay eGLDisplay, int i3) throws IOException {
        i("eglQueryString");
        e("display", eGLDisplay);
        a("name", i3);
        k();
        String strEglQueryString = this.f165108a.eglQueryString(eGLDisplay, i3);
        s(strEglQueryString);
        j();
        return strEglQueryString;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglQuerySurface(EGLDisplay eGLDisplay, EGLSurface eGLSurface, int i3, int[] iArr) throws IOException {
        i("eglQuerySurface");
        e("display", eGLDisplay);
        f("surface", eGLSurface);
        a("attribute", i3);
        k();
        boolean zEglQuerySurface = this.f165108a.eglQuerySurface(eGLDisplay, eGLSurface, i3, iArr);
        q(iArr[0]);
        t(zEglQuerySurface);
        j();
        return zEglQuerySurface;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglSwapBuffers(EGLDisplay eGLDisplay, EGLSurface eGLSurface) throws IOException {
        i("eglSwapBuffers");
        e("display", eGLDisplay);
        f("surface", eGLSurface);
        k();
        boolean zEglSwapBuffers = this.f165108a.eglSwapBuffers(eGLDisplay, eGLSurface);
        t(zEglSwapBuffers);
        j();
        return zEglSwapBuffers;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglTerminate(EGLDisplay eGLDisplay) throws IOException {
        i("eglTerminate");
        e("display", eGLDisplay);
        k();
        boolean zEglTerminate = this.f165108a.eglTerminate(eGLDisplay);
        t(zEglTerminate);
        j();
        return zEglTerminate;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglWaitGL() throws IOException {
        i("eglWaitGL");
        k();
        boolean zEglWaitGL = this.f165108a.eglWaitGL();
        t(zEglWaitGL);
        j();
        return zEglWaitGL;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public boolean eglWaitNative(int i3, Object obj) throws IOException {
        i("eglWaitNative");
        a("engine", i3);
        b("bindTarget", obj);
        k();
        boolean zEglWaitNative = this.f165108a.eglWaitNative(i3, obj);
        t(zEglWaitNative);
        j();
        return zEglWaitNative;
    }

    public final void f(String str, EGLSurface eGLSurface) throws IOException {
        if (eGLSurface == EGL10.EGL_NO_SURFACE) {
            c(str, "EGL10.EGL_NO_SURFACE");
        } else {
            c(str, w(eGLSurface));
        }
    }

    public final void g(String str, int[] iArr) throws IOException {
        if (iArr == null) {
            c(str, "null");
        } else {
            c(str, u(iArr.length, iArr, 0));
        }
    }

    public final void h(String str, Object[] objArr) throws IOException {
        if (objArr == null) {
            c(str, "null");
        } else {
            c(str, v(objArr.length, objArr, 0));
        }
    }

    public final void i(String str) throws IOException {
        o(str + '(');
        this.f165112e = 0;
    }

    public final void j() throws IOException {
        int iEglGetError = this.f165108a.eglGetError();
        if (iEglGetError != 12288) {
            String str = "eglError: " + m(iEglGetError);
            p(str);
            if (this.f165111d) {
                throw new GLException(iEglGetError, str);
            }
        }
    }

    public final void k() throws IOException {
        o(");\n");
        l();
    }

    public final void l() throws IOException {
        try {
            this.f165109b.flush();
        } catch (IOException unused) {
            this.f165109b = null;
        }
    }

    public final void o(String str) throws IOException {
        try {
            this.f165109b.write(str);
        } catch (IOException unused) {
        }
    }

    public final void p(String str) throws IOException {
        o(str + '\n');
    }

    public final void q(int i3) throws IOException {
        s(Integer.toString(i3));
    }

    public final void r(Object obj) throws IOException {
        s(w(obj));
    }

    public final void s(String str) throws IOException {
        o(" returns " + str + ";\n");
        l();
    }

    public final void t(boolean z2) throws IOException {
        s(Boolean.toString(z2));
    }

    public final String u(int i3, int[] iArr, int i4) {
        StringBuilder sb = new StringBuilder();
        sb.append("{\n");
        int length = iArr.length;
        for (int i5 = 0; i5 < i3; i5++) {
            int i6 = i4 + i5;
            sb.append(" [" + i6 + "] = ");
            if (i6 < 0 || i6 >= length) {
                sb.append("out of bounds");
            } else {
                sb.append(iArr[i6]);
            }
            sb.append('\n');
        }
        sb.append("}");
        return sb.toString();
    }

    public final String v(int i3, Object[] objArr, int i4) {
        StringBuilder sb = new StringBuilder();
        sb.append("{\n");
        int length = objArr.length;
        for (int i5 = 0; i5 < i3; i5++) {
            int i6 = i4 + i5;
            sb.append(" [" + i6 + "] = ");
            if (i6 < 0 || i6 >= length) {
                sb.append("out of bounds");
            } else {
                sb.append(objArr[i6]);
            }
            sb.append('\n');
        }
        sb.append("}");
        return sb.toString();
    }

    public final String w(Object obj) {
        return obj == null ? "null" : obj.toString();
    }
}
