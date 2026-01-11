package freemarker.core;

import java.io.IOException;
import java.io.Reader;

/* loaded from: classes8.dex */
public class SimpleCharStream {
    public static final boolean staticFlag = false;

    /* renamed from: a, reason: collision with root package name */
    public int f149726a;

    /* renamed from: b, reason: collision with root package name */
    public int f149727b;

    /* renamed from: c, reason: collision with root package name */
    public int f149728c;

    /* renamed from: d, reason: collision with root package name */
    public int f149729d;

    /* renamed from: e, reason: collision with root package name */
    public int[] f149730e;

    /* renamed from: f, reason: collision with root package name */
    public int[] f149731f;

    /* renamed from: g, reason: collision with root package name */
    public int f149732g;

    /* renamed from: h, reason: collision with root package name */
    public int f149733h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f149734i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f149735j;

    /* renamed from: k, reason: collision with root package name */
    public Reader f149736k;

    /* renamed from: l, reason: collision with root package name */
    public char[] f149737l;

    /* renamed from: m, reason: collision with root package name */
    public int f149738m;

    /* renamed from: n, reason: collision with root package name */
    public int f149739n;

    public SimpleCharStream(Reader reader, int i3, int i4, int i5) {
        this.f149729d = -1;
        this.f149734i = false;
        this.f149735j = false;
        this.f149738m = 0;
        this.f149739n = 0;
        this.f149736k = reader;
        this.f149733h = i3;
        this.f149732g = i4 - 1;
        this.f149726a = i5;
        this.f149727b = i5;
        this.f149737l = new char[i5];
        this.f149730e = new int[i5];
        this.f149731f = new int[i5];
    }

    public char a() throws IOException {
        this.f149728c = -1;
        char cL = l();
        this.f149728c = this.f149729d;
        return cL;
    }

    public void b(boolean z2) {
        int i3 = this.f149726a;
        char[] cArr = new char[i3 + 2048];
        int[] iArr = new int[i3 + 2048];
        int[] iArr2 = new int[i3 + 2048];
        try {
            if (z2) {
                char[] cArr2 = this.f149737l;
                int i4 = this.f149728c;
                System.arraycopy(cArr2, i4, cArr, 0, i3 - i4);
                System.arraycopy(this.f149737l, 0, cArr, this.f149726a - this.f149728c, this.f149729d);
                this.f149737l = cArr;
                int[] iArr3 = this.f149730e;
                int i5 = this.f149728c;
                System.arraycopy(iArr3, i5, iArr, 0, this.f149726a - i5);
                System.arraycopy(this.f149730e, 0, iArr, this.f149726a - this.f149728c, this.f149729d);
                this.f149730e = iArr;
                int[] iArr4 = this.f149731f;
                int i6 = this.f149728c;
                System.arraycopy(iArr4, i6, iArr2, 0, this.f149726a - i6);
                System.arraycopy(this.f149731f, 0, iArr2, this.f149726a - this.f149728c, this.f149729d);
                this.f149731f = iArr2;
                int i7 = this.f149729d + (this.f149726a - this.f149728c);
                this.f149729d = i7;
                this.f149738m = i7;
            } else {
                char[] cArr3 = this.f149737l;
                int i8 = this.f149728c;
                System.arraycopy(cArr3, i8, cArr, 0, i3 - i8);
                this.f149737l = cArr;
                int[] iArr5 = this.f149730e;
                int i9 = this.f149728c;
                System.arraycopy(iArr5, i9, iArr, 0, this.f149726a - i9);
                this.f149730e = iArr;
                int[] iArr6 = this.f149731f;
                int i10 = this.f149728c;
                System.arraycopy(iArr6, i10, iArr2, 0, this.f149726a - i10);
                this.f149731f = iArr2;
                int i11 = this.f149729d - this.f149728c;
                this.f149729d = i11;
                this.f149738m = i11;
            }
            int i12 = this.f149726a + 2048;
            this.f149726a = i12;
            this.f149727b = i12;
            this.f149728c = 0;
        } catch (Throwable th) {
            throw new Error(th.getMessage());
        }
    }

