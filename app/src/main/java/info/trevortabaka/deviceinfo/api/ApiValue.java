package info.trevortabaka.deviceinfo.api;

import android.support.annotation.Nullable;

public interface ApiValue {

    String getValue();

    @Nullable
    String getHumanReadableValue();
}
