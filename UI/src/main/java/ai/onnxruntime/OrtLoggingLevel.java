package ai.onnxruntime;

import java.util.logging.Logger;

/* loaded from: classes2.dex */
public enum OrtLoggingLevel {
    ORT_LOGGING_LEVEL_VERBOSE(0),
    ORT_LOGGING_LEVEL_INFO(1),
    ORT_LOGGING_LEVEL_WARNING(2),
    ORT_LOGGING_LEVEL_ERROR(3),
    ORT_LOGGING_LEVEL_FATAL(4);

    private static final Logger logger = Logger.getLogger(OrtLoggingLevel.class.getName());
    private static final OrtLoggingLevel[] values = new OrtLoggingLevel[5];
    private final int value;

    static {
        for (OrtLoggingLevel ortLoggingLevel : values()) {
            values[ortLoggingLevel.value] = ortLoggingLevel;
        }
    }

    OrtLoggingLevel(int i3) {
        this.value = i3;
    }

    public static OrtLoggingLevel mapFromInt(int i3) {
        if (i3 >= 0) {
            OrtLoggingLevel[] ortLoggingLevelArr = values;
            if (i3 < ortLoggingLevelArr.length) {
                return ortLoggingLevelArr[i3];
            }
        }
        logger.warning("Unknown logging level " + i3 + " setting to ORT_LOGGING_LEVEL_VERBOSE");
        return ORT_LOGGING_LEVEL_VERBOSE;
    }

    public int getValue() {
        return this.value;
    }
}
