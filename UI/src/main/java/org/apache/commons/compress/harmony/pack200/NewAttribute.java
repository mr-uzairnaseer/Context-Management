package org.apache.commons.compress.harmony.pack200;

import org.objectweb.asm.Attribute;

/* loaded from: classes5.dex */
public class NewAttribute extends Attribute {

    /* renamed from: a, reason: collision with root package name */
    public boolean f161064a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f161065b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f161066c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f161067d;

    /* renamed from: e, reason: collision with root package name */
    public final String f161068e;

    public static class ErrorAttribute extends NewAttribute {
        public ErrorAttribute(String str, int i3) {
            super(str, "", i3);
        }
    }

    public static class PassAttribute extends NewAttribute {
        public PassAttribute(String str, int i3) {
            super(str, "", i3);
        }
    }

    public static class StripAttribute extends NewAttribute {
        public StripAttribute(String str, int i3) {
            super(str, "", i3);
        }
    }

    public NewAttribute(String str, String str2, int i3) {
        super(str);
        this.f161068e = str2;
        a(i3);
    }

    public void a(int i3) {
        if (i3 == 0) {
            this.f161064a = true;
            return;
        }
        if (i3 == 1) {
            this.f161066c = true;
        } else if (i3 == 2) {
            this.f161065b = true;
        } else {
            if (i3 != 3) {
                return;
            }
            this.f161067d = true;
        }
    }

    public String b() {
        return this.f161068e;
    }

    public boolean c() {
        return this.f161064a;
    }

    public boolean d() {
        return this.f161067d;
    }

    public boolean e() {
        return this.f161066c;
    }

    public boolean f() {
        return this.f161065b;
    }
}
