package org.apache.commons.compress.harmony.pack200;

import org.objectweb.asm.ClassReader;

/* loaded from: classes5.dex */
public class Pack200ClassReader extends ClassReader {

    /* renamed from: a, reason: collision with root package name */
    public String f161104a;

    public Pack200ClassReader(byte[] bArr) {
        super(bArr);
    }

    public String a() {
        return this.f161104a;
    }

    public void b(String str) {
        this.f161104a = str;
    }
}
