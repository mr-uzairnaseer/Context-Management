package androidx.browser.trusted;

/* loaded from: classes2.dex */
public interface TrustedWebActivityDisplayMode {
    public static final String KEY_ID = "androidx.browser.trusted.displaymode.KEY_ID";

    public static class DefaultMode implements TrustedWebActivityDisplayMode {
    }

    public static class ImmersiveMode implements TrustedWebActivityDisplayMode {
        public static final String KEY_CUTOUT_MODE = "androidx.browser.trusted.displaymode.KEY_CUTOUT_MODE";
        public static final String KEY_STICKY = "androidx.browser.trusted.displaymode.KEY_STICKY";
    }
}
