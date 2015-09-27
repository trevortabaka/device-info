package info.trevortabaka.deviceinfo.api;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public abstract class AbstractHumanReadableApi<T> extends AbstractApi {

    @Nullable
    public abstract String getHumanReadableString();

    @NonNull
    public abstract T getRawValue();

    public AbstractHumanReadableApi(int apiLevel, String name) {
        super(apiLevel, name);
    }

    @Override
    public String getValue() {
        String humanReadable = getHumanReadableString();
        if (humanReadable == null) {
            return String.valueOf(getRawValue());
        } else {
            return humanReadable + " (" + getRawValue() + ")";
        }
    }

}
