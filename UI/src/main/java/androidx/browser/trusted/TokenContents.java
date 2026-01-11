package androidx.browser.trusted;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
final class TokenContents {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f4146a;

    /* renamed from: b, reason: collision with root package name */
    public String f4147b;

    /* renamed from: c, reason: collision with root package name */
    public List f4148c;

    public TokenContents(byte[] bArr, String str, List list) {
        this.f4146a = bArr;
        this.f4147b = str;
        this.f4148c = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            byte[] bArr2 = (byte[]) it.next();
            this.f4148c.add(Arrays.copyOf(bArr2, bArr2.length));
        }
    }

    public static int b(byte[] bArr, byte[] bArr2) {
        if (bArr == bArr2) {
            return 0;
        }
        if (bArr == null) {
            return -1;
        }
        if (bArr2 == null) {
            return 1;
        }
        for (int i3 = 0; i3 < Math.min(bArr.length, bArr2.length); i3++) {
            byte b3 = bArr[i3];
            byte b4 = bArr2[i3];
            if (b3 != b4) {
                return b3 - b4;
            }
        }
        if (bArr.length != bArr2.length) {
            return bArr.length - bArr2.length;
        }
        return 0;
    }

    public static TokenContents c(String str, List list) {
        return new TokenContents(d(str, list), str, list);
    }

    public static byte[] d(String str, List list) throws IOException {
        Collections.sort(list, new Comparator() { // from class: androidx.browser.trusted.a
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return TokenContents.b((byte[]) obj, (byte[]) obj2);
            }
        });
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        dataOutputStream.writeUTF(str);
        dataOutputStream.writeInt(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            byte[] bArr = (byte[]) it.next();
            dataOutputStream.writeInt(bArr.length);
            dataOutputStream.write(bArr);
        }
        dataOutputStream.flush();
        return byteArrayOutputStream.toByteArray();
    }

    public byte[] e(int i3) throws IOException {
        g();
        List list = this.f4148c;
        if (list != null) {
            return Arrays.copyOf((byte[]) list.get(i3), ((byte[]) this.f4148c.get(i3)).length);
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || TokenContents.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.f4146a, ((TokenContents) obj).f4146a);
    }

    public String f() throws IOException {
        g();
        String str = this.f4147b;
        if (str != null) {
            return str;
        }
        throw new IllegalStateException();
    }

    public final void g() throws IOException {
        if (this.f4147b != null) {
            return;
        }
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(this.f4146a));
        this.f4147b = dataInputStream.readUTF();
        int i3 = dataInputStream.readInt();
        this.f4148c = new ArrayList(i3);
        for (int i4 = 0; i4 < i3; i4++) {
            int i5 = dataInputStream.readInt();
            byte[] bArr = new byte[i5];
            if (dataInputStream.read(bArr) != i5) {
                throw new IllegalStateException("Could not read fingerprint");
            }
            this.f4148c.add(bArr);
        }
    }

    public int hashCode() {
        return Arrays.hashCode(this.f4146a);
    }
}
