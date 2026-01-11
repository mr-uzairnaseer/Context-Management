package androidx.core.graphics.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;

/* loaded from: classes3.dex */
public abstract class RoundedBitmapDrawable extends Drawable {

    /* renamed from: a, reason: collision with root package name */
    public final Bitmap f33314a;

    /* renamed from: b, reason: collision with root package name */
    public int f33315b;

    /* renamed from: e, reason: collision with root package name */
    public final BitmapShader f33318e;

    /* renamed from: g, reason: collision with root package name */
    public float f33320g;

    /* renamed from: k, reason: collision with root package name */
    public boolean f33324k;

    /* renamed from: l, reason: collision with root package name */
    public int f33325l;

    /* renamed from: m, reason: collision with root package name */
    public int f33326m;

    /* renamed from: c, reason: collision with root package name */
    public int f33316c = 119;

    /* renamed from: d, reason: collision with root package name */
    public final Paint f33317d = new Paint(3);

    /* renamed from: f, reason: collision with root package name */
    public final Matrix f33319f = new Matrix();

    /* renamed from: h, reason: collision with root package name */
    public final Rect f33321h = new Rect();

    /* renamed from: i, reason: collision with root package name */
    public final RectF f33322i = new RectF();

    /* renamed from: j, reason: collision with root package name */
    public boolean f33323j = true;

    public RoundedBitmapDrawable(Resources resources, Bitmap bitmap) {
        this.f33315b = 160;
        if (resources != null) {
            this.f33315b = resources.getDisplayMetrics().densityDpi;
        }
        this.f33314a = bitmap;
        if (bitmap != null) {
            a();
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            this.f33318e = new BitmapShader(bitmap, tileMode, tileMode);
        } else {
            this.f33326m = -1;
            this.f33325l = -1;
            this.f33318e = null;
        }
    }

    public static boolean d(float f3) {
        return f3 > 0.05f;
    }

    public final void a() {
        this.f33325l = this.f33314a.getScaledWidth(this.f33315b);
        this.f33326m = this.f33314a.getScaledHeight(this.f33315b);
    }

    public float b() {
        return this.f33320g;
    }

    public void c(int i3, int i4, int i5, Rect rect, Rect rect2) {
        throw new UnsupportedOperationException();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Bitmap bitmap = this.f33314a;
        if (bitmap == null) {
            return;
        }
        g();
        if (this.f33317d.getShader() == null) {
            canvas.drawBitmap(bitmap, (Rect) null, this.f33321h, this.f33317d);
            return;
        }
        RectF rectF = this.f33322i;
        float f3 = this.f33320g;
        canvas.drawRoundRect(rectF, f3, f3, this.f33317d);
    }

    public void e(float f3) {
        if (this.f33320g == f3) {
            return;
        }
        this.f33324k = false;
        if (d(f3)) {
            this.f33317d.setShader(this.f33318e);
        } else {
            this.f33317d.setShader(null);
        }
        this.f33320g = f3;
        invalidateSelf();
    }

    public final void f() {
        this.f33320g = Math.min(this.f33326m, this.f33325l) / 2;
    }

    public void g() {
        RoundedBitmapDrawable roundedBitmapDrawable;
        if (this.f33323j) {
            if (this.f33324k) {
                int iMin = Math.min(this.f33325l, this.f33326m);
                roundedBitmapDrawable = this;
                roundedBitmapDrawable.c(this.f33316c, iMin, iMin, getBounds(), this.f33321h);
                int iMin2 = Math.min(roundedBitmapDrawable.f33321h.width(), roundedBitmapDrawable.f33321h.height());
                roundedBitmapDrawable.f33321h.inset(Math.max(0, (roundedBitmapDrawable.f33321h.width() - iMin2) / 2), Math.max(0, (roundedBitmapDrawable.f33321h.height() - iMin2) / 2));
                roundedBitmapDrawable.f33320g = iMin2 * 0.5f;
            } else {
                roundedBitmapDrawable = this;
                roundedBitmapDrawable.c(roundedBitmapDrawable.f33316c, roundedBitmapDrawable.f33325l, roundedBitmapDrawable.f33326m, getBounds(), roundedBitmapDrawable.f33321h);
            }
            roundedBitmapDrawable.f33322i.set(roundedBitmapDrawable.f33321h);
            if (roundedBitmapDrawable.f33318e != null) {
                Matrix matrix = roundedBitmapDrawable.f33319f;
                RectF rectF = roundedBitmapDrawable.f33322i;
                matrix.setTranslate(rectF.left, rectF.top);
                roundedBitmapDrawable.f33319f.preScale(roundedBitmapDrawable.f33322i.width() / roundedBitmapDrawable.f33314a.getWidth(), roundedBitmapDrawable.f33322i.height() / roundedBitmapDrawable.f33314a.getHeight());
                roundedBitmapDrawable.f33318e.setLocalMatrix(roundedBitmapDrawable.f33319f);
                roundedBitmapDrawable.f33317d.setShader(roundedBitmapDrawable.f33318e);
            }
            roundedBitmapDrawable.f33323j = false;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f33317d.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        return this.f33317d.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f33326m;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f33325l;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Bitmap bitmap;
        return (this.f33316c != 119 || this.f33324k || (bitmap = this.f33314a) == null || bitmap.hasAlpha() || this.f33317d.getAlpha() < 255 || d(this.f33320g)) ? -3 : -1;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        if (this.f33324k) {
            f();
        }
        this.f33323j = true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
        if (i3 != this.f33317d.getAlpha()) {
            this.f33317d.setAlpha(i3);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f33317d.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z2) {
        this.f33317d.setDither(z2);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z2) {
        this.f33317d.setFilterBitmap(z2);
        invalidateSelf();
    }
}
