package info.trevortabaka.deviceinfo.api;

public class FloatApi extends AbstractApi {
    private float floatValue;

    public FloatApi(int apiLevel, String name, float floatValue) {
        super(apiLevel, name);
        this.floatValue = floatValue;
    }

    @Override
    public String getValue() {
        return String.valueOf(floatValue);
    }
}
