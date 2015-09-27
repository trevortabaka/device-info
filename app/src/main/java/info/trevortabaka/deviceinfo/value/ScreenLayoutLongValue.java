package info.trevortabaka.deviceinfo.value;

import android.content.res.Configuration;

import info.trevortabaka.deviceinfo.api.ApiValue;

public class ScreenLayoutLongValue implements ApiValue {
    private final int screenLayoutLong;

    public ScreenLayoutLongValue(Configuration configuration) {
        screenLayoutLong = configuration.screenLayout & android.content.res.Configuration.SCREENLAYOUT_LONG_MASK;
    }

    @Override
    public String getValue() {
        return String.valueOf(screenLayoutLong);
    }

    @Override
    public String getHumanReadableValue() {
        switch (screenLayoutLong) {
            case android.content.res.Configuration.SCREENLAYOUT_LONG_NO:
                return "SCREENLAYOUT_LONG_NO";
            case android.content.res.Configuration.SCREENLAYOUT_LONG_UNDEFINED:
                return "SCREENLAYOUT_LONG_UNDEFINED";
            case android.content.res.Configuration.SCREENLAYOUT_LONG_YES:
                return "SCREENLAYOUT_LONG_YES";
            default:
                return null;
        }
    }
}
