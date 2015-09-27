package info.trevortabaka.deviceinfo.api;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class OrientationApi extends AbstractHumanReadableApi<Integer> {
    private final int orientation;

    public OrientationApi(int apiLevel, String name, int orientation) {
        super(apiLevel, name);
        this.orientation = orientation;
    }

    @NonNull
    @Override
    public Integer getRawValue() {
        return orientation;
    }

    @Override
    @Nullable
    public String getHumanReadableString() {
        switch (orientation) {
            case android.content.res.Configuration.ORIENTATION_LANDSCAPE:
                return "Configuration.ORIENTATION_LANDSCAPE";
            case android.content.res.Configuration.ORIENTATION_PORTRAIT:
                return "Configuration.ORIENTATION_PORTRAIT";
            case android.content.res.Configuration.ORIENTATION_SQUARE:
                return "Configuration.ORIENTATION_SQUARE";
            case android.content.res.Configuration.ORIENTATION_UNDEFINED:
                return "Configuration.ORIENTATION_UNDEFINED";
            default:
                return null;
        }
    }
}
