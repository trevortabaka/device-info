package info.trevortabaka.deviceinfo.api;

class StringValueOf<T> implements ApiValue {
    private final T value;

    public StringValueOf(T value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return String.valueOf(value);
    }

    @Override
    public String getHumanReadableValue() {
        return "";
    }
}
