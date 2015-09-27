package info.trevortabaka.deviceinfo.api;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class ScreenLayoutSizeApi extends AbstractHumanReadableApi<Integer> {
    private final int screenLayoutSize;

    public ScreenLayoutSizeApi(int apiLevel, String name, int screenLayout) {
        super(apiLevel, name);
        screenLayoutSize = screenLayout & android.content.res.Configuration.SCREENLAYOUT_SIZE_MASK;
    }

    @NonNull
    @Override
    public Integer getRawValue() {
        return screenLayoutSize;
    }

    @Nullable
    public String getHumanReadableString() {
        switch (screenLayoutSize) {
            case android.content.res.Configuration.SCREENLAYOUT_SIZE_LARGE:
                return "Configuration.SCREENLAYOUT_SIZE_LARGE";
            case android.content.res.Configuration.SCREENLAYOUT_SIZE_NORMAL:
                return "Configuration.SCREENLAYOUT_SIZE_NORMAL";
            case android.content.res.Configuration.SCREENLAYOUT_SIZE_SMALL:
                return "Configuration.SCREENLAYOUT_SIZE_SMALL";
            case android.content.res.Configuration.SCREENLAYOUT_SIZE_UNDEFINED:
                return "Configuration.SCREENLAYOUT_SIZE_UNDEFINED";
            case android.content.res.Configuration.SCREENLAYOUT_SIZE_XLARGE:
                return "Configuration.SCREENLAYOUT_SIZE_XLARGE";
            default:
                return null;
        }
    }
}
