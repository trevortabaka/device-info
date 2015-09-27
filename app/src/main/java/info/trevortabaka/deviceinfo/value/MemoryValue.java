package info.trevortabaka.deviceinfo.value;

import info.trevortabaka.deviceinfo.api.ApiValue;

public class MemoryValue implements ApiValue {
    private final long memory;

    public MemoryValue(long memory) {
        this.memory = memory;
    }

    @Override
    public String getValue() {
        return String.valueOf(memory);
    }

    @Override
    public String getHumanReadableValue() {
        long kibibytes = memory / 1024;
        long mibibytes = kibibytes / 1024;
        return mibibytes + " MiB";
    }
}
