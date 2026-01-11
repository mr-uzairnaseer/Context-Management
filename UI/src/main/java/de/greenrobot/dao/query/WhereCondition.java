package de.greenrobot.dao.query;

/* loaded from: classes5.dex */
public interface WhereCondition {

    public static abstract class AbstractCondition implements WhereCondition {

        /* renamed from: a, reason: collision with root package name */
        public final boolean f76205a = false;

        /* renamed from: b, reason: collision with root package name */
        public final Object f76206b = null;

        /* renamed from: c, reason: collision with root package name */
        public final Object[] f76207c = null;
    }

    public static class PropertyCondition extends AbstractCondition {
    }

    public static class StringCondition extends AbstractCondition {
    }
}
