package info.trevortabaka.deviceinfo.value;

import android.support.annotation.Nullable;

import java.util.Arrays;

import info.trevortabaka.deviceinfo.api.ApiValue;

public class StringArrayValue implements ApiValue {
    private final String[] values;

    public StringArrayValue(String[] values) {
        this.values = values;
    }

    @Override
    public String getValue() {
        return Arrays.toString(values);
    }

    @Nullable
    @Override
    public String getHumanReadableValue() {
        return getValue();
    }
}
