package info.trevortabaka.deviceinfo.api;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class TouchscreenApi extends AbstractHumanReadableApi<Integer> {
    private final int touchscreen;

    public TouchscreenApi(int apiLevel, String name, int touchscreen) {
        super(apiLevel, name);
        this.touchscreen = touchscreen;
    }

    @NonNull
    @Override
    public Integer getRawValue() {
        return touchscreen;
    }

    @Nullable
    public String getHumanReadableString() {
        switch (touchscreen) {
            case android.content.res.Configuration.TOUCHSCREEN_FINGER:
                return "Configuration.TOUCHSCREEN_FINGER";
            case android.content.res.Configuration.TOUCHSCREEN_NOTOUCH:
                return "Configuration.TOUCHSCREEN_NOTOUCH";
            case android.content.res.Configuration.TOUCHSCREEN_UNDEFINED:
                return "Configuration.TOUCHSCREEN_UNDEFINED";
            case android.content.res.Configuration.TOUCHSCREEN_STYLUS:
                return "Configuration.TOUCHSCREEN_STYLUS";
            default:
                return null;
        }
    }
}
