package info.trevortabaka.deviceinfo.api;

public class IntApi extends AbstractApi {
    private final int value;

    public IntApi(int apiLevel, String name, int value) {
        super(apiLevel, name);
        this.value = value;
    }

    @Override
    public String getValue() {
        return String.valueOf(value);
    }
}
