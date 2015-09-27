package info.trevortabaka.deviceinfo.api;

class GenericApi<T> extends AbstractApi {
    private final T value;

    GenericApi(int apiLevel, String name, T value) {
        super(apiLevel, name);
        this.value = value;
    }

    @Override
    public String getValue() {
        return String.valueOf(value);
    }
}
