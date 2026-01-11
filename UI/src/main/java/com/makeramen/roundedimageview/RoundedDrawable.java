package com.makeramen.roundedimageview;

import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.Log;
import android.widget.ImageView;
import java.util.HashSet;

/* loaded from: classes5.dex */
public class RoundedDrawable extends Drawable {
    public static final int DEFAULT_BORDER_COLOR = -16777216;
    public static final String TAG = "RoundedDrawable";

    /* renamed from: a, reason: collision with root package name */
    public final RectF f75363a = new RectF();

    /* renamed from: b, reason: collision with root package name */
    public final RectF f75364b = new RectF();

    /* renamed from: c, reason: collision with root package name */
    public final RectF f75365c;

    /* renamed from: d, reason: collision with root package name */
    public final Bitmap f75366d;

    /* renamed from: e, reason: collision with root package name */
    public final Paint f75367e;

    /* renamed from: f, reason: collision with root package name */
    public final int f75368f;

    /* renamed from: g, reason: collision with root package name */
    public final int f75369g;

    /* renamed from: h, reason: collision with root package name */
    public final RectF f75370h;

    /* renamed from: i, reason: collision with root package name */
    public final Paint f75371i;

    /* renamed from: j, reason: collision with root package name */
    public final Matrix f75372j;

    /* renamed from: k, reason: collision with root package name */
    public final RectF f75373k;

    /* renamed from: l, reason: collision with root package name */
    public Shader.TileMode f75374l;

    /* renamed from: m, reason: collision with root package name */
    public Shader.TileMode f75375m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f75376n;

    /* renamed from: o, reason: collision with root package name */
    public float f75377o;

    /* renamed from: p, reason: collision with root package name */
    public final boolean[] f75378p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f75379q;

    /* renamed from: r, reason: collision with root package name */
    public float f75380r;

    /* renamed from: s, reason: collision with root package name */
    public ColorStateList f75381s;

    /* renamed from: t, reason: collision with root package name */
    public ImageView.ScaleType f75382t;

