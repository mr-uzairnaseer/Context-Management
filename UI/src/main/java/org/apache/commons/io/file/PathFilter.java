package org.apache.commons.io.file;

import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

@FunctionalInterface
/* loaded from: classes6.dex */
public interface PathFilter {
    FileVisitResult a(Path path, BasicFileAttributes basicFileAttributes);
}
