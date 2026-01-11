package freemarker.template;

/* loaded from: classes8.dex */
public interface TransformControl {
    public static final int END_EVALUATION = 1;
    public static final int EVALUATE_BODY = 1;
    public static final int REPEAT_EVALUATION = 0;
    public static final int SKIP_BODY = 0;

    int a();

    void onError(Throwable th);

    int onStart();
}
