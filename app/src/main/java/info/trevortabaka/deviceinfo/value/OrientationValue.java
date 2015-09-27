package info.trevortabaka.deviceinfo.value;

import android.content.res.Configuration;

import info.trevortabaka.deviceinfo.api.ApiValue;

public class OrientationValue implements ApiValue {
    private final int orientation;

    public OrientationValue(Configuration configuration) {
        this.orientation = configuration.orientation;
    }

    @Override
    public String getValue() {
        return String.valueOf(orientation);
    }

    @Override
    public String getHumanReadableValue() {
        switch (orientation) {
            case android.content.res.Configuration.ORIENTATION_LANDSCAPE:
                return "ORIENTATION_LANDSCAPE";
            case android.content.res.Configuration.ORIENTATION_PORTRAIT:
                return "ORIENTATION_PORTRAIT";
            case android.content.res.Configuration.ORIENTATION_SQUARE:
                return "ORIENTATION_SQUARE";
            case android.content.res.Configuration.ORIENTATION_UNDEFINED:
                return "ORIENTATION_UNDEFINED";
            default:
                return null;
        }
    }
}
