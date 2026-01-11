package com.google.android.material.color;

import android.content.Context;
import android.util.Pair;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes4.dex */
final class ColorResourcesTableCreator {

    /* renamed from: a, reason: collision with root package name */
    public static byte f65313a;

    /* renamed from: b, reason: collision with root package name */
    public static final PackageInfo f65314b = new PackageInfo(1, "android");

    /* renamed from: c, reason: collision with root package name */
    public static final Comparator f65315c = new Comparator<ColorResource>() { // from class: com.google.android.material.color.ColorResourcesTableCreator.1
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(ColorResource colorResource, ColorResource colorResource2) {
            return colorResource.f65318c - colorResource2.f65318c;
        }
    };

    public static class ColorResource {

        /* renamed from: a, reason: collision with root package name */
        public final byte f65316a;

        /* renamed from: b, reason: collision with root package name */
        public final byte f65317b;

        /* renamed from: c, reason: collision with root package name */
        public final short f65318c;

        /* renamed from: d, reason: collision with root package name */
        public final String f65319d;

        /* renamed from: e, reason: collision with root package name */
        public final int f65320e;

        public ColorResource(int i3, String str, int i4) {
            this.f65319d = str;
            this.f65320e = i4;
            this.f65318c = (short) (65535 & i3);
            this.f65317b = (byte) ((i3 >> 16) & 255);
            this.f65316a = (byte) ((i3 >> 24) & 255);
        }
    }

    public static class PackageChunk {

        /* renamed from: a, reason: collision with root package name */
        public final ResChunkHeader f65321a;

        /* renamed from: b, reason: collision with root package name */
        public final PackageInfo f65322b;

        /* renamed from: c, reason: collision with root package name */
        public final StringPoolChunk f65323c = new StringPoolChunk(false, "?1", "?2", "?3", "?4", "?5", "color");

        /* renamed from: d, reason: collision with root package name */
        public final StringPoolChunk f65324d;

        /* renamed from: e, reason: collision with root package name */
        public final TypeSpecChunk f65325e;

        public PackageChunk(PackageInfo packageInfo, List list) {
            this.f65322b = packageInfo;
            String[] strArr = new String[list.size()];
            for (int i3 = 0; i3 < list.size(); i3++) {
                strArr[i3] = ((ColorResource) list.get(i3)).f65319d;
            }
            this.f65324d = new StringPoolChunk(true, strArr);
            this.f65325e = new TypeSpecChunk(list);
            this.f65321a = new ResChunkHeader((short) 512, (short) 288, a());
        }

        public int a() {
            return this.f65323c.a() + 288 + this.f65324d.a() + this.f65325e.b();
        }

        public void b(ByteArrayOutputStream byteArrayOutputStream) throws IOException {
            this.f65321a.a(byteArrayOutputStream);
            byteArrayOutputStream.write(ColorResourcesTableCreator.j(this.f65322b.f65326a));
            char[] charArray = this.f65322b.f65327b.toCharArray();
            for (int i3 = 0; i3 < 128; i3++) {
                if (i3 < charArray.length) {
                    byteArrayOutputStream.write(ColorResourcesTableCreator.h(charArray[i3]));
                } else {
                    byteArrayOutputStream.write(ColorResourcesTableCreator.h((char) 0));
                }
            }
            byteArrayOutputStream.write(ColorResourcesTableCreator.j(288));
            byteArrayOutputStream.write(ColorResourcesTableCreator.j(0));
            byteArrayOutputStream.write(ColorResourcesTableCreator.j(this.f65323c.a() + 288));
            byteArrayOutputStream.write(ColorResourcesTableCreator.j(0));
            byteArrayOutputStream.write(ColorResourcesTableCreator.j(0));
            this.f65323c.c(byteArrayOutputStream);
            this.f65324d.c(byteArrayOutputStream);
            this.f65325e.c(byteArrayOutputStream);
        }
    }

    public static class PackageInfo {

        /* renamed from: a, reason: collision with root package name */
        public final int f65326a;

        /* renamed from: b, reason: collision with root package name */
        public final String f65327b;

