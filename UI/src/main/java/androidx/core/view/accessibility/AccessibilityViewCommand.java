package androidx.core.view.accessibility;

import android.os.Bundle;
import android.view.View;

/* loaded from: classes3.dex */
public interface AccessibilityViewCommand {

    public static abstract class CommandArguments {

        /* renamed from: a, reason: collision with root package name */
        public Bundle f33885a;

        public void a(Bundle bundle) {
            this.f33885a = bundle;
        }
    }

    public static final class MoveAtGranularityArguments extends CommandArguments {
    }

    public static final class MoveHtmlArguments extends CommandArguments {
    }

    public static final class MoveWindowArguments extends CommandArguments {
    }

    public static final class ScrollToPositionArguments extends CommandArguments {
    }

    public static final class SetProgressArguments extends CommandArguments {
    }

    public static final class SetSelectionArguments extends CommandArguments {
    }

    public static final class SetTextArguments extends CommandArguments {
    }

    boolean a(View view, CommandArguments commandArguments);
}