    /* renamed from: com.makeramen.roundedimageview.RoundedDrawable$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f75383a;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            f75383a = iArr;
            try {
                iArr[ImageView.ScaleType.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f75383a[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f75383a[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f75383a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f75383a[ImageView.ScaleType.FIT_END.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f75383a[ImageView.ScaleType.FIT_START.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f75383a[ImageView.ScaleType.FIT_XY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public RoundedDrawable(Bitmap bitmap) {
        RectF rectF = new RectF();
        this.f75365c = rectF;
        this.f75370h = new RectF();
        this.f75372j = new Matrix();
        this.f75373k = new RectF();
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        this.f75374l = tileMode;
        this.f75375m = tileMode;
        this.f75376n = true;
        this.f75377o = 0.0f;
        this.f75378p = new boolean[]{true, true, true, true};
        this.f75379q = false;
        this.f75380r = 0.0f;
        this.f75381s = ColorStateList.valueOf(-16777216);
        this.f75382t = ImageView.ScaleType.FIT_CENTER;
        this.f75366d = bitmap;
        int width = bitmap.getWidth();
        this.f75368f = width;
        int height = bitmap.getHeight();
        this.f75369g = height;
        rectF.set(0.0f, 0.0f, width, height);
        Paint paint = new Paint();
        this.f75367e = paint;
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.f75371i = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setAntiAlias(true);
        paint2.setColor(this.f75381s.getColorForState(getState(), -16777216));
        paint2.setStrokeWidth(this.f75380r);
    }

    public static boolean a(boolean[] zArr) {
        for (boolean z2 : zArr) {
            if (z2) {
                return false;
            }
        }
        return true;
    }

    public static boolean b(boolean[] zArr) {
        for (boolean z2 : zArr) {
            if (z2) {
                return true;
            }
        }
        return false;
    }

    public static Bitmap c(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        try {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(Math.max(drawable.getIntrinsicWidth(), 2), Math.max(drawable.getIntrinsicHeight(), 2), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return bitmapCreateBitmap;
        } catch (Exception e3) {
            e3.printStackTrace();
            Log.w(TAG, "Failed to create bitmap from drawable!");
            return null;
        }
    }

    public static RoundedDrawable d(Bitmap bitmap) {
        if (bitmap != null) {
            return new RoundedDrawable(bitmap);
        }
        return null;
    }

    public static Drawable e(Drawable drawable) {
        if (drawable == null || (drawable instanceof RoundedDrawable)) {
            return drawable;
        }
        if (!(drawable instanceof LayerDrawable)) {
            Bitmap bitmapC = c(drawable);
            return bitmapC != null ? new RoundedDrawable(bitmapC) : drawable;
        }
        LayerDrawable layerDrawable = (LayerDrawable) drawable;
        int numberOfLayers = layerDrawable.getNumberOfLayers();
        for (int i3 = 0; i3 < numberOfLayers; i3++) {
            layerDrawable.setDrawableByLayerId(layerDrawable.getId(i3), e(layerDrawable.getDrawable(i3)));
        }
        return layerDrawable;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.f75376n) {
            BitmapShader bitmapShader = new BitmapShader(this.f75366d, this.f75374l, this.f75375m);
            Shader.TileMode tileMode = this.f75374l;
            Shader.TileMode tileMode2 = Shader.TileMode.CLAMP;
            if (tileMode == tileMode2 && this.f75375m == tileMode2) {
                bitmapShader.setLocalMatrix(this.f75372j);
            }
            this.f75367e.setShader(bitmapShader);
            this.f75376n = false;
        }
        if (this.f75379q) {
            if (this.f75380r <= 0.0f) {
                canvas.drawOval(this.f75364b, this.f75367e);
                return;
            } else {
                canvas.drawOval(this.f75364b, this.f75367e);
                canvas.drawOval(this.f75370h, this.f75371i);
                return;
            }
        }
        if (!b(this.f75378p)) {
            canvas.drawRect(this.f75364b, this.f75367e);
            if (this.f75380r > 0.0f) {
                canvas.drawRect(this.f75370h, this.f75371i);
                return;
            }
            return;
        }
        float f3 = this.f75377o;
        if (this.f75380r <= 0.0f) {
            canvas.drawRoundRect(this.f75364b, f3, f3, this.f75367e);
            f(canvas);
        } else {
            canvas.drawRoundRect(this.f75364b, f3, f3, this.f75367e);
            canvas.drawRoundRect(this.f75370h, f3, f3, this.f75371i);
            f(canvas);
            g(canvas);
        }
    }

    public final void f(Canvas canvas) {
        if (a(this.f75378p) || this.f75377o == 0.0f) {
            return;
        }
        RectF rectF = this.f75364b;
        float f3 = rectF.left;
        float f4 = rectF.top;
        float fWidth = rectF.width() + f3;
        float fHeight = this.f75364b.height() + f4;
        float f5 = this.f75377o;
        if (!this.f75378p[0]) {
            this.f75373k.set(f3, f4, f3 + f5, f4 + f5);
            canvas.drawRect(this.f75373k, this.f75367e);
        }
        if (!this.f75378p[1]) {
            this.f75373k.set(fWidth - f5, f4, fWidth, f5);
            canvas.drawRect(this.f75373k, this.f75367e);
        }
        if (!this.f75378p[2]) {
            this.f75373k.set(fWidth - f5, fHeight - f5, fWidth, fHeight);
            canvas.drawRect(this.f75373k, this.f75367e);
        }
        if (this.f75378p[3]) {
            return;
        }
        this.f75373k.set(f3, fHeight - f5, f5 + f3, fHeight);
        canvas.drawRect(this.f75373k, this.f75367e);
    }

    public final void g(Canvas canvas) {
        float f3;
        float f4;
        if (a(this.f75378p) || this.f75377o == 0.0f) {
            return;
        }
        RectF rectF = this.f75364b;
        float f5 = rectF.left;
        float f6 = rectF.top;
        float fWidth = rectF.width() + f5;
        float fHeight = f6 + this.f75364b.height();
        float f7 = this.f75377o;
        float f8 = this.f75380r / 2.0f;
        if (this.f75378p[0]) {
            f3 = f6;
        } else {
            f3 = f6;
            canvas.drawLine(f5 - f8, f6, f5 + f7, f3, this.f75371i);
            canvas.drawLine(f5, f3 - f8, f5, f3 + f7, this.f75371i);
        }
        if (!this.f75378p[1]) {
            float f9 = f3;
            canvas.drawLine((fWidth - f7) - f8, f9, fWidth, f3, this.f75371i);
            canvas.drawLine(fWidth, f9 - f8, fWidth, f9 + f7, this.f75371i);
            fWidth = fWidth;
        }
        if (this.f75378p[2]) {
            f4 = fHeight;
        } else {
            canvas.drawLine((fWidth - f7) - f8, fHeight, fWidth + f8, fHeight, this.f75371i);
            float f10 = fWidth;
            canvas.drawLine(f10, fHeight - f7, fWidth, fHeight, this.f75371i);
            f4 = fHeight;
        }
        if (this.f75378p[3]) {
            return;
        }
        canvas.drawLine(f5 - f8, f4, f5 + f7, f4, this.f75371i);
        canvas.drawLine(f5, f4 - f7, f5, f4, this.f75371i);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f75367e.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        return this.f75367e.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f75369g;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f75368f;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public RoundedDrawable h(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.f75381s = colorStateList;
        this.f75371i.setColor(colorStateList.getColorForState(getState(), -16777216));
        return this;
    }

    public RoundedDrawable i(float f3) {
        this.f75380r = f3;
        this.f75371i.setStrokeWidth(f3);
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return this.f75381s.isStateful();
    }

    public RoundedDrawable j(float f3, float f4, float f5, float f6) {
        HashSet hashSet = new HashSet(4);
        hashSet.add(Float.valueOf(f3));
        hashSet.add(Float.valueOf(f4));
        hashSet.add(Float.valueOf(f5));
        hashSet.add(Float.valueOf(f6));
        hashSet.remove(Float.valueOf(0.0f));
        if (hashSet.size() > 1) {
            throw new IllegalArgumentException("Multiple nonzero corner radii not yet supported.");
        }
        if (hashSet.isEmpty()) {
            this.f75377o = 0.0f;
        } else {
            float fFloatValue = ((Float) hashSet.iterator().next()).floatValue();
            if (Float.isInfinite(fFloatValue) || Float.isNaN(fFloatValue) || fFloatValue < 0.0f) {
                throw new IllegalArgumentException("Invalid radius value: " + fFloatValue);
            }
            this.f75377o = fFloatValue;
        }
        boolean[] zArr = this.f75378p;
        zArr[0] = f3 > 0.0f;
        zArr[1] = f4 > 0.0f;
        zArr[2] = f5 > 0.0f;
        zArr[3] = f6 > 0.0f;
        return this;
    }

    public RoundedDrawable k(boolean z2) {
        this.f75379q = z2;
        return this;
    }

    public RoundedDrawable l(ImageView.ScaleType scaleType) {
        if (scaleType == null) {
            scaleType = ImageView.ScaleType.FIT_CENTER;
        }
        if (this.f75382t != scaleType) {
            this.f75382t = scaleType;
            p();
        }
        return this;
    }

    public RoundedDrawable m(Shader.TileMode tileMode) {
        if (this.f75374l != tileMode) {
            this.f75374l = tileMode;
            this.f75376n = true;
            invalidateSelf();
        }
        return this;
    }

    public RoundedDrawable n(Shader.TileMode tileMode) {
        if (this.f75375m != tileMode) {
            this.f75375m = tileMode;
            this.f75376n = true;
            invalidateSelf();
        }
        return this;
    }

    public Bitmap o() {
        return c(this);
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f75363a.set(rect);
        p();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        int colorForState = this.f75381s.getColorForState(iArr, 0);
        if (this.f75371i.getColor() == colorForState) {
            return super.onStateChange(iArr);
        }
        this.f75371i.setColor(colorForState);
        return true;
    }

    public final void p() {
        float fWidth;
        float fHeight;
        int i3 = AnonymousClass1.f75383a[this.f75382t.ordinal()];
        if (i3 == 1) {
            this.f75370h.set(this.f75363a);
            RectF rectF = this.f75370h;
            float f3 = this.f75380r;
            rectF.inset(f3 / 2.0f, f3 / 2.0f);
            this.f75372j.reset();
            this.f75372j.setTranslate((int) (((this.f75370h.width() - this.f75368f) * 0.5f) + 0.5f), (int) (((this.f75370h.height() - this.f75369g) * 0.5f) + 0.5f));
        } else if (i3 == 2) {
            this.f75370h.set(this.f75363a);
            RectF rectF2 = this.f75370h;
            float f4 = this.f75380r;
            rectF2.inset(f4 / 2.0f, f4 / 2.0f);
            this.f75372j.reset();
            float fWidth2 = 0.0f;
            if (this.f75368f * this.f75370h.height() > this.f75370h.width() * this.f75369g) {
                fWidth = this.f75370h.height() / this.f75369g;
                fHeight = 0.0f;
                fWidth2 = (this.f75370h.width() - (this.f75368f * fWidth)) * 0.5f;
            } else {
                fWidth = this.f75370h.width() / this.f75368f;
                fHeight = (this.f75370h.height() - (this.f75369g * fWidth)) * 0.5f;
            }
            this.f75372j.setScale(fWidth, fWidth);
            Matrix matrix = this.f75372j;
            float f5 = this.f75380r;
            matrix.postTranslate(((int) (fWidth2 + 0.5f)) + (f5 / 2.0f), ((int) (fHeight + 0.5f)) + (f5 / 2.0f));
        } else if (i3 == 3) {
            this.f75372j.reset();
            float fMin = (((float) this.f75368f) > this.f75363a.width() || ((float) this.f75369g) > this.f75363a.height()) ? Math.min(this.f75363a.width() / this.f75368f, this.f75363a.height() / this.f75369g) : 1.0f;
            float fWidth3 = (int) (((this.f75363a.width() - (this.f75368f * fMin)) * 0.5f) + 0.5f);
            float fHeight2 = (int) (((this.f75363a.height() - (this.f75369g * fMin)) * 0.5f) + 0.5f);
            this.f75372j.setScale(fMin, fMin);
            this.f75372j.postTranslate(fWidth3, fHeight2);
            this.f75370h.set(this.f75365c);
            this.f75372j.mapRect(this.f75370h);
            RectF rectF3 = this.f75370h;
            float f6 = this.f75380r;
            rectF3.inset(f6 / 2.0f, f6 / 2.0f);
            this.f75372j.setRectToRect(this.f75365c, this.f75370h, Matrix.ScaleToFit.FILL);
        } else if (i3 == 5) {
            this.f75370h.set(this.f75365c);
            this.f75372j.setRectToRect(this.f75365c, this.f75363a, Matrix.ScaleToFit.END);
            this.f75372j.mapRect(this.f75370h);
            RectF rectF4 = this.f75370h;
            float f7 = this.f75380r;
            rectF4.inset(f7 / 2.0f, f7 / 2.0f);
            this.f75372j.setRectToRect(this.f75365c, this.f75370h, Matrix.ScaleToFit.FILL);
        } else if (i3 == 6) {
            this.f75370h.set(this.f75365c);
            this.f75372j.setRectToRect(this.f75365c, this.f75363a, Matrix.ScaleToFit.START);
            this.f75372j.mapRect(this.f75370h);
            RectF rectF5 = this.f75370h;
            float f8 = this.f75380r;
            rectF5.inset(f8 / 2.0f, f8 / 2.0f);
            this.f75372j.setRectToRect(this.f75365c, this.f75370h, Matrix.ScaleToFit.FILL);
        } else if (i3 != 7) {
            this.f75370h.set(this.f75365c);
            this.f75372j.setRectToRect(this.f75365c, this.f75363a, Matrix.ScaleToFit.CENTER);
            this.f75372j.mapRect(this.f75370h);
            RectF rectF6 = this.f75370h;
            float f9 = this.f75380r;
            rectF6.inset(f9 / 2.0f, f9 / 2.0f);
            this.f75372j.setRectToRect(this.f75365c, this.f75370h, Matrix.ScaleToFit.FILL);
        } else {
            this.f75370h.set(this.f75363a);
            RectF rectF7 = this.f75370h;
            float f10 = this.f75380r;
            rectF7.inset(f10 / 2.0f, f10 / 2.0f);
            this.f75372j.reset();
            this.f75372j.setRectToRect(this.f75365c, this.f75370h, Matrix.ScaleToFit.FILL);
        }
        this.f75364b.set(this.f75370h);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
        this.f75367e.setAlpha(i3);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f75367e.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z2) {
        this.f75367e.setDither(z2);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z2) {
        this.f75367e.setFilterBitmap(z2);
        invalidateSelf();
    }
}
