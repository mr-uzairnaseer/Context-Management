package androidx.core.util;

import android.util.Log;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SyncFailedException;

/* loaded from: classes3.dex */
public class AtomicFile {

    /* renamed from: a, reason: collision with root package name */
    public final File f33623a;

    /* renamed from: b, reason: collision with root package name */
    public final File f33624b;

    /* renamed from: c, reason: collision with root package name */
    public final File f33625c;

    public AtomicFile(File file) {
        this.f33623a = file;
        this.f33624b = new File(file.getPath() + ".new");
        this.f33625c = new File(file.getPath() + ".bak");
    }

    public static void c(File file, File file2) {
        if (file2.isDirectory() && !file2.delete()) {
            Log.e("AtomicFile", "Failed to delete file which is a directory " + file2);
        }
        if (file.renameTo(file2)) {
            return;
        }
        Log.e("AtomicFile", "Failed to rename " + file + " to " + file2);
    }

    public static boolean e(FileOutputStream fileOutputStream) throws SyncFailedException {
        try {
            fileOutputStream.getFD().sync();
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    public void a(FileOutputStream fileOutputStream) throws IOException {
        if (fileOutputStream == null) {
            return;
        }
        if (!e(fileOutputStream)) {
            Log.e("AtomicFile", "Failed to sync file output stream");
        }
        try {
            fileOutputStream.close();
        } catch (IOException e3) {
            Log.e("AtomicFile", "Failed to close file output stream", e3);
        }
        if (this.f33624b.delete()) {
            return;
        }
        Log.e("AtomicFile", "Failed to delete new file " + this.f33624b);
    }

    public void b(FileOutputStream fileOutputStream) throws IOException {
        if (fileOutputStream == null) {
            return;
        }
        if (!e(fileOutputStream)) {
            Log.e("AtomicFile", "Failed to sync file output stream");
        }
        try {
            fileOutputStream.close();
        } catch (IOException e3) {
            Log.e("AtomicFile", "Failed to close file output stream", e3);
        }
        c(this.f33624b, this.f33623a);
    }

    public FileOutputStream d() throws IOException {
        if (this.f33625c.exists()) {
            c(this.f33625c, this.f33623a);
        }
        try {
            return new FileOutputStream(this.f33624b);
        } catch (FileNotFoundException unused) {
            if (!this.f33624b.getParentFile().mkdirs()) {
                throw new IOException("Failed to create directory for " + this.f33624b);
            }
            try {
                return new FileOutputStream(this.f33624b);
            } catch (FileNotFoundException e3) {
                throw new IOException("Failed to create new file " + this.f33624b, e3);
            }
        }
    }
}
