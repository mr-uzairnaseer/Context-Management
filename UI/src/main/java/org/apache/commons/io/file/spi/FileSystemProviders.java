package org.apache.commons.io.file.spi;

import java.nio.file.spi.FileSystemProvider;
import java.util.Collections;
import java.util.List;

/* loaded from: classes6.dex */
public class FileSystemProviders {

    /* renamed from: b, reason: collision with root package name */
    public static final FileSystemProviders f161422b = new FileSystemProviders(FileSystemProvider.installedProviders());

    /* renamed from: a, reason: collision with root package name */
    public final List f161423a;

    public FileSystemProviders(List list) {
        this.f161423a = list == null ? Collections.EMPTY_LIST : list;
    }
}