        public PackageInfo(int i3, String str) {
            this.f65326a = i3;
            this.f65327b = str;
        }
    }

    public static class ResChunkHeader {

        /* renamed from: a, reason: collision with root package name */
        public final short f65328a;

        /* renamed from: b, reason: collision with root package name */
        public final short f65329b;

        /* renamed from: c, reason: collision with root package name */
        public final int f65330c;

        public ResChunkHeader(short s2, short s3, int i3) {
            this.f65328a = s2;
            this.f65329b = s3;
            this.f65330c = i3;
        }

        public void a(ByteArrayOutputStream byteArrayOutputStream) throws IOException {
            byteArrayOutputStream.write(ColorResourcesTableCreator.k(this.f65328a));
            byteArrayOutputStream.write(ColorResourcesTableCreator.k(this.f65329b));
            byteArrayOutputStream.write(ColorResourcesTableCreator.j(this.f65330c));
        }
    }

    public static class ResEntry {

        /* renamed from: a, reason: collision with root package name */
        public final int f65331a;

        /* renamed from: b, reason: collision with root package name */
        public final int f65332b;

        public ResEntry(int i3, int i4) {
            this.f65331a = i3;
            this.f65332b = i4;
        }

        public void a(ByteArrayOutputStream byteArrayOutputStream) throws IOException {
            byteArrayOutputStream.write(ColorResourcesTableCreator.k((short) 8));
            byteArrayOutputStream.write(ColorResourcesTableCreator.k((short) 2));
            byteArrayOutputStream.write(ColorResourcesTableCreator.j(this.f65331a));
            byteArrayOutputStream.write(ColorResourcesTableCreator.k((short) 8));
            byteArrayOutputStream.write(new byte[]{0, Ascii.FS});
            byteArrayOutputStream.write(ColorResourcesTableCreator.j(this.f65332b));
        }
    }

    public static class ResTable {

        /* renamed from: a, reason: collision with root package name */
        public final ResChunkHeader f65333a;

        /* renamed from: b, reason: collision with root package name */
        public final int f65334b;

        /* renamed from: d, reason: collision with root package name */
        public final List f65336d = new ArrayList();

        /* renamed from: c, reason: collision with root package name */
        public final StringPoolChunk f65335c = new StringPoolChunk(new String[0]);

        public ResTable(Map map) {
            this.f65334b = map.size();
            for (Map.Entry entry : map.entrySet()) {
                List list = (List) entry.getValue();
                Collections.sort(list, ColorResourcesTableCreator.f65315c);
                this.f65336d.add(new PackageChunk((PackageInfo) entry.getKey(), list));
            }
            this.f65333a = new ResChunkHeader((short) 2, (short) 12, a());
        }

        public final int a() {
            Iterator it = this.f65336d.iterator();
            int iA = 0;
            while (it.hasNext()) {
                iA += ((PackageChunk) it.next()).a();
            }
            return this.f65335c.a() + 12 + iA;
        }

        public void b(ByteArrayOutputStream byteArrayOutputStream) throws IOException {
            this.f65333a.a(byteArrayOutputStream);
            byteArrayOutputStream.write(ColorResourcesTableCreator.j(this.f65334b));
            this.f65335c.c(byteArrayOutputStream);
            Iterator it = this.f65336d.iterator();
            while (it.hasNext()) {
                ((PackageChunk) it.next()).b(byteArrayOutputStream);
            }
        }
    }

    public static class StringPoolChunk {

        /* renamed from: a, reason: collision with root package name */
        public final ResChunkHeader f65337a;

        /* renamed from: b, reason: collision with root package name */
        public final int f65338b;

        /* renamed from: c, reason: collision with root package name */
        public final int f65339c;

        /* renamed from: d, reason: collision with root package name */
        public final int f65340d;

        /* renamed from: e, reason: collision with root package name */
        public final int f65341e;

        /* renamed from: f, reason: collision with root package name */
        public final List f65342f;

        /* renamed from: g, reason: collision with root package name */
        public final List f65343g;

        /* renamed from: h, reason: collision with root package name */
        public final List f65344h;

        /* renamed from: i, reason: collision with root package name */
        public final List f65345i;

