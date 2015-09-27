package info.trevortabaka.deviceinfo.api;

public class StringApi extends AbstractApi {
    private String value;

    public StringApi(int apiLevel, String name, String value) {
        super(apiLevel, name);
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }
}
