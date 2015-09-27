package info.trevortabaka.deviceinfo.value;

import android.content.res.Configuration;

import info.trevortabaka.deviceinfo.api.ApiValue;

public class ScreenLayoutSizeValue implements ApiValue {
    private final int screenLayoutSize;

    public ScreenLayoutSizeValue(Configuration configuration) {
        screenLayoutSize = configuration.screenLayout & android.content.res.Configuration.SCREENLAYOUT_SIZE_MASK;
    }

    @Override
    public String getValue() {
        return String.valueOf(screenLayoutSize);
    }

    @Override
    public String getHumanReadableValue() {
        switch (screenLayoutSize) {
            case android.content.res.Configuration.SCREENLAYOUT_SIZE_LARGE:
                return "SCREENLAYOUT_SIZE_LARGE";
            case android.content.res.Configuration.SCREENLAYOUT_SIZE_NORMAL:
                return "SCREENLAYOUT_SIZE_NORMAL";
            case android.content.res.Configuration.SCREENLAYOUT_SIZE_SMALL:
                return "SCREENLAYOUT_SIZE_SMALL";
            case android.content.res.Configuration.SCREENLAYOUT_SIZE_UNDEFINED:
                return "SCREENLAYOUT_SIZE_UNDEFINED";
            case android.content.res.Configuration.SCREENLAYOUT_SIZE_XLARGE:
                return "SCREENLAYOUT_SIZE_XLARGE";
            default:
                return null;
        }
    }
}
