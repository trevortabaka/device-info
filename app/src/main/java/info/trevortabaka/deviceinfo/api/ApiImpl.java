package info.trevortabaka.deviceinfo.api;

class ApiImpl implements Api {
    private Class apiClass;
    private int apiLevel;
    private String name;
    private ApiValue value;

    public ApiImpl(Class apiClass, int apiLevel, String name, ApiValue value) {
        this.apiClass = apiClass;
        this.apiLevel = apiLevel;
        this.name = name;
        this.value = value;
    }

    @Override
    public int getApiLevel() {
        return apiLevel;
    }

    @Override
    public String getClassName() {
        return apiClass.getSimpleName();
    }

    @Override
    public String getPackageName() {
        return apiClass.getPackage().getName();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getValue() {
        return value.getValue();
    }

    @Override
    public String getHumanReadableValue() {
        return value.getHumanReadableValue();
    }
}
