package info.trevortabaka.deviceinfo.api;

public class BooleanApi extends AbstractApi {
    private final boolean value;

    public BooleanApi(int apiLevel, String name, boolean value) {
        super(apiLevel, name);
        this.value = value;
    }

    @Override
    public String getValue() {
        return String.valueOf(value);
    }
}
