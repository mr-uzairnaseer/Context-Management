package freemarker.template;

import java.io.FileNotFoundException;

/* loaded from: classes8.dex */
public final class TemplateNotFoundException extends FileNotFoundException {

    /* renamed from: a, reason: collision with root package name */
    public final String f150675a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f150676b;

    public TemplateNotFoundException(String str, Object obj, String str2) {
        super(str2);
        this.f150675a = str;
        this.f150676b = obj;
    }
}
