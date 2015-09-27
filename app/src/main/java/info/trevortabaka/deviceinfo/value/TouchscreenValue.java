package info.trevortabaka.deviceinfo.value;

import android.content.res.Configuration;

import info.trevortabaka.deviceinfo.api.ApiValue;

public class TouchscreenValue implements ApiValue {
    private final int touchscreen;

    public TouchscreenValue(Configuration configuration) {
        this.touchscreen = configuration.touchscreen;
    }

    @Override
    public String getValue() {
        return String.valueOf(touchscreen);
    }

    @Override
    public String getHumanReadableValue() {
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