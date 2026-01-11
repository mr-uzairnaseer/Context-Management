package freemarker.cache;

import com.facebook.share.internal.ShareInternalUtility;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLConnection;

/* loaded from: classes8.dex */
class URLTemplateSource {

    /* renamed from: a, reason: collision with root package name */
    public final URL f149130a;

    /* renamed from: b, reason: collision with root package name */
    public URLConnection f149131b;

    /* renamed from: c, reason: collision with root package name */
    public InputStream f149132c;

    /* renamed from: d, reason: collision with root package name */
    public Boolean f149133d;

    public URLTemplateSource(URL url, Boolean bool) throws IOException {
        this.f149130a = url;
        URLConnection uRLConnectionOpenConnection = url.openConnection();
        this.f149131b = uRLConnectionOpenConnection;
        this.f149133d = bool;
        if (bool != null) {
            uRLConnectionOpenConnection.setUseCaches(bool.booleanValue());
        }
    }

    public void a() {
        try {
            InputStream inputStream = this.f149132c;
            if (inputStream != null) {
                inputStream.close();
            } else {
                this.f149131b.getInputStream().close();
            }
            this.f149132c = null;
            this.f149131b = null;
        } catch (Throwable th) {
            this.f149132c = null;
            this.f149131b = null;
            throw th;
        }
    }

    public InputStream b() throws IOException {
        InputStream inputStream = this.f149132c;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
            this.f149131b = this.f149130a.openConnection();
        }
        InputStream inputStream2 = this.f149131b.getInputStream();
        this.f149132c = inputStream2;
        return inputStream2;
    }

    public Boolean c() {
        return this.f149133d;
    }

    public long d() throws IOException {
        URLConnection uRLConnection = this.f149131b;
        if (!(uRLConnection instanceof JarURLConnection)) {
            long lastModified = uRLConnection.getLastModified();
            return (lastModified == -1 && this.f149130a.getProtocol().equals(ShareInternalUtility.STAGING_PARAM)) ? new File(this.f149130a.getFile()).lastModified() : lastModified;
        }
        URL jarFileURL = ((JarURLConnection) uRLConnection).getJarFileURL();
        if (jarFileURL.getProtocol().equals(ShareInternalUtility.STAGING_PARAM)) {
            return new File(jarFileURL.getFile()).lastModified();
        }
        URLConnection uRLConnectionOpenConnection = null;
        try {
            uRLConnectionOpenConnection = jarFileURL.openConnection();
            long lastModified2 = uRLConnectionOpenConnection.getLastModified();
            try {
                uRLConnectionOpenConnection.getInputStream().close();
            } catch (IOException unused) {
            }
            return lastModified2;
        } catch (IOException unused2) {
            if (uRLConnectionOpenConnection != null) {
                try {
                    uRLConnectionOpenConnection.getInputStream().close();
                } catch (IOException unused3) {
                }
            }
            return -1L;
        } catch (Throwable th) {
            if (uRLConnectionOpenConnection != null) {
                try {
                    uRLConnectionOpenConnection.getInputStream().close();
                } catch (IOException unused4) {
                }
            }
            throw th;
        }
    }

    public void e(boolean z2) {
        URLConnection uRLConnection = this.f149131b;
        if (uRLConnection != null) {
            uRLConnection.setUseCaches(z2);
            this.f149133d = Boolean.valueOf(z2);
        }
    }

    public boolean equals(Object obj) {
        if (obj instanceof URLTemplateSource) {
            return this.f149130a.equals(((URLTemplateSource) obj).f149130a);
        }
        return false;
    }

    public int hashCode() {
        return this.f149130a.hashCode();
    }

    public String toString() {
        return this.f149130a.toString();
    }
}
