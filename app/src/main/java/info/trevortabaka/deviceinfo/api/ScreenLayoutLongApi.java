package info.trevortabaka.deviceinfo.api;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class ScreenLayoutLongApi extends AbstractHumanReadableApi<Integer> {
    private final int screenLayoutLong;

    public ScreenLayoutLongApi(int apiLevel, String name, int screenLayout) {
        super(apiLevel, name);
        screenLayoutLong = screenLayout & android.content.res.Configuration.SCREENLAYOUT_LONG_MASK;
    }

    @NonNull
    @Override
    public Integer getRawValue() {
        return screenLayoutLong;
    }

    @Nullable
    public String getHumanReadableString() {
        switch (screenLayoutLong) {
            case android.content.res.Configuration.SCREENLAYOUT_LONG_NO:
                return "Configuration.SCREENLAYOUT_LONG_NO";
            case android.content.res.Configuration.SCREENLAYOUT_LONG_UNDEFINED:
                return "Configuration.SCREENLAYOUT_LONG_UNDEFINED";
            case android.content.res.Configuration.SCREENLAYOUT_LONG_YES:
                return "Configuration.SCREENLAYOUT_LONG_YES";
            default:
                return null;
        }
    }
}