    public void c() throws IOException {
        int i3 = this.f149738m;
        int i4 = this.f149727b;
        if (i3 == i4) {
            int i5 = this.f149726a;
            if (i4 == i5) {
                int i6 = this.f149728c;
                if (i6 > 2048) {
                    this.f149738m = 0;
                    this.f149729d = 0;
                    this.f149727b = i6;
                } else if (i6 < 0) {
                    this.f149738m = 0;
                    this.f149729d = 0;
                } else {
                    b(false);
                }
            } else {
                int i7 = this.f149728c;
                if (i4 > i7) {
                    this.f149727b = i5;
                } else if (i7 - i4 < 2048) {
                    b(true);
                } else {
                    this.f149727b = i7;
                }
            }
        }
        try {
            Reader reader = this.f149736k;
            char[] cArr = this.f149737l;
            int i8 = this.f149738m;
            int i9 = reader.read(cArr, i8, this.f149727b - i8);
            if (i9 != -1) {
                this.f149738m += i9;
            } else {
                this.f149736k.close();
                throw new IOException();
            }
        } catch (IOException e3) {
            this.f149729d--;
            g(0);
            if (this.f149728c == -1) {
                this.f149728c = this.f149729d;
            }
            throw e3;
        }
    }

    public String d() {
        int i3 = this.f149729d;
        int i4 = this.f149728c;
        if (i3 >= i4) {
            return new String(this.f149737l, i4, (i3 - i4) + 1);
        }
        StringBuffer stringBuffer = new StringBuffer();
        char[] cArr = this.f149737l;
        int i5 = this.f149728c;
        stringBuffer.append(new String(cArr, i5, this.f149726a - i5));
        stringBuffer.append(new String(this.f149737l, 0, this.f149729d + 1));
        return stringBuffer.toString();
    }

    public char[] e(int i3) {
        char[] cArr = new char[i3];
        int i4 = this.f149729d;
        if (i4 + 1 >= i3) {
            System.arraycopy(this.f149737l, (i4 - i3) + 1, cArr, 0, i3);
            return cArr;
        }
        System.arraycopy(this.f149737l, this.f149726a - ((i3 - i4) - 1), cArr, 0, (i3 - i4) - 1);
        System.arraycopy(this.f149737l, 0, cArr, (i3 - r2) - 1, this.f149729d + 1);
        return cArr;
    }

    public void f(char c3) {
        this.f149732g++;
        if (this.f149735j) {
            this.f149735j = false;
            int i3 = this.f149733h;
            this.f149732g = 1;
            this.f149733h = i3 + 1;
        } else if (this.f149734i) {
            this.f149734i = false;
            if (c3 == '\n') {
                this.f149735j = true;
            } else {
                int i4 = this.f149733h;
                this.f149732g = 1;
                this.f149733h = i4 + 1;
            }
        }
        if (c3 == '\t') {
            int i5 = this.f149732g - 1;
            this.f149732g = i5 + (8 - (i5 & 7));
        } else if (c3 == '\n') {
            this.f149735j = true;
        } else if (c3 == '\r') {
            this.f149734i = true;
        }
        int[] iArr = this.f149730e;
        int i6 = this.f149729d;
        iArr[i6] = this.f149733h;
        this.f149731f[i6] = this.f149732g;
    }

    public void g(int i3) {
        this.f149739n += i3;
        int i4 = this.f149729d - i3;
        this.f149729d = i4;
        if (i4 < 0) {
            this.f149729d = i4 + this.f149726a;
        }
    }

    public int h() {
        return this.f149731f[this.f149728c];
    }

    public int i() {
        return this.f149730e[this.f149728c];
    }

    public int j() {
        return this.f149731f[this.f149729d];
    }

    public int k() {
        return this.f149730e[this.f149729d];
    }

    public char l() throws IOException {
        int i3 = this.f149739n;
        if (i3 > 0) {
            this.f149739n = i3 - 1;
            int i4 = this.f149729d + 1;
            this.f149729d = i4;
            if (i4 == this.f149726a) {
                this.f149729d = 0;
            }
            return this.f149737l[this.f149729d];
        }
        int i5 = this.f149729d + 1;
        this.f149729d = i5;
        if (i5 >= this.f149738m) {
            c();
        }
        char c3 = this.f149737l[this.f149729d];
        f(c3);
        return c3;
    }

    public SimpleCharStream(Reader reader, int i3, int i4) {
        this(reader, i3, i4, 4096);
    }
}