        /* renamed from: j, reason: collision with root package name */
        public final boolean f65346j;

        /* renamed from: k, reason: collision with root package name */
        public final int f65347k;

        /* renamed from: l, reason: collision with root package name */
        public final int f65348l;

        public StringPoolChunk(String... strArr) {
            this(false, strArr);
        }

        public int a() {
            return this.f65348l;
        }

        public final Pair b(String str) {
            return new Pair(this.f65346j ? ColorResourcesTableCreator.m(str) : ColorResourcesTableCreator.l(str), Collections.EMPTY_LIST);
        }

        public void c(ByteArrayOutputStream byteArrayOutputStream) throws IOException {
            this.f65337a.a(byteArrayOutputStream);
            byteArrayOutputStream.write(ColorResourcesTableCreator.j(this.f65338b));
            byteArrayOutputStream.write(ColorResourcesTableCreator.j(this.f65339c));
            byteArrayOutputStream.write(ColorResourcesTableCreator.j(this.f65346j ? 256 : 0));
            byteArrayOutputStream.write(ColorResourcesTableCreator.j(this.f65340d));
            byteArrayOutputStream.write(ColorResourcesTableCreator.j(this.f65341e));
            Iterator it = this.f65342f.iterator();
            while (it.hasNext()) {
                byteArrayOutputStream.write(ColorResourcesTableCreator.j(((Integer) it.next()).intValue()));
            }
            Iterator it2 = this.f65343g.iterator();
            while (it2.hasNext()) {
                byteArrayOutputStream.write(ColorResourcesTableCreator.j(((Integer) it2.next()).intValue()));
            }
            Iterator it3 = this.f65344h.iterator();
            while (it3.hasNext()) {
                byteArrayOutputStream.write((byte[]) it3.next());
            }
            int i3 = this.f65347k;
            if (i3 > 0) {
                byteArrayOutputStream.write(new byte[i3]);
            }
            Iterator it4 = this.f65345i.iterator();
            while (it4.hasNext()) {
                Iterator it5 = ((List) it4.next()).iterator();
                while (it5.hasNext()) {
                    ((StringStyledSpan) it5.next()).b(byteArrayOutputStream);
                }
                byteArrayOutputStream.write(ColorResourcesTableCreator.j(-1));
            }
        }

        public StringPoolChunk(boolean z2, String... strArr) {
            this.f65342f = new ArrayList();
            this.f65343g = new ArrayList();
            this.f65344h = new ArrayList();
            this.f65345i = new ArrayList();
            this.f65346j = z2;
            int length = 0;
            for (String str : strArr) {
                Pair pairB = b(str);
                this.f65342f.add(Integer.valueOf(length));
                Object obj = pairB.first;
                length += ((byte[]) obj).length;
                this.f65344h.add((byte[]) obj);
                this.f65345i.add((List) pairB.second);
            }
            int size = 0;
            for (List<StringStyledSpan> list : this.f65345i) {
                for (StringStyledSpan stringStyledSpan : list) {
                    this.f65342f.add(Integer.valueOf(length));
                    length += stringStyledSpan.f65349a.length;
                    this.f65344h.add(stringStyledSpan.f65349a);
                }
                this.f65343g.add(Integer.valueOf(size));
                size += (list.size() * 12) + 4;
            }
            int i3 = length % 4;
            int i4 = i3 == 0 ? 0 : 4 - i3;
            this.f65347k = i4;
            int size2 = this.f65344h.size();
            this.f65338b = size2;
            this.f65339c = this.f65344h.size() - strArr.length;
            boolean z3 = this.f65344h.size() - strArr.length > 0;
            if (!z3) {
                this.f65343g.clear();
                this.f65345i.clear();
            }
            int size3 = (size2 * 4) + 28 + (this.f65343g.size() * 4);
            this.f65340d = size3;
            int i5 = length + i4;
            this.f65341e = z3 ? size3 + i5 : 0;
            int i6 = size3 + i5 + (z3 ? size : 0);
            this.f65348l = i6;
            this.f65337a = new ResChunkHeader((short) 1, (short) 28, i6);
        }
    }

