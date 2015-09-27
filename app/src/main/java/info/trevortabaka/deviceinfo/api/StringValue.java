package info.trevortabaka.deviceinfo.api;

class StringValue<T> implements ApiValue {
    private final T value;

    public StringValue(T value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return String.valueOf(value);
    }

    @Override
    public String getHumanReadableValue() {
        return String.valueOf(value);
    }
}
