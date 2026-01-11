package org.apache.commons.io;

import java.io.FileFilter;
import java.io.IOException;

@Deprecated
/* loaded from: classes6.dex */
public abstract class DirectoryWalker<T> {

    /* renamed from: a, reason: collision with root package name */
    public final FileFilter f161334a;

    /* renamed from: b, reason: collision with root package name */
    public final int f161335b;

    public static class CancelException extends IOException {
    }

    public DirectoryWalker() {
        this(null, -1);
    }

    public DirectoryWalker(FileFilter fileFilter, int i3) {
        this.f161334a = fileFilter;
        this.f161335b = i3;
    }
}
