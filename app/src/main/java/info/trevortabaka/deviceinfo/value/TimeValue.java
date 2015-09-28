package info.trevortabaka.deviceinfo.value;

import java.util.Date;

import info.trevortabaka.deviceinfo.api.ApiValue;

public class TimeValue implements ApiValue {
    private final long time;

    public TimeValue(long time) {
        this.time = time;
    }

    @Override
    public String getValue() {
        return String.valueOf(time);
    }

    @Override
    public String getHumanReadableValue() {
        return new Date(time).toString();
    }
}