    public static class StringStyledSpan {

        /* renamed from: a, reason: collision with root package name */
        public byte[] f65349a;

        /* renamed from: b, reason: collision with root package name */
        public int f65350b;

        /* renamed from: c, reason: collision with root package name */
        public int f65351c;

        /* renamed from: d, reason: collision with root package name */
        public int f65352d;

        private StringStyledSpan() {
        }

        public void b(ByteArrayOutputStream byteArrayOutputStream) throws IOException {
            byteArrayOutputStream.write(ColorResourcesTableCreator.j(this.f65350b));
            byteArrayOutputStream.write(ColorResourcesTableCreator.j(this.f65351c));
            byteArrayOutputStream.write(ColorResourcesTableCreator.j(this.f65352d));
        }
    }

    public static class TypeChunk {

        /* renamed from: a, reason: collision with root package name */
        public final ResChunkHeader f65353a;

        /* renamed from: b, reason: collision with root package name */
        public final int f65354b;

        /* renamed from: c, reason: collision with root package name */
        public final byte[] f65355c;

        /* renamed from: d, reason: collision with root package name */
        public final int[] f65356d;

        /* renamed from: e, reason: collision with root package name */
        public final ResEntry[] f65357e;

        public TypeChunk(List list, Set set, int i3) {
            byte[] bArr = new byte[64];
            this.f65355c = bArr;
            this.f65354b = i3;
            bArr[0] = SignedBytes.MAX_POWER_OF_TWO;
            this.f65357e = new ResEntry[list.size()];
            for (int i4 = 0; i4 < list.size(); i4++) {
                this.f65357e[i4] = new ResEntry(i4, ((ColorResource) list.get(i4)).f65320e);
            }
            this.f65356d = new int[i3];
            int i5 = 0;
            for (short s2 = 0; s2 < i3; s2 = (short) (s2 + 1)) {
                if (set.contains(Short.valueOf(s2))) {
                    this.f65356d[s2] = i5;
                    i5 += 16;
                } else {
                    this.f65356d[s2] = -1;
                }
            }
            this.f65353a = new ResChunkHeader((short) 513, (short) 84, a());
        }

        public int a() {
            return b() + (this.f65357e.length * 16);
        }

        public final int b() {
            return c() + 84;
        }

        public final int c() {
            return this.f65356d.length * 4;
        }

        public void d(ByteArrayOutputStream byteArrayOutputStream) throws IOException {
            this.f65353a.a(byteArrayOutputStream);
            byteArrayOutputStream.write(new byte[]{ColorResourcesTableCreator.f65313a, 0, 0, 0});
            byteArrayOutputStream.write(ColorResourcesTableCreator.j(this.f65354b));
            byteArrayOutputStream.write(ColorResourcesTableCreator.j(b()));
            byteArrayOutputStream.write(this.f65355c);
            for (int i3 : this.f65356d) {
                byteArrayOutputStream.write(ColorResourcesTableCreator.j(i3));
            }
            for (ResEntry resEntry : this.f65357e) {
                resEntry.a(byteArrayOutputStream);
            }
        }
    }

    public static class TypeSpecChunk {

        /* renamed from: a, reason: collision with root package name */
        public final ResChunkHeader f65358a;

        /* renamed from: b, reason: collision with root package name */
        public final int f65359b;

        /* renamed from: c, reason: collision with root package name */
        public final int[] f65360c;

        /* renamed from: d, reason: collision with root package name */
        public final TypeChunk f65361d;

        public TypeSpecChunk(List list) {
            this.f65359b = ((ColorResource) list.get(list.size() - 1)).f65318c + 1;
            HashSet hashSet = new HashSet();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                hashSet.add(Short.valueOf(((ColorResource) it.next()).f65318c));
            }
            this.f65360c = new int[this.f65359b];
            for (short s2 = 0; s2 < this.f65359b; s2 = (short) (s2 + 1)) {
                if (hashSet.contains(Short.valueOf(s2))) {
                    this.f65360c[s2] = 1073741824;
                }
            }
            this.f65358a = new ResChunkHeader((short) 514, (short) 16, a());
            this.f65361d = new TypeChunk(list, hashSet, this.f65359b);
        }

