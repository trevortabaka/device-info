package info.trevortabaka.deviceinfo.api;

import info.trevortabaka.deviceinfo.api.Api;

public abstract class AbstractApi implements Api {
    private final int apiLevel;
    private final String name;

    public AbstractApi(int apiLevel, String name) {
        this.apiLevel = apiLevel;
        this.name = name;
    }

    @Override
    public int getApiLevel() {
        return apiLevel;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " added in " + apiLevel;
    }
}
