package info.trevortabaka.deviceinfo.api;

class UnitValue<T> implements ApiValue {
    private final T value;
    private final String unit;

    public UnitValue(T value, String unit) {
        this.value = value;
        this.unit = unit;
    }

    @Override
    public String getValue() {
        return String.valueOf(value);
    }

    @Override
    public String getHumanReadableValue() {
        return value + " " + unit;
    }
}