        public final int a() {
            return (this.f65359b * 4) + 16;
        }

        public int b() {
            return a() + this.f65361d.a();
        }

        public void c(ByteArrayOutputStream byteArrayOutputStream) throws IOException {
            this.f65358a.a(byteArrayOutputStream);
            byteArrayOutputStream.write(new byte[]{ColorResourcesTableCreator.f65313a, 0, 0, 0});
            byteArrayOutputStream.write(ColorResourcesTableCreator.j(this.f65359b));
            for (int i3 : this.f65360c) {
                byteArrayOutputStream.write(ColorResourcesTableCreator.j(i3));
            }
            this.f65361d.d(byteArrayOutputStream);
        }
    }

    private ColorResourcesTableCreator() {
    }

    public static byte[] h(char c3) {
        return new byte[]{(byte) (c3 & 255), (byte) ((c3 >> '\b') & 255)};
    }

    public static byte[] i(Context context, Map map) throws IOException {
        PackageInfo packageInfo;
        if (map.entrySet().isEmpty()) {
            throw new IllegalArgumentException("No color resources provided for harmonization.");
        }
        PackageInfo packageInfo2 = new PackageInfo(127, context.getPackageName());
        HashMap map2 = new HashMap();
        ColorResource colorResource = null;
        for (Map.Entry entry : map.entrySet()) {
            ColorResource colorResource2 = new ColorResource(((Integer) entry.getKey()).intValue(), context.getResources().getResourceName(((Integer) entry.getKey()).intValue()), ((Integer) entry.getValue()).intValue());
            if (!context.getResources().getResourceTypeName(((Integer) entry.getKey()).intValue()).equals("color")) {
                throw new IllegalArgumentException("Non color resource found: name=" + colorResource2.f65319d + ", typeId=" + Integer.toHexString(colorResource2.f65317b & 255));
            }
            if (colorResource2.f65316a == 1) {
                packageInfo = f65314b;
            } else {
                if (colorResource2.f65316a != 127) {
                    throw new IllegalArgumentException("Not supported with unknown package id: " + ((int) colorResource2.f65316a));
                }
                packageInfo = packageInfo2;
            }
            if (!map2.containsKey(packageInfo)) {
                map2.put(packageInfo, new ArrayList());
            }
            ((List) map2.get(packageInfo)).add(colorResource2);
            colorResource = colorResource2;
        }
        byte b3 = colorResource.f65317b;
        f65313a = b3;
        if (b3 == 0) {
            throw new IllegalArgumentException("No color resources found for harmonization.");
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        new ResTable(map2).b(byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static byte[] j(int i3) {
        return new byte[]{(byte) (i3 & 255), (byte) ((i3 >> 8) & 255), (byte) ((i3 >> 16) & 255), (byte) ((i3 >> 24) & 255)};
    }

    public static byte[] k(short s2) {
        return new byte[]{(byte) (s2 & 255), (byte) ((s2 >> 8) & 255)};
    }

    public static byte[] l(String str) {
        char[] charArray = str.toCharArray();
        int length = charArray.length * 2;
        byte[] bArr = new byte[length + 4];
        byte[] bArrK = k((short) charArray.length);
        bArr[0] = bArrK[0];
        bArr[1] = bArrK[1];
        for (int i3 = 0; i3 < charArray.length; i3++) {
            byte[] bArrH = h(charArray[i3]);
            int i4 = i3 * 2;
            bArr[i4 + 2] = bArrH[0];
            bArr[i4 + 3] = bArrH[1];
        }
        bArr[length + 2] = 0;
        bArr[length + 3] = 0;
        return bArr;
    }

    public static byte[] m(String str) {
        byte[] bytes = str.getBytes(Charset.forName("UTF-8"));
        byte length = (byte) bytes.length;
        int length2 = bytes.length;
        byte[] bArr = new byte[length2 + 3];
        System.arraycopy(bytes, 0, bArr, 2, length);
        bArr[1] = length;
        bArr[0] = length;
        bArr[length2 + 2] = 0;
        return bArr;
    }
}
