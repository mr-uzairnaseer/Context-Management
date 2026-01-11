package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.util.AttributeSet;
import java.util.HashMap;
import java.util.HashSet;

/* loaded from: classes3.dex */
public abstract class Key {
    public static final String ALPHA = "alpha";
    public static final String CURVEFIT = "curveFit";
    public static final String CUSTOM = "CUSTOM";
    public static final String ELEVATION = "elevation";
    public static final String MOTIONPROGRESS = "motionProgress";
    public static final String PIVOT_X = "transformPivotX";
    public static final String PIVOT_Y = "transformPivotY";
    public static final String PROGRESS = "progress";
    public static final String ROTATION = "rotation";
    public static final String ROTATION_X = "rotationX";
    public static final String ROTATION_Y = "rotationY";
    public static final String SCALE_X = "scaleX";
    public static final String SCALE_Y = "scaleY";
    public static final String TRANSITIONEASING = "transitionEasing";
    public static final String TRANSITION_PATH_ROTATE = "transitionPathRotate";
    public static final String TRANSLATION_X = "translationX";
    public static final String TRANSLATION_Y = "translationY";
    public static final String TRANSLATION_Z = "translationZ";
    public static int UNSET = -1;
    public static final String VISIBILITY = "visibility";
    public static final String WAVE_OFFSET = "waveOffset";
    public static final String WAVE_PERIOD = "wavePeriod";
    public static final String WAVE_PHASE = "wavePhase";
    public static final String WAVE_VARIES_BY = "waveVariesBy";

    /* renamed from: a, reason: collision with root package name */
    public int f32094a;

    /* renamed from: b, reason: collision with root package name */
    public int f32095b;

    /* renamed from: c, reason: collision with root package name */
    public String f32096c;

    /* renamed from: d, reason: collision with root package name */
    public int f32097d;

    /* renamed from: e, reason: collision with root package name */
    public HashMap f32098e;

    public Key() {
        int i3 = UNSET;
        this.f32094a = i3;
        this.f32095b = i3;
        this.f32096c = null;
    }

    public abstract void a(HashMap map);

    @Override // 
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public abstract Key clone();

    public Key c(Key key) {
        this.f32094a = key.f32094a;
        this.f32095b = key.f32095b;
        this.f32096c = key.f32096c;
        this.f32097d = key.f32097d;
        this.f32098e = key.f32098e;
        return this;
    }

    public abstract void d(HashSet hashSet);

    public abstract void e(Context context, AttributeSet attributeSet);

    public boolean f(String str) {
        String str2 = this.f32096c;
        if (str2 == null || str == null) {
            return false;
        }
        return str.matches(str2);
    }

    public void g(int i3) {
        this.f32094a = i3;
    }

    public void h(HashMap map) {
    }

    public Key i(int i3) {
        this.f32095b = i3;
        return this;
    }

    public boolean j(Object obj) {
        return obj instanceof Boolean ? ((Boolean) obj).booleanValue() : Boolean.parseBoolean(obj.toString());
    }

    public float k(Object obj) {
        return obj instanceof Float ? ((Float) obj).floatValue() : Float.parseFloat(obj.toString());
    }

    public int l(Object obj) {
        return obj instanceof Integer ? ((Integer) obj).intValue() : Integer.parseInt(obj.toString());
    }
}
